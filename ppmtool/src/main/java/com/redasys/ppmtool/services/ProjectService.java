package com.redasys.ppmtool.services;

import com.redasys.ppmtool.domain.Project;
import com.redasys.ppmtool.exceptions.ProjectIdException;
import com.redasys.ppmtool.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Locale;

@Service
public class ProjectService {
    @Autowired
    private ProjectRepository projectRepository;

    public Project saveOrUpdate(Project project){
        try {
            project.setProjectIdentifier(project.getProjectIdentifier().toUpperCase());
            return projectRepository.save(project);
        }catch(Exception e){
            throw new ProjectIdException("Project ID '"+project.getProjectIdentifier()+"' already exists.");
        }
    }
}
