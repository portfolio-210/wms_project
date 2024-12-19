package wms_project.service;

import java.util.List;
import java.util.Map;

import wms_project.dto.ProductDTO;
import wms_project.dto.ProductsDTO;
import wms_project.dto.StorageDTO;

public interface StorageService {

    int insert1(StorageDTO storageDTO);

    int checkCode(String scode);

    List<StorageDTO> searchall(String mspot);
    List<StorageDTO> searchto(String selectstorage);//전체 창고 리스트에서 첫번째 선택 창고 리스트만 뺌

    StorageDTO getByID(String scode);

    int updateByID(StorageDTO storageDTO);
    
    List<StorageDTO> all(String search);
    
    int deleteByID(String scode);
    
    //상품 입고 관련
    //거래처 이름으로 거래처 코드 찾기
    String getAcode(String acompany);
    //상품 입고하기
    int insertStore(ProductsDTO productsDto);
    
    //창고에 따른 상품 리스트 출력하기
    List<ProductDTO> productlist(String selectstorage);
    
    //기존 입고 테이블의 필요성분 가져오기
    ProductDTO selectProduct(String pdidx);
    
    //새로운 창고로 물건 이동시키기    
    void moveProduct(ProductDTO newProduct);
    
        
    void updateProduct(Map<String, String> params);
}
