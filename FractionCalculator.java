import java.util.Scanner;

public class FractionCalculator {
    
    private final int ADDITION = 1;
    private final int SUBTRACT = 2;
    private final int MULTIPLY = 3;
    private final int DIVIDE = 4;
    
    private int operator = 0;
    
    private Fraction userFraction = new Fraction(0, 1);
    private Fraction secondFraction = null;
    
    public static void main(String[] args) {
        
        Scanner keyboard = new Scanner(System.in);
        FractionCalculator userCalc = new FractionCalculator();
        String entryString;
        
        System.out.println("Hello, welcome to Ian's Fraction Calculator.");
        System.out.println("Enter lines of input to perform fun maths on fractions.");
        System.out.println("To exit the calculator enter 'Exit'.");
        
        boolean error = false;
        while (!error) {
        
            System.out.print("Enter line of input > ");
            entryString = keyboard.nextLine();
            
            if (entryString.equals("Exit")) {
                System.out.println("GoodBye");
                error = true;
                break;
            }
            try {
                System.out.println(userCalc.evaluate(userCalc.getUserFraction(), entryString));
            }
            catch (NumberFormatException e) {
                System.out.println("Error");
                userCalc.evaluate(userCalc.getUserFraction(), "clear");
            }
            catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Error");
                userCalc.evaluate(userCalc.getUserFraction(), "clear");
            }
            catch (Exception e) {
                System.out.println("Error");
                userCalc.evaluate(userCalc.getUserFraction(), "clear");
            }
        }
    }
    
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
                userFraction = userFraction.absValue();
            }
            else if (userArray[count].equalsIgnoreCase("n") || userArray[count].equals("neg")) {
                userFraction = userFraction.negate();
            }
            else if (userArray[count].equalsIgnoreCase("c") || userArray[count].equals("clear")) {
                Fraction clearFraction = new Fraction(0, 1);
                userFraction = clearFraction;
            }
            else if (this.isNumber(userArray[count])) {
                if (this.operatorStored()) {
                    Fraction intFraction = new Fraction(Integer.parseInt(userArray[count]), 1);
                    secondFraction = intFraction;
                    if (this.operator == 1) {
                        userFraction = userFraction.add(secondFraction);
                        secondFraction = null;
                        operator = 0;
                    }
                    else if (this.operator == 2) {
                        userFraction = userFraction.subtract(secondFraction);
                        secondFraction = null;
                        operator = 0;
                    }
                    else if (this.operator == 3) {
                        userFraction = userFraction.multiply(secondFraction);
                        secondFraction = null;
                        operator = 0;
                    }
                    else if (this.operator == 4) {
                        userFraction = userFraction.divide(secondFraction);
                        secondFraction = null;
                        operator = 0;
                    }
                }
                else {
                    Fraction intFraction = new Fraction(Integer.parseInt(userArray[count]), 1);
                    userFraction = intFraction;
                }
            }
            else if (userArray[count].equalsIgnoreCase("q") || userArray[count].equals("quit")) {
                Fraction clearFraction = new Fraction(0, 1);
                userFraction = clearFraction;
                System.out.println("You have reset the Calculator Program.");
                break;
            }
            else {
                if (this.operatorStored()) {
                    String[] fractionStringArray = userArray[count].split("/");
                    int num = Integer.parseInt(fractionStringArray[0]);
                    int denom = Integer.parseInt(fractionStringArray[1]);
                    Fraction secondFraction = new Fraction(num, denom);
                    if (this.operator == 1) {
                        userFraction = userFraction.add(secondFraction);
                        secondFraction = null;
                        operator = 0;
                    }
                    else if (this.operator == 2) {
                        userFraction = userFraction.subtract(secondFraction);
                        secondFraction = null;
                        operator = 0;
                    }
                    else if (this.operator == 3) {
                        userFraction = userFraction.multiply(secondFraction);
                        secondFraction = null;
                        operator = 0;
                    }
                    else if (this.operator == 4) {
                        userFraction = userFraction.divide(secondFraction);
                        secondFraction = null;
                        operator = 0;
                    }
                }
                else {
                    String[] fractionStringArray = userArray[count].split("/");
                    int num = Integer.parseInt(fractionStringArray[0]);
                    int denom = Integer.parseInt(fractionStringArray[1]);
                    Fraction secondFraction = new Fraction(num, denom);
                    userFraction = secondFraction;
                }
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
    
    public Fraction getUserFraction() {
        return userFraction;
    }
    
    public String toString() {
        return userFraction.toString();
    }
}