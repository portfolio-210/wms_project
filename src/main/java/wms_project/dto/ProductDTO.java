package wms_project.dto;

import java.util.List;

import org.springframework.stereotype.Repository;

import lombok.Data;

@Data
@Repository("ProductDTO")
public class ProductDTO {
	 int pdamount;   //입고 번호 auto, 입고 갯수
	 String acompany, acode, pdcode, pdname, sname, scode, pname, pddate;
	 
	 private String pdidx; // 제품 ID
	 private String quantity; // 수량
	 private String instorecode; // 옮길 창고 코드
	 private String instorename; // 옮길 창고 이름
	
}
