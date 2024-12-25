package wms_project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import jakarta.servlet.http.HttpSession;

@Component
public class LoginCheck {

    @Autowired
    private HttpSession session;

    String output = null;
	javascript js = new javascript();

    String checkLogin(Model m) {
        String id = (String) this.session.getAttribute("id");
        try {
            if (id == null || id.isEmpty()) {
                this.output = this.js.ok("비정상적인 접근입니다. 로그인 페이지로 이동합니다.", "./wmsLogin.jsp");
            }
        } catch (Exception e) {
            this.output = this.js.ok("비정상적인 접근입니다. 로그인 페이지로 이동합니다.", "./wmsLogin.jsp");
        }
        m.addAttribute("output", this.output);
        return "output";
    }
}