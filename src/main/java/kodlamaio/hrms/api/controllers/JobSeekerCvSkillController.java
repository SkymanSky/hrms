package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.JobSeekerCvSkillService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.JobSeekerCvSkill;

@RestController
@RequestMapping("/api/JobSeekerCvSkillController")
public class JobSeekerCvSkillController {

	private JobSeekerCvSkillService jobSeekerCvSkillService;

	@Autowired
	public JobSeekerCvSkillController(JobSeekerCvSkillService jobSeekerCvSkillService) {
		super();
		this.jobSeekerCvSkillService = jobSeekerCvSkillService;
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody JobSeekerCvSkill jobSeekerCvSkill) {
		return this.jobSeekerCvSkillService.add(jobSeekerCvSkill);
	}
	
	@PostMapping("/update")
	public Result update(@RequestBody JobSeekerCvSkill jobSeekerCvSkill) {
		return this.jobSeekerCvSkillService.update(jobSeekerCvSkill);
	}
	
	@GetMapping("/findByJobSeekerId")
	public DataResult<List<JobSeekerCvSkill>> findByJobSeekerId(int jobSeekerid){
		return this.jobSeekerCvSkillService.findByJobSeekerId(jobSeekerid);
	}
}
