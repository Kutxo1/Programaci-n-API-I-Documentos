package ad.ud3.api_documentos.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "Documento")
public class Documento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_documento")
    private Integer idDocumento;

    @Column(name = "id_usuario", nullable = false)
    private Integer idUsuario;

    @Column(name = "id_permiso", nullable = false)
    private Integer idPermiso;

    @Column(name = "nombre", nullable = false, length = 20)
    private String nombre;

    @Column(name = "descripcion", nullable = false, columnDefinition = "TEXT")
    private String descripcion;

    @Column(name = "fecha_creacion", nullable = false)
    private LocalDate fechaCreacion;

    @Column(name = "fecha_modificacion", nullable = false)
    private LocalDate fechaModificacion;

    public Documento() {
    }

    public Integer getIdDocumento() {
        return idDocumento;
    }

    public void setIdDocumento(Integer idDocumento) {
        this.idDocumento = idDocumento;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Integer getIdPermiso() {
        return idPermiso;
    }

    public void setIdPermiso(Integer idPermiso) {
        this.idPermiso = idPermiso;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public LocalDate getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(LocalDate fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public LocalDate getFechaModificacion() {
        return fechaModificacion;
    }

    public void setFechaModificacion(LocalDate fechaModificacion) {
        this.fechaModificacion = fechaModificacion;
    }
}
