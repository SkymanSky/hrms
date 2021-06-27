package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.CurriculumVitaeService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.CurriculumVitaeDao;
import kodlamaio.hrms.dataAccess.abstracts.JobSeekerCvLanguageDao;
import kodlamaio.hrms.entities.concretes.CurriculumVitae;
import kodlamaio.hrms.entities.concretes.JobSeekerCvLanguage;
import kodlamaio.hrms.entities.dtos.JobSeekerCvDetailDto;

@Service
public class CurriculumVitaeManager implements CurriculumVitaeService {

	private CurriculumVitaeDao curriculumVitaeDao;
	private JobSeekerCvLanguageDao jobSeekerCvLanguageDao;

	@Autowired
	public CurriculumVitaeManager(CurriculumVitaeDao curriculumVitaeDao,
								 JobSeekerCvLanguageDao jobSeekerCvLanguageDao) {
		super();
		this.curriculumVitaeDao = curriculumVitaeDao;
		this.jobSeekerCvLanguageDao = jobSeekerCvLanguageDao;
	}

	@Override
	public Result add(CurriculumVitae curriculumVitae, JobSeekerCvLanguage jobSeekerCvLanguage) {
		this.jobSeekerCvLanguageDao.save(jobSeekerCvLanguage);
		this.curriculumVitaeDao.save(curriculumVitae);
		return new SuccessResult("Cv saved.");
	}

	@Override
	public DataResult<List<CurriculumVitae>> getall() {
		
		return new SuccessDataResult<List<CurriculumVitae>>(this.curriculumVitaeDao.findAll(),"Cvs listed") ;
	}

	@Override
	public DataResult<List<CurriculumVitae>> findByJobSeekerId(int jobSeekerId) {
		
		return new SuccessDataResult<List<CurriculumVitae>>(this.curriculumVitaeDao.findByJobSeekerId(jobSeekerId),"Cvs listed") ;
	}

	
	@Override
	public DataResult<List<JobSeekerCvDetailDto>> getByJobSeekerId(int jobSeekerId) {
		return new SuccessDataResult<List<JobSeekerCvDetailDto>>(this.curriculumVitaeDao.getByJobSeekerId(jobSeekerId),"Cv listed") ;
	}

}
