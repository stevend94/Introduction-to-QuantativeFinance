/*This is the Call derivative object class for our program. A call option contract
  the holder of the contract (long in the call) the right to buy an asset at an
  agreed price (strike price) at a future agreed dat (Maturity/Expiry date). The
  european and american versions differ, in that the american call can be executed
  at anytime before the maturity date (though it can be proven our pricinf model
  finds they are both equal) so we shall restrict ourselves to the european version.

  Now we make a few assumtions here that may or may not apply to the real world,
  -The asset follows geometric brownian motion (as discussed before)
  -The asset has perfect liquidity in the market(plenty of buyers/sellers)
  -The bid/offer spread is zero (read about this in notes)
  -The interest rates are assumed to be constant throughout

  These contracts require a premium (Your rights don't come for free here) and can also
  be traded on an exchange. This premium will represent the value which is payed to the
  writer of the call contract, which through some logical thinking we see that the pay-off
  function for the long position is given by C = max(S - X, 0) at maturity time T where S is
  the asset price (at time T) and X is the strike price. We go into further details about the
  derivation of the call option price through the black-scholes model given by
  C = SN(d1) - Xexp(-rT)N(d2) where d1 = (ln(S/X) + (r + (v^2)/2)t)/vt^1/2 and also
  d2 = (ln(S/X) + (r - (v^2)/2)t)/vt^1/2 ,N the cummulitive distribution for the normal distribution */

  package Packages.Assets.Derivatives;

  import Packages.QuantLib.StandardNormalDistribution.SND;
  import Packages.QuantLib.GlobalVariables;
  import Packages.QuantLib.Position;
  import Packages.Assets.Asset;

  public class Call extends Derivative {
    private float d1;
    private float d2;

    //Default constructor for Call class object
    public Call(Asset new_asset, float new_strike, float new_maturity, Position new_position, int amount) {
      super(new_asset, new_strike, new_maturity, new_position, amount);
      this.name = "Call contract for " + new_asset.getName() + " with maturity " + new_maturity + " and strike " + new_strike;

      this.d1 = ((float)java.lang.Math.log(asset.getValue()/strike) + ((GlobalVariables.INTEREST + (asset.getVolatility()
      *asset.getVolatility()))*maturity))/(asset.getVolatility()*(float)java.lang.Math.sqrt(maturity));

      this.d2 = ((float)java.lang.Math.log(asset.getValue()/strike) + ((GlobalVariables.INTEREST - (asset.getVolatility()
      *asset.getVolatility()))*maturity))/(asset.getVolatility()*(float)java.lang.Math.sqrt(maturity));

    }

    //Alternative constructor for Call class object which creates the asset aswell
    public Call(float new_value, String new_name, float new_drift_rate, float new_volatility,
                      float new_strike, float new_maturity, Position new_position, int amount)
    {
      super(new_value, new_name, new_drift_rate, new_volatility,
            new_strike, new_maturity, new_position, amount);
      this.name = "Call contract for " + new_name + " with maturity " + new_maturity + " and strike " + new_strike;

      this.d1 = ((float)java.lang.Math.log(asset.getValue()/strike) + ((GlobalVariables.INTEREST + (asset.getVolatility()
      *asset.getVolatility()))*maturity))/(asset.getVolatility()*(float)java.lang.Math.sqrt(maturity));

      this.d2 = ((float)java.lang.Math.log(asset.getValue()/strike) + ((GlobalVariables.INTEREST - (asset.getVolatility()
      *asset.getVolatility()))*maturity))/(asset.getVolatility()*(float)java.lang.Math.sqrt(maturity));
    }

    //Pay-off method for Call contracts given financial position
    public float payOff (float asset_value) {
      float pay_off = 0f;
      switch (position) {
        case SHORT:
             //Short position case, C = - max(S - X, 0)
             pay_off = quantity * (-1*java.lang.Math.max(asset_value - strike, 0));
             break;

        case LONG:
            //Long position case, C = max(S - X, 0)
            pay_off = quantity * (java.lang.Math.max(asset_value - strike, 0));
            break;
      }
      return pay_off;
     }


    void UpdateValue() {
        //Set value as Solution to the black-scholes equation for a call option
        SND distro = new SND();

        this.value = (asset.getValue()*distro.LinearInterpolate(d1))
              - (strike*(float)java.lang.Math.exp(-1*GlobalVariables.INTEREST*maturity)*distro.LinearInterpolate(d2));
      }

    //The greeks for the call option
    public float delta() {
      //Defined by the first partial differential of call option to asset price
      SND distro = new SND();
      return asset.getValue()*distro.LinearInterpolate(d1);
    }

    public float theta() {
      //Defined by the first partial differential equation of call option to time or minus call option to maturity
      SND distro = new SND();
      float firstDif = -1* GlobalVariables.INTEREST *
      (strike*(float)java.lang.Math.exp(-1*GlobalVariables.INTEREST*maturity)*distro.LinearInterpolate(d2));

      float secondDif = -1 * (asset.getValue()*asset.getVolatility()*(float)java.lang.Math.exp(-1*0.5*d1*d1)
                        /(2*(float)java.lang.Math.sqrt(2*(float)java.lang.Math.PI*maturity)));

      return firstDif + secondDif;
    }

    public float gamma() {
      //Defined by the second partial derivative of the call option to asset price
      SND distro = new SND();
      return (1/asset.getValue()) * ((float)java.lang.Math.exp(-1*0.5*d1*d1)/(asset.getVolatility()
              *(float)java.lang.Math.sqrt(maturity*2*(float)java.lang.Math.PI)));
    }

    public float vega() {
      //Defined by the first partial derivative of the call option to volatility
      return (asset.getValue()*(float)java.lang.Math.sqrt(maturity/2*(float)java.lang.Math.PI))
              *(float)java.lang.Math.exp(-1*0.5*d1*d1);
   }

    public float rho() {
      //Defined by the first differential equation of call option to interest rate
      SND distro = new SND();
      return asset.getValue()*maturity*(float)java.lang.Math.exp(-1*GlobalVariables.INTEREST*maturity)
             *distro.LinearInterpolate(d2);
    }
  }
