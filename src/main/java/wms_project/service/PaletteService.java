package wms_project.service;

import wms_project.dto.PaletteDTO;

import java.util.List;

public interface PaletteService {
    //로그인한 관리자의 소속 지점에 따른 팔레트 전체 리스트 출력
    List<PaletteDTO> palette_list(String mspot);
}
