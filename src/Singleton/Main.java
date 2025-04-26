package Singleton;

public class Main {
    public static void main(String[] args) {
        // Obtener la instancia del logger
        Logger logger = Logger.getInstancia();

        // Simular un error
        try {
            int division = 10 / 0;
        } catch (ArithmeticException e) {
            logger.logError("No se puede dividir por cero: " + e.getMessage());
        }
    }
}
