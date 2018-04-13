package com.email.analysis.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "analysis")
public class EmailAnalysisContorller {
    @RequestMapping(value = "test")
    public String test(){
        return "test";
    }
}

