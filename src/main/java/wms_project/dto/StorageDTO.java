package wms_project.dto;

import lombok.Data;

@Data
public class StorageDTO {
	
	String scode, mspot, sname, saddress1, saddress2, smname, smhp, spost;                    
    boolean suse;       // 사용 여부
    String mid;         // 외래 키 (MemberDTO)

}
