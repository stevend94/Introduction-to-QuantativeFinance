/*Asset Class function for Sinatra Package, we should note a few assumtions about the movement
  of the asset over time. The model we use assumes the asset follows geometric brownian motion
  given by the stochastic differencial equation dS(s, t) = uS(s, t)dt + vS(s, t)dWt, where
  S(s, t) is our random variable (under the normal distribution), u is the (deterministic) drift
  rate, v is the (stochastic) volatility and we define Wt as the wiener process (Norbert Wiener)
  which is defined Wt = (t)^1/2 *Z (Z our normal distribution random variable). Solving this using
  stochastic integrate we get that S(s, t) = S(s, 0)exp((u - (v^2)/2)t + vWt) which gives us our
  geormetric brownian motion solution (Further detail in the notes) */

package Packages.Sinatra;

public class Asset{
    private float price;                 //Asset price private Variable
    private String name;                 //Asset name private Variable
    private static int NO_ACTIVE_ASSETS;       //static private var to track number of assets

    private float drift_rate;                 //Asset drift rate (diffusion model)
    private float volatility;                 //Asset stochastic volatility

    public Asset(float new_price, String new_name, float new_drift_rate, float new_volatility)
    {
      //Default constructor for asset class
      this.price = new_price;
      this.name = new_name;
      this.drift_rate = new_drift_rate;
      this.volatility = new_volatility;
      this.NO_ACTIVE_ASSETS++;
    }

    //Return functions for properties of asset
    public float getPrice() { return this.price; }      //Function to return asset price
    public String getName() { return this.name; }       //Function to return asset Value
    public float getDriftRate() { return this.drift_rate; }  //Function to return asset drift rate
    public float getVolatility() { return this.volatility; } //Function to return asset volatility

    //change functions for properties of asset
    public void setPrice(float new_price) { this.price = new_price; }                       //Set new asset price
    public void setName(String new_name) { this.name = new_name; }                          //Set new asset name
    public void setDriftRate(float new_drift_rate) { this.drift_rate = new_drift_rate; }   //Set new asset drift rate
    public void setVolatility(float new_volatility) { this.volatility = new_volatility; }  //Set new asset volatility


}
