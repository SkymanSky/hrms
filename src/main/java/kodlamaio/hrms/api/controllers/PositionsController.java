package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.EmployerService;
import kodlamaio.hrms.business.abstracts.PositionService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Position;

@RestController
@RequestMapping("/api/positions")
@CrossOrigin
public class PositionsController {
	
	private PositionService positionService;
	private EmployerService employerService;

	@Autowired
	public PositionsController(PositionService positionService,EmployerService employerService) {
		super();
		this.positionService = positionService;
		this.employerService=employerService;
	}
	
	@GetMapping("/getall")
	public DataResult<List<Position>> getAll(){
		this.employerService.getall();
		return this.positionService.getAll();
		
	}
	
	@GetMapping("/getbypositionname")
	public DataResult<Position> getByPositionName(Position position){
		return this.positionService.findByPositionName(position);
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody Position position) {
		return this.positionService.add(position);
	}

}
