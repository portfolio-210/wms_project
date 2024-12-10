package wms_project.controller;

import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletResponse;
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

    //팔레트 검색 리스트 페이지 출력
    @PostMapping("/palette/paletteMain.do")
    public String search_palette(@RequestParam("search") String search, Model m){
        String mspot = (String)this.session.getAttribute("mspot");
        List<PaletteDTO> result = ps.search_palette(mspot, search);
        m.addAttribute("all", result);
        m.addAttribute("total", result.size());
        return null;
    }

    //팔레트 삭제하기
    @PostMapping("/palette/palette_delete.do")
    public String delete_palette(@RequestParam("pidx") String pidx, HttpServletResponse res){
        res.setContentType("text/html;charset=utf-8");
        try {
            this.pw = res.getWriter();

            int result = ps.delete_palette(pidx);
            if(result > 0){
                this.pw.print("<script>" +
                        "alert('해당 팔레트가 성공적으로 삭제되었습니다.');" +
                        "location.href='/palette/paletteMain.do';" +
                        "</script>");
            }
            else{
                this.pw.print("<script>" +
                        "alert('삭제에 실패했습니다.\n삭제할 팔레트를 다시 한번 확인하고잠시 후에 다시 시도해주세요.');" +
                        "history.go(-1);" +
                        "</script>");
            }
        } catch (Exception e) {
            this.pw.print("<script>" +
                    "alert('시스템 오류로 인해 정상적으로 삭제되지 않았습니다.\n잠시 후에 다시 시도해주세요.');" +
                    "history.go(-1);" +
                    "</script>");
        } finally {
            this.pw.close();
        }
        return null;
    }


    //팔레트 등록 이름 중복 검사
    @PostMapping("/palette/pnameCheckOk.do")
    public String pnameCheckOk(@RequestParam("pname") String pname, HttpServletResponse res){
        res.setContentType("text/html;charset=utf-8");
        try {
            this.pw = res.getWriter();
            String result = "";

            if(pname.equals("")) {
                System.out.println("빈 값");
            }
            else {
                result = ps.pname_check(pname);
                this.pw.print(result);
            }
        } catch (Exception e) {
            this.pw.print("<script>"
                    + "alert('서버가 불안정합니다. 잠시 후에 다시 시도 해주세요.');"
                    + "history.go(-1);"
                    + "</script>");
        } finally {
            this.pw.close();
        }
        return null;
    }
}
