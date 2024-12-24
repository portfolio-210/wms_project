package wms_project.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import wms_project.dto.MobileDTO;

@Mapper
public interface MobileMapper {
	public List<MobileDTO> MobileLogin(String deliver_id);
	public List<MobileDTO> MobileList(Map<String, Object>list);
	public int MobileState(MobileDTO dto);
}
