import java.util.Scanner;
public class HealthKiosk{
    public static void main (String[] args){
        System.out.println("Welcome to the Health Kiosk");

        //Task 1
        System.out.println("P -> Pharmacy: ");
        System.out.println("L -> Lab: ");
        System.out.println("T -> Triage: ");
        System.out.println("C -> Counseling: ");
        System.out.println("Ender service code (P / L / T/ C): \n" );

        Scanner input = new Scanner(System.in);
        char select = input.next().charAt(0);

        switch (select){
            case 'P':
                System.out.println("Go to: Pharmacy Desk");
                break;
            case 'L':
                System.out.println("Go to: Lab Desk");
                break;
            case 'T':
                System.out.println("Go to: Triage Desk");
                break;
            case 'C':
                System.out.println("Go to: Counseling Desk");
                break;
            default:
                System.out.println("Invalid service code");
        }

        //Task 2


        double calculatedBmiRoundUp = 0;
        int tablet = 0;
        double sinAngleRoundUp = 0;
        int choice = 0;
         if (select == 'T') {
             System.out.println("You are at Triage Desk now, look at the available options:");
             System.out.println("1 for BMI");
             System.out.println("2 for Dosage round-up");
             System.out.println("3 for simple trig helper");
             System.out.println("Enter the Health Metric (1 / 2/ 3) \n");
             choice = input.nextInt();


             if (choice == 1) {
                 System.out.println("Please enter your weight (kg):");
                 double weight = input.nextDouble();
                 System.out.println("Please enter your height (meters):");
                 double height = input.nextDouble();

                 double calculatedBmi = weight / Math.pow(height, 2);
                 calculatedBmiRoundUp = Math.round(calculatedBmi * 10) / 10.0;
                 System.out.println("Your BMI is: " + calculatedBmiRoundUp);


                 if (calculatedBmiRoundUp < 18.5) {
                     System.out.println("Underweight");
                 } else if (calculatedBmiRoundUp > 18.5 && calculatedBmiRoundUp < 24.9) {
                     System.out.println("Normal");
                 } else if (calculatedBmiRoundUp > 25.0 && calculatedBmiRoundUp < 29.9) {
                     System.out.println("Overweight");
                 } else {
                     System.out.println("Obese");
                 }
             }
             else if (choice == 2) {
                 System.out.println("Please enter the required dosage (mg):");
                 double mg = input.nextDouble();
                 tablet = (int)Math.ceil(mg / 250);
                 System.out.println("Your Dosage is: " + tablet);
             }
             else if (choice == 3) {
                 System.out.println("Please enter an angle in degrees: ");
                 double angle = input.nextDouble();

                 double angleRadians = Math.toRadians(angle);

                 double sinAngle = Math.sin(angleRadians);
                 double cosAngle = Math.cos(angleRadians);

                 sinAngleRoundUp = Math.round(sinAngle * 1000) / 1000.0;
                 double cosAngleRoundUp = Math.round(cosAngle * 1000) / 1000.0;

                 System.out.println("Your  sin angle is: " + sinAngleRoundUp);
                 System.out.println("Your cos angle is: " + cosAngleRoundUp);
             }
         }

         //TASK 3
         char randomGenerator = (char) ('A' + (int)(Math.random() * 26));

         int digit1 = (int)(Math.random() * 7);
         int digit2 = (int)(Math.random() * 7);
         int digit3 = (int)(Math.random() * 7);
         int digit4 = (int)(Math.random() * 7);

         String stuID= "" + randomGenerator + digit1 + digit2 + digit3 + digit4;
         System.out.println("Your Student ID is: " + stuID);

         //VALIDATING
         if(stuID.length()!= 5){
             System.out.println("Invalid length");
         }else if(!Character.isLetter(stuID.charAt(0))){
             System.out.println("Invalid: first char must be a letter");
         }else if(!(Character.isDigit(stuID.charAt(1)) &&
                    Character.isDigit(stuID.charAt(2)) &&
                    Character.isDigit(stuID.charAt(3)) &&
                    Character.isDigit(stuID.charAt(4)))){
             System.out.println("Invalid: last 4 must be digits");
        }else{
             System.out.println("ID OK");
         }

        //TASK 4
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please enter your first name: ");
        String firstName = scanner.nextLine();

         char firstLetter = firstName.charAt(0);
         char newLetter = Character.toUpperCase(firstLetter);

         char shiftedLetter = (char) ('A' + (newLetter - 'A' + 2)% 26);

         String lastTwoChars = stuID.substring(stuID.length() - 2);
         String displayCode = "";
         if (choice == 1){
             displayCode = ""+shiftedLetter+lastTwoChars+"-"+calculatedBmiRoundUp;
             System.out.println("Display code: "+displayCode);
         }
         else if(choice == 2){
             displayCode = ""+shiftedLetter+lastTwoChars+"-"+tablet;
             System.out.println("Display code: "+displayCode);
         }
         else if(choice == 3){
             displayCode = ""+shiftedLetter+lastTwoChars+"-"+sinAngleRoundUp;
             System.out.println("Display code: "+displayCode);
         }
         else{
             displayCode = ""+shiftedLetter+lastTwoChars+"-...";
             System.out.println("Display code: "+displayCode);
         }

         //TASK 5
        if(select == 'P'){
            System.out.println("Summary: PHARMACY | " + "ID = "+ stuID + "| Code =" + displayCode);
        }else if(select == 'T'){
            System.out.println("Summary: TRIAGE | " + "ID = "+ stuID + "| Code =" + displayCode);
        }else if(select == 'L'){
            System.out.println("Summary: LAB | " + "ID = "+ stuID + "| Code =" + displayCode);
        }else if(select == 'C'){
            System.out.println("Summary: COUNSELING | " + "ID = "+ stuID + "| Code =" + displayCode);
        }

    }
}