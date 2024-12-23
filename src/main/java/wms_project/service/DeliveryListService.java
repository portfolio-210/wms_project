package wms_project.service;

import java.util.List;
import java.util.Map;

import jakarta.servlet.http.HttpSession;
import wms_project.dto.DeliveryListDTO;

public interface DeliveryListService {

	// 배송기사 등록
	public int deliveryInsert(DeliveryListDTO dto);
	
	// 배송기사 리스트 출력 + 페이징
	//public List<DeliveryDTO> deliveryList(HttpSession session);
	//public List<DeliveryDTO> deliveryList(Map<String, String> pg);
	
	
	public List<DeliveryListDTO> deliveryList(Map<String, Object> params);
	
	
	// 검색기반 카운팅
		//public String deliveryMspotCtn(Map<String, Object> params);
	// mspot기준 전체 카운트
	public String deliveryMspotCtn(String mspot);
	
	
	
	// 사원번호 자동생성 (DB카운트)
	public String deliveryCtn();
	// 승연여부
	public int deliveryApprove(DeliveryListDTO dto);
	// 수정 idx
	public DeliveryListDTO deliveryModifyIdx(String didx);
	// 수정 업데이트
	public int deliveryModify(DeliveryListDTO dto);





}
