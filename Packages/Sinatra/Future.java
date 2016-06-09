/*This class shall represent a Future contract asset which is a legally binding contract
  to either buy(long in the forward) or sell(short in the forward) an asset at an agreed
  price (strike price) at a certain time (expiry/maturity date). The pay-off function
  (for a long position) is given by G = S - X where S is the asset value and X is the
  strike price at time T. In this case the value is the strike price, similar to the forward
  contract.

  There are some key differences between Forwards and Futures, the main being that the money
  recieved to the party of the long position is paid over distinct intervals over the time to
  the maturity of the contract. Futures can also be exchanged on the market unlike Forwards.
  Now we would expect these pricing models to be the same, which indeed they are givin that
  the interest rates are constant(See notes for proof)*/


package Packages.Sinatra;

public class Future extends Derivative {
  //Default constructor for Future class object
  public Future(Asset new_asset, float new_strike, double new_maturity) {
    this.asset = new_asset;         //set new asset
    this.strike = new_strike;       //set new strike price
    this.maturity = new_maturity;   //set new maturity date

    UpdateValue();                  //Update the value of the derivative
    NO_ACTIVE_DERIVATIVES++;
  }

  //Alternative constructor for Future class object which creates the asset aswell
  public Future(float new_price, String new_name, double new_drift_rate,
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
      //Function constructed for Future contract using our Theorem G=Se^RT
      this.value = asset.getPrice()*((float)java.lang.Math.exp(getInterest()*getMaturity()));
    }
}
