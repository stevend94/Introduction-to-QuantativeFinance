/*Here we have the java class object for the portfolio, which shall take
  inputs of derivatives, assets and bonds from our derivatives package.*/

package Packages.QuantLib;

import Packages.Assets.Asset;
import Packages.Assets.Bond;
import Packages.Assets.Derivatives.*;
import Packages.Position;
import Packages.GlobalVariables;

public class Portfolio {
  //private assets list for portfolio
  private Asset[] assets = new Asset[GlobalVariables.MAX_ASSETS];
  private Bond[] bonds = new Bond[GlobalVariables.MAX_BONDS];
  private Forward[] forwards = new Forward[GlobalVariables.MAX_FORWARDS];
  private Future[] futures = new Future[GlobalVariables.MAX_FUTURES];
  private Call[] calls = new Call[GlobalVariables.MAX_CALLS];
  private Put[] puts = new Put[GlobalVariables.MAX_PUTS];

  //private count for each asset
  private int asset_count;
  private int bond_count;
  private int forward_count;
  private int futures_count;
  private int call_count;
  private int put_count;

  private static int NO_ACTIVE_PORTFOLIOS;

  //Default constructor for portfolio class
  public Portfolio() {
    NO_ACTIVE_PORTFOLIOS++;
  }

  //Function to check no maximum has been exceeded
  private boolean ExceedsMax(int count, int max)
  {
    if (count == max)
    {
      System.out.println("You have exceeded the maximum limit");
      return true;
    }
    return false;
  }

  //Function to add new asset using new parameters
  public void addAsset(float new_price, String new_name, float new_drift_rate,
                       float new_volatility, Position new_position, int amount)
  {
    if(ExceedsMax(asset_count, GlobalVariables.MAX_ASSETS) == false)
    {
    assets[asset_count] = new Asset(new_price, new_name, new_drift_rate, new_volatility, new_position, amount);
    asset_count++;
    }
  }

  /*
  //Function to add new asset using existing asset
  public void addAsset(Asset new_asset)
  {
    if(ExceedsMax(asset_count, GlobalVariables.MAX_ASSETS) == false)
    {
    assets[asset_count] = new Asset(new_asset);
    asset_count++;
  }
  */

  //Function to add new bond using new parameters
  public void addBond(float initial_investment, String new_name, float new_maturity, int amount)
  {
    if(ExceedsMax(bond_count, GlobalVariables.MAX_BONDS) == false)
    {
    bonds[bond_count] = new Bond(initial_investment, new_name, new_maturity, amount);
    bond_count++;
    }
  }

  /*
  //Function to add new bond using existing bond
  public void addBond(Bond new_bond)
  {
    bonds[bond_count] = new_bond;
    bond_count++;
  }
  */

  //Function to add new Forward contract using new parameters
  public void addForward(Asset new_asset, float new_strike, float new_maturity, Position new_position, int amount)
  {
    if(ExceedsMax(forward_count, GlobalVariables.MAX_FORWARDS) == false)
    {
    forwards[forward_count] = new Forward(new_asset, new_strike, new_maturity, new_position, amount);
    forward_count++;
    }
  }

  //Function to add new Forward with new asset parameters
  public void addForward(float new_price, String new_name, float new_drift_rate, float new_volatility,
                         float new_strike, float new_maturity, Position new_position, int amount)
  {
    if(ExceedsMax(forward_count, GlobalVariables.MAX_FORWARDS) == false)
    {
    forwards[forward_count] = new Forward(new_price, new_name, new_drift_rate, new_volatility,
                                          new_strike, new_maturity, new_position, amount);
    forward_count++;
    }
  }

  /*
  //Function to add new Forward using existing forward
  public void addForward(Forward new_forward)
  {
    forwards[forward_count] = new_forward;
    forward_count++;
  }
  */

  //Function to add call option contracts
  public void addCall(Asset new_asset, float new_strike, float new_maturity, Position new_position, int amount)
  {
    if(ExceedsMax(call_count, GlobalVariables.MAX_CALLS) == false)
    {
    calls[call_count] = new Call(new_asset, new_strike, new_maturity, new_position, amount);
    call_count++;
    }
  }

  //Function to add new call with new asset parameters
  public void addCall(float new_price, String new_name, float new_drift_rate, float new_volatility,
                         float new_strike, float new_maturity, Position new_position, int amount)
  {
    if(ExceedsMax(call_count, GlobalVariables.MAX_CALLS) == false)
    {
    calls[call_count] = new Call(new_price, new_name, new_drift_rate, new_volatility,
                             new_strike, new_maturity, new_position, amount);
    call_count++;
    }
  }

  /*
  //Function to add new call using existing call
  public void addCall(Call new_call)
  {
    calls[call_count] = new_call;
    call_count++;
  }
  */

  //Function to add put option contracts
  public void addPut(Asset new_asset, float new_strike, float new_maturity, Position new_position, int amount)
  {
    if(ExceedsMax(call_count, GlobalVariables.MAX_CALLS) == false)
    {
    puts[put_count] = new Put(new_asset, new_strike, new_maturity, new_position, amount);
    put_count++;
    }
  }

  //Function to add new put with new asset parameters
  public void addPut(float new_price, String new_name, float new_drift_rate, float new_volatility,
                         float new_strike, float new_maturity, Position new_position, int amount)
  {
    if(ExceedsMax(call_count, GlobalVariables.MAX_CALLS) == false)
    {
    puts[put_count] = new Put(new_price, new_name, new_drift_rate, new_volatility,
                          new_strike, new_maturity, new_position, amount);
    put_count++;
    }
  }

  /*
  //Function to add new put using existing put
  public void addPut(Put new_put)
  {
    puts[put_count] = new_put;
    put_count++;
  }
  */
}
