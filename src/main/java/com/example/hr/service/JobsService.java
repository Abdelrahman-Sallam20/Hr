package com.example.hr.service;

import com.example.hr.entity.Jobs;
import com.example.hr.repository.JobsRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class JobsService {

    JobsRepository jobsRepository;

    public List<Jobs> getAllJobs() {
        return jobsRepository.findAll();
    }

    public Jobs getJobById(String id) {
        return jobsRepository.findById(id).orElse(null);
    }

    public void addJobs(Jobs jobs) {
        jobsRepository.save(jobs);
    }

    public void updateJobs(Jobs jobs) {
        jobsRepository.save(jobs);
    }

    public void deleteJobs(String id) {
        jobsRepository.deleteById(id);
    }
}
