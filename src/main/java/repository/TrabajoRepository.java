package repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import model.Trabajo;

@Repository
public interface TrabajoRepository extends JpaRepository<Trabajo, Long>{

}
