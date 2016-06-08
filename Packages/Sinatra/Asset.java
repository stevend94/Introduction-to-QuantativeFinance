/*Asset Class function for Sinatra Package*/

package Packages.Sinatra;

import Packages.StandardNormalDistribution.SND;

public class Asset{
    private float price;                 //Asset price private Variable
    private String name;                 //Asset name private Variable
    private static int NO_ACTIVE_ASSETS;       //static private var to track number of assets

    private double drift_rate;                 //Asset drift rate (diffusion model)
    private double volatility;                 //Asset stochastic volatility

    public Asset(float new_price, String new_name, double new_drift_rate, double new_volatility)
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
    public double getDriftRate() { return this.drift_rate; }  //Function to return asset drift rate
    public double getVolatility() { return this.volatility; } //Function to return asset volatility

    //change functions for properties of asset
    public void setPrice(float new_price) { this.price = new_price; }                       //Set new asset price
    public void setName(String new_name) { this.name = new_name; }                          //Set new asset name
    public void setDriftRate(double new_drift_rate) { this.drift_rate = new_drift_rate; }   //Set new asset drift rate
    public void setVolatility(double new_volatility) { this.volatility = new_volatility; }  //Set new asset volatility


}
