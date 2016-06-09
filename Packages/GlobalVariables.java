/*We reserve this module for world variables and operations involving quantative finance
  which we shall use in our models and applications.*/

  package Packages;

  public class GlobalVariables {

  //For convenience we fix the (annual continuously compounded) interest rates for derivates at 0.5
  public static final float INTEREST = 0.5f;

  //Our pre set maximum number of objects allowed at any given time
  public static final int MAX_ASSET = 5;
  public static final int MAX_DERIVATIVES = 10;

  //Breakoff point for normal distribution (point in which the probability accurate enought to be 1)
  public static final int SND_BREAK_POINT = 349;
  
}
