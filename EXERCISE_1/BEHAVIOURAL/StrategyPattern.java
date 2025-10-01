interface PaymentStrategy {
    void pay(double amount);
}
class CreditCardPayment implements PaymentStrategy {
    @Override
    public void pay(double amount) {
        System.out.println("Paid Rs." + amount + " using Credit Card.");
    }
}
class PayPalPayment implements PaymentStrategy {
    @Override
    public void pay(double amount) {
        System.out.println("Paid Rs." + amount + " using PayPal.");
    }
}
class UPIPayment implements PaymentStrategy {
    @Override
    public void pay(double amount) {
        System.out.println("Paid Rs." + amount + " using UPI.");
    }
}
class PaymentContext {
    private PaymentStrategy strategy;
    public PaymentContext(PaymentStrategy strategy) {
        this.strategy = strategy;
    }
    public void setPaymentStrategy(PaymentStrategy strategy) {
        this.strategy = strategy;
    }
    public void payAmount(double amount) {
        strategy.pay(amount);
    }
}

public class StrategyPattern{
    public static void main(String[] args) {
        PaymentContext payment = new PaymentContext(new CreditCardPayment());
        payment.payAmount(500);

        payment.setPaymentStrategy(new PayPalPayment());
        payment.payAmount(1000);

        payment.setPaymentStrategy(new UPIPayment());
        payment.payAmount(750);
    }
}
