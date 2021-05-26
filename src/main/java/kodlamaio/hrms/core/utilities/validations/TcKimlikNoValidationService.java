package kodlamaio.hrms.core.utilities.validations;

import org.springframework.stereotype.Service;

import kodlamaio.hrms.entities.concretes.JobSeeker;

@Service
public interface TcKimlikNoValidationService {
	boolean tcKimlikNoValidator(JobSeeker jobSeeker);
}
