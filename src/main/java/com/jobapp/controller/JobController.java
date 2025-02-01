package com.jobapp.controller;

import com.jobapp.entity.Job;
import com.jobapp.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // Marks this class as a RESTful web service controller
@RequestMapping("/jobs") // Base URL mapping for all endpoints in this controller
public class JobController {

    @Autowired // Injects JobService implementation
    private JobService jobService;

    // Get all jobs
    @GetMapping
    public ResponseEntity<List<Job>> findAll(){
        return ResponseEntity.ok(jobService.findAll()); // Returns the list of jobs with HTTP 200 OK status
    }

    // Add a new job
    @PostMapping
    public ResponseEntity<String> addJob(@RequestBody Job job){
        jobService.addJob(job);
        return new ResponseEntity<>("Job added successfully", HttpStatus.CREATED); // HTTP 201 Created
    }

    // Get job by ID
    @GetMapping("/{id}")
    public ResponseEntity<Job> getJobById(@PathVariable Long id){
        Job job = jobService.getJobById(id);
        if(job != null){
            return new ResponseEntity<>(job, HttpStatus.OK); // Returns job if found
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND); // Returns HTTP 404 if job not found
    }

    // Delete job by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteJobById(@PathVariable Long id){
        boolean deleted = jobService.deleteJobById(id);
        if(deleted){
            return new ResponseEntity<>("Job deleted successfully", HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND); // Returns HTTP 404 if job not found
    }

    // Update job by ID
    @PutMapping("/{id}")
    public ResponseEntity<String> updateJobById(@PathVariable Long id, @RequestBody Job updatedJob){
        boolean updated = jobService.updateJobById(id, updatedJob);
        if(updated){
            return new ResponseEntity<>("Job updated successfully", HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND); // Returns HTTP 404 if job not found
    }
}
