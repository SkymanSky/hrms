package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.PositionService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.PositionDao;
import kodlamaio.hrms.entities.concretes.Position;

@Service
public class PositionManager implements PositionService{
	
	private PositionDao positionDao;
	
	@Autowired
	public PositionManager(PositionDao positionDao) {
		super();
		this.positionDao = positionDao;
	}


	@Override
	public DataResult<List<Position>> getAll() {
		 
		return new SuccessDataResult<List<Position>>(this.positionDao.findAll(),"Positions listed") ;
	}


	@Override
	public Result add(Position position) {
		
		if(position.getPositionName()!="") {
			
			if(this.findByPositionName(position).getData()!=null) {
				
				return new ErrorResult("Position is already in system");
			}
			
			this.positionDao.save(position);
			
		}
		return new SuccessResult("Position added.");
	}


	@Override
	public DataResult<Position> findByPositionName(Position position) {
		
		return new SuccessDataResult<Position>(this.positionDao.findByPositionName(position.getPositionName()),"");
	}

	
}
