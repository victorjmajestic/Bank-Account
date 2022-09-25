/*Victor Majestic
 * A class to store the date. */

public class Date extends Object {
  
  //An instance field to store the day.
  public int day;
  //An instance field to store the month.
  public int month;
  
  public Date(int month, int day) {
    this.day = day;
    this.month = month;
  }
  
  //A method to retrieve the current day.
  public int getDay() {
    return this.day;
  }
  
  //A method to retrieve the current month.
  public int getMonth() {
    return this.month;
  }
  
  //A method to change the day, which changes the month if necessary.
  public void incrementDay() {
    if (this.month == 2 && this.day == 28) {
      this.month = 3;
      this.day = 1;
    }
    else if (this.day == 30) {
      if (this.month == 4 || this.month == 6 || this.month == 9 || this.month == 11) {
        this.month = this.month + 1;
        this.day = 1;
      }
    }
    else if (this.day == 31) {
      if (this.month == 1 || this.month == 3 || this.month == 5 || this.month == 7 || this.month == 8 || this.month == 10) {
        this.month = this.month + 1;
        this.day = 1;
      }
      else if (this.month == 12) {
        this.month = 1;
        this.day = 1;
      }
    }
    else {
      this.day = this.day + 1;
    }
  }
  
  //An overriden method to determine if two dates are equal to each other.
  public boolean equals(Object o) {
    if (o instanceof Date) {
      Date d = (Date)o;
      if (this.getMonth() == d.getMonth() && this.getDay() == d.getDay()) {
        return true;
      }
      else {
        return false;
      }
    }
    return false;
  }
  
  //A method to display the date. Returns null if an invalid month is inserted.
  public String toString() {
    if (this.month == 1)
      return "January " + getDay();
    else if (this.month == 2)
      return "February " + getDay();
    else if (this.month == 3)
      return "March " + getDay();
    else if (this.month == 4)
      return "April " + getDay();
    else if (this.month == 5)
      return "May " + getDay();
    else if (this.month == 6)
      return "June " + getDay();
    else if (this.month == 7)
      return "July " + getDay();
    else if (this.month == 8)
      return "August " + getDay();
    else if (this.month == 9)
      return "September " + getDay();
    else if (this.month == 10)
      return "October " + getDay();
    else if (this.month == 11)
      return "November " + getDay();
    else if (this.month == 12)
      return "December " + getDay();
    else
      return null;
  }
}