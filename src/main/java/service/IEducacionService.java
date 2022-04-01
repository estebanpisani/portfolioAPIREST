package service;

import java.util.List;

import model.Educacion;

public interface IEducacionService {
	
	public void saveEducacion (Educacion educacion);
	
	public void updateEducacion(Long id, Educacion educacion);
	
	public List<Educacion> getEducacions();
	
	public Educacion findPersona (Long id);
	
	public void deleteEducacion (Long id);
}
