package com.jobapp.service;

import com.jobapp.entity.Job;
import com.jobapp.repository.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service // Marks this class as a Spring service component
public class JobServiceImpl implements JobService {
    // private final List<Job> jobs = new ArrayList<>(); // In-memory job list

    @Autowired
    JobRepository jobRepository;


    // Retrieve all jobs
    @Override
    public List<Job> findAll() {
        return jobRepository.findAll();
    }

    // Add a new job
    @Override
    public void addJob(Job job) {
        jobRepository.save(job);
    }

    // Retrieve a job by its ID
    @Override
    public Job getJobById(Long id) {
        return jobRepository.findById(id).orElse(null);
    }

    // Delete a job by ID
    @Override
    public boolean deleteJobById(Long id) {
        try{
            jobRepository.deleteById(id);
            return true;
        }catch(Exception e){
            return false;
        }
    }

    // Update a job by ID
    @Override
    public boolean updateJobById(Long id, Job updatedJob) {
        Optional<Job> jobOptional = jobRepository.findById(id);

        if (jobOptional.isPresent()) {
            Job job = jobOptional.get();
            job.setTitle(updatedJob.getTitle()); // Updates job title
            job.setDescription(updatedJob.getDescription()); // Updates job description
            job.setMinSalary(updatedJob.getMinSalary()); // Updates min salary
            job.setMaxSalary(updatedJob.getMaxSalary()); // Updates max salary
            return true; // Returns true if job is found and updated
        }
        return false; // Returns false if job not found
    }
}