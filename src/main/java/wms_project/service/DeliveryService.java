package wms_project.service;

import java.util.List;
import java.util.Map;

import jakarta.servlet.http.HttpSession;
import wms_project.dto.DeliveryDTO;

public interface DeliveryService {

	// 배송기사 등록
	public int deliveryInsert(DeliveryDTO dto);
	
	// 배송기사 리스트 출력 + 페이징
	public List<DeliveryDTO> deliveryList(HttpSession session);
	//public List<DeliveryDTO> deliveryList(Map<String, String> pg);
	
	// mspot기준 전체 카운트
	public String deliveryMspotCtn(String mspot);
	
	
	
	// 사원번호 자동생성 (DB카운트)
	public String deliveryCtn();
	
	// 승연여부
	public int deliveryApprove(DeliveryDTO dto);
	List<DeliveryDTO> deliveryList();





}
