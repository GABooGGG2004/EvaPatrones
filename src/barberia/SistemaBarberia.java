package barberia;

import java.util.Scanner;

public class SistemaBarberia {

    private AgendaReservas agenda = AgendaReservas.getInstancia();
    private Invocador invocador = new Invocador();

    public void registrarCliente(Scanner scanner) {
        System.out.print("Ingrese nombre del cliente: ");
        String nombre = scanner.nextLine().trim();
        if (nombre.isEmpty()) {
            System.out.println("Nombre no puede estar vacío.");
            return;
        }
        Cliente cliente = new Cliente(nombre);
        agenda.agregarCliente(cliente);
        System.out.println("Cliente registrado con éxito.");
    }

    public void agendarReserva(Scanner scanner) {
        System.out.print("Nombre del cliente: ");
        String nombre = scanner.nextLine().trim();
        Cliente cliente = agenda.buscarCliente(nombre);

        if (cliente == null) {
            System.out.println("Cliente no encontrado.");
            return;
        }

        System.out.print("Hora de la cita (formato HH:mm): ");
        String hora = scanner.nextLine().trim();

        // Validación del formato HH:mm usando regex con barras escapadas
        if (!hora.matches("^([01]?\\d|2[0-3]):[0-5]\\d$")) {
            System.out.println(" Formato de hora incorrecto.");
            return;
        }

        Comando comando = new AgendarReservaCommand(cliente, hora);
        invocador.setComando(comando);
        invocador.ejecutarComando();
    }

    public void cancelarReserva(Scanner scanner) {
        System.out.print("Nombre del cliente: ");
        String nombre = scanner.nextLine().trim();
        Cliente cliente = agenda.buscarCliente(nombre);

        if (cliente == null || !agenda.tieneReserva(cliente)) {
            System.out.println("Cliente no tiene reservas.");
            return;
        }

        agenda.cancelarReserva(cliente);
        System.out.println("Reserva cancelada.");
    }

    public void verReservas() {
        agenda.mostrarReservas();
    }
}
