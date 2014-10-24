public class FractionTest {
    public static void main(String[] args) {
    
    // test divide by zero - should print an error and exit
    new Fraction(1, 0);

    // test multiply
   /*  Fraction f = new Fraction(3,10);
    Fraction g = new Fraction(1,2);
    Fraction h = new Fraction(3,5);
    if (!f.equals(g.multiply(h))) System.out.println("Multiply failed"); */

    /* Fraction i = new Fraction(1, -2);
    Fraction n = new Fraction(11, 15);
    Fraction test = i.divide(n);
    System.out.println(test); */
    
    Fraction p = new Fraction(11, -15);
    System.out.println(p.negate());
    
    System.out.println(p.absValue());
    
    Fraction j = new Fraction(5, 1);
    System.out.println(j);
    
    
    /* int i = -1;
    
    System.out.println(i);
    
    String s = Integer.toString(i);
    
    System.out.println(s);
    
    System.out.println(s.charAt(0));
    
    System.out.println(s.charAt(1)); */
    
    // test equals
    /* test(new Fraction(1, 2),new Fraction(1, 2),"error test 1");
    test(new Fraction(1, 2),new Fraction(3, 6),"error test 2");
    test(new Fraction(-1, 2),new Fraction(1, -2),"error test 3");
    test(new Fraction(-1, -2),new Fraction(1, 2),"error test 4");
    test(new Fraction(4, -8),new Fraction(1, 2),"error test 5"); */
    // extend with extra tests
}

static void test(Fraction f1, Fraction f2, String msg){
    if (! f1.equals(f2))
    System.out.println(msg);
    }
}