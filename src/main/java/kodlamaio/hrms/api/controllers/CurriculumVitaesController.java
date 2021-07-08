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

import kodlamaio.hrms.business.abstracts.CurriculumVitaeService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.CurriculumVitae;
import kodlamaio.hrms.entities.concretes.JobSeekerCvLanguage;
import kodlamaio.hrms.entities.dtos.JobSeekerCvDetailDto;

@RestController
@RequestMapping("api/cvs")
@CrossOrigin
public class CurriculumVitaesController {

	private CurriculumVitaeService curriculumVitaeService;

	@Autowired
	public CurriculumVitaesController(CurriculumVitaeService curriculumVitaeService) {
		super();
		this.curriculumVitaeService = curriculumVitaeService;
	}

	@GetMapping("/getall")
	public DataResult<List<CurriculumVitae>> getAll() {
		return this.curriculumVitaeService.getall();
	}

	/*@GetMapping("/findByJobSeekerId")
	public DataResult<CurriculumVitae> findByJobSeekerId(@RequestParam int jobSeekerId) {
		return this.curriculumVitaeService.findByJobSeekerId(jobSeekerId);
	}*/
	
	@GetMapping("/findByJobSeekerId")
	public DataResult<CurriculumVitae> findByJobSeekerId(@RequestParam int jobSeekerId) {
		return this.curriculumVitaeService.findByJobSeekerId(jobSeekerId);
	}

	@GetMapping("/getallbyjobseekerid")
	public DataResult<List<JobSeekerCvDetailDto>> getByJobSeekerId(@RequestParam int jobSeekerId) {
		return this.curriculumVitaeService.getByJobSeekerId(jobSeekerId);
	}

	@PostMapping("/add")
	public Result add(@RequestBody CurriculumVitae curriculumVitae,
			@RequestBody JobSeekerCvLanguage jobSeekerCvLanguage) {
		return this.curriculumVitaeService.add(curriculumVitae, jobSeekerCvLanguage);
	}
	
	@PostMapping("/update")
	public Result add(@RequestBody CurriculumVitae curriculumVitae) {
		return this.curriculumVitaeService.update(curriculumVitae);
	}

}
