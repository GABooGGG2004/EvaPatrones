package barberia;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        SistemaBarberia sistema = new SistemaBarberia();
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n=== Barberia NULL ===");
            System.out.println("1. Registrar cliente");
            System.out.println("2. Agendar reserva");
            System.out.println("3. Cancelar reserva");
            System.out.println("4. Ver reservas");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opcion: ");

            while (!scanner.hasNextInt()) {
                System.out.println("Ingrese un numero valido.");
                scanner.next();
            }

            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    sistema.registrarCliente(scanner);
                    break;
                case 2:
                    sistema.agendarReserva(scanner);
                    break;
                case 3:
                    sistema.cancelarReserva(scanner);
                    break;
                case 4:
                    sistema.verReservas();
                    break;
                case 0:
                    System.out.println("Gracias por usar el sistema.");
                    break;
                default:
                    System.out.println("Opcion invalida.");
            }

        } while (opcion != 0);

        scanner.close();
    }
}
