package wms_project.controller;

import java.io.PrintWriter;
import java.util.Base64.Decoder;
import java.util.HashMap;
import java.util.Base64;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import jakarta.annotation.Resource;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletResponse;
import wms_project.dto.MemberDTO;
import wms_project.dto.OfficeDTO;
import wms_project.service.OfficeService;

@Controller
public class OfficeController {
	PrintWriter pw = null;

	@Resource(name="OfficeDTO")
	OfficeDTO odto;
	
	@Autowired
    OfficeService os;
	
//officeMain.jsp Controller
	//전체 지점 현황 페이지 출력
	@GetMapping("/office/officeMain.do")
	public String office_main(Model m) {
		List<OfficeDTO> all = os.office_list();
		m.addAttribute("all", all);
		m.addAttribute("total", all.size());
		return null;
	}
	
	//검색 지점 현황 페이지 출력
	@PostMapping("/office/officeMain.do")
	public String search_ok(@RequestParam("search") String search, Model m) {
		List<OfficeDTO> searchAll = os.search_office(search);
		m.addAttribute("all", searchAll);
		m.addAttribute("total", searchAll.size());
		return null;
	}
	
	//지점 삭제
	@GetMapping("/office/office_delete.do")
	public String office_delete(@RequestParam("oidx")String oidx, @RequestParam("key")String key, ServletResponse res) {
		res.setContentType("text/html;charset=utf-8");
		try {
			this.pw = res.getWriter();
			
			Decoder decoder = Base64.getDecoder();
			byte[] keycheck = decoder.decode(key);
			String keycode = new String(keycheck);
			if(keycode.equals("wms.test")) {
				byte[] oidxcheck = decoder.decode(oidx);
				String no = new String(oidxcheck);
				int result = os.delete_office(no);
				if(result > 0) {
					this.pw.print("<script>"
							+ "alert('해당 지점이 삭제 되었습니다.');"
							+ "location.href='./officeMain.do';"
							+ "</script>");
				}
				else {
					this.pw.print("<script>"
							+ "alert('해당 게시물의 정보가 올바르지 않습니다.');"
							+ "location.href='./officeMain.do';"
							+ "</script>");
				}
			}
			else {
				this.pw.print("<script>"
						+ "alert('해당 페이지에 접근이 잘 못 되었습니다.');"
						+ "history.go(-1);"
						+ "</script>");
			}
		} catch (Exception e) {
			System.out.println("삭제 실패");
			System.out.println(e.getMessage());
		} finally {
			this.pw.close();
		}
		return null;
	}
	
	
//officeInsert.jsp Controller
	/*
	//지점 등록 초기 화면 출력
	@GetMapping("/office/officeInsert.do")
	public String office_insert() {
		return null;
	}

	 */
	
	//등록할 지점 중복 검사
	@CrossOrigin("*")	//AJAX CORS 방지
	@PostMapping("/office/officenameCheck.do")
	public String oname_check(@RequestParam("officename") String officename, HttpServletResponse res) {
		res.setContentType("text/html;charset=utf-8");
		try {
			this.pw = res.getWriter();
			String result = "";
			
			if(officename.equals("")) {
				System.out.println("빈 값");
			}
			else {
				result = os.check_officename(officename);
				this.pw.print(result);
			}
		} catch (Exception e) {
			this.pw.print("<script>"
					+ "alert('서버가 불안정합니다. 잠시 후에 다시 시도 해주세요.');"
					+ "history.go(-1);"
					+ "</script>");
		} finally {
			this.pw.close();
		}
		return null;
	}

	//지점 등록
	@GetMapping("/office/officeInsert.do")
	public String office_insert(@ModelAttribute OfficeDTO officeDTO, ServletResponse res) {
		res.setContentType("text/html;charset=utf-8");
		try {
			this.pw = res.getWriter();
			
			int result = os.insert_office(officeDTO);
			if(result > 0) {
				this.pw.print("<script>"
						+ "alert('해당 지점이 등록 되었습니다.');"
						+ "location.href='./officeMain.do';"
						+ "</script>");
			}
			else {
				this.pw.print("<script>"
						+ "alert('게시물 등록에 실패하였습니다.\n입력한 정보를 다시 한 번 확인해주세요.');"
						+ "history.go(-1);"
						+ "</script>");
			}
		} catch (Exception e) {
			System.out.println("지점 등록 실패");
			System.out.println(e.getMessage());
		} finally {
			this.pw.close();
		}
		return null;
	}

	
	
//officePopList.jsp Controller
	//지점 관리자 목록 출력
	@GetMapping("/office/officePopList.do")
	public String office_poplist(Model m) {
		List<MemberDTO> all = os.poplist_member();
		m.addAttribute("all", all);
		m.addAttribute("total", all.size());
		
		return null;
	}
	
	//관리자 검색
	@PostMapping("/office/officePopList.do")
	public String search_member(@RequestParam("part") String part, @RequestParam("search") String search, Model m) {
		Map<String, String> keyword = new HashMap<>();
		keyword.put("part", part);
		keyword.put("search", search);
		List<MemberDTO> all = os.search_member(keyword);
		m.addAttribute("all", all);
		m.addAttribute("total", all.size());
		return null;
	}

	//관리자 적용 버튼 클릭 시 insert
	@CrossOrigin("*")
	@PostMapping("/office/officeInsert.do")
	@ResponseBody
	public Map<String, String> apply_member(@RequestParam("midx") String midx) {
		Map<String, String> response = new HashMap<>();
		try {
			if(midx.isEmpty()){
				response.put("error", "해당 관리자는 적용이 불가능합니다. 다른 관리자를 확인해주세요.");
			} else {
				List<MemberDTO> result = os.apply_member(midx);
				if(result == null){
					response.put("error", "적용할 수 없는 관리자 입니다. 관리자 현황을 다시 한 번 확인해주세요.");
				} else {
					MemberDTO member = result.get(0);
					response.put("mname", member.getMname());
					response.put("mhp", member.getMhp());
					response.put("memail", member.getMemail());
				}
			}
		} catch (Exception e) {
			response.put("error", "서버가 불안정합니다. 잠시 후 다시 이용해주세요.");
		}
		return response;
	}
}
