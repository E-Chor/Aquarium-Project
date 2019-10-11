import java.awt.Color;
import java.util.Random;
/** Aquarium Lab Series: <br>    
 *      The AquaSimApplication class contains the main function that will
 *      run the Aquarium Simulation. (This description should be updated
 *      when the behavior of the program changes.)<br>
 *
 * Modifications: <br>
 *   23 March 2008,  Alyce Brady,  Created skeleton main that constructs and
 *                                 displays an empty aquarium.<br>
 *   (date), (your name), Modified to .... <br>
 *
 *  @author  Alyce Brady  (should be Your Name)
 *  @version 23 March 2008  (should be today's date)
 *  @see AquariumController
 **/
public class AquaSimApplication
{
    /**
     *  This is the main function.  It executes the program.
     *  @param    String args[] is never used
     **/
    private static Random generator;
    public static void main(String args[])
    {
        System.out.println("Welcome to my aquarium");

        // CONSTRUCT OBJECTS NEEDED FOR THE AQUARIUM SIMULATION.
        generator =  new Random();
        int randNumber;
        //int randNum = generator.nextInt(10);
        // Construct the aquarium.  Specify its dimensions when creating it.
        Aquarium aqua;                 // create reference to an Aquarium ...
        aqua = new Aquarium(2000, 2000); // ... object that has now been created
        // Construct fish and add them to the aquarium.
        AquaFish first =  new AquaFish(aqua,getColor());
        aqua.add(first);
        
        AquaFish second = new AquaFish(aqua,getColor());
        aqua.add(second);
        

        AquaFish third = new AquaFish(aqua,getColor());
        aqua.add(third);
        
        // Construct a graphical user interface (GUI) to display and control
        // the simulation.  The user interface needs to know about the
        // aquarium, so we pass aqua to the user interface constructor.
        AquaSimGUI userInterface;              // create reference to GUI ...
        userInterface = new AquaSimGUI(aqua,true);  // ... and then GUI itself

        // Tell the user how to start the aquarium simulation.
        System.out.println("Press the Start button to start the simulation.");

        // Now wait for the user to press the start button.
        userInterface.waitForStart();

        // Draw the initial view of the aquarium and its contents.
        userInterface.showAquarium();


        // RUN THE AQUARIUM SIMULATION.

        // Make the fish move and redisplay.
        int infiniteLoop=0;
        while(infiniteLoop<userInterface.getNumberOfSteps())
            {
        if(first.atWall()||changeDirection()<1)
            {
                first.changeDir();
            }
        else
            {
                first.moveForward();
            }
        if(second.atWall()||changeDirection()<1)
            {
                second.changeDir();
            }
        else
            {
                second.moveForward();
            }
        if(third.atWall()||changeDirection()<1)
            {
                third.changeDir();
            }
        else
            {
                third.moveForward();
            }
        userInterface.showAquarium();
        infiniteLoop=infiniteLoop+1;
            }
        
        // WRAP UP.

        // Remind user how to quit application.
        userInterface.println ("Close GUI display window to quit.");

    }//end main
    public static Color getColor()
        {
            int randNumber = generator.nextInt(6);
            if (randNumber==0)
            return Color.RED;
            else if (randNumber==1)
            return Color.BLUE;
            else if (randNumber==2)
            return Color.GREEN;
            else if (randNumber==3)
            return Color.ORANGE;
            else if (randNumber==4)
            return Color.YELLOW;
            else
            return Color.MAGENTA; 
        }
    public static int changeDirection()
        {
            int randNumber = generator.nextInt(4);
            return randNumber;
        }
}//end class
