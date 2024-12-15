package wms_project.serviceimp;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.servlet.http.HttpSession;
import wms_project.controller.AccountController;
import wms_project.controller.DeliveryController;
import wms_project.dto.DeliveryDTO;
import wms_project.mapper.DeliveryMapper;
import wms_project.service.DeliveryService;

@Service
public class DeliveryServiceImp implements DeliveryService{

	@Autowired
	private DeliveryMapper dm;

	@Autowired
    private HttpSession session;  // HttpSession 주입
	
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
		pg.put("startno", String.valueOf(DeliveryController.startno));	// 0번부터 mapper에 #{이걸로해놈}
		pg.put("endno", String.valueOf(DeliveryController.endno));	// 0번부터 mapper에 #{이걸로해놈} 컨트롤러에 스태틱 가져옴
		
		String mspot = (String) session.getAttribute("mspot");
	    pg.put("mspot", mspot);
		
		
		List<DeliveryDTO> all = dm.deliveryList(pg);
		return all;
	}
	
	@Override
	public String deliveryMspotCtn(String mspot) {
		return dm.deliveryMspotCtn(mspot);
	}
	
	
	// 사원번호 자동생성 (DB카운트)
	@Override
	public String deliveryCtn() {
		String result = dm.deliveryCtn();
		
		return result;
	};
	
	
	@Override
	public int deliveryApprove(DeliveryDTO dto) {
		int result = dm.deliveryApprove(dto);
		return result;
	}

	@Override
	public List<DeliveryDTO> deliveryList(HttpSession session) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
	
	
}
