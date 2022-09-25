/* Victor Majestic
 * A class to represent a credit card account. */

public class CreditCardAccount extends Object {
 
 //"limit" represents the credit card limit.
 public int cclimit;
 /*"ccinterest" represents the interest charged if the card
  * is not paid in full.*/
 public double ccinterest;
 /*"ccminimum" represents the minimum amount that must
  * be paid per month.*/
 public int ccminimum;
 /*"cclatefee" represents the fee charged if less
  * than the minimum is paid.*/
 public int cclatefee;
 //"ccbalance" represents the amount charged to the credit card.
 public double ccbalance;
 /*"monthlypayment" represents the amount of money left to
  * pay until the card is paid in full. */
 public double monthlypayment;
 /*"ccinterestsofar" is the amount of interest accumulated
  * in a certain month. */
 public double ccinterestsofar;
 /*"paymenttotal" represents the total amount of money
  * paid per month.*/
 public double paymenttotal;
 /*"paidinfull" is a flag, which is based on whether the
  * card was paid in full in the last month or not.*/
 public boolean paidinfull;
 
 public CreditCardAccount() {
   cclimit = 500;
   ccinterest = 0.02;
   ccminimum = 10;
   cclatefee = 15;
   ccbalance = 0.0;
   monthlypayment = ccminimum;
   ccinterestsofar = 0;
   paymenttotal = 0;
   paidinfull = true;
 }
 
 public CreditCardAccount(int cclimit, double ccinterest, int ccminimum, int cclatefee) {
 }
 
 //A method to retrieve the credit card limit.
 public int getCreditLimit() {
   return cclimit;
 }
 
 //A method to change the credit card limit to a given input.
 public int setCreditLimit(int newlimit) {                            //"newlimit" is the new credit card limit.
  cclimit = newlimit;
  return cclimit;
 }
 
 //A method to retrieve the interest rate.
 public double getInterestRate() {
   return ccinterest;
 }
 
 //A method to change the interest rate to a given input.  
 public double setInterestRate(double newinterest) {                  //"newinterest" is the new interest rate.
   ccinterest = newinterest;
   return ccinterest;
 }
 
 //A method to retrieve the minimum payment.
 public int getMinMonthlyPayment() {
   return ccminimum;
 }
 
 //A method to change the minimum payment to a given input.
 public int setMinMonthlyPayment(int newmin) {                        //"newmin" is the new minimum.
   ccminimum = newmin;
   return ccminimum;
 }
 
 //A method to retrieve the late payment penalty.
 public int getLatePaymentPenalty() {
   return cclatefee;
 }
 
 //A method to change the late payment penalty to a given input.
 public int setLatePaymentPenalty(int newpenalty) {                   //"newpenalty" is the new late penalty.
   cclatefee = newpenalty;
   return cclatefee;
 }
 
 //A method to retrieve the credit card balance.
 public double getBalance() {
   return ccbalance;
 }
 
 //A method to retrieve the amount of money paid so far in the month.
 public double getMonthlyPayment() {
   return paymenttotal;
 }
 
 /*A method to charge to the credit card, which increases the amount
  * of money you need to pay and returns false if you try to charge
  * more than your account balance.*/
 public boolean charge(double input) {
   if (ccbalance + input <= cclimit) {
     ccbalance = ccbalance + input;
     monthlypayment = monthlypayment + input;
     return true;
   }
   else {
     return false;
   }
 }
  
 //A method to pay off your credit card debt.
 public void payment(double output) {
   ccbalance = ccbalance - output;
   paymenttotal = paymenttotal + output;
   monthlypayment = monthlypayment - output;
 }
 
 /*A method to change the day and charge interest if the card
  * was not paid in full last month.*/
 public void incrementDay() {
   if (paidinfull == false) {
     double sum = ccbalance + ccinterestsofar;                        //"sum" is the sum of the balance and interest accumulated so far.
     ccinterestsofar = ccinterest / 365 * sum;
   }
 }
 
 /*A method to change the month. This determines whether the card
  * was paid in full, and applies a late fee if the minimum was
  * not paid that month.*/
 public void incrementMonth() {
   ccbalance = ccbalance + ccinterestsofar;
   ccinterestsofar = 0;
   if (paymenttotal >= monthlypayment) {
     paidinfull = true;
   }
   else {
     paidinfull = false;
   }
   if (ccminimum < monthlypayment && paymenttotal < ccminimum) {
     ccbalance = ccbalance + cclatefee;
   }
   paymenttotal = 0;
   monthlypayment = ccbalance;
 }
}