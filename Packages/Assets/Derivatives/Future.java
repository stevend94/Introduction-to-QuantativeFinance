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


package Packages.Assets.Derivatives;

import Packages.GlobalVariables;
import Packages.Position;
import Packages.Assets.Asset;

public class Future extends Derivative {

  //Default constructor for Future class object
  public Future(Asset new_asset, float new_strike, float new_maturity, Position new_position, int amount) {
    super(new_asset, new_strike, new_maturity, new_position, amount);
    this.name = "Future contract for " + new_asset.getName() + " with maturity " + new_maturity + " and strike " + new_strike;
  }

  //Alternative constructor for Future class object which creates the asset aswell
  public Future(float new_price, String new_name, float new_drift_rate, float new_volatility,
                    float new_strike, float new_maturity, Position new_position, int amount)
  {
    super(new_price, new_name, new_drift_rate, new_volatility,
          new_strike, new_maturity, new_position, amount);
    this.name = "Future contract for " + new_name + " with maturity " + new_maturity + " and strike " + new_strike;
  }

    //Function to change strike price to no arbitrage value
    public void fixStrike() { this.strike = this.value; }

    //Pay-off method for futures contracts given financial position (though more of an approximation)
    public float payOff(float asset_value) {
      float pay_off = 0f;
      switch (position) {
        case SHORT:
             //Short position case, F = X - S
             pay_off = quantity * (strike - asset_value);
             break;

        case LONG:
            //Long position case, F = S - X
            pay_off = quantity * (asset_value - strike);
            break;
      }
      return pay_off;
    }

     void UpdateValue() {
      //Function constructed for Future contract using our Theorem G=Se^RT
      this.value = asset.getPrice()*((float)java.lang.Math.exp(GlobalVariables.INTEREST*getMaturity()));
    }
}
