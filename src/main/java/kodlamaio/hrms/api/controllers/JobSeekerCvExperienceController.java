package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.JobSeekerCvExperienceService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.JobSeekerCvExperience;
import kodlamaio.hrms.entities.concretes.JobSeekerCvSchool;

@RestController
@RequestMapping("/api/jobseekercvexperiencecontroller")
public class JobSeekerCvExperienceController {
	
	private JobSeekerCvExperienceService jobSeekerCvExperienceService;
	
	@Autowired
	public JobSeekerCvExperienceController(JobSeekerCvExperienceService jobSeekerCvExperienceService) {
		super();
		this.jobSeekerCvExperienceService = jobSeekerCvExperienceService;
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody JobSeekerCvExperience JobSeekerCvExperience) {
		return this.jobSeekerCvExperienceService.add(JobSeekerCvExperience);
	}
	
	@GetMapping("/getJobSeekerCvExperiencesSortedByAsc")
	public DataResult<List<JobSeekerCvExperience>> getJobSeekerAllExperiencesSortedByAsc(int jobSeekerid){
		return this.jobSeekerCvExperienceService.getJobSeekerAllExperiencesSortedByAsc(jobSeekerid);
	}

}
