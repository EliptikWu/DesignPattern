package Adapter;

// Interfaz que el sistema espera (Target)
interface HDMI {
    void conectarConHDMI();
}

// Clase existente con una interfaz incompatible (Adaptee)
class VGA {
    public void conectarConVGA() {
        System.out.println("Conectado usando interfaz VGA.");
    }
}

// Adaptador que permite usar un VGA como si fuera HDMI
class AdaptadorVGAaHDMI implements HDMI {
    private VGA vga;

    public AdaptadorVGAaHDMI(VGA vga) {
        this.vga = vga;
    }

    @Override
    public void conectarConHDMI() {
        System.out.println("Adaptando señal de VGA a HDMI...");
        vga.conectarConVGA();
    }
}

// Nueva clase existente con interfaz DisplayPort (Adaptee)
class DisplayPort {
    public void conectarConDisplayPort() {
        System.out.println("Conectado usando interfaz DisplayPort.");
    }
}

// Adaptador que permite usar un DisplayPort como si fuera HDMI
class AdaptadorDisplayPortAHDMI implements HDMI {
    private DisplayPort dp;

    public AdaptadorDisplayPortAHDMI(DisplayPort dp) {
        this.dp = dp;
    }

    @Override
    public void conectarConHDMI() {
        System.out.println("Adaptando señal de DisplayPort a HDMI...");
        dp.conectarConDisplayPort();
    }
}

// Cliente que solo trabaja con HDMI
public class Cliente {
    public static void main(String[] args) {
        // Dispositivo con salida VGA
        VGA miMonitorVGA = new VGA();
        HDMI adaptadorVGA = new AdaptadorVGAaHDMI(miMonitorVGA);
        adaptadorVGA.conectarConHDMI();

        // Dispositivo con salida DisplayPort
        DisplayPort miMonitorDP = new DisplayPort();
        HDMI adaptadorDP = new AdaptadorDisplayPortAHDMI(miMonitorDP);
        adaptadorDP.conectarConHDMI();
    }
}
