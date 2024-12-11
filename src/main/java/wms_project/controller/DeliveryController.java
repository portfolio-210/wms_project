package wms_project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import jakarta.annotation.Resource;
import wms_project.dto.DeliveryDTO;
import wms_project.service.DeliveryService;

@Controller
public class DeliveryController implements security {

	@Resource(name="deliverydto")
	DeliveryDTO dto;
	@Autowired
	DeliveryService ds;
	
	String output = null;
	javascript js = new javascript();
	
	//페이징
	public static int startno = 0;	// 비트윈에 시작값 
	public static int endno = 15; // 비트윈에 종료값
	
	
	@GetMapping("/delivery/deliveryMain.do")
	public String deliveryMain() {
		
		return null;
	}
	
	@PostMapping("/delivery/deliveryInsertok.do")
	public String deliveryInsertok(@ModelAttribute("delivery") DeliveryDTO dto,
									Model m)throws Exception {
		if("".equals(dto.getDimgnm())) {
			dto.setDimgnm("N");
		}
		String userpw = dto.getDpass();
		StringBuilder repass = secode(userpw);
		dto.setDpass(repass.toString());
		
		try {
			int result = ds.deliveryInsert(dto);
			System.out.println(result);
			if(result > 0) {
				this.output=this.js.ok("배송기사 등록이 완료 되었습니다.", "/delivery/deliveryMain.do");
			}
			else {
				this.output=this.js.no("배송기사 등록에 실패하였습니다. 다시 시도해 주세요.");
			}
		} catch (Exception e) {
			this.output=this.js.no("데이터 오류로 인하여 등록 되지 않습니다. 다시 시도해 주세요"+e);
		}
		m.addAttribute("output", output);
 		return "output";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
