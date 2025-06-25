# Sistema de Gestión de Reservas para Barbería

## Descripción del sistema

Esta aplicación por consola en Java permite a una barbería gestionar la reserva de citas para sus clientes. El sistema registra clientes, agenda, muestra y cancela reservas, evitando errores comunes de doble reserva o confusión horaria.

Funciona con una interfaz sencilla por consola, con validaciones para asegurar la correcta entrada de datos y evitar caídas o errores en tiempo de ejecución.

---

## Problema a resolver

Las barberías tradicionales a menudo manejan reservas manualmente, lo que provoca errores de doble reserva, pérdida de citas y falta de seguimiento. Este sistema digitaliza la gestión de reservas para un control eficiente y organizado, garantizando que cada cliente pueda reservar y ser notificado correctamente.

---

## Patrones de diseño implementados y su justificación

### 1. Singleton (Patrón Creacional)  
**Dónde:** En la clase `AgendaReservas`.  
**Por qué:** Para asegurar que exista una única instancia que controle todas las reservas y clientes. Esto previene inconsistencias y facilita la gestión centralizada.  
**Cómo:** Se implementa con un constructor privado y un método estático `getInstancia()` que devuelve siempre la misma instancia.

### 2. Facade (Patrón Estructural)  
**Dónde:** En la clase `SistemaBarberia`.  
**Por qué:** Para simplificar la interacción del usuario con el sistema, ocultando la complejidad interna y exponiendo una interfaz sencilla con métodos claros para registrar clientes, agendar, cancelar y ver reservas.  
**Cómo:** La clase `SistemaBarberia` actúa como fachada, coordinando las llamadas a la clase `AgendaReservas` y otras.

### 3. Observer (Patrón de Comportamiento)  
**Dónde:** En la comunicación entre `AgendaReservas` y los clientes (`Cliente` implementa la interfaz `ObservadorCliente`).  
**Por qué:** Para notificar a los clientes sobre confirmaciones o cancelaciones de sus reservas sin acoplar directamente la lógica de notificación dentro del sistema principal.  
**Cómo:** Cada cliente es un observador que recibe mensajes cuando su reserva cambia, implementando el método `notificar()`.

### 4. Command (Patrón Libre Elección)  
**Dónde:** En la gestión de acciones sobre reservas, especialmente para agendar una reserva.  
**Por qué:** Para encapsular las operaciones como objetos, facilitando la extensión, mantenimiento y posible implementación futura de acciones como deshacer comandos.  
**Cómo:** La interfaz `Comando` define el método `ejecutar()`, y la clase `AgendarReservaCommand` implementa la acción concreta.

---

## Calidad y organización del código

- **Nombres descriptivos:** Clases y métodos con nombres claros como `AgendaReservas`, `SistemaBarberia`, `agendarReserva`.
- **Modularidad:** Código separado en clases con responsabilidades claras y delimitadas.
- **Validaciones:** Entrada del usuario validada para evitar errores y caídas, por ejemplo validación del formato de hora.
- **Manejo de errores:** Mensajes claros al usuario y protección contra entradas inválidas.
- **Uso de patrones:** Patrones aplicados correctamente para mejorar estructura, extensibilidad y mantenimiento.

---

## Instrucciones de compilación y ejecución

### Requisitos
- JDK 17 o superior instalado.
- IDE NetBeans (opcional) o cualquier otro que soporte Java.

### Clona el repositorio

```bash
git clone https://github.com/GABooGGG2004/EvaPatrones.git
cd EvaPatrones
```
### Ve a src

```bash
cd src/
```
  
### Compila el proyecto:

```bash
javac $(ls barberia/*.java)
```

### Ejecuta la aplicación:

```bash
java barberia.Main
```

### Compilar y ejecutar con NetBeans
1. Abre NetBeans.

2. Selecciona File > Open Project y navega a la carpeta donde clonaste el repositorio.

3. Abre el proyecto.

4. Ejecuta la clase Main con clic derecho > Run File o con Shift + F6.

### Sigue las instrucciones en pantalla para registrar clientes y gestionar reservas.

  Ejemplo:

  ```bash
  === Barbería NULL ===
  1. Registrar cliente
  2. Agendar reserva
  3. Cancelar reserva
  4. Ver reservas
  0. Salir
  Seleccione una opción: 1
  Ingrese nombre del cliente: Juan Pérez
     Cliente registrado con éxito.
  
  Seleccione una opción: 2
  Nombre del cliente: Juan Pérez
  Hora de la cita (formato HH:mm): 14:30
    Notificación para Juan Pérez: Reserva confirmada para las 14:30
  
  Seleccione una opción: 4
    Juan Pérez tiene una cita a las 14:30
  
  Seleccione una opción: 0
  Gracias por usar el sistema.
  
  ```
