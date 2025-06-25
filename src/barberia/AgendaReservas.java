package barberia;

import java.util.*;

public class AgendaReservas {
    private static AgendaReservas instancia;
    private List<Reserva> reservas = new ArrayList<>();
    private List<Cliente> clientes = new ArrayList<>();

    private AgendaReservas() {}

    public static AgendaReservas getInstancia() {
        if (instancia == null) instancia = new AgendaReservas();
        return instancia;
    }

    public void agregarCliente(Cliente cliente) {
        clientes.add(cliente);
    }

    public Cliente buscarCliente(String nombre) {
        for (Cliente c : clientes) {
            if (c.getNombre().equalsIgnoreCase(nombre)) return c;
        }
        return null;
    }

    public void agregarReserva(Reserva reserva) {
        reservas.add(reserva);
        reserva.getCliente().notificar("Reserva confirmada para las " + reserva.getHora());
    }

    public void cancelarReserva(Cliente cliente) {
        reservas.removeIf(r -> r.getCliente().equals(cliente));
        cliente.notificar("Su reserva ha sido cancelada.");
    }

    public void mostrarReservas() {
        if (reservas.isEmpty()) {
            System.out.println("🔍 No hay reservas agendadas.");
        } else {
            for (Reserva r : reservas) {
                System.out.println("" + r);
            }
        }
    }

    public boolean tieneReserva(Cliente cliente) {
        return reservas.stream().anyMatch(r -> r.getCliente().equals(cliente));
    }
}