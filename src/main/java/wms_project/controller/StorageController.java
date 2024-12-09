package wms_project.controller;

import org.eclipse.tags.shaded.org.apache.regexp.recompile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import wms_project.dto.StorageDTO;
import wms_project.service.StorageService;

@Controller
public class StorageController {
	
	String output = null;
	javascript js = new javascript();
	
	@Autowired
	StorageService ss;
	
	
	
	
	
	@GetMapping("/storage/storageInsert.do")
	public String storageInsert(StorageDTO storageDTO) {
		
		
		return null;
	}
	
	
	
	@PostMapping("/storageInsert.do")
	public String InsertStorage(StorageDTO storageDTO, Model m) {
		
			try {
			int result = ss.insert1(storageDTO);
			
			
			// 결과에 따라 뷰에 메시지 추가
	        if (result > 0) {
	        this.output = this.js.ok("등록 되었습니다.", "/storage/storageMain.do");
	            
	        } else {
	        	this.output = this.js.no("등록 실패하였습니다.");
	        
	        }
		} catch (Exception e) {
			System.out.println("등록 실패");
		}
		
		m.addAttribute("output", output);
		
		
		return "output";
	}
	
	
	// GET 요청을 처리하는 checkCode 메서드
    @GetMapping("/api/checkCode/{scode}") // /api/checkCode/{scode} 경로로 매핑
    @ResponseBody // 메서드의 반환값을 HTTP 응답 본문으로 사용
    	public ResponseEntity<Integer> checkCode(@PathVariable("scode") String scode){
            int count = ss.checkCode(scode); // 서비스 메서드 호출
            System.out.println("count"+count);
            return ResponseEntity.ok(count); // count 값을 HTTP 응답으로 반환
      }
    
	

}
