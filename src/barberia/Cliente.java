package barberia;

public class Cliente implements ObservadorCliente {
    private String nombre;

    public Cliente(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    @Override
    public void notificar(String mensaje) {
        System.out.println("Notificacion para " + nombre + ": " + mensaje);
    }
}