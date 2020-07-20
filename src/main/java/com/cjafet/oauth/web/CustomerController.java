package com.cjafet.oauth.web;

import org.keycloak.common.util.KeycloakUriBuilder;
import org.keycloak.constants.ServiceUrlConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import java.security.Principal;
import java.util.Optional;


@Controller
public class CustomerController {

    private @Autowired
    HttpServletRequest request;

    @GetMapping("/")
    public String landing() {
        return "landing";
    }

    @GetMapping("/error")
    public String error() {
        return "403";
    }

    @GetMapping("/api")
    public String customers(Principal principal, Model model) {
        String logoutUri = KeycloakUriBuilder
                                    .fromUri("http://localhost:8080/auth")
                                    .path(ServiceUrlConstants.TOKEN_SERVICE_LOGOUT_PATH)
                                    .queryParam("redirect_uri", "http://localhost:8080/api")
                                    .build("rba").toString();

        model.addAttribute("logout",  logoutUri);
        model.addAttribute("principal",  principal);

        return "client";
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String handleLogout() throws ServletException {
        request.logout();
        return "landing";
    }




}
