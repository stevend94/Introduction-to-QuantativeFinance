/*This shall represent our Bond class object, which in our case we shall consider as
  a risk free investment (though thats not quite true). It shall have an investment
  that increases in accordance with our annual continuously compounded interest rates
  which can be old at any time, given by Bt = B0*exp(rt) where B0 is the initial
  investment at time t = 0 and Bt is the value at time t*/

package Packages.Assets;

import Packages.QuantLib.GlobalVariables;

public class Bond {
  private float investment;                 //Initial investment in bond
  private String name;                      //Name of given bond
  private static int NO_ACTIVE_BONDS;       //static private var to track number of assets
  private float maturity;                   //Time duration till maturity of bond
  private int quantity;                     //the quantity of this bond

  //Default constructor for Bond class object
  public Bond(float initial_investment, String new_name, float new_maturity, int amount) {
    this.investment = initial_investment;
    this.name = new_name;
    this.maturity = new_maturity;
    this.quantity = amount;
    NO_ACTIVE_BONDS++;
  }

  //Get functions for bond class object
  public String getName() { return this.name; }

  public float getInvestment() { return this.investment; }

  public float getMaturity() { return this.maturity; }

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
