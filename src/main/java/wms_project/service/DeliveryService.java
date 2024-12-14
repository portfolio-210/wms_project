package wms_project.service;

import java.util.List;

import wms_project.dto.DeliveryDTO;

public interface DeliveryService {

	// 배송기사 등록
	public int deliveryInsert(DeliveryDTO dto);
	// 배송기사 리스트 출력 + 페이징
	public List<DeliveryDTO> deliveryList();
	// 사원번호 자동생성 (DB카운트)
	public String deliveryCtn();




}
