package com.jb.spring_boot_rest.service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.jb.spring_boot_rest.model.JobPost;
import com.jb.spring_boot_rest.repo.JobRepo;

@Service
public class JobService {
    @Autowired
    private JobRepo repo;

    public void addJob(JobPost jobPost)
    {
        repo.addJob(jobPost);
    }

    public List<JobPost> getAllJobs()
    {
            return repo.getAllJobs();
        
    }

    public JobPost getJob(int postId)
    {
        return repo.getJob(postId);
    }

}
