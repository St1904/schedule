package com.rep.core.restController;

import com.rep.core.Dto.ThemeDto;
import com.rep.core.services.SubjectThemeService;
import com.rep.db.domain.Subject;
import com.rep.db.domain.Theme;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

import static org.springframework.http.HttpStatus.*;
import static org.springframework.web.bind.annotation.RequestMethod.*;

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
            return new ResponseEntity<>(NO_CONTENT);
        }
        return new ResponseEntity<>(themes, OK);
    }

    @RequestMapping(method = GET, path = "/tree/parent", params = {"idParent"})
    public ResponseEntity<List<ThemeDto>> getTreeByIdParent(@RequestHeader("idTutor") Long idTutor,
                                                            @RequestParam("idParent") Long idParent) {
        List<ThemeDto> themes = subjectThemeService.findTreeByIdParent(idParent);
        if (themes.isEmpty()) {
            return new ResponseEntity<>(NO_CONTENT);
        }
        return new ResponseEntity<>(themes, OK);
    }

    //TODO Используется?
    @RequestMapping(method = GET, path = "/subject/{idSubject}")
    public ResponseEntity<List<ThemeDto>> getThemesByIdSubject(@RequestHeader("idTutor") Long idTutor,
                                                               @PathVariable("idSubject") Long idSubject) {
        List<ThemeDto> themes = ThemeDto.of(subjectThemeService.findThemesByIdSubject(idSubject));
        if (themes.isEmpty()) {
            return new ResponseEntity<>(NO_CONTENT);
        }
        return new ResponseEntity<>(themes, OK);
    }

    @RequestMapping(method = POST, path = "/subject")
    public ResponseEntity<Subject> saveNewSubject(@RequestHeader("idTutor") Long idTutor,
                                                  @RequestBody Subject subject,
                                                  UriComponentsBuilder ucBuilder) {
        subject.setIdTutor(idTutor);
        Subject saved = subjectThemeService.createSubject(subject);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/rest/theme/subject/{id}").buildAndExpand(saved.getIdTutor(), saved.getId()).toUri());
        return new ResponseEntity<>(headers, CREATED);
    }

    @RequestMapping(method = POST)
    public ResponseEntity<Theme> saveNewTheme(@RequestHeader("idTutor") Long idTutor,
                                              @RequestBody Theme theme,
                                              UriComponentsBuilder ucBuilder) {
        Theme saved = subjectThemeService.createTheme(theme);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/rest/theme/{id}").buildAndExpand(saved.getId()).toUri());
        return new ResponseEntity<>(theme, headers, CREATED);
    }

    @RequestMapping(method = DELETE, path = "/{id}")
    public ResponseEntity<Theme> deleteContactName(@RequestHeader("idTutor") Long idTutor,
                                                   @PathVariable("id") Long id) {
        Theme found = subjectThemeService.findThemeById(id);
/*        if (found == null || !found.getIdStudent().equals(idTutor)) {
            return new ResponseEntity<>(NOT_FOUND);
        }*/
        subjectThemeService.deleteThemeById(id);
        return new ResponseEntity<>(NO_CONTENT);
    }
}