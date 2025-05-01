package Interpreter;


// 1. Abstract Expression: Defines a method for interpretation
interface Expression {
    int interpret();
}

// 2. Terminal Expression: Represents numbers in the expression
class Number implements Expression {
    private int number;

    public Number(int number) {
        this.number = number;
    }

    @Override
    public int interpret() {
        return number;  // Returns the value of the number
    }
}

// 3. Non-Terminal Expression: Represents addition operation
class Add implements Expression {
    private Expression leftExpression;
    private Expression rightExpression;

    public Add(Expression leftExpression, Expression rightExpression) {
        this.leftExpression = leftExpression;
        this.rightExpression = rightExpression;
    }

    @Override
    public int interpret() {
        return leftExpression.interpret() + rightExpression.interpret(); // Adds two expressions
    }
}

// 4. Non-Terminal Expression: Represents subtraction operation
class Subtract implements Expression {
    private Expression leftExpression;
    private Expression rightExpression;

    public Subtract(Expression leftExpression, Expression rightExpression) {
        this.leftExpression = leftExpression;
        this.rightExpression = rightExpression;
    }

    @Override
    public int interpret() {
        return leftExpression.interpret() - rightExpression.interpret(); // Subtracts two expressions
    }
}


