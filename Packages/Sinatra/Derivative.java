/*This object shall act as the foundation for our derivatives which shall include basic properties as

  - The underlying asset to which the derivative is associated
  - The strike price of the derivative
  - The Maturity date (given the annual interest rate model)
  - The computed value of the derivative (Under the Black-scholes model)

It should be noted that we are operating under the assumtion that the asset price follows a pattern that
is described by geometric brownian motion and under constant interest rates throughout */

package Packages.Sinatra;

import Packages.GlobalVariables;

public abstract class Derivative {
  protected String name;              //Name of derivative (if given)
  protected float value;              //Value of the derivative based on black scholes model
  protected float strike;             //Strike price of the derivative
  protected Asset asset;              //Underlying asset associated with derivative
  protected float maturity;          //Time till maturity to be more exact
  static int NO_ACTIVE_DERIVATIVES;


  /*All Return functions for derivative class object variables in order of occurence*/
  public String getName() { return this.name; }            //Function to return name of derivative

  public float getValue() { return this.value; }           //Function to return the value of the derivative

  public float getStrike() { return this.strike; }         //Function to return the strike priceof the derivative

  public Asset getAsset() { return this.asset; }           //function to return the underlying asset

  public double getMaturity() { return this.maturity; }    //Function to return the maturity date of the derivative

  //Abstract function that will determine the value of the derivative
  abstract void UpdateValue();
}
