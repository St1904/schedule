package com.rep.core.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by sbt-sokolova-ts on 15.02.2017.
 */

@Controller
@RequestMapping("/client/event")
public class EventController {
    @RequestMapping(method = RequestMethod.GET)
    public String home() {
        return "schedule";
    }
}
