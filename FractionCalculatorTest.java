public class FractionCalculatorTest {
    public static void main(String[] args) {
        
        FractionCalculator fc = new FractionCalculator();
        
        Fraction testFraction = new Fraction(2, 3);
        
        /* // Testing Clear
        fc.evaluate(testFraction, "* / clear"); */
        
        System.out.println(fc.getOperator());
        System.out.println(fc.toString());
        
        
        // Testing if entry is whole number
        /* fc.evaluate(testFraction, "50");
        
        System.out.println(fc.toString()); */
        
        /* // Testing Quit
        fc.evaluate(testFraction, "50 quit 100"); */
        
        System.out.println(fc.toString());
        
        /* // Testing how to split user integer entry
        String newString = "123/4";
        String[] newArray = newString.split("/");
        
        int num = Integer.parseInt(newArray[0]);
        int denom = Integer.parseInt(newArray[1]);
        
        System.out.println(num + denom); */
        
        
        // Testing long Strings of input
        System.out.println(fc.evaluate(testFraction, "- - 1/3 "));
    }
}