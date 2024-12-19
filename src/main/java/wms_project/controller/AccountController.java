package wms_project.controller;

import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
	
	
	//페이징
	public static int startno = 0;	// 비트윈에 시작값 
	public static int endno = 15; // 비트윈에 종료값
	
	

	@GetMapping("/account/accountMain.do")
	public String accountMain(@RequestParam(value = "search", required = false) String search,
							@RequestParam(value="pageno", required = false) Integer pageno,
							Model m) {
		
		System.out.println(search);
		System.out.println("어카운트의 pageno : " + pageno);
		int a = 0;
		
		Map<String, Object> paramValue = new HashMap<>();
		paramValue.put("search", search);
		
		int total = as.accountCtn(paramValue);

		if(pageno == null) {
			pageno = 1;
			this.startno = 0;
			this.endno = 15;
			
		}else {	// URI가 파라미터가 있을경우
			this.startno = (pageno-1) * 15;	//15개씩 출력
			this.endno = 15;
		}
		
		
		
		paramValue.put("endno", this.endno);
        paramValue.put("startno", this.startno);
	     
	     List<AccountDTO> result = as.accountList(paramValue);
	     m.addAttribute("all", result);
	     m.addAttribute("total", total);
	     m.addAttribute("userpage", pageno);
	     m.addAttribute("search", search);
	     m.addAttribute("endno",this.endno);
		
		
		return null;
	}
	
	

	// 메인페이지
	/*
	@GetMapping("/account/accountMain.do")
	public String accountMain(Model m,
			@RequestParam(value="pageno", required = false) Integer pageno,
			@RequestParam(value = "search", required = false) String search) {
		//integer 는 null값을 받을수있고 int는 null 이안나와서 500번에러남!!
		System.out.println(search);
		
		
		if(pageno==null) {
			pageno = 1;
			this.startno = 0;
			this.endno = 15;
			
		}else {	// URI가 파라미터가 있을경우
			this.startno = (pageno-1) * 15;	//15개씩 출력
			this.endno = 15;
		}
	
		dto.setSearch(search);
		int result = as.accountListCtn();		
		List<AccountDTO> all = as.accountList();
		m.addAttribute("all", all);
		m.addAttribute("total",result);
		m.addAttribute("userpage",pageno);	
		 
		return null;
	}
	*/
	
	/*
	@PostMapping("/account/accountMain.do")
	public String accountSearch(@RequestParam("search") String search,
			Model m) {
		System.out.println(search);
		
		List<AccountDTO> all = as.accountSearch(search);
		m.addAttribute("all", all);
		m.addAttribute("total", all.size());
		
		return null;
	}
*/
	
	
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
			this.output=this.js.no("데이터 오류로 인하여 등록 되지 않습니다. 다시 시도해 주세요");
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
	 	public String accountModify(@RequestParam("aidx") String aidx,
	 								Model m) {
	 		System.out.println(aidx);
	 		AccountDTO adto = as.accountIdx(aidx);
	 		
	 		
	 		m.addAttribute("adto",adto);
	 		
	 		return "account/accountModify";
	 	};

	 	
	 	//거래처 수정 업로드
		@PostMapping("/account/accountModifyok.do")
		public String accountmodifyok(@ModelAttribute("modify") AccountDTO dto,
										Model m) throws Exception {
			
			try {
				int result = as.accountModify(dto);
				System.out.println(result);
				
				if(result > 0) {
					this.output=this.js.ok("정상적으로 수정이 완료 되었습니다.", "/account/accountMain.do");
				}
				else {
					this.output=this.js.no("거래처 수정을 실패하였습니다. 다시 시도해 주세요.");
				}
				 
			} catch (Exception e) {
				this.output=this.js.no("데이터 오류로 인하여 수정 되지 않습니다. 다시 시도해 주세요"+e);
			}
			m.addAttribute("output", output);
		
	 		return "output";
		}

		
		// 삭제
		@GetMapping("/account/accountDelete.do")
		public String accountDelete(@RequestParam("aidx") String aidx,
									Model m) {
			try {
				int result = as.accountDelete(aidx);
				System.out.println(result);
				if(result > 0) {
					this.output=this.js.ok("정상적으로 삭제가 완료되었습니다.", "/account/accountMain.do");
				}
				else {
					this.output=this.js.no("거래처 삭제를 실패하였습니다. 다시 시도해 주세요.");
					System.out.println(result);
				}
			} catch (Exception e) {
				this.output=this.js.no("데이터 오류로 인하여 등록 되지 않습니다. 다시 시도해 주세요"+e);
			}
			m.addAttribute("output", output);
	 		return "output";
		}
	 	/*
	 	 select*from account;

		UPDATE account SET approve ='Y' where aidx = '1';
		UPDATE account SET approve ='Y' where aidx = '2'; 
	 	  
	 	 */
	 	
	 	
	
	
	
}// 끝
