package pe.rojasenciso.contactospringbootpostgres;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/v1")
public class ContactoController {
	
	@Autowired
	private ContactoService servicio;
	
	//Servicio de Listar Parametros
	@GetMapping("/contactos")
	public List<Contacto> listarContacto(){
		return servicio.listarContactos();
	}
	
	//Servicio de obtener Parametro
	@GetMapping("/contactos/{id}")
	public ResponseEntity<Contacto> obtenerConatcto(@PathVariable Long id) {
		Contacto contacto = servicio.obtenerContacto(id);
		return ResponseEntity.ok(contacto);
	}
	
	//Servicio de Guardar Parametro
	@PostMapping("/contactos")
	public Contacto guardarParametro(@RequestBody Contacto contacto){
		return servicio.guardarContacto(contacto);
	}
	
	//Servicio de Eliminar Parametro
	@DeleteMapping("/contactos/{id}")
	public ResponseEntity<Map<String,Boolean>>eliminarcontactos(@PathVariable Long id) {
		Contacto contacto = servicio.obtenerContacto(id);
		servicio.eliminarContacto(contacto);
		Map<String, Boolean> respuesta = new HashMap<>();
		respuesta.put("eliminar",Boolean.TRUE);
		return ResponseEntity.ok(respuesta);
	}
	
	//Servicio de Actualizar Parametro
	@PutMapping("/contactos/{id}")
	public ResponseEntity<Contacto>actualizarParametro(@PathVariable Long id, @RequestBody Contacto contactoModi) {		

			
		Contacto contacto = servicio.obtenerContacto(id);
		contacto.setNombre(contactoModi.getNombre());
				
		Contacto parametroActualizado = servicio.guardarContacto(contacto);		
		return ResponseEntity.ok(parametroActualizado);
	}	

}
