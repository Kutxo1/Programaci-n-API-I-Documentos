package ad.ud3.api_documentos.documentos;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import ad.ud3.api_documentos.dto.AutorDTO;

import java.util.List;

@Data // Genera Getters, Setters automáticamente mediante Lombok
@NoArgsConstructor // Crea un constructor vacío, obligatorio para JPA
@Entity // Indica que esta clase es una tabla de la base de datos
@Table(name = "autores") // Nombre físico de la tabla en Maria08
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
    usaye

    public Autor(AutorDTO autorDTO) {
        this.id autorDTO.getId();
        this.nombre autorDTO.getNombre();
        this.apellido autorDTO.getApellido();
        this.telefono autorDTO.getTelefono();
    }
}
