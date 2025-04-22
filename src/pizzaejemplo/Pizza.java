package pizzaejemplo;


import java.util.Collections;
import java.util.List;

public class Pizza {
    private final String size;
    private final List<String> ingredients;

    Pizza(PizzaBuilder builder) {
        this.size = builder.getSize();       // lee size desde el builder
        this.ingredients = Collections.unmodifiableList(builder.getIngredients());
    }

    public String getSize() { return size; }
    public List<String> getIngredients() { return ingredients; }

    @Override
    public String toString() {
        return "Pizza{size='" + size + "', ingredients=" + ingredients + '}';
    }

    public interface PizzaBuilder {
        PizzaBuilder setSize(String size);
        String getSize();                     // para construcción interna
        PizzaBuilder addIngredient(String ing);
        List<String> getIngredients();
        Pizza build();
    }
}