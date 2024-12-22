package wms_project.service;

import wms_project.dto.ProductDTO;
import wms_project.dto.ShippingDTO;

import java.util.List;
import java.util.Map;

public interface ShipmentService {
    //오더 리스트 출력
    List<ShippingDTO> shipment_list(Map<String, Object> paramValue);
    //물품 검색 팝업 상품 리스트 출력
    List<ProductDTO> product_list(Map<String, Object> paramValue);
}
