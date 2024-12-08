package wms_project.service;

import java.util.List;

import wms_project.dto.MemberDTO;

public interface MemberService {

	// 1) 회원가입
	public int member_join(MemberDTO dto);
	
	//2) 아이디 중복확인
	public String search_id(String mid);
	
	//3) 로그인 
	public List<MemberDTO> login_id(String mid);
}
