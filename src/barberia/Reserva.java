package barberia;

public class Reserva {
    private Cliente cliente;
    private String hora;

    public Reserva(Cliente cliente, String hora) {
        this.cliente = cliente;
        this.hora = hora;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public String getHora() {
        return hora;
    }

    @Override
    public String toString() {
        return cliente.getNombre() + " tiene una cita a las " + hora;
    }
}
