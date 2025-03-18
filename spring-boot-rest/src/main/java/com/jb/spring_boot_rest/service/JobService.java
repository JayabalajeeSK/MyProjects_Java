package com.jb.spring_boot_rest.service;

import java.util.List;

import com.jb.spring_boot_rest.model.JobPost;

public interface JobService {

    void addJob(JobPost jobPost);

    List<JobPost> getAllJobs();

    JobPost getJob(int postId);

    void deleteJob(int postId);

    void load();
}
