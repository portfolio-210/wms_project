package wms_project.service;

import wms_project.dto.StorageDTO;

public interface StorageService {
	
	int insert1(StorageDTO storageDTO);
	int checkCode(String scode);
}
