package wms_project.serviceimp;


import java.util.HashMap;
import java.util.List;
import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import wms_project.controller.AccountController;
import wms_project.dto.AccountDTO;
import wms_project.mapper.AccountMapper;
import wms_project.service.AccountService;

@Service
public class AccountServiceImp implements AccountService {


	
	@Autowired
	private AccountMapper am;
	

		@Override
		public int account_insert(AccountDTO dto) {

			int result = am.account_insert(dto);
			return result;
		};
	
		@Override
		public String search_company(String acompany) {	
			String result = am.search_company(acompany);
			return result;
		};
		
		@Override
		public String account_ctn() {
			String result = am.account_ctn();
			return result;
		};
		

		@Override
		public List<AccountDTO> accountList(){
			Map<String, String> pg = new HashMap<>();
			pg.put("startno", String.valueOf(AccountController.startno));	// 0번부터 mapper에 #{이걸로해놈}
			pg.put("endno", String.valueOf(AccountController.endno));	// 0번부터 mapper에 #{이걸로해놈} 컨트롤러에 스태틱 가져옴
			List<AccountDTO> all = am.accountList(pg);
			return all;
		};

		
		
		
		
		
		
		

		// modify 수정페이지
		@Override
		public AccountDTO accountIdx(String aidx) {
			AccountDTO adto = am.accountIdx(aidx);
			return adto;
		};
		
		// modify 수정완료
		@Override
		public int accountModify(AccountDTO dto) {
			int result = am.accountModify(dto);
			return result;
		};
		
		@Override
		public List<AccountDTO> accountSearch(String search) {
			List<AccountDTO> result = am.accountSearch(search);
			return result;
		};
		@Override
		public int accountDelete(String aidx) {
			int result = am.accountDelete(aidx);
			return result;
		}
		//페이징 카운트
		@Override
		public int accountListCtn() {
			int result = am.accountListCtn();
			return result;
		}
		
		
	
}
