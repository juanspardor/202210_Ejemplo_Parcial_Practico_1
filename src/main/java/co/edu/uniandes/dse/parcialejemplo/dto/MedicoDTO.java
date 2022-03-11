package co.edu.uniandes.dse.parcialejemplo.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MedicoDTO 
{
	private Long id;
	private String nombre;
	private String apellido;
	private String registroMedico;
	private String especialidad;
}
