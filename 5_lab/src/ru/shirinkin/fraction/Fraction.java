package ru.shirinkin.fraction;

public class Fraction implements Ifraction {
    private int numerator;
    private int denominator;

    // properties
    public int getNumerator() {
        return numerator;
    }

    public int getDenominator() {
        return denominator;
    }

    @Override
    public void setNumerator(int numerator) {
        this.numerator = numerator;
    }

    @Override
    public void setDenominator(int denominator) {
        if(denominator == 0){
            throw new ArithmeticException("Can't divide by zero");
        }

        if (denominator < 0) {
            numerator = -numerator;
            this.denominator = -denominator;
        } else {
            this.denominator = denominator;
        }
    }

    //constructors
    public Fraction(int numerator, int denominator) {
        setDenominator(denominator);
        setNumerator(numerator);
    }

    //methods
    @Override
    public double getValue() {
        if(denominator == 0){
            throw new ArithmeticException("Can't divide by zero");
        }
        return (double) numerator / denominator;
    }


    @Override
    public String toString() {
        return numerator + "/" + denominator;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Fraction fraction = (Fraction) o;
        return numerator == fraction.numerator && denominator == fraction.denominator;
    }

}
