package ru.shirinkin.fraction;

public class CachedFraction implements Ifraction{
    private final Fraction fraction;
    private Double cachedValue;
    boolean isCached;

    //properties
    @Override
    public double getValue() {
        if (!isCached) {
            cachedValue = fraction.getValue();
            isCached = true;
        }
        return cachedValue;
    }

    @Override
    public void setNumerator(int numerator) {
        fraction.setNumerator(numerator);
        isCached = false;
        cachedValue = null;
    }

    @Override
    public void setDenominator(int denominator) {
        fraction.setDenominator(denominator);
        isCached = false;
        cachedValue = null;
    }

    public int getNumerator() {
        return fraction.getNumerator();
    }

    public int getDenominator() {
        return fraction.getDenominator();
    }

    //constructors
    public CachedFraction(Fraction fraction) {
        this.fraction = fraction;
        isCached = false;
    }

    //methods
    @Override
    public String toString() {
        return fraction.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof CachedFraction) {
            CachedFraction other = (CachedFraction) obj;
            return fraction.equals(other.fraction);
        }
        return false;
    }

}
