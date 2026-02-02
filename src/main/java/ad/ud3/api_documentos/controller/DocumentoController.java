package ad.ud3.api_documentos.controller;

import ad.ud3.api_documentos.dto.DocumentoDTO;
import ad.ud3.api_documentos.model.Documento;
import ad.ud3.api_documentos.service.DocumentoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/documentos")
public class DocumentoController {

    private final DocumentoService documentoService;

    public DocumentoController(DocumentoService documentoService) {
        this.documentoService = documentoService;
    }

    @GetMapping
    public List<DocumentoDTO> getAll() {
        return documentoService.getAll();
    }

    @PostMapping
    public Documento create(@RequestBody Documento documento) {
        return documentoService.save(documento);
    }
}
