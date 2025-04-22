package pizzaejemplo;
// 2. Interfaz Builder (los pasos para construir la Pizza)
public interface PizzaBuilder {
    // Define el tamaño obligatorio
    PizzaBuilder size(String size);
    // Agrega un ingrediente al listado
    PizzaBuilder addIngredient(String ingredient);
    // Construye el producto final
    Pizza build();
}