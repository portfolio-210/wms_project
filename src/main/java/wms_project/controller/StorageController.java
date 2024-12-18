package wms_project.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import wms_project.dto.AccountDTO;
import wms_project.dto.PaletteDTO;
import wms_project.dto.ProductDTO;
import wms_project.dto.ProductsDTO;
import wms_project.dto.StorageDTO;
import wms_project.service.AccountService;
import wms_project.service.PaletteService;
import wms_project.service.StorageService;

@Controller
public class StorageController {

	@Resource(name="accountdto")
	AccountDTO dto;
	
	@Resource(name="PaletteDTO")
	PaletteDTO pdto;
	
	@Autowired
	AccountService as;
	
	@Autowired
	PaletteService ps;
	
    String output = null;
    javascript js = new javascript();

    @Autowired
    StorageService ss;
    
    
    @PostMapping("/storage/moveProduct.do")
    public String productChange(@RequestParam Map<String, Object> checked, Model m) {   	
      	
    	 System.out.println("Received parameters: " + checked); // 이 줄을 추가하여 확인

    	    String json = (String) checked.get("List"); // Map에서 List를 가져오기
    	    if (json == null) {
    	        throw new IllegalArgumentException("The parameter 'List' is missing or null.");
    	    }
        ObjectMapper mapper = new ObjectMapper();                             
  
	      try { 
	    	  List<ProductDTO> playerList = mapper.readValue(json, new TypeReference<ArrayList<ProductDTO>>(){});
	    	  System.out.println(playerList);
    		this.output = this.js.ok("이동 되었습니다.", "/storage/storageList.do");
    			            	
    	}catch (Exception e) {
    		e.printStackTrace();
    		this.output = this.js.no("시스템 오류로 인해 실패하였습니다.");
		}
        	
    	m.addAttribute("output", output);
        return "output";
        
        }
    	
    	
   
    
    
    @GetMapping("/storage/storageList.do")
    public String productList(@RequestParam(value = "selectstorage", required = false) String selectstorage, 
								   @RequestParam(value = "storageto", required = false) String storageto,
								   HttpServletRequest req, Model m) {   	
    	 HttpSession sess = req.getSession();
      	 String mspot = (String) sess.getAttribute("mspot"); 
      	 Map<String, Object> params = new HashMap<>();    	 
      	 params.put("selectstorage", selectstorage);
      	 params.put("storageto", storageto);
      	 
      	 List<StorageDTO> members = ss.searchall(mspot);
      	 List<StorageDTO> membersall = ss.searchto(selectstorage);
      	 List<ProductDTO> list = ss.productlist(selectstorage);
   	 
      	 m.addAttribute("product",list);//사용자가 선택한 창고 상품 리스트
      	 m.addAttribute("members",members); //사용자와 맞는 창고 리스트
      	 m.addAttribute("membersall",membersall); //첫번째 선택한 창고를 제외한 전체 창고 리스트
    	return null;
    }
 
    
    
    @PostMapping("/storage/productInsert.do")
    public String storageInsert(ProductsDTO productsDto, Model m) {
    	//System.out.println(productDTO);
    	int total = 0;  // 총 삽입된 개수
    			
    			try {
    			int result = ss.insertStore(productsDto);
	    		
    			if (result > 0) {
	    			
    				total++; }
    			
	    		if (total > 0) {	
	    			this.output = this.js.ok("등록 되었습니다.", "/storage/storageList.do");
	    		
	    		}else {
	    			this.output = this.js.no("등록 실패하였습니다.");
				}
    		
        	}catch (Exception e) {
        		e.printStackTrace();
        		this.output = this.js.no("시스템 오류로 인해 실패하였습니다.");
    		}
            
    	
        	m.addAttribute("output", output);
            return "output";
        }
 
    
    
    @GetMapping("/account/getAccountCode")
    @ResponseBody // JSON 응답을 반환하기 위해 추가
    public String getAccountCode(@RequestParam("acompany") String acompany) {
    	
    	String acode = null;
        if (acompany != null && !acompany.isEmpty()) {
            acode = ss.getAcode(acompany); // 거래처 코드 조회
        }
    	
        return acode;
    }
    
