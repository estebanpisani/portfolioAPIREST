package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import model.Trabajo;
import repository.TrabajoRepository;

@Service
public class TrabajoService implements ITrabajoService{

	@Autowired
	TrabajoRepository trabajoRepo;
	
	@Override
	public void saveTrabajo(Trabajo trabajo) {
		trabajoRepo.save(trabajo);
	}

	@Override
	public void updateTrabajo(Long id, Trabajo trabajo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Trabajo> getTrabajos() {
		return trabajoRepo.findAll();
	}

	@Override
	public Trabajo findTrabajo(Long id) {
		return trabajoRepo.findById(id).orElse(null);
	}

	@Override
	public void deleteTrabajo(Long id) {
		trabajoRepo.deleteById(id);
	}
	
	

}
