//
// Este archivo ha sido generado por Eclipse Implementation of JAXB v3.0.0 
// Visite https://eclipse-ee4j.github.io/jaxb-ri 
// Todas las modificaciones realizadas en este archivo se perderán si se vuelve a compilar el esquema de origen. 
// Generado el: 2024.10.23 a las 05:31:52 AM PET 
//


package pe.edu.cibertec.ws.objects;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para proveedorws complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="proveedorws"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="nombre_proveedor" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="tipo_servicio" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="contacto" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="email" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "proveedorws", propOrder = {
    "id",
    "nombreProveedor",
    "tipoServicio",
    "contacto",
    "email"
})
public class Proveedorws {

    protected int id;
    @XmlElement(name = "nombre_proveedor", required = true)
    protected String nombreProveedor;
    @XmlElement(name = "tipo_servicio", required = true)
    protected String tipoServicio;
    @XmlElement(required = true)
    protected String contacto;
    @XmlElement(required = true)
    protected String email;

    /**
     * Obtiene el valor de la propiedad id.
     * 
     */
    public int getId() {
        return id;
    }

    /**
     * Define el valor de la propiedad id.
     * 
     */
    public void setId(int value) {
        this.id = value;
    }

    /**
     * Obtiene el valor de la propiedad nombreProveedor.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNombreProveedor() {
        return nombreProveedor;
    }

    /**
     * Define el valor de la propiedad nombreProveedor.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNombreProveedor(String value) {
        this.nombreProveedor = value;
    }

    /**
     * Obtiene el valor de la propiedad tipoServicio.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTipoServicio() {
        return tipoServicio;
    }

    /**
     * Define el valor de la propiedad tipoServicio.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTipoServicio(String value) {
        this.tipoServicio = value;
    }

    /**
     * Obtiene el valor de la propiedad contacto.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getContacto() {
        return contacto;
    }

    /**
     * Define el valor de la propiedad contacto.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setContacto(String value) {
        this.contacto = value;
    }

    /**
     * Obtiene el valor de la propiedad email.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEmail() {
        return email;
    }

    /**
     * Define el valor de la propiedad email.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEmail(String value) {
        this.email = value;
    }

}
