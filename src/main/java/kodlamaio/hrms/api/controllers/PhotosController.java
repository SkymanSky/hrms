package kodlamaio.hrms.api.controllers;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import kodlamaio.hrms.business.abstracts.PhotoService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.entities.concretes.Photo;


@RestController
@RequestMapping("/api/photos")
public class PhotosController {
	
	private PhotoService photoService;

	@Autowired
	public PhotosController(PhotoService photoService) {
		super();
		this.photoService = photoService;
	}
	
	@PostMapping("/photoupload")
	public ResponseEntity<?> photoUpload(@RequestParam("cvId") int cvId, @RequestParam("photo") MultipartFile photo) {
		return ResponseEntity.ok(this.photoService.upload(photo,cvId));
	}
	
	@GetMapping("/getall")
	public DataResult<List<Photo>> getAll() {
		return this.photoService.getAll();
	}
	

}
