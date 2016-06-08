/*Blank template for a java application*/

/**
 *
 * @author Steven
 */
import Packages.Sinatra.Asset;
import Packages.Sinatra.Derivative;
import Packages.StandardNormalDistribution.SND;


public class Main{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        SND s = new SND();
        System.out.println(s.LinearInterpolate(1.237f));
        System.out.println("Systems Operational: True");
    }

}
