package pe.rojasenciso.contactospringbootpostgres;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ContactoService {
	@Autowired
	private contactoRepository repositorio;

	//Listar Parametros
	public List<Contacto> listarContactos(){		
		return repositorio.findAll();
	}
	
	//Obtener Parametro
	public Contacto obtenerContacto(Long id) {
		Contacto contacto = repositorio.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("No existe el contacto con el ID : " + id));
		return contacto;
	}
	
	//Guardar Parametro
	public Contacto guardarContacto(Contacto contacto) {
		return repositorio.save(contacto);
	}
	
	//Eliminar Parametro
	public void eliminarContacto(Contacto contacto) {		
		repositorio.delete(contacto);
	}
		
}
