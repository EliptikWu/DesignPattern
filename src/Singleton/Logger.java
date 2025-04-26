package Singleton;

public class Logger {
    private static Logger instancia;

    // Constructor privado para evitar instanciación externa
    private Logger() {
    }

    // Método de acceso público para obtener la instancia única
    public static Logger getInstancia() {
        if (instancia == null) {
            instancia = new Logger();
        }
        return instancia;
    }

    // Método para registrar errores
    public void logError(String mensaje) {
        System.err.println("[ERROR] " + mensaje);
    }
}

