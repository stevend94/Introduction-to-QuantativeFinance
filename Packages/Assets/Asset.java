/*Asset Class function for Derivatives Package, we should note a few assumtions about the movement
  of the asset over time. The model we use assumes the asset follows geometric brownian motion
  given by the stochastic differencial equation dS(s, t) = uS(s, t)dt + vS(s, t)dWt, where
  S(s, t) is our random variable (under the normal distribution), u is the (deterministic) drift
  rate, v is the (stochastic) volatility and we define Wt as the wiener process (Norbert Wiener)
  which is defined Wt = (t)^1/2 *Z (Z our normal distribution random variable). Solving this using
  stochastic integrate we get that S(s, t) = S(s, 0)exp((u - (v^2)/2)t + vWt) which gives us our
  geormetric brownian motion solution (Further detail in the notes)

  Note! Asset implies both shares or commodity investments. */

package Packages.Assets;

import Packages.QuantLib.Position;

public class Asset{
    private float value;                       //Asset value private Variable
    private String name;                       //Asset name private Variable
    private static int NO_ACTIVE_ASSETS;       //static private var to track number of assets
    private int quantity;                        //the quantity of the asset

    private float drift_rate;                 //Asset drift rate (diffusion model)
    private float volatility;                 //Asset stochastic volatility
    private Position position;                //Financial position of asset

    public Asset(float new_value, String new_name, float new_drift_rate,
                 float new_volatility, Position new_position, int amount)
    {
      //Default constructor for asset class
      this.value = new_value;
      this.name = new_name;
      this.drift_rate = new_drift_rate;
      this.volatility = new_volatility;
      this.NO_ACTIVE_ASSETS++;
      this.position = new_position;
      this.quantity = amount;
    }

    public Asset() {

    }

    //Return functions for properties of asset
    public float getValue() { return this.value; }             //Function to return asset value
    public String getName() { return this.name; }              //Function to return asset Name
    public float getDriftRate() { return this.drift_rate; }    //Function to return asset drift rate
    public float getVolatility() { return this.volatility; }   //Function to return asset volatility
    public int getQuantity() { return this.quantity; }         //Function to return asset quantity
    public Position getPosition() { return this.position; }    //Function to return assets financial position

    //change functions for properties of asset
    public void setValue(float new_value) { this.value = new_value; }                       //Set new asset value
    public void setName(String new_name) { this.name = new_name; }                          //Set new asset name
    public void setDriftRate(float new_drift_rate) { this.drift_rate = new_drift_rate; }    //Set new asset drift rate
    public void setVolatility(float new_volatility) { this.volatility = new_volatility; }   //Set new asset volatility
    public void setQuantity(int amount) { this.quantity = amount; }                         //Set new quantity of asset
    public void setPosition(Position new_position) { this.position = new_position; }        //Set new financial position


}
