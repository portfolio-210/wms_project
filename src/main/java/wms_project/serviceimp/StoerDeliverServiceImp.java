package wms_project.serviceimp;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import wms_project.dto.DeliveryDTO;
import wms_project.dto.ShippingDTO;
import wms_project.mapper.StoreDeliveryMapper;
import wms_project.service.StoreDeliveryService;




@Service
public class StoerDeliverServiceImp implements StoreDeliveryService {

	@Autowired
	StoreDeliveryMapper sdm;
	
	
	@Override
	public List<ShippingDTO> order_list(Map<String, Object> params) {
		
		return sdm.order_list(params);
	}
	
	@Override
	public List<DeliveryDTO> deliverymenlist(String mspot) {
		
		return sdm.deliverymenlist(mspot);
	}
	
	@Override
	public void useDeliverymen(Map<String, Object> params) {
		
		sdm.useDeliverymen(params);
	}
	
	@Override
	public int DeleteDeliverymen(int aidx) {
		int result = sdm.DeleteDeliverymen(aidx);
		return result;
	}
	
	
}
