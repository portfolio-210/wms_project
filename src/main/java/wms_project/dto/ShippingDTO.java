package wms_project.dto;

import lombok.Data;
import org.springframework.stereotype.Repository;

@Data
@Repository("ShippingDTO")
public class ShippingDTO {
    //orderMain.jsp 오더 등록 페이지
    int aidx;   //주문 번호
    String aproductcode, aproductname;
    String acustomernm, acustomerhp, acustomeraddr;
    String accountnm, accountcode;
    String adeliveryck, orderdate;

    //shipmentMain.jsp 배송 선택(본사, 지점) 페이지
    String bstorage, bstoragecode, bpalettenm, bpalettecode, bapprove;

    //StoreDelivery.jsp 배송 기사 배정 페이지
    String deliveryname, dcode, dspot, dapprove;

    //shippingDelivery.jsp 배송현황 및 운송장 출력 페이지
    String stracking, sqrimg, sqrurl, shipstate;



    /*
    CREATE TABLE shipping (
    aidx INT NOT NULL AUTO_INCREMENT,
    aproductcode VARCHAR(20) NOT NULL,
    aproduct VARCHAR(40) NOT NULL,
    acustomer VARCHAR(30) NOT NULL,
    ahp VARCHAR(20) NOT NULL,
    addr TEXT NOT NULL,
    account VARCHAR(30) NOT NULL,
    acode VARCHAR(10) NOT NULL,
    adeliveryck ENUM('Y', 'N') NOT NULL DEFAULT 'N',
    date TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    bstorage VARCHAR(30) NOT NULL DEFAULT 'N',
    bstoragecode VARCHAR(10) NOT NULL DEFAULT 'N',
    bpalett VARCHAR(30) NOT NULL DEFAULT 'N',
    bpalettcode VARCHAR(15) NOT NULL DEFAULT 'N',
    deliveryname VARCHAR(30) NOT NULL DEFAULT 'N',
    dcode VARCHAR(20) NOT NULL DEFAULT 'N',
    dspot VARCHAR(20) NOT NULL DEFAULT 'N',
    stracking VARCHAR(30) NOT NULL DEFAULT 'N',
    sqrimg VARCHAR(150) NULL DEFAULT 'N',
    sqrurl VARCHAR(30) NOT NULL DEFAULT 'N',
    shipstate ENUM('대기', '배송중', '배송완료', '분실', '반품') NOT NULL DEFAULT '대기',
    PRIMARY KEY(aidx)
);
    */
}
