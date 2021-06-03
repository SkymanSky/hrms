package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.JobSeekerCvSchoolService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.JobSeekerCvSchoolDao;
import kodlamaio.hrms.entities.concretes.JobSeekerCvSchool;

@Service
public class JobSeekerCvSchoolManager implements JobSeekerCvSchoolService {

	private JobSeekerCvSchoolDao jobSeekerCvSchoolDao;
	@Autowired
	public JobSeekerCvSchoolManager(JobSeekerCvSchoolDao jobSeekerCvSchoolDao) {
		super();
		this.jobSeekerCvSchoolDao = jobSeekerCvSchoolDao;
	}
	@Override
	public Result add(JobSeekerCvSchool jobSeekerCvSchool) {
		this.jobSeekerCvSchoolDao.save(jobSeekerCvSchool);
		return new SuccessResult("Scool informations added");
	}
	@Override
	public DataResult<List<JobSeekerCvSchool>> getJobSeekerAllSchoolsSortedByAsc(int jobSeekerid) {
		
		return new SuccessDataResult<List<JobSeekerCvSchool>>(this.jobSeekerCvSchoolDao.getJobSeekerAllSchoolsSortedByAsc(jobSeekerid),"Your schools listed.");
	}

}
