package wms_project.service;

import java.util.List;
import java.util.Map;

import wms_project.dto.DeliveryShipDTO;

public interface DeliveryShipService {
	
	// 배송 기사별 현황 옵션 출력
	public List<DeliveryShipDTO> ShipName();
	
	// 배송기사 리스트 출력 + 날짜별 + 배송기사별현황
	public List<DeliveryShipDTO> ShipList(Map<String, Object> list);
	
	//total
	public int ShipCtn(Map<String, Object> ctn);
	
	//운송장 생성
	public int ShipTracking(DeliveryShipDTO dto);
	
	public String ShipTR(String aidx);
	
	//qr 조회
	public String ShipQR(String aidx);	
	
	//qr 생성업데이트
	public int QRmake(DeliveryShipDTO dto);
}
