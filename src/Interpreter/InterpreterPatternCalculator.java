package Interpreter;

// 5. Client: Builds and interprets the expression
public class InterpreterPatternCalculator {
    public static void main(String[] args) {
        // We want to evaluate the expression: "10 + 2 - 5"

        // Create terminal expressions (numbers)
        Expression ten = new Number(10);
        Expression two = new Number(2);
        Expression five = new Number(5);

        // Create non-terminal expressions (addition and subtraction)
        Expression add = new Add(ten, two);       // "10 + 2"
        Expression subtract = new Subtract(add, five); // "(10 + 2) - 5"

        // Interpret the final expression
        System.out.println("Result: " + subtract.interpret()); // Output: 7
    }
}
