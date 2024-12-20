package wms_project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import jakarta.annotation.Resource;
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
						Model m) {
		
		//배송기사별 현황 출력
		List<DeliveryShipDTO> dsnm = dss.ShipName();
		m.addAttribute("dsnm", dsnm);
		
		return null;
	}
	
	
	
	
}
