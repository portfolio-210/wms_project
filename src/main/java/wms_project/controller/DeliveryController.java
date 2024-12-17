package wms_project.controller;

import java.io.File;
import java.io.PrintWriter;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;


import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import wms_project.dto.AccountDTO;
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
	public String deliveryMain(Model m,@RequestParam(value="pageno", required = false) Integer pageno,
			HttpSession session) {

		 
		
		
		if(pageno==null) {
			this.startno = 0;
			this.endno = 15;
			
		}else {	// URI가 파라미터가 있을경우
			this.startno = (pageno-1) * 15;	//15개씩 출력
			this.endno = 15;
		}		
	
		
		// 전체
		//String result = ds.deliveryCtn();		
		
		// mspot값만 전체 값으로 핸들링 ㅜㅜ
		String mspot = (String) session.getAttribute("mspot");
	    String result = ds.deliveryMspotCtn(mspot);
		

		List<DeliveryDTO> all = ds.deliveryList();
		m.addAttribute("all", all);
		m.addAttribute("total", result);
		// 사용자가 클릭한 페이지번호
		m.addAttribute("userpage",pageno);	

		return null;
	}
	
	
	
	@PostMapping("/delivery/deliveryInsertok.do")
	public String deliveryInsertok( @ModelAttribute("delivery") DeliveryDTO dto,
									@RequestParam("dimgnmf") MultipartFile files, 
									HttpServletResponse res, 
									HttpServletRequest req,
									Model m)throws Exception {
		
		Date date = new Date();
		SimpleDateFormat si = new SimpleDateFormat("yyyyMMddhhmmss");
		Random random = new Random();
		
		// 사진 첨부 핸들링
		
		if("".equals(dto.getDimgnm())) {
			dto.setDimgnm("N");
		} 
		
		
		if ("N".equals(dto.getDimgnm())) {
		    dto.setDimgrenm("N");
		    dto.setDimgurl("N");
		    dto.setDimgck("N");
		} else {
		    dto.setDimgrenm("Y");
		    dto.setDimgurl("Y");
		    dto.setDimgck("Y");
		}
		
		// 패스워드 보안
		String userpw = dto.getDpass();
		StringBuilder repass = secode(userpw);
		dto.setDpass(repass.toString());
		
		// 사진 첨부
		
		String filenm = files.getOriginalFilename();
		long filesize = files.getSize();
		
		if (filesize > 2097152) {
			this.output=this.js.no("첨부파일 용량은 최대 2MB까지만 등록 가능합니다.");
		}else {	
			
			String url = req.getServletContext().getRealPath("/imgUpload/");
			//System.out.println(url);
			String type = filenm.substring(filenm.lastIndexOf("."));
			int no = random.nextInt(40)+1;	
			String new_nm = si.format(date);

			FileCopyUtils.copy(files.getBytes(), new File(url+new_nm+no+type));

				dto.setDimgnm(filenm);
				dto.setDimgrenm(new_nm+no+type);
				dto.setDimgurl("./imgUpload/");
		}
		
			            
		try {
			// 사진 없이 등록하면 dimgnm 컬럼에 "N"값으로 변경
			int result = ds.deliveryInsert(dto);
			
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

	//배송기사 사원번호 자동생성 (AJAX)
	@CrossOrigin("*")
	@GetMapping("/delivery/deliveryCode.do")
	public String deliveryCode(HttpServletResponse res) throws Exception {	
		
		PrintWriter pw = res.getWriter();
		String ctn = "";
		ctn = ds.deliveryCtn();
		System.out.println(ctn);
		pw.print(ctn);
		pw.close();
		return null;
	}
	
	
	
	//배송기사 현황 바꾸기
	@GetMapping("/delivery/deliveryApprove.do")
	public String deliveryApprove(@RequestParam("dapprove") String approve,
	                               @RequestParam("didx") String idx, 
	                               Model m) {
	   
	    dto.setDapprove(approve);  
	    dto.setDidx(Integer.parseInt(idx)); 

	    try {
	        int result = ds.deliveryApprove(dto);
		        if (result > 0) {
		        	//System.out.println(result);
		        	this.output=this.js.ok("배송기사의 현황이 [ "+ approve +" ] 변경 되었습니다.", "/delivery/deliveryMain.do");
		        } else {
		        	this.output=this.js.no("배송기사의 현황 수정을 실패하였습니다. 다시 시도해 주세요.");
		        }
	    } catch (Exception e) {
	        e.printStackTrace();
	        this.output=this.js.no("데이터 오류로 인하여 수정 되지 않습니다. 다시 시도해 주세요"+ e.getMessage());
	    }
	    
	    m.addAttribute("output", output);
	    return "output"; 
	}
	
	//수정 idx값으로 조회
	@GetMapping("/delivery/deliveryModify.do")
	public String deliveryModify(@RequestParam("didx") String didx,
								Model m) {
		DeliveryDTO ddto = ds.deliveryModifyIdx(didx);
		m.addAttribute("ddto", ddto);
		
		return "delivery/deliveryModify";
	}
	
	
	/*
	@PostMapping("/delivery/deliveryModifyok.do")
	public String deliveryModifyok( @ModelAttribute("modify") DeliveryDTO dto,
									@RequestParam("dimgnmf") MultipartFile files, 
									HttpServletResponse res, 
									HttpServletRequest req,
									Model m)throws Exception {
		Date date = new Date();
		SimpleDateFormat si = new SimpleDateFormat("yyyyMMddhhmmss");
		Random random = new Random();
		
		System.out.println("사진은??"+files);
		// 사진 첨부 핸들링
		
		if("".equals(dto.getDimgnm())) {
			dto.setDimgnm("N");
		} 
		
		
		if ("N".equals(dto.getDimgnm())) {
		    dto.setDimgrenm("N");
		    dto.setDimgurl("N");
		    dto.setDimgck("N");
		} else {		    
			  dto.setDimgrenm("Y");
			    dto.setDimgurl("Y");
			    dto.setDimgck("Y");
			
		}
		
		// 패스워드 보안
		String userpw = dto.getDpass();
		StringBuilder repass = secode(userpw);
		dto.setDpass(repass.toString());
		
		// 사진 첨부
		
		String filenm = files.getOriginalFilename();
		long filesize = files.getSize();
		
		if (filesize > 2097152) {
			this.output=this.js.no("첨부파일 용량은 최대 2MB까지만 등록 가능합니다.");
		}else {	
			
			String url = req.getServletContext().getRealPath("/imgUpload/");
			//System.out.println(url);
			String type = filenm.substring(filenm.lastIndexOf("."));
			int no = random.nextInt(40)+1;	
			String new_nm = si.format(date);

			FileCopyUtils.copy(files.getBytes(), new File(url+new_nm+no+type));

				dto.setDimgnm(filenm);
				dto.setDimgrenm(new_nm+no+type);
				dto.setDimgurl("./imgUpload/");
		}
		
			           
		try {
			// 사진 없이 등록하면 dimgnm 컬럼에 "N"값으로 변경
			int result = ds.deliveryModify(dto);
			System.out.println("result 는?"+result);
			
			if(result > 0) {
				this.output=this.js.ok("배송기사 수정이 완료 되었습니다.", "/delivery/deliveryMain.do");
			}
			else {
				this.output=this.js.no("배송기사 수정을 실패하였습니다. 다시 시도해 주세요.");
			}
		} catch (Exception e) {
			e.printStackTrace();
			this.output=this.js.no("데이터 오류로 인하여 등록 되지 않습니다. 다시 시도해 주세요"+e);
		}
		m.addAttribute("output", output);
		         
 		return "output";
	}
	*/
	@PostMapping("/delivery/deliveryModifyok.do")
	public String deliveryModifyok(@ModelAttribute("modify") DeliveryDTO dto,
	                               @RequestParam("dimgnmf") MultipartFile files, 
	                               HttpServletResponse res, 
	                               HttpServletRequest req,
	                               Model m) throws Exception {

	    Date date = new Date();
	    SimpleDateFormat si = new SimpleDateFormat("yyyyMMddhhmmss");
	    Random random = new Random();
	    
	
	    
	    // 사진 첨부 핸들링
	    if (dto.getDimgnm() == null) {
	        dto.setDimgnm("N");
	    }
	    
	    if ("N".equals(dto.getDimgnm())) {
	        dto.setDimgrenm("N");
	        dto.setDimgurl("N");
	        dto.setDimgck("N");
	    } else {
	    	dto.setDimgrenm("Y");
		    dto.setDimgurl("Y");
		    dto.setDimgck("Y");
	    }

	    // 패스워드 보안
	    String userpw = dto.getDpass();
	    StringBuilder repass = secode(userpw);
	    dto.setDpass(repass.toString());

	    // 사진 첨부
	    String filenm = files.getOriginalFilename();
	    long filesize = files.getSize();
	    
	    if (filesize > 2097152) {
	        this.output = this.js.no("첨부파일 용량은 최대 2MB까지만 등록 가능합니다.");
	    } else {
	        if (files.isEmpty()) {
	            this.output = this.js.no("파일을 선택해주세요.");
	        } else {
	            String url = req.getServletContext().getRealPath("/imgUpload/");
	            System.out.println(url);
	            String type = filenm.substring(filenm.lastIndexOf("."));
	            int no = random.nextInt(40) + 1;    
	            String new_nm = si.format(date);
	            
	            // 파일 복사
	            FileCopyUtils.copy(files.getBytes(), new File(url + new_nm + no + type));

	            dto.setDimgnm(filenm);
	            dto.setDimgrenm(new_nm + no + type);
	            dto.setDimgurl("./imgUpload/");
	            dto.setDimgck("Y");
	        }
	    }

	    try {
	        // 사진 없이 등록하면 dimgnm 컬럼에 "N"값으로 변경
	        int result = ds.deliveryModify(dto);
	        System.out.println("result 는?" + result);

	        if (result > 0) {
	            this.output = this.js.ok("배송기사 수정이 완료 되었습니다.", "/delivery/deliveryMain.do");
	        } else {
	            this.output = this.js.no("배송기사 수정을 실패하였습니다. 다시 시도해 주세요.");
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	        this.output = this.js.no("데이터 오류로 인하여 등록 되지 않습니다. 다시 시도해 주세요" + e);
	    }

	    m.addAttribute("output", output);
	    return "output";
	}

	
	
	
	
	
	
	
	
}
