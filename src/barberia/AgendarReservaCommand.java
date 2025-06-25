package barberia;

public class AgendarReservaCommand implements Comando {
    private Cliente cliente;
    private String hora;

    public AgendarReservaCommand(Cliente cliente, String hora) {
        this.cliente = cliente;
        this.hora = hora;
    }

    @Override
    public void ejecutar() {
        Reserva reserva = new Reserva(cliente, hora);
        AgendaReservas.getInstancia().agregarReserva(reserva);
    }
}