package kodlamaio.hrms.business.concretes;

import java.time.LocalDate;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import kodlamaio.hrms.business.abstracts.PhotoService;
import kodlamaio.hrms.core.utilities.photos.CloudinaryService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorDataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.PhotoDao;
import kodlamaio.hrms.entities.concretes.Photo;

@Service
public class PhotoManager implements PhotoService {

	private PhotoDao photoDao;
	private CloudinaryService cloudinaryService;

	@Autowired
	public PhotoManager(PhotoDao photoDao, CloudinaryService cloudinaryService) {
		super();
		this.photoDao = photoDao;
		this.cloudinaryService = cloudinaryService;
	}

	@Override
	public Result add(Photo photo) {
		if (this.photoDao.save(photo) != null) {
			return new SuccessResult();
		}
		return new ErrorResult();
	}

	@Override
	public DataResult<Photo> upload(MultipartFile photo, int cvId) {
		
		DataResult<Map<String, String>> result = this.cloudinaryService.upload(photo);

		if (result.isSuccess()) {

			Photo photo1 = new Photo();
			photo1.setCurriculumVitaeId(cvId);
			// photo.setCreatedDate(LocalDate.now());
			photo1.setImage(result.getData().get("url"));
			photo1.setTitle(result.getData().get("public_id"));
			Result addingResult = this.add(photo1);
			if (addingResult.isSuccess()) {
				return new SuccessDataResult<Photo>(photo1);
			}
		}
		return new ErrorDataResult<Photo>(null, "Dosya yüklenemedi");
	}

}
