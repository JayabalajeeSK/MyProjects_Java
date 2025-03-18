package com.jb.JobApp.service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.jb.JobApp.model.JobPost;
import com.jb.JobApp.repo.JobRepo;

@Service
public class JobService {
    @Autowired
    private JobRepo repo;

    public void addJob(JobPost jobPost)
    {
        repo.save(jobPost);
    }

    public List<JobPost> getAllJobs()
    {
            return repo.findAll();
        
    }

    public JobPost getJob(int postId)
    {
        return repo.findById(postId).orElse(new JobPost());
    }

    public void updateJob(JobPost jobPost)
    {
        repo.save(jobPost);
    }

    public void deleteJob(JobPost jobPost)
    {
        repo.delete(jobPost);
    }


}
