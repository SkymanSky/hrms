package kodlamaio.hrms.core.utilities.validations;

import org.springframework.stereotype.Service;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.entities.concretes.Employer;
import kodlamaio.hrms.entities.concretes.JobSeeker;

@Service
public interface SentValidationMessageService {
	DataResult<JobSeeker> sentEmail(JobSeeker jobSeeker);
	DataResult<Employer> sentEmail(Employer employer);
}
