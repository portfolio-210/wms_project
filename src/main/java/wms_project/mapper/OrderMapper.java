package wms_project.mapper;

import org.apache.ibatis.annotations.Mapper;
import wms_project.dto.ShippingDTO;

@Mapper
public interface OrderMapper {
    //첨부파일 내용 insert
    int insert_order(ShippingDTO sdto);
}
