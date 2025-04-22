package FactoryMethod;

// --- PASO 1: Definir la Interfaz del Producto ---
interface Envio {
    String tipoDeEnvio(); // Todos los envios deben poder decribir su tipo.
}

// --- PASO 2: Crear Productos Concretos ---
class EnvioTerrestre implements Envio {
    @Override
    public String tipoDeEnvio() {
        return "Envio por tierra (Camión, furgoneta, etc.)";
    }
}

class EnvioMaritimo implements Envio {
    @Override
    public String tipoDeEnvio() {
        return "Envio por mar (barco o buque de carga)";
    }
}

class EnvioAereo implements Envio {
    @Override
    public String tipoDeEnvio() {
        return "Envio por aire (avión)";
    }
}

// --- PASO 3: Definir la Fábrica Abstracta (Creator) ---

abstract class FabricaEnvios {

    public abstract Envio crearEnvio();


    public void procesarEnvio() {
        Envio envio = crearEnvio();
        System.out.println("Procesando: " + envio.tipoDeEnvio());
    }
}

// --- PASO 4: Crear Fábricas Concretas (Concrete Creators) ---
class FabricaEnvioTerrestre extends FabricaEnvios {
    @Override
    public Envio crearEnvio() {
        return new EnvioTerrestre();
    }
}

class FabricaEnvioMaritimo extends FabricaEnvios {
    @Override
    public Envio crearEnvio() {
        return new EnvioMaritimo();
    }
}

class FabricaEnvioAereo extends FabricaEnvios {
    @Override
    public Envio crearEnvio() {
        return new EnvioAereo();
    }
}

