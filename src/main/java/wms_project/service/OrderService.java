package wms_project.service;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.multipart.MultipartFile;
import wms_project.dto.ShippingDTO;

public interface OrderService {
    //첨부파일 저장
    String file_save(MultipartFile order_file, HttpServletRequest req);
    //첨부파일 내용 insert
    int insert_order(ShippingDTO sdto);
}
