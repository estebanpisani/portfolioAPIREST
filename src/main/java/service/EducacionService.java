package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import model.Educacion;
import repository.EducacionRepository;

@Service
public class EducacionService implements IEducacionService {
	
	@Autowired
	EducacionRepository educacionRepo;

@Override
public void saveEducacion(Educacion educacion) {
	educacionRepo.save(educacion);
}

@Override
public void updateEducacion(Long id, Educacion educacion) {
	// TODO Auto-generated method stub
	
}

@Override
public List<Educacion> getEducacions() {
	return educacionRepo.findAll();
}

@Override
public Educacion findPersona(Long id) {
	return educacionRepo.findById(id).orElse(null);
}


@Override
public void deleteEducacion(Long id) {
	educacionRepo.deleteById(id);
}

}
