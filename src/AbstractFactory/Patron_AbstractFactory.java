package AbstractFactory;

// Interfaces para productos
interface Sofa {
    void reclinar();
}

interface Silla {
    void ensamblar();
}

interface Mesa {
    void ensamblar();
}

// Implementaciones de Sofa
class SofaModerno implements Sofa {
    public void reclinar() {
        System.out.println("Sofá moderno reclinándose.");
    }
}

class SofaVictoriano implements Sofa {
    public void reclinar() {
        System.out.println("Sofá victoriano reclinándose.");
    }
}

// Implementaciones de Silla
class SillaModerna implements Silla {
    public void ensamblar() {
        System.out.println("Silla moderna ensamblada.");
    }
}

class SillaVictoriana implements Silla {
    public void ensamblar() {
        System.out.println("Silla victoriana ensamblada.");
    }
}

// Implementaciones de Mesa
class MesaModerna implements Mesa {
    public void ensamblar() {
        System.out.println("Mesa moderna ensamblada.");
    }
}

class MesaRustica implements Mesa {
    public void ensamblar() {
        System.out.println("Mesa rústica ensamblada.");
    }
}

class MesaVictoriana implements Mesa {
    public void ensamblar() {
        System.out.println("Mesa victoriana ensamblada.");
    }
}

// Interfaz de Fábrica Abstracta
interface Fabricacion {
    Silla crearSilla();
    Sofa crearSofa();
    Mesa crearMesa();
}

// Fabricación Moderna
class FabricacionModerna implements Fabricacion {
    public Silla crearSilla() {
        return new SillaModerna();
    }

    public Sofa crearSofa() {
        return new SofaModerno();
    }

    public Mesa crearMesa() {
        return new MesaModerna();
    }
}

// Fabricación Victoriana
class FabricacionVictoriana implements Fabricacion {
    public Silla crearSilla() {
        return new SillaVictoriana();
    }

    public Sofa crearSofa() {
        return new SofaVictoriano();
    }

    public Mesa crearMesa() {
        return new MesaVictoriana();
    }
}

// Fabricación Rústica (solo mesa)
class FabricacionRustica implements Fabricacion {
    public Silla crearSilla() {
        return null; // No disponible
    }

    public Sofa crearSofa() {
        return null; // No disponible
    }

    public Mesa crearMesa() {
        return new MesaRustica();
    }
}