    //
    @GetMapping("/storage/storageInstore.do")
    public String storageInstore1(@RequestParam(value = "acompany", required = false) String acompany, StorageDTO storageDTO,HttpServletRequest req, Model m) {
    HttpSession sess = req.getSession();
   	 String mspot = (String) sess.getAttribute("mspot");   	 
   	 List<StorageDTO> members = ss.searchall(mspot);
   	 List<PaletteDTO> palette = ps.palette_list(mspot);
	 

	 
    
	 m.addAttribute("palette",palette);//사용자와 맞는 팔레트 리스트
   	 m.addAttribute("members",members);
   	

        return null;
    }
    
    
   /* @PostMapping("/storage/storageInstore.do")
    public String storageInstore(StorageDTO storageDTO,HttpServletRequest req, Model m) {
    	HttpSession sess = req.getSession();
    	 String mspot = (String) sess.getAttribute("mspot");
    	 List<StorageDTO> members = ss.searchall(mspot);
    	 List<PaletteDTO> palette = ps.palette_list(mspot);
    	 System.out.println("palette"+palette);
    	 
    	 
    	 m.addAttribute("palette",palette);//사용자와 맞는 팔레트 리스트
    	 m.addAttribute("members",members);//사용자와 맞는 창고 리스트
        
        return null;
    } */
      
    
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
    public ResponseEntity<Integer> checkCode(@PathVariable("scode") String scode) {
        int count = ss.checkCode(scode); // 서비스 메서드 호출
        System.out.println("count" + count);
        return ResponseEntity.ok(count); // count 값을 HTTP 응답으로 반환
    }


    @GetMapping("/storage/storageMain.do")
    public String showMembers(@RequestParam(value = "mspot", required = false) String mspot,@RequestParam(value ="search", required = false) String search, Model m, HttpServletRequest req) {
    	 HttpSession sess = req.getSession();
    	 String sessionMspot = (String) sess.getAttribute("mspot");
    	 mspot = sessionMspot; 
    	 
    	 if(search == null) {
    	 List<StorageDTO> members = ss.searchall(mspot); // 전체 멤버 가져오기	
    	 m.addAttribute("members", members); // 모델에 추가
    	 }else {
     	 
    		 
    	 List<StorageDTO> all = ss.all(search);
     	 m.addAttribute("members", all);
    	 }

        return null; // JSP 페이지 이름 반환
    }
    
        

    @GetMapping("/storage/storageUpdate.do")
    public String getMember(@RequestParam(value = "scode") String scode, Model m) {
        m.addAttribute("member", ss.getByID(scode));
        return null;
    }

    @PostMapping("/storage/storageUpdate.do")
    public String updateMember(StorageDTO storageDTO, Model m) {
       
    	try {
    	ss.updateByID(storageDTO);
  
        this.output = this.js.ok("수정 되었습니다.", "/storage/storageMain.do");
        
    	}catch (Exception e) {
    		this.output = this.js.no("변경 실패하였습니다.");
		}
        
    	m.addAttribute("output", output);
        m.addAttribute("member", ss.getByID(storageDTO.getScode()));
        return "output";
    }
    
    @PostMapping("/storageDelete.do")
    public String deleteStorage(@RequestParam("scode") String scode, Model m) {
    	 	System.out.println(scode);
    	try {
    	int result = ss.deleteByID(scode);
    	System.out.println(result);
  
	    	if(result > 0){
	    		this.output = this.js.ok("수정 되었습니다.", "/storage/storageMain.do");
	    	}else {
	    		this.output = this.js.no("변경 하실 수 없습니다.");
	    	}
            
    	}catch (Exception e) {
    		this.output = this.js.no("변경 실패하였습니다.");
		}
        
    	m.addAttribute("output", output);
        return "output";
    }
    

}
