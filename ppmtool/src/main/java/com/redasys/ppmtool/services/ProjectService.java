package com.redasys.ppmtool.services;

import com.redasys.ppmtool.domain.Project;
import com.redasys.ppmtool.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectService {
    @Autowired
    private ProjectRepository projectRepository;

    public Project saveOrUpdate(Project project){
        //TODO: LOGIC
        return projectRepository.save(project);
    }
}
