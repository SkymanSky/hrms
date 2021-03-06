package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.JobPostingService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.JobPosting;

@RestController
@RequestMapping("api/jobpositions")
@CrossOrigin
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
	
	@GetMapping("/getallasc")
	public DataResult<List<JobPosting>> getAllSortedAsc(){
		return this.jobPostingService.getAllSortedAsc();
	}
	
	@GetMapping("/getallactivedesc")
	public DataResult<List<JobPosting>> getAllStatusIsActiveSortedByDesc(){
		return this.jobPostingService.getAllStatusIsActiveSortedByDesc();
	}
	
	@GetMapping("/getallactiveasc")
	public DataResult<List<JobPosting>> getAllStatusIsActiveSortedByAsc(){
		return this.jobPostingService.getAllStatusIsActiveSortedByAsc();
	}
	
	@GetMapping("/getalldesc")
	public DataResult<List<JobPosting>> getAllSortedDesc(){
		return this.jobPostingService.getAllSortedDesc();
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
	
	@PostMapping("/updateJobPostingStatusToInactive")
	public Result updateJobPostingStatusToInactive(@RequestParam("id") int id) {
		
		return this.jobPostingService.updateJobPostingStatusToInactive(id);
		
	}
	
	@PostMapping("/updateJobPostingStatusToACtive")
	public Result updateJobPostingStatusToActive(@RequestParam("id") int id) {
		return this.jobPostingService.updateJobPostingStatusToActive(id);
	}
	
}
