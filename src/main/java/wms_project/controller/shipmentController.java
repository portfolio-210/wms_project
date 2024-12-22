package wms_project.controller;

import jakarta.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import wms_project.dto.ShippingDTO;

@Controller
public class shipmentController {

    @Resource(name="ShippingDTO")
    ShippingDTO sdto;

    @GetMapping("/shipment/shipmentMain.do")
    public String shipment_list(){

        return null;
    }
}
