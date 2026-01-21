package ad.ud3.api_documentos.repository;

import ad.ud3.api_documentos.model.Documentos;
import org.springframework.data.jpa.repository. JpaRepository;
import org.springframework.stereotype. Repository;
import ad.ud3.api_documentos.model.Documentos;
@Repository // Registra la interfaz como un componente de persistencia de Spring
public interface documentosRepository extends JpaRepository<Documentos, Integer> {
// Al extender JpaRepository, ya tenemos métodos como save(), findAll(), deleteById(), etc.
// Spring Data JPA implementará automáticamente la lógica para interactuar con la tabla 'autores'.
}