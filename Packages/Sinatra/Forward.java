/*This class shall represent a Forward contract asset which is a legally binding contract
  to either buy(long in the forward) or sell(short in the forward) an asset at an agreed
  price (strike price) at a certain time (expiry/maturity date). The pay-off function
  (for a long position) is given by F = S - X where S is the asset value and X is the
  strike price at time T*/

package Packages.Sinatra;

public class Forward extends Derivative {

  //Default constructor for Forward class object
  public Forward(Asset new_asset, float new_strike, double new_maturity) {
    this.asset = new_asset;         //set new asset
    this.strike = new_strike;       //set new strike price
    this.maturity = new_maturity;   //set new maturity date

    updateValue();                  //Update the value of the derivative
    NO_ACTIVE_DERIVATIVES++;
  }

}
