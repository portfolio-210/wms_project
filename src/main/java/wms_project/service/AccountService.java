package wms_project.service;

import java.util.List;
import java.util.Map;

import wms_project.dto.AccountDTO;

public interface AccountService {
	
		// 거래처 등록
		public int account_insert(AccountDTO dto);
		// 거래처명 중복검사
		public String search_company(String acompany);
		// 거래처 리스트 총 갯수
		public String account_ctn();
		// 거래처 리스트 출력
		public List<AccountDTO> accountList();

		
		
		
		// 페이징 카운트
		public int accountListCtn();
		// 거래처 수정 조회
		public AccountDTO accountIdx(String aidx);
		// 거래처 수정 (UPDATE)
		public int accountModify(AccountDTO dto);
		// 거래처 검색
		public List<AccountDTO> accountSearch (String search);
		// 삭제 UPDATE
		public int accountDelete (String aidx);
		
}
