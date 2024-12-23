package wms_project.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import wms_project.dto.DeliveryShipDTO;

@Mapper
public interface DeliveryShipMapper {

	
	// 배송기사별 현황 출력
	public List<DeliveryShipDTO> ShipName();
	
	// 배송기사 리스트 출력 + 날짜별 + 배송기사별현황
	public List<DeliveryShipDTO> ShipList(Map<String, Object> list);
	
	// total값
	public int ShipCtn(Map<String, Object> ctn);
	
	// 운송장 업데이트
	public int ShipTracking(DeliveryShipDTO dto);
	
	// 운송장 있는지 조회
	public String ShipTR(String aidx);
	
	//qr 조회
	public String ShipQR(String aidx);
	
	//qr 생성업데이트
	public int QRmake(DeliveryShipDTO dto);
}
