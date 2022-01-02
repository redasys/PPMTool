package com.redasys.ppmtool.web;

import com.redasys.ppmtool.domain.Project;
import com.redasys.ppmtool.services.ProjectService;
import com.redasys.ppmtool.services.ValidationErrorMappingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api/project")
public class ProjectController {
    @Autowired
    private ProjectService projectService;

    @Autowired
    private ValidationErrorMappingService validationErrorMappingService;

    @PostMapping("")
    public ResponseEntity<?> createNewProject(@Valid @RequestBody Project project, BindingResult result){
        ResponseEntity<?> errorMap = validationErrorMappingService.MapValidateionService(result);
        if(errorMap!=null){
            return errorMap;
        }

        Project project1 = projectService.saveOrUpdate(project);
        return new ResponseEntity<Project>(project1, HttpStatus.CREATED);
    }
}
