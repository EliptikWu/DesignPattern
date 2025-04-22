package AbstractFactory;

// Clase principal
public class Main {
    public static void main(String[] args) {
        System.out.println("=== Fábrica Moderna ===");
        Fabricacion moderna = new FabricacionModerna();
        moderna.crearSilla().ensamblar();
        moderna.crearSofa().reclinar();
        moderna.crearMesa().ensamblar();

        System.out.println("\n=== Fábrica Victoriana ===");
        Fabricacion victoriana = new FabricacionVictoriana();
        victoriana.crearSilla().ensamblar();
        victoriana.crearSofa().reclinar();
        victoriana.crearMesa().ensamblar();

        System.out.println("\n=== Fábrica Rústica ===");
        Fabricacion rustica = new FabricacionRustica();
        Mesa mesaRustica = rustica.crearMesa();
        if (mesaRustica != null) mesaRustica.ensamblar();}
}