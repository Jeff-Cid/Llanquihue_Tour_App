package cl.llanquihuetourapp.model;

public class Tour {

    private String nombre;
    private String tipo;
    private int duracionHoras;
    private int precio;

    public Tour() {
        this.nombre = "Sin nombre";
        this.tipo = "Sin duracion";
        this.duracionHoras = 0;
        this.precio = 0;
    }

    public Tour(String nombre, String tipo, int duracionHoras, int precio) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.duracionHoras = duracionHoras;
        this.precio = precio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        if(nombre == null || nombre.isBlank()){
            throw new IllegalArgumentException("El nombre no puede estar vacío");
        }
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        if(tipo == null || tipo.isBlank()){
            throw new IllegalArgumentException("El tipo no puede estar vacío");
        }
        this.tipo = tipo;
    }

    public int getDuracionHoras() {
        return duracionHoras;
    }

    public void setDuracion(int duracionHoras) {
        if(precio <= 0) {
            throw new IllegalArgumentException("La duración no puede estar vacía");
        }
        this.duracionHoras = duracionHoras;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecios(int precios) {
        if(precio <= 0) {
            throw new IllegalArgumentException("El precio no puede estar vacío");
        }
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "Tour --> " + "Nombre: " + nombre + " | Tipo: " + tipo + " | Duración: " + duracionHoras + " horas" + " | Precio: $" + precio;
    }
}
