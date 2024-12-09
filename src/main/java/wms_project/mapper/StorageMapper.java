package wms_project.mapper;

import org.apache.ibatis.annotations.Mapper;

import wms_project.dto.StorageDTO;

@Mapper
public interface StorageMapper {

	int insert1(StorageDTO storageDTO);
	int checkCode(String scode);
}
