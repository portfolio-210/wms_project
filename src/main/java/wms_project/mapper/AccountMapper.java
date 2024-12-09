package wms_project.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import wms_project.dto.AccountDTO;

@Mapper
public interface AccountMapper {


	int account_insert(AccountDTO dto);	
	public String search_company(String acompany);
	public String account_ctn();
	public List<AccountDTO> accountList();
	public String accountIdx(String aidx);
	
}
