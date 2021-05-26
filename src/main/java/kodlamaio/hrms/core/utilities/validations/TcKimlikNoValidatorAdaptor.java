package kodlamaio.hrms.core.utilities.validations;

import org.springframework.stereotype.Service;

import kodlamaio.hrms.entities.concretes.JobSeeker;
import tr.gov.nvi.tckimlik.KPSPublicSoapProxy;
@Service
public class TcKimlikNoValidatorAdaptor implements TcKimlikNoValidationService{

	@Override
	public boolean tcKimlikNoValidator(JobSeeker jobSeeker) {
		KPSPublicSoapProxy validator = new KPSPublicSoapProxy();
		return validator.tcKimlikDogula(jobSeeker);
		
	}

}
