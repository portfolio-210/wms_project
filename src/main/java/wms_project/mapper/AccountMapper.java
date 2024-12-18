package wms_project.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import wms_project.dto.AccountDTO;
import wms_project.dto.OfficeDTO;

@Mapper
public interface AccountMapper {

	// 거래처 등록
	public int account_insert(AccountDTO dto);	
	// 거래처명 중복검사
	public String search_company(String acompany);
	// 거래처 리스트 총 갯수
	public String account_ctn();
	// 거래처 리스트 출력 + 페이징
	//public List<AccountDTO> accountList(Map<String, String> pg);
	// 거래처 검색
	//public List<AccountDTO> accountSearch (String search);
	
	//위에꺼 말고 새로
	// 리스트 + 검색 + 페이징
	List<AccountDTO> accountList(Map<String, Object> paramValue);
	// 카운트 검색
	int accountCtn(Map<String, Object> paramValue);
	
	
	
	// 페이징 카운트
	public int accountListCtn();
	// 거래처 수정 조회
	public AccountDTO accountIdx(String aidx);
	// 거래처 수정 (UPDATE)
	public int accountModify(AccountDTO dto);
	// 삭제 UPDATE
	public int accountDelete (String aidx);
	
	
	
	
	public List<AccountDTO> accountListALL(Map<String, String> pg);
	public Integer accountAllCtn(String search);
	
	

	
}
