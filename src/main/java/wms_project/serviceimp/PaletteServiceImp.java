package wms_project.serviceimp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wms_project.dto.PaletteDTO;
import wms_project.mapper.PaletteMapper;
import wms_project.service.PaletteService;

import java.util.List;

@Service
public class PaletteServiceImp implements PaletteService {
    @Autowired
    PaletteMapper pm;

    //로그인한 관리자의 소속 지점에 따른 팔레트 전체 리스트 출력
    @Override
    public List<PaletteDTO> palette_list(String mspot) {
        List<PaletteDTO> result = pm.palette_list(mspot);
        return result;
    }

    //검색한 팔레트 리스트 출력

    @Override
    public List<PaletteDTO> search_palette(String mspot, String search) {
        List<PaletteDTO> result = pm.search_palette(mspot, search);
        return result;
    }
}
