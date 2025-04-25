package Composite;

public class ArchivadorComposite {
    public static void main(String[] args) {
        // Crear carpeta raíz
        Carpeta raiz = new Carpeta("Raíz");

        // Crear subcarpetas
        Carpeta documentos = new Carpeta("Documentos");
        Carpeta imagenes = new Carpeta("Imágenes");

        // --- Nuevo: Carpeta anidada dentro de Documentos ---
        Carpeta proyectos = new Carpeta("Proyectos");
        // Archivos dentro de “Proyectos”
        Archivo proyecto1 = new Archivo("proyecto1.docx", 450);
        Archivo proyecto2 = new Archivo("proyecto2.pdf", 800);
        proyectos.añadir(proyecto1);
        proyectos.añadir(proyecto2);
        // -----------------------------------------------

        // Crear archivos individuales
        Archivo archivo1 = new Archivo("documento.txt", 100);
        Archivo archivo2 = new Archivo("foto.jpg", 2000);
        Archivo archivo3 = new Archivo("config.xml", 300);

        // Añadir archivos y subcarpeta “Proyectos” a “Documentos”
        documentos.añadir(archivo1);
        documentos.añadir(archivo3);
        documentos.añadir(proyectos);    // añadimos la carpeta anidada

        // Añadir archivo a “Imágenes”
        imagenes.añadir(archivo2);

        // Añadir carpetas a la raíz
        raiz.añadir(documentos);
        raiz.añadir(imagenes);

        // Mostrar estructura completa del archivador
        System.out.println("📂 Estructura del Archivador:");
        raiz.mostrar("");

        // Mostrar tamaño total de la raíz
        System.out.println("\n📦 Tamaño total: " + raiz.getTamaño() + " bytes");
    }
}
