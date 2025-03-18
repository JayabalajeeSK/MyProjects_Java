package com.jb.spring_boot_rest;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.jb.spring_boot_rest.model.JobPost;
import com.jb.spring_boot_rest.service.impl.JobServiceImplementation;

@Controller
@RestController
@CrossOrigin(origins="http://localhost:3000/")
public class JobRestController {
@Autowired
    private JobServiceImplementation service;

    @GetMapping(path="jobPost", produces = {"application/json"})
    //@ResponseBody
    public List<JobPost> getAlljobs()
    {
        return service.getAllJobs();

    }
    @GetMapping("jobPost/{postId}")
    //@ResponseBody
    public JobPost getJobs(@PathVariable("postId") int postId)
    {
        return service.getJob(postId);

    }

    @PostMapping("jobPost")
    public JobPost addJob(@RequestBody JobPost jobPost)
    {
        service.addJob(jobPost);
        return service.getJob(jobPost.getPostId());

    }

    @PutMapping("jobPost")
    public JobPost updateJobs(@RequestBody JobPost jobPost)
    {
        service.updateJob(jobPost);
        return service.getJob(jobPost.getPostId());
    }

    @DeleteMapping("jobPost/{postId}")
    public String deleteJob(@PathVariable("postId") int postId)
    {
        service.deleteJob(postId);
        return "Deleted";
    }

    @GetMapping("load")
    public String loadData()
    {
        service.load();
        return "success";

    }
}
