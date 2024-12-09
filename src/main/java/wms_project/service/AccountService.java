package wms_project.service;

import java.util.List;

import wms_project.dto.AccountDTO;

public interface AccountService {
	

		public int account_insert(AccountDTO dto);
		public String search_company(String acompany);
		public String account_ctn();
		public List<AccountDTO> accountList();
		public String accountIdx(String aidx);
		
}
