package mx.gob.impi.chatbot.persistence.api.model.estado;

import java.io.Serializable;

public class EstadoPojo implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer estadoPk;
    private String nombre;

    /**
     * Constructor default de la clase.
     */
    public EstadoPojo() {
    }
    
    public EstadoPojo(Integer estadoPk, String nombre) {
        this.estadoPk = estadoPk;
        this.nombre = nombre;
    }

    /**
     * Constructor con los atributos que conforman la llave de la clase.
     */
    public  EstadoPojo(Integer estadoPk) {
        this.estadoPk = estadoPk;
    }

    public Integer getEstadoPk() {
        return estadoPk;
    }

    public void setEstadoPk(Integer estadoPk) {
        this.estadoPk = estadoPk;
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

}
