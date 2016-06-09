/*This class shall represent a Forward contract asset which is a legally binding contract
  to either buy(long in the forward) or sell(short in the forward) an asset at an agreed
  price (strike price) at a certain time (expiry/maturity date). The pay-off function
  (for a long position) is given by F = S - X where S is the asset value and X is the
  strike price at time T.

  In this case the value is the strike price, it should be also noted that these Forward
  contracts are negotiated between the two parties instead of an exchange, though this
  shall have no affect on our pricing model.*/


package Packages.Sinatra;

public class Forward extends Derivative {

  //Default constructor for Forward class object
  public Forward(Asset new_asset, float new_strike, double new_maturity) {
    this.asset = new_asset;         //set new asset
    this.strike = new_strike;       //set new strike price
    this.maturity = new_maturity;   //set new maturity date

    UpdateValue();                  //Update the value of the derivative
    NO_ACTIVE_DERIVATIVES++;
  }

  //Alternative constructor for Forward class object which creates the asset aswell
  public Forward(float new_price, String new_name, double new_drift_rate,
                 double new_volatility, float new_strike, double new_maturity)
  {
    Asset new_asset = new Asset(new_price, new_name, new_drift_rate, new_volatility);  //Create new asset object
    this.asset = new_asset;         //set new asset
    this.strike = new_strike;       //set new strike price
    this.maturity = new_maturity;   //set new maturity date

    UpdateValue();                  //Update the value of the derivative
    NO_ACTIVE_DERIVATIVES++;
    }

    public void UpdateValue() {
      //Function constructed for Forward contract using non arbitrage argument F=Se^RT
      this.value = asset.getPrice()*((float)java.lang.Math.exp(getInterest()*getMaturity()));
    }

}
