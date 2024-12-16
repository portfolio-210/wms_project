package wms_project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class OrderController {

    //Order 메인 페이지
    @GetMapping("/order/orderMain.do")
    public String order_list(Model m, @RequestParam(value = "start_date", required = false) String start_date,
                             @RequestParam(value = "end_date", required = false) String end_date){

        return null;
    }

    //excel 첨부 파일 저장
    @PostMapping("/order/file_upload.do")
    public String file_upload(@RequestParam("order_file")MultipartFile file){
        System.out.println(file.getOriginalFilename());
        System.out.println(file.getContentType());  //application/vnd.ms-excel

        return null;
    }
}
