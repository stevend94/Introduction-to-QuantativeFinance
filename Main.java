/*Blank template for a java application*/

/**
 *
 * @author Steven
 */
import Packages.Sinatra.Asset;
import Packages.Sinatra.Derivative;
import Packages.Sinatra.Forward;
import Packages.Sinatra.Future;


public class Main{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Asset asset = new Asset(7.21f, "ASDX", 0.21, 0.2);
        Forward forward = new Forward(asset, 8f, 0.5);
        System.out.println(forward.getValue());
        System.out.println("Systems Operational: True");
    }

}
