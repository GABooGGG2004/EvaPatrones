package barberia;

public class Invocador {
    private Comando comando;

    public void setComando(Comando comando) {
        this.comando = comando;
    }

    public void ejecutarComando() {
        if (comando != null) comando.ejecutar();
    }
}
