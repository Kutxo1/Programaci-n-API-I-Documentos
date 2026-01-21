package ad.ud3.api_documentos.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import ad.ud3.api_documentos.dto.DocumentosDTO;

import java.util.List;

@Data // Genera Getters, Setters automáticamente mediante Lombok
@NoArgsConstructor // Crea un constructor vacío, obligatorio para JPA
@Entity // Indica que esta clase es una tabla de la base de datos
@Table(name = "Documentos") // Nombre físico de la tabla en MariaDB
public class Documentos {

    @Id // Define la clave primaria
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Autoincremental en la DB
    private Integer id;
    private String nombre;
    private String apellido;
    private String telefono;
// Relación 1 a Muchos: Un autor tiene una lista de libros.
// mappedBy: indica que el campo "autor" en la clase Libro es el dueño de la relación
// Cascade Type ALL: las operaciones sobre Autor se propagan a sus Libros
// orphanRemoval true: Si hay Libros sin autor se eliminan.
//FetchType. Lazy: Los libros no se cargan al no ser que realices un get
    @OneToMany(mappedBy = "autor", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<Libro> libros;
// Constructor manual para convertir un DTO en Entidad rápidamente

    public Documentos(DocumentosDTO documentosDTO) {
        this.id_documento = documentosDTO.getId_documento();
        this.id_usuario = documentosDTO.getId_usuario();
        this.id_permiso = documentosDTO.getId_permiso();
        this.nombre = documentosDTO.getNombre();
        this.descripcion = documentosDTO.getDescripcion();
        this.fecha_creacion = documentosDTO.getFecha_creacion();
        this.fecha_modificacion = documentosDTO.getFecha_modificacion();
    }
}
