package wms_project.service;

import java.util.List;


import wms_project.dto.StorageDTO;

public interface StorageService {

    int insert1(StorageDTO storageDTO);

    int checkCode(String scode);

    List<StorageDTO> searchall(String mspot);

    StorageDTO getByID(String scode);

    int updateByID(StorageDTO storageDTO);
    
    List<StorageDTO> all(String search);
    
    int deleteByID(String scode);
}
