public final class Fraction extends Number implements Comparable<Fraction> {
    private final int num;
    private final int den;

    public static final Fraction ZERO = new Fraction(0, 1);
    public static final Fraction UN = new Fraction(1, 1);

    // Constructeur principal (numérateur, dénominateur)
    public Fraction(int num, int den) {
        if (den == 0) throw new IllegalArgumentException("Denominator must not be 0");
        // normaliser le signe : den positif
        if (den < 0) { num = -num; den = -den; }
        int g = gcd(Math.abs(num), den);
        // si num == 0, on obtient 0/1
        this.num = (g == 0) ? 0 : num / g;
        this.den = (g == 0) ? 1 : den / g;
    }

    // Constructeur avec numérateur seul (dénominateur = 1)
    public Fraction(int num) {
        this(num, 1);
    }

    // Constructeur sans argument -> 0/1
    public Fraction() {
        this(0, 1);
    }

    // GCD (Euclide)
    private static int gcd(int a, int b) {
        if (a == 0) return b;
        while (b != 0) {
            int t = a % b;
            a = b;
            b = t;
        }
        return a;
    }

    // Getters
    public int getNumerator() {
        return num;
    }

    public int getDenominator() {
        return den;
    }

    @Override
    public String toString() {
        return num + "/" + den;
    }

    // Addition (retourne une nouvelle fraction)
    public Fraction add(Fraction other) {
        long n = (long) this.num * other.den + (long) other.num * this.den;
        long d = (long) this.den * other.den;
        // Attention aux très grands nombres : pour le TD on reste en int (cas simple)
        return new Fraction((int) n, (int) d);
    }

    // Egalité sur la forme réduite
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Fraction)) return false;
        Fraction f = (Fraction) o;
        return this.num == f.num && this.den == f.den;
    }

    @Override
    public int hashCode() {
        return 31 * num + den;
    }

    // Ordre naturel : compare num1/den1 et num2/den2 par cross-multiplication
    @Override
    public int compareTo(Fraction other) {
        long left = (long) this.num * other.den;
        long right = (long) other.num * this.den;
        return Long.compare(left, right);
    }

    // Méthodes héritées de Number
    @Override
    public int intValue() {
        return (int) doubleValue();
    }

    @Override
    public long longValue() {
        return (long) doubleValue();
    }

    @Override
    public float floatValue() {
        return (float) doubleValue();
    }

    @Override
    public double doubleValue() {
        return (double) num / den;
    }
}

