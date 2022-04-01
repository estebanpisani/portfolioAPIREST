package service;

import java.util.List;

import model.Trabajo;

public interface ITrabajoService {
	
	public void saveTrabajo (Trabajo trabajo);
	
	public void updateTrabajo(Long id, Trabajo trabajo);
	
	public List<Trabajo> getTrabajos();
	
	public Trabajo findTrabajo (Long id);
	
	public void deleteTrabajo (Long id);
	
}
