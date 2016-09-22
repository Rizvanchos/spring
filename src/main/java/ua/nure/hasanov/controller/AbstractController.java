package ua.nure.hasanov.controller;

import org.springframework.web.bind.annotation.ModelAttribute;

import javax.servlet.http.HttpServletRequest;

public abstract class AbstractController {

    public static final String REDIRECT_PREFIX = "redirect:";
    public static final String FORWARD_PREFIX = "forward:";
    public static final String ROOT = "/";

    @ModelAttribute("request")
    public HttpServletRequest addRequestToModel(HttpServletRequest request) {
        return request;
    }
}
