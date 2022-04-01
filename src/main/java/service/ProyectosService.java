package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import model.Proyecto;
import repository.ProyectoRepository;

@Service
public class ProyectosService implements IProyectoService {
	
	@Autowired
	ProyectoRepository proyectoRepo;

	@Override
	public void saveProyecto(Proyecto proyecto) {
		proyectoRepo.save(proyecto);		
	}

	@Override
	public void updateProyecto(Long id, Proyecto proyecto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Proyecto> getProyectos() {
		return proyectoRepo.findAll();
	}

	@Override
	public Proyecto findProyecto(Long id) {
		return proyectoRepo.findById(id).orElse(null);
	}

	@Override
	public void deleteProyecto(Long id) {
		proyectoRepo.deleteById(id);
	}
	
	

}
