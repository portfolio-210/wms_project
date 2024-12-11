package wms_project.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import wms_project.dto.MemberDTO;
import wms_project.dto.OfficeDTO;

@Mapper
public interface OfficeMapper {

	public List<OfficeDTO> office_list();
	public List<OfficeDTO> search_office(String search);
	public int delete_office(String oidx);
	public String check_officename(String officename);
	public List<MemberDTO> poplist_member();
	public List<MemberDTO> search_member(Map<String, String> keyword);
	public List<MemberDTO> apply_member(String midx);
	public int insert_office(OfficeDTO odto);
	OfficeDTO modify_office(String oidx);
	//지점 정보 수정
	int update_office(OfficeDTO officeDTO);
}
