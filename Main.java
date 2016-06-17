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

        Portfolio portfolio = new Portfolio();
        portfolio.addAsset(7.21f, "ASDX", 0.21f, 0.2f, Position.LONG, 1);
        System.out.println("Systems Operational: True");
    }

}
