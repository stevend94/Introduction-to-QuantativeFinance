/*Blank template for a java application*/

/**
 *
 * @author Steven
 */
import Packages.Sinatra.Asset;
import Packages.Sinatra.Derivative;
import Packages.Sinatra.Forward;
import Packages.Sinatra.Future;
import Packages.Sinatra.Call;


public class Main{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Asset asset = new Asset(7.21f, "ASDX", 0.21f, 0.2f);
        Call call = new Call(asset, 8, 0.5f);
        System.out.println(call.getValue());
        System.out.println("Systems Operational: True");
    }

}
