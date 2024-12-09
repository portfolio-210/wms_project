package wms_project.serviceimp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import wms_project.dto.AccountDTO;
import wms_project.mapper.AccountMapper;
import wms_project.service.AccountService;

@Service
public class AccountServiceimp implements AccountService {

	@Autowired
	private AccountMapper am;
	

		@Override
		public int account_insert(AccountDTO dto) {
			int result = am.account_insert(dto);
			return result;
		}
	
		@Override
		public String search_company(String acompany) {	
			String result = am.search_company(acompany);
			return result;
		}
		
		@Override
		public String account_ctn() {
			String result = am.account_ctn();
			return result;
		};
		
		@Override
		public List<AccountDTO> accountList(){
			List<AccountDTO> all = am.accountList();
			return all;
			
		}
		
		@Override
		public String accountIdx(String aidx) {
			String result = am.accountIdx(aidx);
			return null;
		}
}
