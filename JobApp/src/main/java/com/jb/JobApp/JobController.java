package com.jb.JobApp;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
public class JobController {

    @GetMapping({"/","home"}) // home and home page button (nav)
    public String home() {
        return "home"; 
    }

    @GetMapping("viewalljobs") //view all jobs and all jobs (nav)
    public String viewallJob()
    {
        return "viewalljobs";
    }

    @GetMapping("addjob") //add job
    public String addJob()
    {
        return "addjob";
    }
}
