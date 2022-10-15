package pe.rojasenciso.contactospringbootpostgres;

import java.time.LocalDateTime;


import javax.persistence.*;

import lombok.*;

@Data
@Entity
@Setter @Getter	
public class Contacto {
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long id;
	private String nombre;	
	private LocalDateTime fechaRegistro;
	
	@PrePersist
	void prePersist() {
		fechaRegistro = LocalDateTime.now();
	}

}
