package wms_project.controller;

import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.poi.ss.usermodel.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import wms_project.dto.ShippingDTO;
import wms_project.service.OrderService;

import java.io.File;
import java.io.InputStream;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.Random;

@Controller
public class OrderController {
    @Resource(name="ShippingDTO")
    ShippingDTO sdto;

    @Autowired
    OrderService os;

    PrintWriter pw = null;


    //Order 메인 페이지
    @GetMapping("/order/orderMain.do")
    public String order_list(Model m, @RequestParam(value = "start_date", required = false) String start_date,
                             @RequestParam(value = "end_date", required = false) String end_date){
        //select
        return null;
    }

    //excel 첨부 파일 내용 insert
    @PostMapping("/order/file_upload.do")
    public String file_upload(@RequestParam(value = "order_file", required = false)MultipartFile order_file,
                              HttpServletResponse res, HttpServletRequest req){
        //excel file insert
        res.setContentType("text/html;charset=utf-8");
        try {
            //첨부파일 이름 변경하여 /excelUpload/ 디렉토리에 저장
            String new_name = os.file_save(order_file, req);

            //첨부 파일 내용 insert
            int count = 0;

            InputStream inputStream = order_file.getInputStream();
            Workbook workbook = WorkbookFactory.create(inputStream);
            Sheet sheet = workbook.getSheetAt(0);
            Iterator<Row> rows = sheet.iterator();

            while(rows.hasNext()){  //값이 있는 행 확인, 다음 읽을 행이 더이상 없을 때까지
                Row row = rows.next();  //값이 있는 행 읽기
                Iterator<Cell> cellIterator = row.cellIterator();   //열을 배열 형태로 읽어들임
                if(row.getRowNum() > 0){
                    while(cellIterator.hasNext()){  //값이 있는 셀 확인, 다음 읽을 셀이 더이상 없을 때까지
                        Cell cell = cellIterator.next();    //값이 있는 셀 읽기
                        int cellno = cell.getColumnIndex(); //셀 순서대로 셀 번호 부여
                        switch (cellno){
                            case 0:
                                sdto.setAidx(Integer.parseInt(cell.toString()));
                                break;
                            case 1:
                                sdto.setAproductcode(cell.toString());
                                break;
                            case 2:
                                sdto.setAproductname(cell.toString());
                                break;
                            case 3:
                                sdto.setAcustomernm(cell.toString());
                                break;
                            case 4:
                                sdto.setAcustomerhp(cell.toString());
                                break;
                            case 5:
                                sdto.setAcustomeraddr(cell.toString());
                                break;
                            case 6:
                                sdto.setAccountnm(cell.toString());
                                break;
                        }
                    }
                    try {
                        int result = os.insert_order(sdto);
                        if(result > 0){
                            count += 1;
                        }
                    } catch (Exception e) {
                        this.pw.print("<script>" +
                                "alert('시스템 오류로 인하여 주문 등록에 실패하였습니다.\n잠시 후 다시 시도해주세요.');" +
                                "history.go(-1);" +
                                "</script>");
                    }
                }
            }
            this.pw = res.getWriter();
            this.pw.print("<script>" +
                    "alert('등록하신 파일의 주문 " + count + "개가 등록되었습니다.');" +
                    "history.go(-1);" +
                    "</script>");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.pw.close();
        }
        return null;
    }
}
