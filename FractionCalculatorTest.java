public class FractionCalculatorTest {
    public static void main(String[] args) {
        
        
        FractionCalculator fc = new FractionCalculator();
        
        Fraction testFraction = new Fraction(-2, 3);
        
        
        /* // Testing Clear
        fc.evaluate(testFraction, "* / clear"); */
        
        System.out.println(fc.getOperator());
        System.out.println(fc.toString());
        
        
        // Testing if entry is whole number
        /* fc.evaluate(testFraction, "50");
        
        System.out.println(fc.toString()); */
        
        
        fc.evaluate(testFraction, "50 quit 100");
        
        System.out.println(fc.toString());
        
        
    }
}