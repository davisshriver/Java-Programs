import java.io.*;
import java.util.*;

class VolumeFormulasCustomer {
   public static void main(String[] args) throws FileNotFoundException  {
   
      Scanner input = new Scanner(System.in);
      
      VolumeFormulas volume = new VolumeFormulas();
   
      // Increment variables
      
      int i = 0;
      int j = 0;
      int k = 0;
      int l = 0;
      
      // Variables to take care of user input
      char key;
      boolean userInput = false;
      int YN = 0;
      int userShape = 0;
      double userRadius = 0;
      double userHeight = 0;
      double userVolume = 0;
   
      String lastName;
      
      // Arrays to hold input data
      
      int[] shapes = new int[30];
      double[] radius = new double[30];
      double[] height = new double[30];
      double[] volumes = new double[30];
      
      // Get name of input file
      
      System.out.println("Please enter the filename in the run arguments section, press any key when done.");
      key = input.next().charAt(0);
     
      // Creates file object to input data
      
      File file = new File(args[0]);
      
      if (!file.exists()) {
         System.out.println("File does not exist, exiting...");
         System.exit(0);
      }
      Scanner read = new Scanner(file);
      // Acquire name for the output file
      
      System.out.print("Please enter your last name: ");
      lastName = input.next();
      
      // Setup of output file and print writer based on lastName
      
      File oFile = new File(lastName + ".volumeCalculations.txt");
      
      PrintWriter print = new PrintWriter(oFile);
      
      //Prompts user for data set
      
      System.out.print("Do you have your own set of data? (1 for Yes, 2 for No): ");
      YN = input.nextInt();
      
      // Setting user input to user variables and finding volume
      
      if(YN == 1) { 
         System.out.print("What shape do you want to find the volume of (1) Cylinder, (2) Cone, (3) Sphere: ");
         userShape = input.nextInt(); 
         
         System.out.print("What is the radius?: ");
         userRadius = input.nextDouble();
        
         if (userShape == 2 || userShape == 1) {
            System.out.print("What is the height of your shape?: ");
            userHeight = input.nextDouble();
         }
         userInput = true;
      }
      
      // If user input is true, calculate userVolume based on shape number
      
      if(userInput = true) {
      
         if(userShape == 1) { 
            userVolume = Math.PI * (userRadius * userRadius) * userHeight;
         }
         else if(userShape == 2) {
            userVolume = Math.PI * (userRadius * userRadius) * (userHeight / 3);
         }
         else if(userShape == 3) { 
            userVolume = Math.PI * (userRadius * userRadius * userRadius) * 1.33333333333333;
         }
      
      }
      
      // While loop that brings in file data and stores it in the correct array
      try {
         while(read.hasNext()) {
         
            shapes[i] = read.nextInt();
            
            if(shapes[i] == 1 || shapes[i] == 2){
               radius[j] = read.nextDouble();
               height[k] = read.nextDouble(); 
               i++;
               j++;
               k++;  
            }
            else if(shapes[i] == 3) {
               radius[j] = read.nextDouble();
               i++;
               j++;
            }
         }
      }
      
      catch(ArrayIndexOutOfBoundsException ex) {
         System.out.println("Too many elements, make sure you only have 30 sets of data or less.");
         System.exit(0);
      }
      catch(InputMismatchException ex) {
         System.out.println("Input file is out of order, please reorder the input file or choose another one. Exiting...");
         System.exit(0);
      }
      
      System.out.println("How would you like to recieve the volumes?");
      System.out.println("(1) Monitor only");
      System.out.println("(2) File only");
      System.out.println("(3) Both");
      YN = input.nextInt();
      
      // Reset increment variables
      
      j = 0 ;
      k = 0;
      
      while (l < i) {
         if (shapes[j] == 1) {
            volumes[l] = volume.cylinderVolume(radius[j], height[k]);
            j++;
            k++;
            l++;
         }
         else if(shapes[j] == 2) {
            volumes[l] = volume.coneVolume(radius[j], height[k]);
            j++;
            k++;
            l++;
         }
         else if(shapes[j] == 3) {
            volumes[l] = volume.sphereVolume(radius[j]);
            j++;
            l++;
         }
         
      }
      
      j = 0;
      k = 0;
      l = 0;
   
      // Option 1, prints to the screen
   
      if(YN == 1) {
         if(userInput == true) {
            System.out.println("Total Volumes calculated: " + (volume.counterValue() + 1));
            System.out.println("");
         }
         else {
            System.out.println("Total Volumes calculated: " + volume.counterValue());
            System.out.println("");
         }
         
         while(j < volume.counterValue()) {
            if(shapes[j] == 1) {
               
               System.out.printf("Cylinder volume with radius " + radius[j] + " and height " + height[k] + " is %.2f" , volumes[l]);
               System.out.println("");
               j++;
               k++;
               l++;
            }
            else if(shapes[j] == 2) {
               
               System.out.printf("Cone volume with radius " + radius[j] + " and height " + height[k] + " is %.2f" , volumes[l]);
               System.out.println("");
               j++;
               k++;
               l++;
            }
            else if(shapes[j] == 3) {
               System.out.println("Total Volumes calculated: " + volume.counterValue());
               System.out.println("");
               System.out.printf("Sphere volume with radius " + radius[j] + " is %.2f" , volumes[l]);
               System.out.println("");
               j++;
               l++;
            }
         } 
         
         if(userInput == true) {
            if(userShape == 1) {
               System.out.printf("Cylinder volume with radius " + userRadius + " and height " + userHeight + " is %.2f" , userVolume);
            }
            else if(userShape == 2) {
               System.out.printf("Cone volume with radius " + userRadius + " and height " + userHeight + " is %.2f" , userVolume);
            }
            else if(userShape == 3) {
               System.out.printf("Sphere volume with radius " + userRadius + " and height " + userHeight + " is %.2f" , userVolume);
            }
         }
      }
      
      // Option 2, prints to a file
      
      else if(YN == 2) {
         if(userInput == true) {
            print.println("Total Volumes calculated: " + (volume.counterValue() + 1));
            print.println("");
         }
         else {
            print.println("Total Volumes calculated: " + volume.counterValue());
            print.println("");
         }
         while(j < volume.counterValue()) {
            if(shapes[j] == 1) {
               print.printf("Cylinder volume with radius " + radius[j] + " and height " + height[k] + " is %.2f" , volumes[l]);
               print.println("");
               j++;
               k++;
               l++;
            }
            else if(shapes[j] == 2) {
               print.printf("Cone volume with radius " + radius[j] + " and height " + height[k] + " is %.2f" , volumes[l]);
               print.println("");
               j++;
               k++;
               l++;
            }
            else if(shapes[j] == 3) {
               print.printf("Sphere volume with radius " + radius[j] + " is %.2f" , volumes[l]);
               print.println("");
               j++;
               l++;
            }
         } 
         
         if(userInput == true) {
            if(userShape == 1) {
               print.printf("Cylinder volume with radius " + userRadius + " and height " + userHeight + " is %.2f" , userVolume);
            }
            else if(userShape == 2) {
               print.printf("Cone volume with radius " + userRadius + " and height " + userHeight + " is %.2f" , userVolume);
            }
            else if(userShape == 3) {
               print.printf("Sphere volume with radius " + userRadius + " and height " + userHeight + " is %.2f" , userVolume);
            }
         }
         
         print.close();
      }
      
      // Option 3, prints to screen and the file 
      
      else if(YN == 3) { 
         if(userInput == true) {
            System.out.println("Total Volumes calculated: " + (volume.counterValue() + 1));
            System.out.println("");
            print.println("Total Volumes calculated: " + (volume.counterValue() + 1));
            print.println("");
         }
         else {
            System.out.println("Total Volumes calculated: " + volume.counterValue());
            System.out.println("");
            print.println("Total Volumes calculated: " + volume.counterValue());
            print.println("");
         }
         
         while(j < volume.counterValue()) {
            if(shapes[j] == 1) {
               print.printf("Cylinder volume with radius " + radius[j] + " and height " + height[k] + " is %.2f" , volumes[l]);
               print.println("");
               System.out.printf("Cylinder volume with radius " + radius[j] + " and height " + height[k] + " is %.2f" , volumes[l]);
               System.out.println("");
               j++;
               k++;
               l++;
            }
            else if(shapes[j] == 2) {
               print.printf("Cone volume with radius " + radius[j] + " and height " + height[k] + " is %.2f" , volumes[l]);
               print.println("");
               System.out.printf("Cone volume with radius " + radius[j] + " and height " + height[k] + " is %.2f" , volumes[l]);
               System.out.println("");
               j++;
               k++;
               l++;
            }
            else if(shapes[j] == 3) {
               print.printf("Sphere volume with radius " + radius[j] + " is %.2f" , volumes[l]);
               print.println("");
               System.out.printf("Sphere volume with radius " + radius[j] + " is %.2f" , volumes[l]);
               System.out.println("");
               j++;
               l++;
            }
         } 
         
         if(userInput == true) {
            if(userShape == 1) {
               print.printf("Cylinder volume with radius " + userRadius + " and height " + userHeight + " is %.2f" , userVolume);
               System.out.printf("Cylinder volume with radius " + userRadius + " and height " + userHeight + " is %.2f" , userVolume);
            }
            else if(userShape == 2) {
               print.printf("Cone volume with radius " + userRadius + " and height " + userHeight + " is %.2f" , userVolume);
               System.out.printf("Cone volume with radius " + userRadius + " and height " + userHeight + " is %.2f" , userVolume);
            }
            else if(userShape == 3) {
               print.printf("Sphere volume with radius " + userRadius + " is %.2f" , userVolume);
               System.out.printf("Sphere volume with radius " + userRadius + " is %.2f" , userVolume);
            }
         }
         
         print.close();
      }
      
   }
}
