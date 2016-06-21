/*Blank template for a java application*/

/**
 *
 * @author Steven
 */

import Packages.QuantLib.Portfolio;
import Packages.Position;
import Packages.Assets.Asset;
import Packages.Assets.Derivatives.Forward;
import Packages.Assets.Derivatives.Future;
import Packages.Assets.Derivatives.Call;
import Packages.Assets.Derivatives.Put;
import Packages.Assets.Bond;
import Packages.GlobalVariables;



public class Main{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        /*
        Asset asset = new Asset(7.21f, "ASDX", 0.21f, 0.2f, Position.LONG, 1);
      //  Put put = new Put(asset, 11, 0.5f);
      //  System.out.println(put.getValue());
       Forward forward = new Forward(asset, 11, 0.5f, Position.LONG, 1);
       Bond bond = new Bond(6, "NASQ 6m", 0.5f, 1);
       System.out.println(forward.payOff(15));
       System.out.println(bond.getValue());
       */
       System.out.println("");

        Portfolio portfolio = new Portfolio("NASDQ Portfolio");
        portfolio.addAsset(7.21f, "ASDX", 0.21f, 0.2f, Position.LONG, 1);
        portfolio.addAsset(3.62f, "NAFDQ", 0.22f, 0.1f, Position.LONG, 3);
        portfolio.addAsset(6.15f, "QFTS", 0.07f, 0.3f, Position.LONG, 5);
        portfolio.addBond(7.83f, "QFTS", 0.5f, 8);
        portfolio.addForward(4.33f, "ASDX", 0.075f, 0.3f, 5.0f, 0.75f, Position.LONG, 100);
        portfolio.addCall(4.33f, "ASDX", 0.075f, 0.3f, 5.0f, 0.75f, Position.SHORT, 50);
        portfolio.addCall(2.76f, "NAFDQ", 0.15f, 0.41f, 5.0f, 0.5f, Position.LONG, 75);
        portfolio.PrintAssets();

        System.out.println(portfolio.currentInvestment());
        System.out.println("Systems Operational: True");
    }

}
