package design.patterns.structural;

public class Proxy {
    public static void main(String[] args) {
        Bank proxy = new BankAtmProxy();
        proxy.withdraw();
    }
}

interface Bank{
    void withdraw();
}

class BankAccount implements Bank {

    @Override
    public void withdraw() {
        System.out.println("Withdraw from real Bank");
    }
}

class BankAtmProxy implements Bank{
    BankAccount bankAccount;
    BankAtmProxy(){
        this.bankAccount = new BankAccount();
    }

    @Override
    public void withdraw() {
        bankAccount.withdraw();
    }
}
