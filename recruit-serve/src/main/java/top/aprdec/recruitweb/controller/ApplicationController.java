package top.aprdec.recruitweb.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  面试简历
 * </p>
 *
 * @author aprdec
 * @since 2024-06-11 11:03:10
 */
@RestController
@RequestMapping("/application")
public class ApplicationController {
    @GetMapping("/list")
    public String list(){

        return "application list";
    }

}
