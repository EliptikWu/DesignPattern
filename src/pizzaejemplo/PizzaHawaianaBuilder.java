package pizzaejemplo;
// 3. ConcreteBuilder (implementa los pasos de construcción de la pizza hawaiana)
public class PizzaHawaianaBuilder extends PizzaConcreteBuilder {
    public PizzaHawaianaBuilder() {
        super.addIngredient("Jamón");
        super.addIngredient("Piña");
    }
}
