package kodlamaio.hrms.core.utilities.photos;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;


import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;

@Service
public class CloudinaryAdaptor implements CloudinaryService {

	private Cloudinary cloudinary;

	@Autowired
	public CloudinaryAdaptor() {
		Map<String, String> valuesMap = new HashMap<>();
		valuesMap.put("cloud_name", "skymansky");
		valuesMap.put("api_key", "545899925229753");
		valuesMap.put("api_secret", "qZevVp5dUXVlVwX253txpFFEQM4");
		cloudinary = new Cloudinary(valuesMap);
	}

	@Override
	public DataResult<Map<String, String>> upload(MultipartFile multipartFile) {
		File file;
		try {
			file = convert(multipartFile);
			Map<String, String> result = cloudinary.uploader().upload(file, ObjectUtils.emptyMap());
			file.delete();
			return new SuccessDataResult<Map<String, String>>(result);
		} catch (IOException e) {
			e.printStackTrace();
			return new ErrorDataResult<Map<String, String>>("Dosya yüklenemedi");
		}
	}

	public DataResult<Map> delete(String id) throws IOException {
		Map result = cloudinary.uploader().destroy(id, ObjectUtils.emptyMap());
		return new SuccessDataResult<Map>(result);
	}

	private File convert(MultipartFile multipartFile) throws IOException {
		File file = new File(multipartFile.getOriginalFilename());
		FileOutputStream stream = new FileOutputStream(file);
		stream.write(multipartFile.getBytes());
		stream.close();

		return file;
	}

}
