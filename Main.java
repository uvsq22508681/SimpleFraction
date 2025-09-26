public class Main {
    public static void main(String[] args) {
        // Constructeurs
        Fraction f1 = new Fraction(3, 6);      // doit réduire en 1/2
        assert f1.getNumerator() == 1 && f1.getDenominator() == 2 : "Réduction 3/6 -> 1/2 failed";

        Fraction f2 = new Fraction(2);         // 2/1
        assert f2.getNumerator() == 2 && f2.getDenominator() == 1;

        Fraction f0 = new Fraction();          // 0/1
        assert f0.equals(Fraction.ZERO);

        // Constantes
        assert Fraction.UN.equals(new Fraction(1, 1));

        // doubleValue
        Fraction half = new Fraction(1, 2);
        assert Math.abs(half.doubleValue() - 0.5) < 1E-9;

        // addition
        Fraction a = new Fraction(1, 2);
        Fraction b = new Fraction(1, 3);
        Fraction sum = a.add(b); // 1/2 + 1/3 = 5/6
        assert sum.equals(new Fraction(5, 6)) : "Addition incorrecte";

        // equality
        assert new Fraction(2, 4).equals(new Fraction(1, 2));

        // comparaison
        Fraction small = new Fraction(1, 3);
        Fraction big = new Fraction(1, 2);
        assert small.compareTo(big) < 0;
        assert big.compareTo(small) > 0;
        assert new Fraction(2, 4).compareTo(new Fraction(1, 2)) == 0;

        // Number compatibility
        Number aNumber = java.math.BigDecimal.ONE;
        Number anotherNumber = new Fraction(1, 2);
        assert Math.abs(aNumber.doubleValue() + anotherNumber.doubleValue() - 1.5) < 1E-8;

        System.out.println("Tous les tests (assertions) sont OK.");
    }
}
