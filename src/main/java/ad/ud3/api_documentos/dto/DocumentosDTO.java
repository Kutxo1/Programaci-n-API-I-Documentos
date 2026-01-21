package ad.ud3.api_documentos.dto;

import lombok.Data; // Anotación de Lombok para generar Getters, Setters, toString, etc.
import lombok.NoArgsConstructor; // Anotación de Lombok para generar un constructor vacio
import ad.ud3.api_documentos.model.Documentos;

import java.util.List; // Importa la interfaz List para manejar colecciones
import java.util.stream.Collectors; // Importa Collectors para transformar flujos (streams) en listas

@Data // Genera automáticamente los métodos básicos (get, set, equals, etc.)
@NoArgsConstructor // Genera el constructor sin argumentos necesario para frameworks como Jackson
public class DocumentosDTO {
    // Definición de atributos que se enviarán/recibirán a través de la API
    private Integer id;
    private String nombre;
    private String apellido;
    private String telefono;
    // Lista de objetos LibroDTO para evitar enviar la entidad Libro directamente (evita recursividad)
    private List<LibroDTO> libros;

    /**
     * Constructor de conveniencia que transforma una Entidad Autor en un DTO.
     * Se utiliza para preparar los datos antes de enviarlos al cliente (frontend).
     */
    public DocumentosDTO(Documentos documentos) {
// Mapeo de atributos simples de la entidad al DTO
        this.id_documento = documentosDTO.getId_documento();
        this.id_usuario = documentosDTO.getId_usuario();
        this.id_permiso = documentosDTO.getId_permiso();
        this.nombre = documentosDTO.getNombre();
        this.descripcion = documentosDTO.getDescripcion();
        this.fecha_creacion = documentosDTO.getFecha_creacion();
        this.fecha_modificacion = documentosDTO.getFecha_modificacion();
// Verificamos si el autor tiene libros asignados para evitar errores de puntero nulo
        if (documentos.getLibros() != null) {
// Convertimos la lista de entidades Libro en una lista de LibroDTO usando Streams
            this.libros = documentos.getLibros().stream()
                    .map(libro -> {
// Por cada objeto "Libro" de la base de datos, creamos un nuevo "LibroDTO"
                        LibroDTO dto = new LibroDTO();
                        dto.setId(libro.getId()); // Asignamos el ID del libro
                        dto.setTitulo(libro.getTitulo()); // Asignamos el titulo
                        dto.setAnioPublicacion(libro.getAnioPublicacion()); // Asignamos el año
                        dto.setAutorId(autor.getId()); // Guardamos solo el ID del autor (rompe la recursividad)
                        return dto; // Devolvemos el objeto DTO recién creado al flujo
                    })
// Agrupamos todos los LibroDTO creados en una nueva lista
                    .collect(Collectors.toList());
        }
    }
}