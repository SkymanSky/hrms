package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.JobSeekerService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.JobSeeker;

@RestController
@RequestMapping("/api/jobseekers")
@CrossOrigin

public class JobSeekersController {
	
	private JobSeekerService jobSeekerService;
	
	@Autowired
	public JobSeekersController(JobSeekerService jobSeekerService) {
		super();
		this.jobSeekerService = jobSeekerService;
	}
	
	@GetMapping("/getall")
	public DataResult<List<JobSeeker>> getAll(){
		return this.jobSeekerService.getAll();
	}
	
	@GetMapping("/findbytcno")
	public DataResult<JobSeeker> findByTcno(JobSeeker jobSeeker){
		return this.jobSeekerService.findByTcno(jobSeeker);
	}
	
	@GetMapping("/findbyemail")
	public DataResult<JobSeeker> findByEmail(JobSeeker jobSeeker){
		return this.jobSeekerService.findByEmail(jobSeeker);
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody JobSeeker jobSeeker){
		return this.jobSeekerService.add(jobSeeker);
	}
	
	@GetMapping("/findbyid")
	public DataResult<JobSeeker> findByUserId(int userId){
		return this.jobSeekerService.findByUserId(userId);
	}


}
