interface PaymentGateway {
    void processPayment(double amount);
}


// NOTE: Payment Services.
class RazorpayGateway implements PaymentGateway {
    public void processPayment(double amount) {
        System.out.println("Processing INR payment via a Razorpay: ₹" +  amount);
    }
}

class PayUGateway implements PaymentGateway {
    public void processPayment(double amount) {
        System.out.println("processing INR payment via pauU: ₹" + amount);
    }
}

class StripeGateway implements PaymentGateway {
    public void processPayment(double amount) {
        System.out.println("processing Dollar payment via stripe: $" + amount);
    }
}

class PaypalGateway implements PaymentGateway {
    public void processPayment(double amount) {
        System.out.println("processing Dollar payment via paypalGateway: $" + amount);
    }
}


// NOTE: Invoice Logic.
interface Invoice {
    void generateInvoice();
}

class USInvoice implements Invoice {
    public void generateInvoice() {
        System.out.println("Generating GST invoice for US");
    }
}

class GSTInvoice implements Invoice {
    public void generateInvoice() {
        System.out.println("Generating GST invoice for INDIA");
    }
}


// NOTE: Factory Methods.
interface RegionFactory {
    PaymentGateway createPaymentGateway(String gatewayType);
    Invoice createInvoice();
}

class IndiaFactory implements RegionFactory {
    public PaymentGateway createPaymentGateway(String gatewayType) {
        switch (gatewayType.toLowerCase()) {
            case "razorpay":
                return new RazorpayGateway();
            case "payu" :
                return new PayUGateway();
            default:
                throw new IllegalArgumentException("Unsupported payment gateway type in India: " + gatewayType);
        }
    }

    public Invoice createInvoice() {
        return new GSTInvoice();
    }
}

class USFactory implements RegionFactory {
    public PaymentGateway createPaymentGateway(String gatewayType) {
        switch (gatewayType.toLowerCase()) {
            case "stripe":
                return new StripeGateway();
            case "paypal" :
                return new PaypalGateway();
            default:
                throw new IllegalArgumentException("Unsupported payment gateway type in US: " + gatewayType);
        }
    }

    public Invoice createInvoice() {
        return new USInvoice();
    }
}


//NOTE: Factory Patterns
class CheckoutService {
    private final PaymentGateway paymentGateway;
    private final Invoice invoice;

    public CheckoutService(RegionFactory factory, String gatewayType) {
        this.paymentGateway = factory.createPaymentGateway(gatewayType);
        this.invoice = factory.createInvoice();
    }

    public void completeOrder(double amount) {
        paymentGateway.processPayment(amount);
        invoice.generateInvoice();
    }
}

public class Main {
    public static void main(String[] args) {
        CheckoutService india = new CheckoutService(new IndiaFactory(), "razorpay");
        CheckoutService US = new CheckoutService(new USFactory(), "stripe");
        india.completeOrder(10000);
        US.completeOrder(10000);
    }
}