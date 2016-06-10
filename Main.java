/*Blank template for a java application*/

/**
 *
 * @author Steven
 */

import Packages.Position;
import Packages.Sinatra.Asset;
import Packages.Sinatra.Derivative;
import Packages.Sinatra.Forward;
import Packages.Sinatra.Future;
import Packages.Sinatra.Call;
import Packages.Sinatra.Put;


public class Main{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Asset asset = new Asset(7.21f, "ASDX", 0.21f, 0.2f);
      //  Put put = new Put(asset, 11, 0.5f);
      //  System.out.println(put.getValue());
       Forward forward = new Forward(asset, 11, 0.5f, Position.LONG);
       System.out.println(forward.payOff(8));
        System.out.println("Systems Operational: True");
    }

}
