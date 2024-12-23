package wms_project.controller;


import java.io.ByteArrayOutputStream;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.support.MethodArgumentTypeMismatchException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.client.j2se.MatrixToImageConfig;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;

import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import wms_project.dto.DeliveryShipDTO;
import wms_project.service.DeliveryShipService;

@Controller
public class DeliveryShipController {

	@Resource(name="dsdto")
	DeliveryShipDTO dto;
	
	@Autowired
	private DeliveryShipService dss;
	
	String output = null;
	javascript js = new javascript();
	
	// 메인페이지
	
	@GetMapping("/deliveryShip/deliveryShip.do")
	public String deliveryShip(
			@RequestParam(value = "start", required = false) String start,
			@RequestParam(value = "end", required = false) String end,
			@RequestParam(value = "dcode", required = false) String dcode,
			@RequestParam(value = "pageno", required = false) Integer pageno,
			Model m) {
		
		int startno = 0;    //글 시작 번호
        int endno = 15;     //한 페이지에 출력될 행 개수
        if(pageno == null){
            pageno = 1;
        } else {
            startno = (pageno-1) * 15;
        }
		
		
		
		//배송기사별 현황 출력
		List<DeliveryShipDTO> dsnm = dss.ShipName();
		m.addAttribute("dsnm", dsnm);
		
		
		
		Map<String, Object> ctn = new HashMap<>();
		ctn.put("dcode", dcode);
		ctn.put("start", start);
		ctn.put("end", end);
		ctn.put("startno", startno);
		ctn.put("endno", endno);
		
		int total = dss.ShipCtn(ctn);
		m.addAttribute("total", total);
		//System.out.println(total);

		
		Map<String, Object> list = new HashMap<>();
		list.put("dcode", dcode);
		list.put("start", start);
		list.put("end", end);
		list.put("startno", startno);
		list.put("endno", endno);
		
		List<DeliveryShipDTO> all = dss.ShipList(list);
		m.addAttribute("all",all);
		//m.addAttribute("total",total);

		
		return null;
	}
	
	
	
	//운송장 번호 생성

