package wms_project.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;


import wms_project.dto.StorageDTO;

@Mapper
public interface StorageMapper {

	int insert1(StorageDTO storageDTO);
	int checkCode(String scode);
	List<StorageDTO> searchall(String mspot);
}
