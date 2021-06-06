package kodlamaio.hrms.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.JobSeekerCvLanguageService;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.JobSeekerCvLanguage;

@RestController
@RequestMapping("/api/JobSeekerCvLanguageController")

public class JobSeekerCvLanguageController {
	
	private JobSeekerCvLanguageService jobSeekerCvLanguageService;

	@Autowired
	public JobSeekerCvLanguageController(JobSeekerCvLanguageService jobSeekerCvLanguageService) {
		super();
		this.jobSeekerCvLanguageService = jobSeekerCvLanguageService;
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody JobSeekerCvLanguage jobSeekerCvLanguage) {
		return this.jobSeekerCvLanguageService.add(jobSeekerCvLanguage);
	}

}
