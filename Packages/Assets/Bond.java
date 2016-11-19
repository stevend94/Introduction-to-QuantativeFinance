/*This shall represent our Bond class object, which in our case we shall consider as
  a risk free investment (though thats not quite true). It shall have an investment
  that increases in accordance with our annual continuously compounded interest rates
  which can be old at any time, given by Bt = B0*exp(rt) where B0 is the initial
  investment at time t = 0 and Bt is the value at time t*/

package Packages.Assets;

import Packages.QuantLib.GlobalVariables;
import Packages.QuantLib.FDate;

public class Bond {
  private float investment;                 //Initial investment in bond
  private String name;                      //Name of given bond
  private static int NO_ACTIVE_BONDS;       //static private var to track number of assets
  private FDate maturity_date;              //maturity date for object
  private float maturity;                   //the time (in days) to maturity
  private int quantity;                     //the quantity of this bond

  //Default constructor for Bond class object with date (FDate)
  public Bond(float initial_investment, String new_name, FDate new_maturity_date, int amount) {
    this.investment = initial_investment;
    this.name = new_name;
    this.maturity_date = new_maturity_date;
    this.quantity = amount;
    NO_ACTIVE_BONDS++;
    this.maturity = GlobalVariables.CURRENT_DATE.daysBetween(maturity_date)/365.2422f;
  }

  //Constructor for Bond class object with maturity date as a fraction of a year
  public Bond(float initial_investment, String new_name, float time_to_maturity, int amount) {
    this.investment = initial_investment;
    this.name = new_name;
    this.maturity = time_to_maturity;
    this.quantity = amount;
    NO_ACTIVE_BONDS++;
    this.maturity_date = new FDate(GlobalVariables.CURRENT_DATE.getDay(),
                                  (GlobalVariables.CURRENT_DATE.getMonth() + (int)(maturity * 12)),
                                   GlobalVariables.CURRENT_DATE.getYear());
  }

  //Get functions for bond class object
  public String getName() { return this.name; }

  public float getInvestment() { return this.investment; }

  public float getMaturity() { return this.maturity; }

  public FDate getMaturityDate() { return this.maturity_date; }

  public int getQuantity() { return this.quantity; }

  //Function to get future value of the bond at maturity
  public float getValue() {
    return quantity * (investment * (float)java.lang.Math.exp(GlobalVariables.INTEREST*maturity));
  }

  //Function to get the value of the bond given some time parameter
  public float getValue(float time) {
    if (time >= maturity) {
      return quantity * (investment * (float)java.lang.Math.exp(GlobalVariables.INTEREST*maturity));
    }

    return quantity * (investment * (float)java.lang.Math.exp(GlobalVariables.INTEREST*time));
  }

}
