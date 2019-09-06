abstract class Account {
    double balance = 1000.00;

    void deposit(double amount){
        balance += amount;
    }
    void withdraw(double amount){
        balance -= amount;
    }
    abstract double getBalance();
}

class CheckingAccount extends Account{
    double getBalance(){
        return balance - 1.00;
    }
}

class SavingAccount extends Account{
    double getInterestPayment() {
        return balance * 0.01;
    }
    double getBalance() {
        return balance + getInterestPayment();
    }
}


