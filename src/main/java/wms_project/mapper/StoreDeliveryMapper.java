package wms_project.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import wms_project.dto.DeliveryDTO;
import wms_project.dto.ShippingDTO;

@Mapper
public interface StoreDeliveryMapper {
	
	List<ShippingDTO> order_list(Map<String, Object> params);
	List<DeliveryDTO> deliverymenlist(String mspot);
	
	void useDeliverymen(Map<String, Object> params);
	
	int DeleteDeliverymen(int aidx);
}
