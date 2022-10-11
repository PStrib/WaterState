import java.util.Scanner;

/**
 * Program to find the state of water at any given temperature and altitude
 * @author Peter Stribblehill
 * @version 10/10/2022
 */
public class WaterState {
    public static void main(String[] args){
        Scanner scanner=new Scanner(System.in);
        final int seaLevelBoilingPoint=100;
        final int seaLevel=0;
        final int degreeIncrement=300;
        final int freezingPoint=0;

        System.out.println("What is the temperature? (to the nearest degree c)");
        int temperature=scanner.nextInt();
        //if the temperature is below 0 then the altitude doesn't matter
        if (temperature<freezingPoint){
            System.out.println("Water is solid at this temperature");
            return;
        }

        System.out.println("What is the altitude? (to the nearest metre above sea level)");
        int altitude=scanner.nextInt();
        while(altitude<seaLevel){
            System.out.println("Sorry, please enter a height above sea level");
            altitude=scanner.nextInt();
        }

        int degreesAboveSeaLevel=altitude/degreeIncrement;
        int newBoilingPoint=seaLevelBoilingPoint-degreesAboveSeaLevel;

        String state;
        //If the temperature is over the altitude adjusted boiling point, the state is set to 'gaseous'
        if(temperature>=newBoilingPoint){state="gaseous";}
        //If not then the state is set to 'liquid'
        else{state="liquid";}

        System.out.println("The boiling point of water at this height is "+newBoilingPoint+" degrees c");
        System.out.println("Water is "+state+" at these conditions");
    }
}