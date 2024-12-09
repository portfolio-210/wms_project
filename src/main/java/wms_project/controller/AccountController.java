package wms_project.controller;

import java.io.PrintWriter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletResponse;
import wms_project.dto.AccountDTO;
import wms_project.service.AccountService;

@Controller
public class AccountController {

	@Resource(name="accountdto")
	AccountDTO dto;
	@Autowired
	AccountService as;
	
	
	
	String output = null;
	javascript js = new javascript();
	
	
	// 메인페이지
	@GetMapping("/account/accountMain.do")
	public String accountMain(Model m) {
		List<AccountDTO> all = as.accountList();
		m.addAttribute("all", all);
		m.addAttribute("total", all.size());
		return null;
	}
	
	
	// 거래처 등록 여기서 거래처 코드 핸들링
	@GetMapping("/account/accountInsert.do")
	public String accountInsert() {
		
		return null;
	}
	
	
	//거래처 등록
	@PostMapping("/account/accountInsertok.do")
	public String accountInsertok(@ModelAttribute("account") AccountDTO dto,
									Model m) throws Exception {
		
		try {
			int result = as.account_insert(dto);
			System.out.println(result);
			if(result > 0) {
				System.out.println(result);
				this.output=this.js.ok("정상적으로 거래처등록이 완료 되었습니다.", "/account/accountMain.do");
			}
			else {
				this.output=this.js.no("거래처 등록에 실패하였습니다. 다시 시도해 주세요.");
			}
		} catch (Exception e) {
			this.output=this.js.no("데이터 오류로 인하여 등록 되지 않습니다. 다시 시도해 주세요"+e);
		}
		m.addAttribute("output", output);
 		return "output";

	}
		
		 // 거래처명 중복체크
	 	@CrossOrigin("*")
	 	@PostMapping("/account/companyck.do")
	 	public String companycheck(@RequestParam("acompany") String acompany, 
	 			HttpServletResponse res) throws Exception {	
	 				
	 		PrintWriter pw = res.getWriter();
	 		String result ="ok";
	 		String count = "";
	 		if(acompany.equals("")) {
	 		}
	 		else {
	 			result = as.search_company(acompany);
	 			count = as.account_ctn();
	 			System.out.println("중복체크 결과 : "+result);
	 			pw.print(result+","+count);
	 			pw.close();
	 		}
	 		return null;
	 	}
	 	
	 	
	 	@GetMapping("/account/accountModify.do")
	 	public String accountModify(@RequestParam("aidx") int aidx,
	 								Model m) {
	 /*
	 			int idx = dto.getAidx();
	 			idx = as.accountIdx(aidx);
	 			
	 			List<AccountDTO> all = as.accountList();
	 			m.addAttribute("all", all);
	 			m.addAttribute("total", all.size());
	 	*/
	 		
	 		return null;
	 	}
		
	
	
	
}
