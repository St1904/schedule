package com.rep.core.restControllers;

import com.rep.core.services.LessonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by St on 07.01.2018.
 */

@CrossOrigin
@RestController
@RequestMapping(path = "/rest/lesson")
public class RestLessonController {
    private LessonService lessonService;

    @Autowired
    public RestLessonController(LessonService lessonService) {
        this.lessonService = lessonService;
    }

}
