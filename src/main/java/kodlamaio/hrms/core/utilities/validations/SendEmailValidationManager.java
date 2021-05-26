package kodlamaio.hrms.core.utilities.validations;

import org.springframework.stereotype.Service;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.entities.concretes.Employer;
import kodlamaio.hrms.entities.concretes.JobSeeker;

@Service
public class SendEmailValidationManager implements SentValidationMessageService {

	@Override
	public DataResult<JobSeeker> sentEmail(JobSeeker jobSeeker) {
		
		return new SuccessDataResult<JobSeeker>(jobSeeker,jobSeeker.getEmail()+" Mail adresinize dogrulama emaili gonderilmistir.");
	}

	@Override
	public DataResult<Employer> sentEmail(Employer employer) {
		
		return new SuccessDataResult<Employer>(employer, employer.getEmail()+" Mail adresinize dogrulama emaili gonderilmistir.");
	}

}
