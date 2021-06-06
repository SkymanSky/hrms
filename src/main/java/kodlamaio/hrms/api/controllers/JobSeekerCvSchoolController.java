package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.JobSeekerCvSchoolService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.JobSeekerCvSchool;

@RestController
@RequestMapping("/api/jobSeekercvschoolcontroller")
public class JobSeekerCvSchoolController {
	
	private JobSeekerCvSchoolService jobSeekerCvSchoolService;
	@Autowired
	public JobSeekerCvSchoolController(JobSeekerCvSchoolService jobSeekerCvSchoolService) {
		super();
		this.jobSeekerCvSchoolService = jobSeekerCvSchoolService;
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody JobSeekerCvSchool JobSeekerCvSchool) {
		return this.jobSeekerCvSchoolService.add(JobSeekerCvSchool);
	}
	
	@GetMapping("/getJobSeekerAllSchoolsSortedByAsc")
	public DataResult<List<JobSeekerCvSchool>> getJobSeekerAllSchoolsSortedByAsc(int jobSeekerid){
		return this.jobSeekerCvSchoolService.getJobSeekerAllSchoolsSortedByAsc(jobSeekerid);
	}

}
