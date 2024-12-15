package wms_project.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import wms_project.dto.DeliveryDTO;

@Mapper
public interface DeliveryMapper {

	// 배송기사 등록
	public int deliveryInsert(DeliveryDTO dto);
	// 배송기사 리스트 출력 + 페이징
	public List<DeliveryDTO> deliveryList(Map<String, String> pg);
	// mspot기준 전체 카운트
	public String deliveryMspotCtn(String mspot);
	
	// 사원번호 자동생성 (DB카운트)
	public String deliveryCtn();
	
	// 승연여부
	public int deliveryApprove(DeliveryDTO dto);
	
	
}
