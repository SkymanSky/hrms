package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.CurriculumVitae;
import kodlamaio.hrms.entities.concretes.JobSeekerCvLanguage;
import kodlamaio.hrms.entities.dtos.JobSeekerCvDetailDto;

public interface CurriculumVitaeService {
	Result add(CurriculumVitae curriculumVitae, JobSeekerCvLanguage jobSeekerCVLanguage);
	DataResult<List<CurriculumVitae>> getall();
	DataResult<List<CurriculumVitae>> findByJobSeekerId(int jobSeekerId);
	DataResult<List<JobSeekerCvDetailDto>> getByJobSeekerId(int jobSeekerId);
	
}
