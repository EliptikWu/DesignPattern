package pizzaejemplo;
// 4. Director (opcional, organiza el proceso de construcción)
import java.util.Scanner;

public class Pizzeria {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Bienvenido a la Pizzería dinámica");
        System.out.print("Tipo (1=Estándar, 2=Hawaiana): ");
        int tipo = Integer.parseInt(sc.nextLine());

        Pizza.PizzaBuilder builder = (tipo == 2)
                ? new PizzaHawaianaBuilder()
                : new PizzaConcreteBuilder();

        System.out.print("Tamaño (chica, mediana, grande): ");
        String size = sc.nextLine();
        builder.setSize(size);                // ¡Usa el setter! :contentReference[oaicite:7]{index=7}

        if (tipo == 1) {
            System.out.print("¿Cuántos ingredientes adicionales? ");
            int count = Integer.parseInt(sc.nextLine());
            for (int i = 1; i <= count; i++) {
                System.out.print("Ingrediente #" + i + ": ");
                builder.addIngredient(sc.nextLine());
            }
        }

        Pizza pizza = builder.build();
        System.out.println("\nSu pizza: " + pizza);
        sc.close();
    }
}
