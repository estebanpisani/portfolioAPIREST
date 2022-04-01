package service;

import java.util.List;

import model.Proyecto;

public interface IProyectoService {
	

	
	public void saveProyecto (Proyecto proyecto);
	
	public void updateProyecto(Long id, Proyecto proyecto);
	
	public List<Proyecto> getProyectos();
	
	public Proyecto findProyecto (Long id);
	
	public void deleteProyecto (Long id);

}
