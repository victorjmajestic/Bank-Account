/* Victor Majestic
  A class to represent the functions of the bank account. */

public class BankAccount extends Object {

  //"balance" represents the overall account balance.
  public double balance;
  //"minimum" represents the minimum value of the account.
  public double minimum;
  //"interest" represents the interest rate.
  public double interest;
  //"atmfee" is the fee deducted when withdrawing from an ATM.
  public double atmfee;
  /*"overdraft" is the fee deducted, once a month, if the
   * current balance is less than the minimum balance. */
  public double overdraft;
  /*"bouncedcheck" is the fee charged if you try to withdraw
   * more money than what is in the account balance, if you
   * call the "withdrawDraft" method. */
  public double bouncedcheck;
  /*"withdrawfee" is the fee charged if you withdraw money
   * more times than the withdraw limit. */
  public double withdrawfee;
  /*"withdrawlimit" is the limit of the number of times you
   * can withdraw money from the bank each month.*/
  public int withdrawlimit;
  /*"interestthismonth" is the amount of interest accumulated
   * in the current month. */
  public double interestthismonth;
  /*"overdraftcharged" is a flag to check if the overdraft fee
   * has been charged that month. */
  public boolean overdraftcharged;
  
  public BankAccount() {
    balance = 0.0;
    minimum = 50;
    interest = 0.04;
    atmfee = 2.0;
    overdraft = 10.0;
    bouncedcheck = 12.0;
    withdrawfee = 1.0;
    withdrawlimit = 2;
    interestthismonth = 0;
    overdraftcharged = false;
  }
  
  public BankAccount(double interest, int minimum, double overdraft, double atmfee, double bouncedcheck) {
  }
  
  //A method to retrieve the current account balance.
  public double getBalance() {
    return balance;
  }
  
  //A method to retrieve the interest rate.
  public double getInterestRate() {
    return interest;
  }
  
  //A method to change the interest rate to a given input.
  public double setInterestRate(double intrate) {  //"intrate" represents the desired input rate. Substitute for "this.interest".
    interest = intrate;
    return interest;
  }
  
  //A method to retrieve the minimum balance of the account.
  public double getMinimumBalance() {
    return minimum;
  }
  
  /*A method to change the minimum balance of the account to
   * a given input.*/
  public double setMinimumBalance(double minbal) { //"minbal" represents the desired minimum balance.
    minimum = minbal;
    return minimum;
  }
  
  //A method to retrieve the fee of withdrawing from an ATM.
  public double getATMFee() {
    return atmfee;
  }
  
  /*A method to change the fee of withdrawing from an ATM to
   * a given input.*/
  public double setATMFee(double atm) {            //"atm" represents the desired ATM fee.
    atmfee = atm;
    return atmfee;
  }
  
  //A method to retrieve the overdraft fee.
  public double getOverDraftFee() {
    return overdraft;
  }
  
  //A method to change the overdraft fee to a given input.
  public double setOverDraftFee(double odf) {      //"odf" represents the desired overdraft fee.
    overdraft = odf;
    return overdraft;
  }
  
  //A method to retrieve the bounced check fee.
  public double getBouncedCheckFee() {
    return bouncedcheck;
  }
  
  //A method to change the bounced check fee to a given input.
  public double setBouncedCheckFee(double bcfee) { //"bcfee" represents the desired balanced check fee.
    bouncedcheck = bcfee;
    return bouncedcheck;
  }
  
  /*A method to retrieve the fee when you withdraw money more
   * times than permitted in a given month.*/
  public double getWithdrawFee() {
    return withdrawfee;
  }
  
  /*A method to change the fee when you withdraw money more
   * times than permitted in a given month to a given input.*/
  public double setWithdrawFee(double withfee) {   //"withfee" represents the desired withdraw fee.
    withdrawfee = withfee;
    return withdrawfee;
  }
  
  /*A method to retrieve the maximum number of withdrawals
   * per month.*/
  public int getWithdrawLimit() {
    return withdrawlimit;
  }
  
  /*A method to change the maximum number of withdrawals
   * per month to a given input.*/
  public int setWithdrawLimit(int withlimit) {     //"withlimit" represents the desired withdraw limit.
    withdrawlimit = withlimit;
    return withdrawlimit;
  }
  
  /*A method to deposit money to the account and add to the
   * overall balance.*/
  public void deposit(double input) {              //"input" is the amount of money deposited.
    balance = balance + input;
  }
  
  /*A method to withdraw money from the account and subtract
   * from the overall balance. This method applies the withdraw
   * fee if the limit is exceeded, and does nothing if you
   * attempt to withdraw more money than what is in the balance.*/
  public boolean withdraw(double output) {        //In all methods, "output" is the amount of money withdrawn.
    if (balance >= output && withdrawlimit > 0) {
      withdrawlimit = withdrawlimit - 1;
        balance = balance - output;
        return true;
    }
    else if (balance >= output && withdrawlimit <= 0) {
      balance = balance - output - withdrawfee;
      return true;
    }
    else {
      return false;
    }
  }
  
  /*A method to withdraw money from the account and subtract
   * from the overall balance. This method applies the withdraw
   * fee if the limit is exceeded, and applies the bounced check 
   * fee if you attempt to withdraw more money than what is in
   * the balance.*/
  public boolean withdrawDraft(double output) {
    if (balance >= output && withdrawlimit > 0) {
      withdrawlimit = withdrawlimit - 1;
        balance = balance - output;
        return true;
    }
    else if (balance >= output && withdrawlimit <= 0) {
      balance = balance - output - withdrawfee;
      return true;
    }
    else {
      balance = balance - bouncedcheck;
      return false;
    }
  }
  
  /*A method to withdraw money from the account via ATM and subtract
   * from the overall balance. This method always applies the ATM
   * fee, applies the withdraw fee if the limit is exceeded, and
   * returns false if you attempt to withdraw more money than what is
   * in the balance.*/
  public boolean withdrawATM(double output) {
    if (balance >= output + atmfee && withdrawlimit > 0) {
      withdrawlimit = withdrawlimit - 1;
      balance = balance - output - atmfee;
      return true;
    }
    else if (balance >= output + atmfee && withdrawlimit <= 0) {
      balance = balance - output - atmfee - withdrawfee;
      return true;
    }
    else {
      return false;
    }
  }
  
  /*A method to change the day and generate the interest
   * accumulated during the month. No interest is generated
   * if the overdraft charge is/was applied that month.*/
  public void incrementDay() {
   if (balance < minimum && overdraftcharged == false) {
     balance = balance - overdraft;
     overdraftcharged = true;
   }
   else if (balance < minimum && overdraftcharged == true) {
   }
   else {
      double sum = balance + interestthismonth;   //"sum" is the sum of the balance and interest this month.                                            
      interestthismonth = interest / 365 * sum;
   }
  }
  
  /*A method to change the month and add the interest to the
   * overall account balance. This resets the interest within
   * the month and the overdraft charge.*/
  public void incrementMonth() {
    balance = balance + interestthismonth;
    interestthismonth = 0;
    overdraftcharged = false;
  }
}