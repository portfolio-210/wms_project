package wms_project.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import wms_project.dto.ConfigDTO;

@Mapper
public interface ConfigMapper {
	List<ConfigDTO> all(Map<String, Object> keycode);
	List<ConfigDTO> searchall(Map<String, Object>params);
	int update1(ConfigDTO configDTO);
	Integer Total(ConfigDTO configDTO);
}
