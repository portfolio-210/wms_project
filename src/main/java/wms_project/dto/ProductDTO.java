package wms_project.dto;

import java.util.List;

import org.springframework.stereotype.Repository;

import lombok.Data;

@Data
@Repository("ProductDTO")
public class ProductDTO {
	 int pdamount;   //입고 번호 auto, 입고 갯수
	 String acompany, acode, pdcode, pdname, sname, scode, pname, pddate;

}
