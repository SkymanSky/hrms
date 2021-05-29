package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.JobPostingService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.JobPosting;

@RestController
@RequestMapping("api/jobpositions")
public class JobPositionsController {
	
	private JobPostingService jobPostingService;
	
	@Autowired
	public JobPositionsController(JobPostingService jobPostingService) {
		super();
		this.jobPostingService = jobPostingService;
	}
	
	@GetMapping("/getall")
	public DataResult<List<JobPosting>> getAll(){
		return this.jobPostingService.getAll();
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody JobPosting jobPosting) {
		return this.jobPostingService.add(jobPosting);
	}
	
	@GetMapping("/getbystatus")
	public DataResult<List<JobPosting>> getByStatus(boolean jobPostingStatus){
		return this.jobPostingService.getByStatus(jobPostingStatus);
	}
	
	@GetMapping("/getbyuseridstatusactive")
	public DataResult<List<JobPosting>> getByUserIdStatusActive(int userId){
		return this.jobPostingService.getByUserIdStatusActive(userId);
	}
	
}
