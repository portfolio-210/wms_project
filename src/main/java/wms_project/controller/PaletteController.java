package wms_project.controller;

import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import wms_project.dto.PaletteDTO;
import wms_project.service.PaletteService;

import jakarta.servlet.http.HttpSession;
import java.io.PrintWriter;
import java.util.List;

@Controller
public class PaletteController {
    @Resource(name="PaletteDTO")
    PaletteDTO pdto;

    @Autowired
    PaletteService ps;

    @Autowired
    HttpSession session;

    PrintWriter pw = null;


    //팔레트 메인 페이지 출력 - 로그인한 관리자의 소속 지점에 따른 팔레트 전체 리스트 출력
    @GetMapping("/palette/paletteMain.do")
    public String palette_list(Model m){
        String mspot = (String)this.session.getAttribute("mspot");
        List<PaletteDTO> result = ps.palette_list(mspot);
        m.addAttribute("all", result);
        m.addAttribute("total", result.size());
        return null;
    }

    //팔레트 검색 후 리스트 페이지 출력
    @PostMapping("/palette/paletteMain.do")
    public String search_palette(@RequestParam("search") String search, Model m){
        String mspot = (String)this.session.getAttribute("mspot");
        List<PaletteDTO> result = ps.search_palette(mspot, search);
        m.addAttribute("all", result);
        m.addAttribute("total", result.size());
        return null;
    }
}
