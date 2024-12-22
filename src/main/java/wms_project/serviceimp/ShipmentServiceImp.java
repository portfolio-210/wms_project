package wms_project.serviceimp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wms_project.dto.ProductDTO;
import wms_project.dto.ShippingDTO;
import wms_project.mapper.ShipmentMapper;
import wms_project.service.ShipmentService;

import java.util.List;
import java.util.Map;

@Service
public class ShipmentServiceImp implements ShipmentService {
    @Autowired
    ShipmentMapper sm;

    //오더 리스트 출력
    @Override
    public List<ShippingDTO> shipment_list(Map<String, Object> paramValue) {
        List<ShippingDTO> result = sm.shipment_list(paramValue);
        return result;
    }

    //물품 검색 팝업 상품 리스트 출력
    @Override
    public List<ProductDTO> product_list(Map<String, Object> paramValue) {
        List<ProductDTO> result = sm.product_list(paramValue);
        return result;
    }

}
