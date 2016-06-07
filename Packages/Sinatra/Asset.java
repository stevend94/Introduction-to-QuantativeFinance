/*Asset Class function for Sinatra Package*/

package Sinatra;

import Packages.StandardNormalDistribution.SND;

public class Asset{
    private float asset_price;                 //Asset price private Variable
    private String asset_name;                 //Asset name private Variable
    private static int NO_ACTIVE_ASSETS;       //static private var to track number of assets

    public Asset(float new_price, String new_name)
    {
      //Default constructor for asset class
      this.asset_price = new_price;
      this.asset_name = new_name;
      this.NO_ACTIVE_ASSETS++;
      SND s = new SND();
    }

    public float getPrice() { return this.asset_price; }  //Function to return asset price
    public String getName() { return this.asset_name; }   //Function to return asset Value


}
