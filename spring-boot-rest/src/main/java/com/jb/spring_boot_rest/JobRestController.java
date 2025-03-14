package com.jb.spring_boot_rest;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.jb.spring_boot_rest.model.JobPost;
import com.jb.spring_boot_rest.service.JobService;

@Controller
@RestController
@CrossOrigin(origins="http://localhost:3000/")
public class JobRestController {
@Autowired
    private JobService service;

    @GetMapping("jobPosts")
    //@ResponseBody
    public List<JobPost> getAlljobs()
    {
        return service.getAllJobs();

    }
}
