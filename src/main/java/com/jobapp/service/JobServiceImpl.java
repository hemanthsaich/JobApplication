package com.jobapp.service;

import com.jobapp.entity.Job;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service // Marks this class as a Spring service component
public class JobServiceImpl implements JobService {
    private final List<Job> jobs = new ArrayList<>(); // In-memory job list
    private Long nextId = 1L; // Auto-increment ID for jobs

    // Retrieve all jobs
    @Override
    public List<Job> findAll() {
        return jobs;
    }

    // Add a new job to the list
    @Override
    public void addJob(Job job) {
        job.setId(nextId++); // Assigns an auto-incremented ID
        jobs.add(job);
    }

    // Retrieve a job by its ID
    @Override
    public Job getJobById(Long id) {
        for (Job job : jobs) {
            if (job.getId().equals(id)) {
                return job; // Returns job if found
            }
        }
        return null; // Returns null if job not found
    }

    // Delete a job by ID
    @Override
    public boolean deleteJobById(Long id) {
        Iterator<Job> iterator = jobs.iterator();
        while (iterator.hasNext()) {
            Job job = iterator.next();
            if (job.getId().equals(id)) {
                iterator.remove(); // Removes job from list
                return true;
            }
        }
        return false; // Returns false if job not found
    }

    // Update a job by ID
    @Override
    public boolean updateJobById(Long id, Job updatedJob) {
        for (Job job : jobs) {
            if (job.getId().equals(id)) {
                job.setTitle(updatedJob.getTitle()); // Updates job title
                job.setDescription(updatedJob.getDescription()); // Updates job description
                job.setMinSalary(updatedJob.getMinSalary()); // Updates min salary
                job.setMaxSalary(updatedJob.getMaxSalary()); // Updates max salary
                return true;
            }
        }
        return false; // Returns false if job not found
    }
}