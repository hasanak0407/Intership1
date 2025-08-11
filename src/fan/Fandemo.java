package fan;
import java.util.ArrayList;
import java.util.Scanner;
public class Fandemo {
    public static void main(String[] args) {
        ArrayList<Fan> fansArrayList = new ArrayList<>();
        int i = 1;
        int totalCount=0;
        int countOfFansOn = 0;
        while (i <= 180) {
            Fan f = new Fan();
            fansArrayList.add(f);
            i++;
        }
        System.out.println("No. of fans in warehouse : " + fansArrayList.size());
        Scanner sc = new Scanner(System.in);
        boolean outerRunning = true;
        while (outerRunning) {
            System.out.print("Enter fan no. to test : ");
            int fanSeleceted = sc.nextInt();
            if (fanSeleceted < 0 || fanSeleceted >= fansArrayList.size()) {
                System.out.println("Invalid fan number");
                continue;
            }
            Fan f = fansArrayList.get(fanSeleceted);
            boolean running = true;
            while (running == true) {
                System.out.println("******************************************************************************** Fan Controls ********************************************************************************");
                System.out.println("1.Switch on the fan");
                System.out.println("2.Switch off the fan");
                System.out.println("3.Increase speed of the fan");
                System.out.println("4.Decrease speed of the fan");
                System.out.println("5.Exit control of current fan");
                System.out.println("6.Report");
                System.out.println("7.Shut down the application");
                System.out.print("Enter choice : ");
                int choice = sc.nextInt();
                switch (choice) {
                    case 1 -> {
                        if (f.isOn() == false) {
                            System.out.println("Switching on the fan");
                            f.switchOnTheFan();
                            countOfFansOn++;
                            totalCount++;
                        } else {
                            System.out.println("Fan is already running");
                        }
                    }
                    case 2 -> {
                        if (f.isOn() == false) {
                            System.out.println("Fan is already off");
                            //System.out.println("Switching off the fan");
                        } else {
                            f.switchOfTheFan();
                            countOfFansOn--;
                            totalCount++;
                        }
                    }
                    case 3 -> {
                        f.increaseSpeed();
                        totalCount++;
                        System.out.println("Fan speed is : " + f.getSpeed());
                    }
                    case 4 -> {
                        f.decreaseSpeed();
                        totalCount++;
                        System.out.println("Fan speed is : " + f.getSpeed());
                    }
                    case 5 -> {
                        running = false;
                        totalCount++;
                        System.out.println("Exiting fan control for Fan no. : " + fanSeleceted);
                    }
                    case 6 -> {
                        totalCount++;
                        System.out.println("No. of fans in switched on status : " + countOfFansOn);
                        System.out.println("Total no. of buttons pressed : "+totalCount);
                    }
                    case 7 -> {
                        running = false;
                        outerRunning = false;
                        totalCount++;
                        System.out.println("Shutting down the application");
                    }
                    default -> System.out.println("Invalid choice");
                }
            }
        }
        sc.close();
    }
}