package wms_project.controller;

import jakarta.annotation.Resource;
import org.apache.commons.math3.stat.descriptive.summary.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import wms_project.dto.ProductDTO;
import wms_project.dto.ShippingDTO;
import wms_project.service.ShipmentService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class shipmentController {

    @Resource(name="ShippingDTO")
    ShippingDTO sdto;

    @Autowired
    ShipmentService ss;

    //shipmentMain 배송 선택 메인 페이지 출력
    @GetMapping("/shipment/shipmentMain.do")
    public String shipment_list(@RequestParam(value = "start_date", required = false) String start_date,
                                @RequestParam(value = "end_date", required = false) String end_date,
                                Model m){
        Map<String, Object> paramValue = new HashMap<>();
        paramValue.put("start_date", start_date);
        paramValue.put("end_date", end_date);
        List<ShippingDTO> result = ss.shipment_list(paramValue);

        m.addAttribute("all", result);
        m.addAttribute("start_date", start_date);
        m.addAttribute("end_date", end_date);

        return null;
    }

    //물품 검색 팝업 페이지 출력
    @GetMapping("/shipment/shipmentPopList.do")
    public String pop_list(@RequestParam(value = "pdcodes", required = false) String pdcodes,
                           @RequestParam(value = "part", required = false) String part,
                           @RequestParam(value = "search", required = false) String search,
                           Model m){
        String[] aproductcodes = pdcodes.split(",");
        Map<String, Object> paramValue = new HashMap<>();
        paramValue.put("part", part);
        paramValue.put("search", search);
        List<ProductDTO> all = new ArrayList<>();
        for (String aproductcode : aproductcodes) {
            paramValue.put("aproductcode", aproductcode);
            List<ProductDTO> product = ss.product_list(paramValue);
            all.addAll(product);
        }
        m.addAttribute("all", all);
        m.addAttribute("pdcodes", pdcodes);
        return null;
    }
}
