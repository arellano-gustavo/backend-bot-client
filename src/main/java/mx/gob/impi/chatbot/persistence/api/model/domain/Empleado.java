/*
 * Licencia:    Este código se encuentra bajo la protección
 *              que otorga el contrato establecido entre
 *              Ultrasist SA de CV y su cliente, IMPI, por lo
 *              que queda estrictamente prohibido copiar, donar
 *              vender y/o distribuir el presente código por
 *              cualquier medio electrónico o impreso sin el
 *              permiso explícito y por escrito del cliente.
 *
 * Proyecto:    Chatbot IMPI
 * Paquete:     mx.gob.impi.chatbot.persistence.api.model.domain
 * Modulo:      Area
 * Tipo:        clase
 * Autor:       Gustavo A. Arellano (GAA)
 * Fecha:       Viernes 20 de Septiembre de 2019 (13_41)
 * Version:     1.0-SNAPSHOT
 * .
 * POJO asociado a la entidad 'Area'
 *
 * Historia:    .
 *              20190920_1341 Creación del tipo
 *
 *
 */
package mx.gob.impi.chatbot.persistence.api.model.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * <p>Descripción:</p>
 * POJO asociado a la entidad 'Empleado'
 *
 * @author Gustavo A. Arellano (GAA)
 * @version 1.0-SNAPSHOT
 */
@JsonIgnoreProperties(value = { "Area_Adscripcion", "Direccion", "Jefe", "Lista_Inventario", "Oficinal_Regional", "Puesto", "Vacaciones" })
public class Empleado {

    @JsonProperty("Apellido_Materno")
    private String apellido_Materno;

    public String getApellido_Materno() {
        return apellido_Materno;
    }

    public void setApellido_Materno(String apellido_Materno){
        this.apellido_Materno = apellido_Materno;
    }

    @JsonProperty("Apellido_Paterno")
    private String apellido_Paterno;

    public String getApellido_Paterno() {
        return apellido_Paterno;
    }

    public void setApellido_Paterno(String Apellido_Paterno){
        this.apellido_Paterno = Apellido_Paterno;
    }

    @JsonProperty("CURP")
    private String curp;

    public String getCURP() {
        return curp;
    }

    public void setCURP(String CURP){
        this.curp = CURP;
    }

    @JsonProperty("Correo_Institucional")
    private String correo_Institucional;

    public String getCorreo_Institucional() {
        return correo_Institucional;
    }

    public void setCorreo_Institucional(String Correo_Institucional){
        this.correo_Institucional = Correo_Institucional;
    }

    @JsonProperty("Estatus")
    private String estatus;

    public String getEstatus() {
        return estatus;
    }

    public void setEstatus(String Estatus){
        this.estatus = Estatus;
    }

    @JsonProperty("Fecha_Alta_Tecnica")
    private String fecha_Alta_Tecnica;

    public String getFecha_Alta_Tecnica() {
        return fecha_Alta_Tecnica;
    }

    public void setFecha_Alta_Tecnica(String Fecha_Alta_Tecnica){
        this.fecha_Alta_Tecnica = Fecha_Alta_Tecnica;
    }

    @JsonProperty("Fecha_Nacimiento")
    private String fecha_Nacimiento;

    public String getFecha_Nacimiento() {
        return fecha_Nacimiento;
    }

    public void setFecha_Nacimiento(String Fecha_Nacimiento){
        this.fecha_Nacimiento = Fecha_Nacimiento;
    }

    @JsonProperty("Fecha_Ultima_Promocion")
    private String fecha_Ultima_Promocion;

    public String getFecha_Ultima_Promocion() {
        return fecha_Ultima_Promocion;
    }

    public void setFecha_Ultima_Promocion(String Fecha_Ultima_Promocion){
        this.fecha_Ultima_Promocion = Fecha_Ultima_Promocion;
    }

    @JsonProperty("Grupo_Personal")
    private String grupo_Personal;

    public String getGrupo_Personal() {
        return grupo_Personal;
    }

    public void setGrupo_Personal(String Grupo_Personal){
        this.grupo_Personal = Grupo_Personal;
    }

    @JsonProperty("Nombre")
    private String nombre;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String Nombre){
        this.nombre = Nombre;
    }

    @JsonProperty("RFC")
    private String rfc;

    public String getRFC() {
        return rfc;
    }

    public void setRFC(String RFC){
        this.rfc = RFC;
    }


    @JsonProperty("Numero_Empleado_Entero")
    private String numero_Empleado_Entero;

    public String getNumero_Empleado_Entero() {
        return numero_Empleado_Entero;
    }

    public void setNumero_Empleado_Entero(String Numero_Empleado_Entero){
        this.numero_Empleado_Entero = Numero_Empleado_Entero;
    }

    @JsonProperty("Numero_Empleado")
    private String numero_Empleado;

    public String getNumero_Empleado() {
        return numero_Empleado;
    }

    public void setNumero_Empleado(String Numero_Empleado){
        this.numero_Empleado = Numero_Empleado;
    }

    @JsonProperty("Nombre_Completo")
    private String nombre_Completo;

    public String getNombre_Completo() {
        return nombre_Completo;
    }

    public void setNombre_Completo(String Nombre_Completo){
        this.nombre_Completo = Nombre_Completo;
    }

    public Empleado() {
    }

    public Empleado(String apellido_Materno, String apellido_Paterno, String curp, String correo_Institucional,
            String estatus, String fecha_Alta_Tecnica, String fecha_Nacimiento, String fecha_Ultima_Promocion,
            String grupo_Personal, String nombre, String rfc, String numero_Empleado_Entero, String numero_Empleado,
            String nombre_Completo) {
        this.apellido_Materno = apellido_Materno;
        this.apellido_Paterno = apellido_Paterno;
        this.curp = curp;
        this.correo_Institucional = correo_Institucional;
        this.estatus = estatus;
        this.fecha_Alta_Tecnica = fecha_Alta_Tecnica;
        this.fecha_Nacimiento = fecha_Nacimiento;
        this.fecha_Ultima_Promocion = fecha_Ultima_Promocion;
        this.grupo_Personal = grupo_Personal;
        this.nombre = nombre;
        this.rfc = rfc;
        this.numero_Empleado_Entero = numero_Empleado_Entero;
        this.numero_Empleado = numero_Empleado;
        this.nombre_Completo = nombre_Completo;
    }


}
