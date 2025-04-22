package pizzaejemplo;

import java.util.ArrayList;
import java.util.List;

public class PizzaConcreteBuilder implements Pizza.PizzaBuilder {
    protected String size;
    protected List<String> ingredients = new ArrayList<>();

    @Override
    public Pizza.PizzaBuilder setSize(String size) {
        this.size = size;
        return this;
    }

    @Override
    public String getSize() {
        return this.size;
    }

    @Override
    public Pizza.PizzaBuilder addIngredient(String ing) {
        this.ingredients.add(ing);
        return this;
    }

    @Override
    public List<String> getIngredients() {
        return this.ingredients;
    }

    @Override
    public Pizza build() {
        return new Pizza(this);
    }
}