package design.patterns.behavioral;

public class Strategy {
    public static void main(String[] args) {
        Payment payment = new Payment(new UPIPay());
        payment.makePayment();
    }
}

interface PayStrategy{
    void pay();
}

class CCPay implements PayStrategy{

    @Override
    public void pay() {
        System.out.println("Payment by CC");
    }
}

class UPIPay implements PayStrategy{

    @Override
    public void pay() {
        System.out.println("Payment by UPI");
    }
}

class Payment{
    PayStrategy payStrategy;
    Payment(PayStrategy payStrategy){
        this.payStrategy=payStrategy;
    }
    void makePayment(){
        payStrategy.pay();
    }
}
