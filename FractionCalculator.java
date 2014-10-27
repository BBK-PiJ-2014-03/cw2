public class FractionCalculator {
    
    private final int ADDITION = 1;
    private final int SUBTRACT = 2;
    private final int MULTIPLY = 3;
    private final int DIVIDE = 4;
    
    private int operator = 0;
    
    private Fraction userFraction = new Fraction(0, 1);
    private Fraction secondFraction = null;
    
    
    
    public Fraction evaluate(Fraction fraction, String inputString) {
        
        String[] userArray = inputString.split(" ");
        userFraction = fraction;
        
        
        for (int count = 0; count < userArray.length; count++) {
            if (userArray[count].equals("+")) {
                if (this.operatorStored()) {
                    System.out.println("Error: operator already in memory.");
                }
                else {
                    operator = ADDITION;
                }
            }
            else if (userArray[count].equals("-")) {
                if (this.operatorStored()) {
                    System.out.println("Error: operator already in memory.");
                }
                else {
                    operator = SUBTRACT;
                }
            }
            else if (userArray[count].equals("/")) {
                if (this.operatorStored()) {
                    System.out.println("Error: operator already in memory.");
                }
                else {
                    operator = DIVIDE;
                }
            }
            else if (userArray[count].equals("*")) {
                if (this.operatorStored()) {
                    System.out.println("Error: operator already in memory.");
                }
                else {
                    operator = MULTIPLY;
                }
            }
            else if (userArray[count].equalsIgnoreCase("a") || userArray[count].equals("abs")) {
                Fraction absFraction = userFraction.absValue();
                userFraction = absFraction;
            }
            else if (userArray[count].equalsIgnoreCase("n") || userArray[count].equals("neg")) {
                Fraction negFraction = userFraction.negate();
                userFraction = negFraction;
            }
            else if (userArray[count].equalsIgnoreCase("c") || userArray[count].equals("clear")) {
                Fraction clearFraction = new Fraction(0, 1);
                userFraction = clearFraction;
            }
            else if (this.isNumber(userArray[count])) {
                if (secondFraction == null) {
                    Fraction intFraction = new Fraction(Integer.parseInt(userArray[count]), 1);
                    secondFraction = intFraction;
                    
            }
            else if (userArray[count].equalsIgnoreCase("q") || userArray[count].equals("quit")) {
                Fraction clearFraction = new Fraction(0, 1);
                userFraction = clearFraction;
                System.out.println("You have exited the Calculator program.");
                break;
            }
            
            
            
        }
        
        return new Fraction(userFraction.getNumerator(), userFraction.getDenominator());
    }
    
    private boolean operatorStored() {
        if (this.operator > 0 && this.operator < 5) {
            return true;
        }
        else {
            return false;
        }
    }
    
    
    
    private boolean isNumber(String str) {
        
        for (int count = 0; count < str.length(); count++) {
            if (!Character.isDigit(str.charAt(count))) {
                return false;
            }
        }
        return true;
    }
    
    
    public int getOperator() {
        return operator;
    }
    
    public String toString() {
        return userFraction.toString();
    }
}