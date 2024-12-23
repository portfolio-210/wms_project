package wms_project.serviceimp;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.servlet.http.HttpSession;
import wms_project.controller.AccountController;
import wms_project.controller.DeliveryListController;
import wms_project.dto.DeliveryListDTO;
import wms_project.mapper.DeliveryListMapper;
import wms_project.service.DeliveryListService;

@Service
public class DeliveryListServiceImp implements DeliveryListService{

	@Autowired
	private DeliveryListMapper dm;

	
	// 배송기사 등록
	@Override
	public int deliveryInsert(DeliveryListDTO dto) {
		int result = dm.deliveryInsert(dto);
		return result;
	};

	// 리스트 + 검색 + 페이징
	@Override
	public List<DeliveryListDTO> deliveryList(Map<String, Object> paramValue) {
		List<DeliveryListDTO> result = dm.deliveryList(paramValue);
		return result;
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
	// 승인처리 	
	@Override
	public int deliveryApprove(DeliveryListDTO dto) {
		int result = dm.deliveryApprove(dto);
		return result;
	}


	// 수정 idx값 가져오기
	@Override
	public DeliveryListDTO deliveryModifyIdx(String didx) {
		DeliveryListDTO ddto = dm.deliveryModifyIdx(didx);
		return ddto;
	}
	// 수정 update
	@Override
	public int deliveryModify(DeliveryListDTO dto) {
		int result = dm.deliveryModify(dto);
		return result;
	}

	
	
	
	
}
