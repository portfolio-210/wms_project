package wms_project.service;

import java.util.List;
import java.util.Map;

import wms_project.dto.DeliveryDTO;
import wms_project.dto.ShippingDTO;

public interface StoreDeliveryService {

	List<ShippingDTO> order_list(Map<String, Object> params);
	List<DeliveryDTO> deliverymenlist(String mspot);
	void useDeliverymen(Map<String, Object> params);
	
	int DeleteDeliverymen(int aidx);
}
