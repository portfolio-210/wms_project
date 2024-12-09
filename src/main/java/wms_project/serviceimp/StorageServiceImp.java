package wms_project.serviceimp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import wms_project.dto.StorageDTO;
import wms_project.mapper.StorageMapper;
import wms_project.service.StorageService;

@Service
public class StorageServiceImp implements StorageService {

	
	@Autowired
	StorageMapper sm;
	
	@Override
	public int insert1(StorageDTO storageDTO) {
		
		return sm.insert1(storageDTO);
	}
		
	@Override
	public int checkCode(String scode) {
		int count = sm.checkCode(scode);
        return count;		
	}
	
	@Override
	public List<StorageDTO> searchall(String mspot) {
		
		return sm.searchall(mspot);
	}
		
}
