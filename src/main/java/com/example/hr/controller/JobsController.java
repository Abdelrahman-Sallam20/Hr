package com.example.hr.controller;

import com.example.hr.entity.Jobs;
import com.example.hr.service.JobsService;
import io.swagger.annotations.Api;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/jobs")
@Api(value = "job", description = "operations for Job Service")
public class JobsController {

    JobsService jobsService;

    @GetMapping(path = "/list")
    public List<Jobs> getAllJobs() {
        return jobsService.getAllJobs();
    }

    @GetMapping(path = "/find")
    public Jobs findById(@RequestParam(name = "jobId") String jobId) {
        return jobsService.getJobById(jobId);
    }

    @PostMapping(path = "/new")
    public Jobs addJobs(@RequestBody Jobs jobs) {
        jobsService.addJobs(jobs);
        return jobs;
    }

    @PutMapping(path = "/update")
    public Jobs updateJobs(@RequestBody Jobs jobs) {
        jobsService.updateJobs(jobs);
        return jobs;
    }


    @DeleteMapping(path = "/delete")
    public String deleteJob(@RequestParam(name = "id") String id) {
        jobsService.deleteJobs(id);
        return "Successfully deleted";
    }
}
