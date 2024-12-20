package wms_project.serviceimp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import wms_project.dto.DeliveryShipDTO;
import wms_project.mapper.DeliveryShipMapper;
import wms_project.service.DeliveryShipService;

@Service
public class DeliveryShipServiceImp implements DeliveryShipService {
	
	@Autowired
	private DeliveryShipMapper dsm;
	
	@Override
	public List<DeliveryShipDTO> ShipName() {
		List<DeliveryShipDTO> dsnm = dsm.ShipName();
		return dsnm;
	}
	
	
	
}
