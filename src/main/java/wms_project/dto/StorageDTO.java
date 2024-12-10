package wms_project.dto;

import lombok.Data;

@Data
public class StorageDTO {
	int suse;
	String scode, sspot, sname, saddress1, saddress2, smname, smhp, spost;                    
    boolean sdeleted;        // 사용 여부
    String mid;         // 외래 키 (MemberDTO)
    String search;
    String mspot;
}
