package wms_project.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import wms_project.dto.MobileDTO;
import wms_project.service.MobileService;

@Controller
public class MobileController implements security {
	@Resource(name="mobiledto")
	MobileDTO dto;
	@Autowired
	MobileService ms;
	
	String output = null;
	javascript js = new javascript();
	
	@PostMapping("/deliveryMobile/mobileLoginOk.do")
	public String mobileLoginOk(
			@RequestParam(value = "deliver_id", required = false) String deliver_id,
			@RequestParam(value = "deliver_pw", required = false) String deliver_pw,
			HttpServletRequest req,
			Model m) {
		System.out.println(deliver_id);
		System.out.println(deliver_pw);
		
		List<MobileDTO> result = ms.MobileLogin(deliver_id);
		if(result.size() == 0) {
			this.output=this.js.ok("기사님 사원번호 및 패스워드를 다시 확인해주세요.","./mobileLogin.jsp");	
		}
		else {
			try {
				StringBuilder repass = secode(deliver_pw);
				if(result.get(0).getDpass().equals(repass.toString())) {
					if(!result.get(0).getDapprove().equals("근무중")) {
						this.output=this.js.ok("현재 '근무중'인 기사님만 로그인이 가능합니다. 센터로 문의해주세요.","./mobileLogin.jsp");
					}
					else {
						HttpSession session = req.getSession();
						session.setAttribute("dcode", result.get(0).getDcode());
						session.setAttribute("name", result.get(0).getDname());
						session.setAttribute("email", result.get(0).getDemail());
						session.setAttribute("spot", result.get(0).getDspot());
						session.setAttribute("hp", result.get(0).getDhp());
						session.setAttribute("approve", result.get(0).getDapprove());
						this.output=this.js.ok("로그인되었습니다. 안전운전하세요!","./mobileMain.do");	
					}
				}
				else {
						this.output=this.js.ok("사원번호 및 패스워드를 다시 확인해주세요.","./mobileLogin.jsp");
				}
				
			} catch (Exception e) {
				this.output=this.js.no("데이터 오류로 인하여 다시 시도해 주세요.");
			}
		}
		m.addAttribute("output", this.output);
        return "output"; 
	}
	
	
	@GetMapping("/deliveryMobile/logout.do")
  	public String logout(HttpServletRequest req, 
  						Model m) {

  		HttpSession session = req.getSession();
  		session.removeAttribute("dcode");
  		session.removeAttribute("name");
  		session.removeAttribute("email");
  		session.removeAttribute("spot");
  		session.removeAttribute("hp");
  		session.removeAttribute("approve");
  		
  		try {
  			if (session.getAttribute("dcode") == null) {
  				this.output = this.js.ok("로그아웃 되었습니다","./mobileLogin.jsp");	
  			} else {
  			    this.output = this.js.no("로그인에 실패하였습니다. 다시시도해주세요.");
  			}
  		} catch (Exception e) {
  				this.output = this.js.no("시스템 서버 오류로 인하여 다시 시도해주세요.");
  		} 
  		m.addAttribute("output", this.output);
  		return "output";
  	}
	
	
	
	@GetMapping("/deliveryMobile/mobileMain.do")
	public String mobileMain(
			@RequestParam(value = "state", required = false) String state,
			HttpServletRequest req,
			Model m) {
		
		
		System.out.println("상태는? : "+state);
		
		
		
		Map<String, Object> list = new HashMap<>();
		
		List<MobileDTO> result = ms.MobileList(list);
		m.addAttribute("result", result);
		
		return null;
	}
	
	
	
	
	
	
	
	
}
