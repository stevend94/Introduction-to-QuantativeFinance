/*This object shall act as the foundation for our derivatives which shall include basic properties as

  - The underlying asset to which the derivative is associated
  - The strike price of the derivative
  - The Maturity date (given the annual interest rate model)
  - The computed value of the derivative (Under the Black-scholes model)

It should be noted that we are operating under the assumtion that the asset price follows a pattern that
is described by geometric brownian motion and under constant interest rates throughout */

package Packages.Sinatra;

public abstract class Derivative {
  private String name;              //Name of derivative (if given)
  private float value;              //Value of the derivative based on black scholes model
  private float strike;
  private Asset asset;              //Underlying asset associated with derivative
  private double maturity;           //Time till maturity to be more exact
  static int NO_ACTIVE_DERIVATIVES;

  //Function to return name of derivative
  public String getName() { return this.name; }

  //Function to return the value of the derivative
  public float getValue() { return this.value; }

  //Function to return the strike priceof the derivative
  public float getStrike() { return this.strike; }

  //Function to return the maturity date of the derivative
  public double getMaturity() { return this.maturity; }

  //function to return the underlying asset
  public Asset getAsset() { return this.asset; }

  //Abstract function that will determine the value of the derivative
  abstract void updateValue();
}
