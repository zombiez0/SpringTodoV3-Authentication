package com.app.todo.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

@Controller
public class WebController {

    @Value("${header-ip-candidates}")
    private String[] headerCandidates;

    public WebController(){
        System.out.println("WebController TodoController");
    }

    @GetMapping({"/"})
    public String getTemplate(Model model) {
        if (RequestContextHolder.getRequestAttributes() == null) {
            model.addAttribute("name", "0.0.0.0");
            return "index";
        }
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        for (String header: headerCandidates) {
            String ipList = request.getHeader(header);
            if (ipList != null && ipList.length() != 0 && !"unknown".equalsIgnoreCase(ipList)) {
                String ip = ipList.split(",")[0];
                model.addAttribute("name", ip);
                System.out.printf("test");
                return "index";
            }
        }
        model.addAttribute("name", request.getRemoteAddr());
        return "index";
    }
}
