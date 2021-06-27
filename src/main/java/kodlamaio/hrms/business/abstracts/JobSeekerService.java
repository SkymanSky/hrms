package kodlamaio.hrms.business.abstracts;


import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.JobSeeker;
import kodlamaio.hrms.entities.dtos.JobSeekerCvDetailDto;

public interface JobSeekerService {
	Result add(JobSeeker jobSeeker);
	DataResult<List<JobSeeker>> getAll();
	DataResult<JobSeeker> findByTcno(JobSeeker jobSeeker);
	DataResult<JobSeeker> findByEmail(JobSeeker jobSeeker);
	DataResult<JobSeeker> findByUserId(int userId);
	DataResult<List<JobSeekerCvDetailDto>> getJobSeekerWithExperienceDetails();
}
