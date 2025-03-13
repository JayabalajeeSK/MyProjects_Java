package com.jb.JobApp;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jb.JobApp.model.JobPost;

@Controller
@RequestMapping
public class JobController {
///////////////////////////////////////////
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
/////////////////////////////////////////// 
//  addjob page
    @PostMapping("handleForm") //add job
    public String handleForm(JobPost jobPost) //senting data to accept that data
    {
        return "success";
    }
}
