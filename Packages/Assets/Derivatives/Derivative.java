/*This object shall act as the foundation for our derivatives which shall include basic properties as

  - The underlying asset to which the derivative is associated
  - The strike price of the derivative
  - The Maturity date (given the annual interest rate model)
  - The computed value of the derivative (Under the Black-scholes model)

It should be noted that we are operating under the assumtion that the asset price follows a pattern that
is described by geometric brownian motion and under constant interest rates throughout */

package Packages.Assets.Derivatives;

import Packages.GlobalVariables;
import Packages.Position;
import Packages.Assets.Asset;

public abstract class Derivative {
  protected String name;                              //Name of derivative (if given)
  protected float value;                              //Value of the derivative based on black scholes model
  protected float strike;                             //Strike price of the derivative
  protected Asset asset;                              //Underlying asset associated with derivative
  protected float maturity;                           //Time till maturity to be more exact
  static int NO_ACTIVE_DERIVATIVES;
  protected Position position;                        //Financial position of the derivative
  protected int quantity;                               //quantity of the derivative

  //Default constructor for Derivative class object
  public Derivative(Asset new_asset, float new_strike, float new_maturity, Position new_position, int amount) {
    this.asset = new_asset;         //set new asset
    this.strike = new_strike;       //set new strike price
    this.maturity = new_maturity;   //set new maturity date
    this.position = new_position;   //set new Financial position
    this.quantity = amount;         //set new quantity

    UpdateValue();                  //Update the value of the derivative
    NO_ACTIVE_DERIVATIVES++;
  }

  //Alternative constructor for Derivative class object which creates the asset aswell
  public Derivative(float new_price, String new_name, float new_drift_rate, float new_volatility,
                    float new_strike, float new_maturity, Position new_position, int amount)
  {
    Asset new_asset = new Asset(new_price, new_name, new_drift_rate, new_volatility, Position.LONG, 1);  //Create new asset object
    this.asset = new_asset;         //set new asset
    this.strike = new_strike;       //set new strike price
    this.maturity = new_maturity;   //set new maturity date
    this.position = new_position;   //set new Financial position
    this.quantity = amount;         //set new quantity

    UpdateValue();                  //Update the value of the derivative
    NO_ACTIVE_DERIVATIVES++;
    }



  /*All Return functions for derivative class object variables in order of occurence*/
  public String getName() { return this.name; }            //Function to return name of derivative

  public float getValue() { return this.value; }           //Function to return the value of the derivative

  public float getStrike() { return this.strike; }         //Function to return the strike priceof the derivative

  public Asset getAsset() { return this.asset; }           //function to return the underlying asset

  public float getMaturity() { return this.maturity; }     //Function to return the maturity date of the derivative

  public int getQuantity() { return this.quantity; }       //Function to return the quantity of derivatives

  public Position getPosition() { return this.position; }  //Function to return the financial position of the derivative

  //This method shall define the pay-off function of the derivative at a given asset price
  public abstract float payOff(float new_asset);

  //Abstract function that will determine the value of the derivative
  abstract void UpdateValue();
}
