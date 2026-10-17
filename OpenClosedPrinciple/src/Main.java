interface TaxCalculator {
    double amountAfterTax(double amount);
}

class IndianTax implements TaxCalculator {
    public double amountAfterTax(double amount) {
        return (amount + amount * 0.18);
    }
}

class USTax implements TaxCalculator {
    public double amountAfterTax(double amount) {
        return (amount + amount * 0.15);
    }
}

class EuroTax implements TaxCalculator {
    public double amountAfterTax(double amount) {
        return (amount + amount * 0.1);
    }
}

public class Main {
    public static void main(String[] args) {
        TaxCalculator taxCalculator = new USTax();
        var total = taxCalculator.amountAfterTax(100);
        System.out.println(total);
    }
}