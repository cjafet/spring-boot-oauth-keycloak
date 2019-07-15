package com.cjafet.oauth;

import org.keycloak.KeycloakSecurityContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Optional;


@Controller
public class HomeController {

    @GetMapping("/")
    public String client() {
        return "client";
    }

    @GetMapping("/api")
    public String customers(@RequestParam("state") Optional<String> state, @RequestParam("session_state") Optional<String> session, @RequestParam("code") Optional<String> code, Model model) {
        model.addAttribute("state", state);
        return "client";
    }

//    private void configCommonAttributes(Model model) {
//        model.addAttribute("name", getKeycloakSecurityContext().getIdToken().getGivenName());
//    }
//    private KeycloakSecurityContext getKeycloakSecurityContext() {
//        return (KeycloakSecurityContext) request.getAttribute(KeycloakSecurityContext.class.getName());
//    }


}
