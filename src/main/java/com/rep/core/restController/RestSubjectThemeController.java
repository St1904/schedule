package com.rep.core.restController;

import com.rep.core.Dto.ThemeDto;
import com.rep.core.services.SubjectThemeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.NOT_FOUND;
import static org.springframework.http.HttpStatus.OK;
import static org.springframework.web.bind.annotation.RequestMethod.GET;

/**
 * Created by St on 14.08.2017.
 */

@CrossOrigin
@RestController
@RequestMapping("/rest/theme")
public class RestSubjectThemeController {
    private final SubjectThemeService subjectThemeService;

    @Autowired
    public RestSubjectThemeController(SubjectThemeService subjectThemeService) {
        this.subjectThemeService = subjectThemeService;
    }

    @RequestMapping(method = GET, path = "/parent", params = {"idParent"})
    public ResponseEntity<List<ThemeDto>> getThemesByIdParent(@RequestHeader("idTutor") Long idTutor,
                                                           @RequestParam("idParent") Long idParent) {
//        List<Subject> subjects = subjectThemeService.findSubjectsByIdTutor(idTutor);
        List<ThemeDto> themes = ThemeDto.of(subjectThemeService.findThemesByIdParent(idParent));
        if (themes.isEmpty()) {
            return new ResponseEntity<>(NOT_FOUND);
        }
        return new ResponseEntity<>(themes, OK);
    }
}