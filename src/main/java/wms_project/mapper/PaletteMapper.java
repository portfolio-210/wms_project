package wms_project.mapper;

import org.apache.ibatis.annotations.Mapper;
import wms_project.dto.PaletteDTO;

import java.util.List;

@Mapper
public interface PaletteMapper {
    //로그인한 관리자의 소속 지점에 따른 팔레트 전체 리스트 출력
    List<PaletteDTO> palette_list(String mspot);
    //검색한 팔레트 리스트 출력
    List<PaletteDTO> search_palette(String mspot, String search);
    //팔레트 삭제
    int delete_palette(String pidx);
    //팔레트명 중복 검사
    String pname_check(String pname);
}
