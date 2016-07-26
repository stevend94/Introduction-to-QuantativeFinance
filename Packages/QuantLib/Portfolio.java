/*Here we have the java class object for the portfolio, which shall take
  inputs of derivatives, assets and bonds from our derivatives package.*/

package Packages.QuantLib;

import Packages.Assets.Asset;
import Packages.Assets.Bond;
import Packages.Assets.Derivatives.*;
import Packages.QuantLib.Position;
import Packages.QuantLib.GlobalVariables;

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

  private String name;
  private static int NO_ACTIVE_PORTFOLIOS;

  //Default constructor for portfolio class
  public Portfolio(String new_name) {
    this.name = new_name;
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
  public void addAsset(float new_value, String new_name, float new_drift_rate,
                       float new_volatility, Position new_position, int amount)
  {
    if(ExceedsMax(asset_count, GlobalVariables.MAX_ASSETS) == false)
    {
    assets[asset_count] = new Asset(new_value, new_name, new_drift_rate, new_volatility, new_position, amount);
    asset_count++;
    }
  }


  //Function to add new asset using existing asset
  public void addAsset(Asset new_asset)
  {
    if(ExceedsMax(asset_count, GlobalVariables.MAX_ASSETS) == false)
    {
    assets[asset_count] = new_asset;
    asset_count++;
    }
  }

  //Function to access an asset from a portfolio through its ordered number
  public Asset getAsset(int asset_number)
  {
    if(ExceedsMax(asset_number, asset_count) == false)
    {
      return assets[asset_number];
    }
    return null;
  }

  //Function to access an asset from a portfolio through its name
  public Asset getAsset(String asset_name)
  {
    for(int i = 0; i < asset_count; i++)
    {
      if(asset_name == assets[i].getName())
      {
        return assets[i];
      }
    }
    return null;
  }


  //Function to add new bond using new parameters
  public void addBond(float initial_investment, String new_name, float new_maturity, int amount)
  {
    if(ExceedsMax(bond_count, GlobalVariables.MAX_BONDS) == false)
    {
    bonds[bond_count] = new Bond(initial_investment, new_name, new_maturity, amount);
    bond_count++;
    }
  }


  //Function to add new bond using existing bond
  public void addBond(Bond new_bond)
  {
    if(ExceedsMax(bond_count, GlobalVariables.MAX_BONDS) == false)
    {
    bonds[bond_count] = new_bond;
    bond_count++;
    }
  }

  //Function to access an bond from a portfolio through its ordered number
  public Bond getBond(int bond_number)
  {
    if(ExceedsMax(bond_number, bond_count) == false)
    {
      return bonds[bond_number];
    }
    return null;
  }

  //Function to access an bond from a portfolio through its name
  public Bond getBond(String bond_name)
  {
    for(int i = 0; i < bond_count; i++)
    {
      if(bond_name == bonds[i].getName())
      {
        return bonds[i];
      }
    }
    return null;
  }



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
  public void addForward(float new_value, String new_name, float new_drift_rate, float new_volatility,
                         float new_strike, float new_maturity, Position new_position, int amount)
  {
    if(ExceedsMax(forward_count, GlobalVariables.MAX_FORWARDS) == false)
    {
    forwards[forward_count] = new Forward(new_value, new_name, new_drift_rate, new_volatility,
                                          new_strike, new_maturity, new_position, amount);
    forward_count++;
    }
  }


  //Function to add new Forward using existing forward
  public void addForward(Forward new_forward)
  {
    if(ExceedsMax(forward_count, GlobalVariables.MAX_FORWARDS) == false)
    {
    forwards[forward_count] = new_forward;
    forward_count++;
    }
  }

  //Function to access a forward from a portfolio through its ordered number
  public Forward getForward(int forward_number)
  {
    if(ExceedsMax(forward_number, forward_count) == false)
    {
      return forwards[forward_number];
    }
    return null;
  }

  //Function to access a forward from a portfolio through its name
  public Forward getForward(String forward_name)
  {
    for(int i = 0; i < forward_count; i++)
    {
      if(forward_name == forwards[i].getName())
      {
        return forwards[i];
      }
    }
    return null;
  }


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
  public void addCall(float new_value, String new_name, float new_drift_rate, float new_volatility,
                         float new_strike, float new_maturity, Position new_position, int amount)
  {
    if(ExceedsMax(call_count, GlobalVariables.MAX_CALLS) == false)
    {
    calls[call_count] = new Call(new_value, new_name, new_drift_rate, new_volatility,
                             new_strike, new_maturity, new_position, amount);
    call_count++;
    }
  }


  //Function to add new call using existing call
  public void addCall(Call new_call)
  {
    if(ExceedsMax(call_count, GlobalVariables.MAX_CALLS) == false)
    {
    calls[call_count] = new_call;
    call_count++;
    }
  }
  //Function to access a call from a portfolio through its ordered number
  public Call getCall(int call_number)
  {
    if(ExceedsMax(call_number, call_count) == false)
    {
      return calls[call_number];
    }
    return null;
  }

  //Function to access a call from a portfolio through its name
  public Call getCall(String call_name)
  {
    for(int i = 0; i < call_count; i++)
    {
      if(call_name == calls[i].getName())
      {
        return calls[i];
      }
    }
    return null;
  }

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
  public void addPut(float new_value, String new_name, float new_drift_rate, float new_volatility,
                         float new_strike, float new_maturity, Position new_position, int amount)
  {
    if(ExceedsMax(call_count, GlobalVariables.MAX_CALLS) == false)
    {
    puts[put_count] = new Put(new_value, new_name, new_drift_rate, new_volatility,
                          new_strike, new_maturity, new_position, amount);
    put_count++;
    }
  }


  //Function to add new put using existing put
  public void addPut(Put new_put)
  {
    if(ExceedsMax(call_count, GlobalVariables.MAX_CALLS) == false)
    {
    puts[put_count] = new_put;
    put_count++;
    }
  }

  //Function to access a put from a portfolio through its ordered number
  public Put getPut(int put_number)
  {
    if(ExceedsMax(put_number, put_count) == false)
    {
      return puts[put_number];
    }
    return null;
  }

  //Function to access a put from a portfolio through its name
  public Put getPut(String put_name)
  {
    for(int i = 0; i < put_count; i++)
    {
      if(put_name == puts[i].getName())
      {
        return puts[i];
      }
    }
    return null;
  }

  //Function to print all assets of portfolio
  public void PrintAssets()
  {
    System.out.println("//////////////////////////Assets for " + this.name + "//////////////////////////");
    System.out.println("");

    //Here we print all stocks and assets
    if (asset_count != 0) {
    System.out.println("    Current Stocks/Assets: ");
    for(int i = 0; i < asset_count; i++) {
      System.out.println("    " + assets[i].getName() + " at spot price " + assets[i].getValue()
                                             + " [" + assets[i].getQuantity()+ "]");
    }
  }
    System.out.println("");

   //Here we print all Bonds
   if (bond_count != 0) {
   System.out.println("    Current Bonds:");
   for(int i = 0; i < bond_count; i++) {
     System.out.println("    " + bonds[i].getName() + " of investment " + bonds[i].getInvestment() + " and maturity " +
     bonds[i].getMaturity() + " with face value " + bonds[i].getValue() + " [" + bonds[i].getQuantity() + "]");
    }
  }
    System.out.println("");

    //Here we print all Forward contracts
    if (forward_count != 0) {
    System.out.println("    Current Forward Contracts:");
    for(int i = 0; i < forward_count; i++) {
      System.out.println("    " + forwards[i].getName() + " [" + forwards[i].getQuantity() + "]");
     }
   }
     System.out.println("");

    //Here we print all call contracts
    if (call_count != 0) {
    System.out.println("    Current Call Contracts: ");
    for(int i = 0; i < call_count; i++) {
      System.out.println("    " + calls[i].getName() +
                         " with value " + calls[i].getValue() + " [" + calls[i].getQuantity() + "]");
     }
   }
      System.out.println("");

    //Here we print all call contracts
    if (put_count != 0) {
    System.out.println("    Current Put Contracts:");
    for(int i = 0; i < put_count; i++) {
      System.out.println("    " + puts[i].getName() +
                         " with value " + calls[i].getValue() + " [" + calls[i].getQuantity() + "]");
     }
   }
        System.out.println("");
  }

  public float currentInvestment()
  {
    //Function to get the total investment of the portfolio (not forwards & futures require no investment)
    float investment = 0f;

     //add all assets to current value
     for(int i = 0; i < asset_count; i++)
     {
       if(assets[i].getPosition() == Position.LONG)
          investment += assets[i].getQuantity()*assets[i].getValue();
       else
          investment -= assets[i].getQuantity()*assets[i].getValue();
     }

     //add all bonds to current value (at time t = 0)
     for(int i = 0; i < bond_count; i++) {
       investment += bonds[i].getQuantity()*bonds[i].getInvestment();
     }

     //add all call premiums to current value
     for(int i = 0; i < call_count; i++) {
       if(calls[i].getPosition() == Position.LONG)
          investment -= calls[i].getQuantity()*calls[i].getValue();
       else
          investment += calls[i].getQuantity()*calls[i].getValue();
     }

     //add all put premiums to current value
     for(int i = 0; i < put_count; i++) {
       if(puts[i].getPosition() == Position.LONG)
          investment -= puts[i].getQuantity()*puts[i].getValue();
       else
          investment += puts[i].getQuantity()*puts[i].getValue();
     }

     return investment;
  }

}
