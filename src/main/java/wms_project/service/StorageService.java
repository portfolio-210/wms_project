package wms_project.service;

import java.util.List;

import wms_project.dto.ProductDTO;
import wms_project.dto.ProductsDTO;
import wms_project.dto.StorageDTO;

public interface StorageService {

    int insert1(StorageDTO storageDTO);

    int checkCode(String scode);

    List<StorageDTO> searchall(String mspot);

    StorageDTO getByID(String scode);

    int updateByID(StorageDTO storageDTO);
    
    List<StorageDTO> all(String search);
    
    int deleteByID(String scode);
    
    //상품 입고 관련
    //거래처 이름으로 거래처 코드 찾기
    String getAcode(String acompany);
    
    int insertStore(ProductsDTO productsDto);
}
