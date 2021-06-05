package kodlamaio.hrms.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.JobSeekerCvLanguageService;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.JobSeekerCvLanguageDao;
import kodlamaio.hrms.entities.concretes.JobSeekerCvLanguage;

@Service
public class JobSeekerCvLanguageManager implements JobSeekerCvLanguageService {
	
	private JobSeekerCvLanguageDao jobSeekerCvLanguageDao;
	
	@Autowired
	public JobSeekerCvLanguageManager(JobSeekerCvLanguageDao jobSeekerCvLanguageDao) {
		super();
		this.jobSeekerCvLanguageDao = jobSeekerCvLanguageDao;
	}

	@Override
	public Result add(JobSeekerCvLanguage jobSeekerCvLanguage) {
		this.jobSeekerCvLanguageDao.save(jobSeekerCvLanguage);
		return new SuccessResult("Language information added to your cv.");
	}
	
	

}
