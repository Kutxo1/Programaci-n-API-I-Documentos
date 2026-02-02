package ad.ud3.api_documentos.model;

import jakarta.persistence.*;

@Entity
@Table(name = "Tipo_Documento")
public class TipoDocumento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idTipo;

    @Column(nullable = false, length = 20)
    private String nombre;

    // GETTERS & SETTERS
}
