package ad.ud3.api_documentos.repository;

import ad.ud3.api_documentos.model.TipoDocumento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TipoDocumentoRepository extends JpaRepository<TipoDocumento, Integer> {
}
