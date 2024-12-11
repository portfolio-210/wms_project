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

import wms_project.dto.ConfigDTO;
import wms_project.service.ConfigService;

@Controller
public class ConfigController {
	
	public static int startno = 1;

	String output = null;
	javascript js = new javascript();
	
	@Autowired
	ConfigService cs;
	
	@PostMapping("/config/configMain.do")
	public String search(@RequestParam("part1") String part1, @RequestParam("part2") String part2, @RequestParam("search") String search, 
		 Model m) {
		Map<String, Object> keycode = new HashMap<>();				
		keycode.put("part1",part1);
		keycode.put("part2",part2);
		keycode.put("search",search);			
	  			
		List<ConfigDTO> all = cs.all(keycode);
		
		
						
		m.addAttribute("members", all); // 'm'을 사용하여 모델에 추가
		return null;
	}
	
	@GetMapping("/config/configMain.do")
    public String showMembers(@RequestParam(value = "pageno",required = false) Integer pageno, Model m) {
        List<ConfigDTO> members = cs.searchall(); // 전체 멤버 가져오기
        ConfigDTO configDTO = new ConfigDTO();
        
        Integer total = null;
        total=cs.Total(configDTO);
        
               
        
        m.addAttribute("members", members); // 모델에 추가
        
        
        return null; // JSP 페이지 이름 반환
    }
	
	@PostMapping("/config/update.do")
    public String getMethodName(@RequestParam("part3") String part3, 
                                 @RequestParam("midx") int midx,
                                 Model m) {
        try {
            // ConfigDTO 객체 생성 및 값 설정
            ConfigDTO configDTO = new ConfigDTO();
            configDTO.setPart3(part3); // part3 값 설정
            configDTO.setMidx(midx);   // midx 값 설정

            // update1 메서드 호출
            int result = cs.update1(configDTO);

            if (result > 0) {
                this.output = this.js.ok("변경 되었습니다.", "/config/configMain.do");
               
            } else {
                this.output = this.js.no("변경 실패하였습니다.");
            }
        } catch (Exception e) {
            System.out.println("변경 실패");
            e.printStackTrace(); // 예외 스택 트레이스 출력
        }

        m.addAttribute("output", output);
		return "output";
    }
	
	
}
