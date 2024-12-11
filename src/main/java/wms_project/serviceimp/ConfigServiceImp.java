package wms_project.serviceimp;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import wms_project.dto.ConfigDTO;
import wms_project.mapper.ConfigMapper;
import wms_project.service.ConfigService;

@Service
public class ConfigServiceImp implements ConfigService {

	@Autowired
	ConfigMapper cm;


	@Override
	public List<ConfigDTO> all(Map<String, Object> keycode) {
			
		List<ConfigDTO> all = cm.all(keycode);
		
		return all;
	}
	
	@Override
	public List<ConfigDTO> searchall() {
	
	return cm.searchall();
	}
	
	@Override
	public Integer Total(ConfigDTO configDTO) {
		Integer total = cm.Total(configDTO);
		return total;
	}
	
	
	@Override
	public int update1(ConfigDTO configDTO) {
	return cm.update1(configDTO);
	}
}
