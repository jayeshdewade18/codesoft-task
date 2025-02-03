// Source code is decompiled from a .class file using FernFlower decompiler.
public class BankAccount {
    private double balance;
 
    public BankAccount(double var1) {
       if (var1 >= 0.0) {
          this.balance = var1;
       } else {
          this.balance = 0.0;
          System.out.println("Initial balance cannot be negative. Balance set to 0.");
       }
 
    }
 
    public void deposit(double var1) {
       if (var1 > 0.0) {
          this.balance += var1;
          System.out.println("Deposit successful! New balance: " + this.balance);
       } else {
          System.out.println("Deposit amount must be positive.");
       }
 
    }
 
    public void withdraw(double var1) {
       if (var1 > 0.0 && var1 <= this.balance) {
          this.balance -= var1;
          System.out.println("Withdrawal successful! New balance: " + this.balance);
       } else if (var1 <= 0.0) {
          System.out.println("Withdrawal amount must be positive.");
       } else {
          System.out.println("Insufficient balance. Withdrawal failed.");
       }
 
    }
 
    public void checkBalance() {
       System.out.println("Your current balance is: " + this.balance);
    }
 }
 