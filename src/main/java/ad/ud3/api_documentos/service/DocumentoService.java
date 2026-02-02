package ad.ud3.api_documentos.service;

import ad.ud3.api_documentos.dto.DocumentoDTO;
import ad.ud3.api_documentos.model.Documento;
import ad.ud3.api_documentos.repository.DocumentoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DocumentoService {

    private final DocumentoRepository documentoRepository;

    public DocumentoService(DocumentoRepository documentoRepository) {
        this.documentoRepository = documentoRepository;
    }

    public List<DocumentoDTO> getAll() {
        return documentoRepository.findAll()
                .stream()
                .map(doc -> {
                    DocumentoDTO dto = new DocumentoDTO();
                    dto.setIdDocumento(doc.getIdDocumento());
                    dto.setNombre(doc.getNombre());
                    dto.setDescripcion(doc.getDescripcion());
                    dto.setFechaCreacion(doc.getFechaCreacion());
                    dto.setFechaModificacion(doc.getFechaModificacion());
                    return dto;
                })
                .collect(Collectors.toList());
    }

    public Documento save(Documento documento) {
        return documentoRepository.save(documento);
    }
}
