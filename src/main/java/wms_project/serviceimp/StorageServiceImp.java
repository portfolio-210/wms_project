package wms_project.serviceimp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import wms_project.dto.ConfigDTO;
import wms_project.dto.ProductDTO;
import wms_project.dto.ProductsDTO;
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

    @Override
    public StorageDTO getByID(String scode) {
        return sm.getByID(scode);
    }

    @Override
    public int updateByID(StorageDTO storageDTO) {
        return sm.updateByID(storageDTO);
    }
    
    @Override
    public List<StorageDTO> all(String search) {
    	
    	return sm.all(search);
    }
    
    @Override
    public int deleteByID(String scode) {
    	StorageDTO storageDTO = new StorageDTO();
        storageDTO.setScode(scode);  	
    	return sm.deleteByID(scode);
    }
    
    //상품 입고 관련
    
    @Override
    public String getAcode(String acompany) {
        return sm.getAcode(acompany);
    }
    
    @Override
    public int insertStore(ProductsDTO productsDto) {
    	
    	
	    return sm.insertStore(productsDto); // 최종 삽입된 개수 반환
    }

}
