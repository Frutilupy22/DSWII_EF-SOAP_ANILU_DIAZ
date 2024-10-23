package pe.edu.cibertec.DSWII_EF_SOAP_ANILU_DIAZ.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "proveedores")
public class Proveedor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nombreProveedor;
    private String tipoServicio;
    private String contacto;
    private String email;
}
