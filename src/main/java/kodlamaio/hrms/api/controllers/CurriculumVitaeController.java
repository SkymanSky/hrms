package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.CurriculumVitaeService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.CurriculumVitae;
import kodlamaio.hrms.entities.concretes.JobSeekerCvLanguage;

@RestController
@RequestMapping("api/cvs")
public class CurriculumVitaeController {
	
	private CurriculumVitaeService curriculumVitaeService;

	@Autowired
	public CurriculumVitaeController(CurriculumVitaeService curriculumVitaeService) {
		super();
		this.curriculumVitaeService = curriculumVitaeService;
	}
	
	@GetMapping("/getall")
	public DataResult<List<CurriculumVitae>> getAll(){
		return this.curriculumVitaeService.getall();
	}
	
	@GetMapping("/getbyjobseekerid")
	public DataResult<CurriculumVitae> findByJobSeekerId(int jobSeekerId){
		return this.curriculumVitaeService.findByJobSeekerId(jobSeekerId);
	}
	
	@GetMapping("/getbyalljobseekerid")
	public DataResult<List<CurriculumVitae>> getAllByJobSeekerId(int jobSeekerId){
		return this.curriculumVitaeService.getAllByJobSeekerId(jobSeekerId);
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody CurriculumVitae curriculumVitae, @RequestBody JobSeekerCvLanguage jobSeekerCvLanguage){
		return this.curriculumVitaeService.add(curriculumVitae,jobSeekerCvLanguage);
	}

}
