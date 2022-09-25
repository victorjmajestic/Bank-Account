/* Victor Majestic
 * A class to keep track of all accounts.*/

public class Account extends Object {
  
  //"firstname" is the first name of the account owner.
  public String firstname;
  //"lastname" is the last name of the account owner.
  public String lastname;
  //"address" is the address of the account owner.
  public String address;
  //"zipcode" is the zipcode of the account owner.
  public String zipcode;
  //"savings" represents a savings account.
  public BankAccount savings;
  //"checking" represents a checking account.
  public BankAccount checking;
  //"moneymarket" represents a money market account.
  public BankAccount moneymarket;
  //"ccaccount" represents a credit card account.
  public CreditCardAccount ccaccount;
  //"date" represents the current date.
  public Date date;
  
  public Account(String firstname, String lastname, String address, String zipcode, Date date) {
  this.firstname = firstname;
  this.lastname = lastname;
  this.address = address;
  this.zipcode = zipcode;
  this.savings = savings;
  this.checking = checking;
  this.moneymarket = moneymarket;
  this.ccaccount = ccaccount;
  this.date = date;
  }
  
  //A method to retrieve the first name.
  public String getFirstName() {
    return this.firstname;
  }
  
  //A method to change the first name to a given input.
  public String setFirstName(String firstname) {
    this.firstname = firstname;
    return this.firstname;
  }
  
  //A method to retrieve the last name.
  public String getLastName() {
    return this.lastname;
  }
  
  //A method to change the last name to a given input.
  public String setLastName(String lastname) {
    this.lastname = lastname;
    return this.lastname;
  }
  
  //A method to retrieve the address.
  public String getStreetAddress() {
    return this.address;
  }
  
  //A method to change the address to a given input.
  public String setStreetAddress(String address) {
    this.address = address;
    return this.address;
  }
  
  //A method to retrieve the zip code.
  public String getZipCode() {
    return this.zipcode;
  }
  
  //A method to change the zip code to a given input.
  public String setZipCode(String zipcode) {
    this.zipcode = zipcode;
    return this.zipcode;
  }
  
  //A method to retrieve the address of a savings account.
  public BankAccount getSavingsAccount() {
    return this.savings;
  }
  
  //A method to assign a savings account to a person.
  public BankAccount setSavingsAccount(BankAccount savings) {
    this.savings = savings;
    return this.savings;
  }
  
  //A method to retrieve the address of a checking account.
  public BankAccount getCheckingAccount() {
    return this.checking;
  }
  
  //A method to assign a checking account to a person.
  public BankAccount setCheckingAccount(BankAccount checking) {
    this.checking = checking;
    return this.checking;
  }
  
  //A method to retrieve the address of a money market account.
  public BankAccount getMoneyMarketAccount() {
    return this.moneymarket;
  }
  
  //A method to assign a money market account to a person.
  public BankAccount setMoneyMarketAccount(BankAccount moneymarket) {
    this.moneymarket = moneymarket;
    return this.moneymarket;
  }
  
  //A method to retrieve the address of a credit card account.
  public CreditCardAccount getCreditCardAccount() {
    return this.ccaccount;
  }
  
  //A method to assign a credit card account to a person.
  public CreditCardAccount setCreditCardAccount(CreditCardAccount ccaccount) {
    this.ccaccount = ccaccount;
    return this.ccaccount;
  }
  
  //A method to retrieve the current date.
  public Date getDate() {
    return this.date;
  }
  
  //A method to set the current date to a certain date.
  public Date setDate(Date date) {
    this.date = date;
    return this.date;
  }
  
  //A method to change the day of all valid accounts.
  public void incrementDay() {
   date.incrementDay();
   if (this.getSavingsAccount() != null) {
     savings.incrementDay();
     if (date.getDay() == 1) {
       savings.incrementMonth();
     }
   }
   if (this.getCheckingAccount() != null) {
     checking.incrementDay();
     if (date.getDay() == 1) {
       checking.incrementMonth();
     }
   }
   if (this.getCreditCardAccount() != null) {
     ccaccount.incrementDay();
     if (date.getDay() == 1) {
       ccaccount.incrementMonth();
     }
   }
   if (this.getMoneyMarketAccount() != null) {
     moneymarket.incrementDay();
     if (date.getDay() == 1) {
       moneymarket.incrementMonth();
     }
   }
  }
  
  //A method to compare two accounts to determine if they are the same.
  public boolean equals(Object o) {
    if (o instanceof Account) {
      Account a = (Account)o;
      if (this.getFirstName().equals(a.getFirstName()) && this.getLastName().equals(a.getLastName()) && this.getStreetAddress().equals(a.getStreetAddress()) && this.getZipCode().equals(a.getZipCode())) {
        return true;
      }
      else {
        return false;
      }
    }
    return false;
  }
  
  //A method to retrieve all the details of the account.
  public String toString() {
    String str = "";                                          //"str" is a String to store all account information and balances of valid accounts.
     str += this.getFirstName() + " " + this.getLastName() + ". " + this.getStreetAddress() + ". " + this.getZipCode() + ".";
     if(this.getSavingsAccount() != null){
       str+= " Savings: " + savings.getBalance() + ".";
     }
     if(this.getCheckingAccount() != null){ 
       str+= " Checking Balance: " + checking.getBalance() + ".";
     }
     if(this.getCreditCardAccount() != null){
       str+= " Credit Card: " + ccaccount.getBalance() + ".";
     }
     if(this.getMoneyMarketAccount() != null){ 
       str+= " Money Market: " + moneymarket.getBalance() + ".";
     }
     return str;
  }
  
}