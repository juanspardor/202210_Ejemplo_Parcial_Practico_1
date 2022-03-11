package co.edu.uniandes.dse.parcialejemplo.services;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import co.edu.uniandes.dse.parcialejemplo.entities.MedicoEntity;
import uk.co.jemos.podam.api.PodamFactory;
import uk.co.jemos.podam.api.PodamFactoryImpl;


@ExtendWith(SpringExtension.class)
@DataJpaTest
@Transactional
@Import(MedicoService.class)
class MedicoServiceTest 
{

	@Autowired
	private MedicoService medicoService;
	
	@Autowired
	private TestEntityManager entityManager;
	
	private PodamFactory factory = new PodamFactoryImpl();
	
	private List<MedicoEntity> medicoList = new ArrayList<>();
	
	
	@BeforeEach
	void setUp() throws Exception 
	{
		clearData();
		insertData();
	}
	
	private void clearData()
	{
		entityManager.getEntityManager().createQuery("delete from MedicoEntity");
	}
	
	private void insertData()
	{
		for(int i = 1; i<=3; i++)
		{
			MedicoEntity medicoEntity = factory.manufacturePojo(MedicoEntity.class);
			entityManager.persist(medicoEntity);
			medicoList.add(medicoEntity);
		}
	}
	
	/**
	 * Prueba para obtener todos los medicos
	 */
	@Test
	void testGetMedicos()
	{
		List<MedicoEntity> medicos = medicoService.getMedicos();
		assertEquals(medicos.size(), medicoList.size());
		
		for(MedicoEntity medicoEntity: medicos)
		{
			boolean encontrado = false;
			for(MedicoEntity medico: medicoList)
			{
				if(medicoEntity.getId().equals(medico.getId()))
				{
					encontrado = true;
				}
			}
			assertTrue(encontrado);
		}
	}

}
