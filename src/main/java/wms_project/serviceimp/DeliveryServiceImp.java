package wms_project.serviceimp;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import wms_project.controller.AccountController;
import wms_project.dto.DeliveryDTO;
import wms_project.mapper.DeliveryMapper;
import wms_project.service.DeliveryService;

@Service
public class DeliveryServiceImp implements DeliveryService{

	@Autowired
	private DeliveryMapper dm;
	
	// 배송기사 등록
	@Override
	public int deliveryInsert(DeliveryDTO dto) {
		int result = dm.deliveryInsert(dto);
		return result;
	};
	
	// 배송기사 리스트 출력 + 페이징
	@Override
	public List<DeliveryDTO> deliveryList() {
		Map<String, String> pg = new HashMap<>();
		pg.put("startno", String.valueOf(AccountController.startno));	// 0번부터 mapper에 #{이걸로해놈}
		pg.put("endno", String.valueOf(AccountController.endno));	// 0번부터 mapper에 #{이걸로해놈} 컨트롤러에 스태틱 가져옴
		List<DeliveryDTO> all = dm.deliveryList(pg);
		return all;
	}
	
}
