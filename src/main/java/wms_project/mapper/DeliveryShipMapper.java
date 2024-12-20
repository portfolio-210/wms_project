package wms_project.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import wms_project.dto.DeliveryShipDTO;

@Mapper
public interface DeliveryShipMapper {

	public List<DeliveryShipDTO> ShipName();
}
