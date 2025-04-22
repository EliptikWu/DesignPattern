package FactoryMethod;

// --- PASO 5: Usar las Fábricas (Código Cliente) ---
public class DemoSimpleFactory {

    public static void main(String[] args) {

        System.out.println("Probando envío Terrestre:");
        FabricaEnvios terrestre = new FabricaEnvioTerrestre();
        terrestre.procesarEnvio();

        System.out.println("\nProbando envío Marítimo:");
        FabricaEnvios maritimo = new FabricaEnvioMaritimo();
        maritimo.procesarEnvio();

        System.out.println("\nProbando envío Aéreo:");
        FabricaEnvios aereo = new FabricaEnvioAereo();
        aereo.procesarEnvio();

    }
}