	@PostMapping("/deliveryShip/deliveryTracking.do")
	public String deliveryTracking(@RequestParam(value = "aidx", required = false) String aidx, Model m) {
	   
		if (aidx == null || aidx.isEmpty()) {
	        m.addAttribute("output", "선택된 항목이 없습니다.");
	        return "output";
	    }

	    // 배열로 aidx받은 값 
	    String[] idxArray = aidx.split(",");
	    //중복된 운송장 번호 리스트
	    List<String> trdu = new ArrayList<>();
	    
	    
	    for (String aidxStr : idxArray) {
	        int aidxInt = Integer.parseInt(aidxStr);

	        // 운송장 번호 생성
	        Date date = new Date();
	        SimpleDateFormat si = new SimpleDateFormat("yyyyMMddss");
	        Random random = new Random();
	        String trnm = si.format(date);
	        int no = 1000 + random.nextInt(9000);
	        String trno = trnm + no;

	        // 기존 운송장 번호 확인
	        String existingTracking = dss.ShipTR(aidxStr); // aidx에 대한 기존 운송장 번호 조회
	        if ("N".equals(existingTracking)) {
	            DeliveryShipDTO dto = new DeliveryShipDTO();
	            dto.setAidx(aidxInt);
	            dto.setStracking(trno);

	            try {
	                int result = dss.ShipTracking(dto); // 운송장 번호 업데이트
	                if (result > 0) {
	                    System.out.println("운송장 번호 생성: " + trno);
	                    this.output = this.js.ok("운송장 번호가 생성 되었습니다.", "/deliveryShip/deliveryShip.do");
	                } else {
	                    System.out.println("운송장 번호 생성 실패");
	                    this.output = this.js.no("운송장 번호 생성에 실패하였습니다. 다시 시도해주세요.");
	                }
	            } catch (Exception e) {
	            	this.output = this.js.no("데이터 오류로 운송장 번호를 생성하지 못하였습니다.\n관리자에게 문의해주세요.");
	            }
	        } else {
	        	trdu.add(existingTracking);
	           // System.out.println("이미 운송장 번호가 생성된 항목: " + aidxStr);
	            String a1 = dss.ShipTR(aidxStr);
	            
	      
	         
	            System.out.println("a1 : "+ a1);
	            System.out.println("aidxStr : " + aidxStr);
	            System.out.println();
	            this.output = this.js.ok("이미 생성된 운송장 번호가 있습니다. ["+aidxStr+"]","/deliveryShip/deliveryShip.do");
	        }
	    }
	    
	    //이미 생성된 운송장 번호 출력
	    if (!trdu.isEmpty()) {
	        String trduList = String.join(", ", trdu);
	        
	        this.output = this.js.no("이미 생성된 운송장은 제외후 생성됩니다.\\n기존 운송장번호 : [" + trduList + "]");
	    }
	  
	    m.addAttribute("output", output);
	    return "output";
	}

	
	@ExceptionHandler(MethodArgumentTypeMismatchException.class)
	@PostMapping("/deliveryShip/deliveryQr.do")
	public String deliveryQr(
			@RequestParam(value = "aidx", required = false) String aidx,
			HttpServletRequest req,
			HttpServletResponse res,
			Model m) throws Exception {
	//System.out.println(aidx);
	
	
	 // 배열로 aidx받은 값 
    String[] idxArray = aidx.split(",");
    //중복된 운송장 번호 리스트
    List<String> trdu = new ArrayList<>();	// aidx넣을 빈값
    //System.out.println("trdu값 : " + trdu);
    
    for(String aidxStr : idxArray) {
    	
    	// 선택한 aidx값
    	int aidxInt = Integer.parseInt(aidxStr);
    	//System.out.println("aidxInt : " +aidxInt);
    	
    	//송장번호
    	String trck = dss.ShipTR(aidxStr);
    	//System.out.println("trck : " + trck);
    	
    	//qrimg 값!!
    	String qrimg = dss.ShipQR(aidxStr);
    	//System.out.println("qrimg : " + qrimg);
    	

    	// 운송장 번호가 N이 아니면!!!
    	if("N".equals(trck)) {
    		 this.output = this.js.no("송장번호가 없는 오더 제외하고, QR코드가 생성되었습니다.\\nQR코드가 생성되지않은 오더는 운송장 먼처 생성해주세요.");
    	}
    	else if(!"N".equals(qrimg)) {
    		this.output = this.js.no("이미 QR코드가 생성된 오더 입니다.");
    	}
    	else {
    		String url = "http://localhost:8080/deliveryShip/deliveryQr.do?tacking="+trck;
    		int size = 300;
    		BitMatrix bm = new MultiFormatWriter().encode(url, BarcodeFormat.QR_CODE, size, size);
    	
    		int qrcode = 0xFFFF8629;	// QR색상
			int qrbscolor = 0xFFFFFFFF;	// QR 배경색
			MatrixToImageConfig mc = new MatrixToImageConfig(qrcode,qrbscolor);	
    	
			ByteArrayOutputStream bs = null;
			
			bs = new ByteArrayOutputStream();
			MatrixToImageWriter.writeToStream(bm, "PNG", bs, mc);
			String fileurl = req.getServletContext().getRealPath("/deliveryShip/qrImg/"); 
			FileCopyUtils.copy(bs.toByteArray(), new File(fileurl + trck + ".png"));
			bs.flush();
			
			try {
				DeliveryShipDTO dto = new DeliveryShipDTO();
				dto.setAidx(aidxInt);
				dto.setSqrimg(trck+".png");
				dto.setSqrurl("./deliveryShip/qrImg/");
				
				//qr 저장하는곳
				int result = dss.QRmake(dto);
				System.out.println(result);
				 if (result > 0) {
	                    this.output = this.js.ok("QR코드가 생성되었습니다.", "/deliveryShip/deliveryShip.do");
	                } else {
	                    this.output = this.js.no("QR코드 생성에 실패하였습니다. 다시 시도해주세요.");
	                }
			} catch (Exception e) {
				this.output = this.js.no("데이터 오류로 QR코드를 생성하지 못하였습니다.\n관리자에게 문의해주세요.");
			}
    	}
    }
	    m.addAttribute("output", output);
	    return "output";
	}
	
	
	
	
	
	
	

	
}//end
