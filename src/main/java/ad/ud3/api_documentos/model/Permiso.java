package ad.ud3.api_documentos.model;

import jakarta.persistence.*;

@Entity
@Table(name = "Permisos")
public class Permiso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idPermiso;

    // GETTERS & SETTERS
}
