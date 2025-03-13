package com.jb.JobApp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.jb.JobApp.model.JobPost;
import com.jb.JobApp.service.JobService;
@Controller
@RequestMapping
public class JobController {

    @Autowired
    private JobService service;
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
        service.addJob(jobPost);
        return "success";
    }
}
