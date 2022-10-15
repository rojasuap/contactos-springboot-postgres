package pe.rojasenciso.contactospringbootpostgres;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

@Repository
public interface contactoRepository extends JpaRepository<Contacto, Long>{

}
