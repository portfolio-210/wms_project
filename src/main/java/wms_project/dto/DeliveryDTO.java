package wms_project.dto;

import org.springframework.stereotype.Repository;

import lombok.Data;

@Data
@Repository("deliverydto")
public class DeliveryDTO {
	int didx;
	String dcode, dspot, dname, dpass, demail, dhp, didnum;
	String dimgnm, dimgrenm, dimgurl, dimgck;
	String dapprove, ddate, dmodify;
}
