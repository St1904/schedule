package com.rep.core.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by sbt-sokolova-ts on 14.02.2017.
 */

@Controller
@RequestMapping("/client/contactname")
public class ContactNameController {
    @RequestMapping(method = RequestMethod.GET)
    public String getContact() {
        return "contactname";
    }
}
