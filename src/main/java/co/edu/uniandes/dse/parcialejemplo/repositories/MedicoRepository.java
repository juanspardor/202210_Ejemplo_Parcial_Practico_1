package co.edu.uniandes.dse.parcialejemplo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.edu.uniandes.dse.parcialejemplo.entities.MedicoEntity;

@Repository
public interface MedicoRepository extends JpaRepository<MedicoEntity, Long>{

}
