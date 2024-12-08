package wms_project.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import wms_project.dto.MemberDTO;

@Mapper
public interface MemberMapper {

	//1) 회원가입
	int member_join(MemberDTO dto);
	
	//2 아이디 중복확인
	String search_id(String mid);
	
	//3) 로그인 사용자 정보 체크
	List<MemberDTO> login_id(String mid);
}
