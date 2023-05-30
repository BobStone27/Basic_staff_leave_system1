


import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main{

    public static void main(String[] args){

        mainPick();


    }

    public static void mainPick(){
        Scanner scanner = new Scanner(System.in);
        int pickNumber;

        while(true){
            System.out.println("Enter 1 for admin page:\nEnter 2 for Staff page:\n");
            pickNumber = scanner.nextInt();

            if (pickNumber == 1){
                System.out.println("You picked admin page");
                adminLogInPage();
                break;
            }
            else if (pickNumber == 2){
                System.out.println("You picked staff page");
                staffLogInPage();
                break;
            }
            else if (pickNumber <= 0 || pickNumber > 2){
                System.out.println("Wrong number please try again");
            }
            else{
                break;
            }

        }


    }
    public static void adminLogInPage(){
        //The username
        String adminCorrectUsername = "admin";
        //The password
        String adminCorrectPassword = "admin123";

        Scanner adminScanner = new Scanner(System.in);

        while (true){
            //Prompt for username
            System.out.println("Enter the username:");
            String adminUsername = adminScanner.nextLine();

            //Prompt for password
            System.out.println("Enter the password:");
            String adminPassword = adminScanner.nextLine();

            if(adminUsername.equals(adminCorrectUsername) && adminPassword.equals(adminCorrectPassword)){
                System.out.println("Correct Username and password: ");
                admin();
                break;
            }
            else{
                System.out.println("Invalid username or password");
            }
        }
    }
    public static void staffLogInPage(){
        //The staff username
        String staffCorrectUsername = "staff";
        //The staff password
        String staffCorrectPassword = "staff123";

        Scanner staffScanner = new Scanner(System.in);

        while(true){
            //Prompt for username
            System.out.println("Enter the staff username:");
            String staffUsername = staffScanner.nextLine();

            //Prompt for password
            System.out.println("Enter the staff password:");
            String staffPassword = staffScanner.nextLine();

            if(staffUsername.equals(staffCorrectUsername) && staffPassword.equals(staffCorrectPassword)){
                System.out.println("Correct username and password");
                staffPage();
                break;
            }
            else{
                System.out.println("Please try again");
            }


        }
    }
    public static void admin(){
        Scanner adminPickScanner = new Scanner(System.in);
        int adminPick;

        while(true){
            System.out.println("Enter 1 for Add new Staff information\nEnter 2 for update leave balance\nEnter 3 to search for staff leave information\n");
            adminPick = adminPickScanner.nextInt();

            if(adminPick == 1){
                System.out.println("You have pick to enter new staff information");
                addStaff();
                break;
            }
            else if (adminPick == 2){
                System.out.println("You have pick to update leave balance");
                updateStaffLeave();
                break;
            }
            else if (adminPick == 3){
                System.out.println("You have pick to search for staff leave");
                adminSearchStaffLeave();
                break;
            }
            else if (adminPick <= 0 || adminPick > 3){
                System.out.println("Wrong. Please try again");
            }
            else{
                break;
            }
        }

    }
    public static void addStaff(){
        Scanner addStaffInformationScanner = new Scanner(System.in);

        //Staff Name
        System.out.println("Enter the staff name:");
        String staffName = addStaffInformationScanner.nextLine();

        //Staff ID
        System.out.println("Enter the staff ID:");
        int staffID = addStaffInformationScanner.nextInt();
        addStaffInformationScanner.nextLine();

        //Annual Leave
        System.out.println("Enter the staff annual leave: ");
        int staffAnnual = addStaffInformationScanner.nextInt();
        addStaffInformationScanner.nextLine();

        //Compassionate leave
        System.out.println("Enter the staff compassionate leave: ");
        int staffCompassionate = addStaffInformationScanner.nextInt();
        addStaffInformationScanner.nextLine();

        //Emergency leave
        System.out.println("Enter the staff emergency leave: ");
        int staffEmergency = addStaffInformationScanner.nextInt();
        addStaffInformationScanner.nextLine();

        //Medical leave
        System.out.println("Enter the staff medical leave: ");
        int staffMedical = addStaffInformationScanner.nextInt();
        addStaffInformationScanner.nextLine();

        try{
            FileWriter fileWriter = new FileWriter("employeeFile.txt");
            fileWriter.write(staffName + "\n");
            fileWriter.write(staffID + "\n");
            fileWriter.write(staffAnnual + "\n");
            fileWriter.write(staffCompassionate + "\n");
            fileWriter.write(staffEmergency + "\n");
            fileWriter.write(staffMedical + "\n");

            fileWriter.close();

            System.out.println("Success");
        }catch (IOException e){
            System.out.println("Invalid");
            e.printStackTrace();
        }

    }

    public static void updateStaffLeave(){
        Scanner updateLeaveScanner = new Scanner(System.in);

        //Prompt for file name
        System.out.println("Enter the file name:");
        String updateStaffFileName = updateLeaveScanner.nextLine();

        //Prompt for which line
        System.out.println("Enter the line number:");
        int updateStaffLine = updateLeaveScanner.nextInt();
        updateLeaveScanner.nextLine();

        //Prompt for new content
        System.out.println("Enter the new content:");
        String updateStaffContent = updateLeaveScanner.nextLine();

        List<String> lines = new ArrayList<>();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(updateStaffFileName))){
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                lines.add(line);
            }
        }catch (IOException e){
            System.out.println("Error");
            return;
        }

        //Check the lines
        if(updateStaffLine < 1 || updateStaffLine > lines.size()){
            System.out.println("Invalid line number");
            return;
        }

        //Update the specified line
        lines.set(updateStaffLine - 1, updateStaffContent);

        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(updateStaffFileName))){
            for (String line : lines){
                bufferedWriter.write(line);
                bufferedWriter.newLine();
            }
        }catch (IOException e){
            System.out.println("Error");
        }
        System.out.println("New content have update successfully");

    }

    public static void adminSearchStaffLeave(){
        File file = new File("staffFile.txt");

        try{
            FileReader staffFileContentReader = new FileReader(file);
            BufferedReader staffFileBufferedReader = new BufferedReader(staffFileContentReader);

            String readLine;
            while ((readLine = staffFileBufferedReader.readLine()) != null){
                System.out.println(readLine);
            }
            staffFileBufferedReader.close();
            staffFileContentReader.close();
        }catch (IOException e){
            System.out.println("Error");
            e.printStackTrace();
        }



    }

    public static void staffPage(){
        Scanner staffPickScanner = new Scanner(System.in);
        int staffPick;

        while(true){
            System.out.println("Enter 1 to Apply leave:\nEnter 2 to cancel leave:\n");
            staffPick = staffPickScanner.nextInt();

            if (staffPick == 1){
                System.out.println("You pick to apply leave");
                applyLeavePage();
                break;
            }
            else if (staffPick == 2){
                System.out.println("You pick to cancel leave");
                cancelLeavePage();
                break;
            }
            else if (staffPick <= 0 || staffPick > 2){
                System.out.println("Wrong Number. Please try again");
            }
            else{
                break;
            }
        }

    }

    public static void applyLeavePage(){
        Scanner applyLeaveScanner = new Scanner(System.in);

        //Staff Name
        System.out.println("Enter your name:");
        String staffName = applyLeaveScanner.nextLine();

        //Staff ID
        System.out.println("Enter your ID:(Your staff ID)");
        int staffID = applyLeaveScanner.nextInt();
        applyLeaveScanner.nextLine();

        //Staff Leave Type
        System.out.println("Enter your leave type:(Example Medical Leave, Compassionate leave and etc)");
        String leaveType = applyLeaveScanner.nextLine();

        //Leave days
        System.out.println("Enter how many days:");
        String leaveDays = applyLeaveScanner.nextLine();

        //Leave Date
        System.out.println("Enter the date of your leave:");
        String leaveDate = applyLeaveScanner.nextLine();

        try{
            FileWriter staffApplyLeaveWriter = new FileWriter("staffFile.txt");
            staffApplyLeaveWriter.write(staffName + "\n");
            staffApplyLeaveWriter.write(staffID + "\n");
            staffApplyLeaveWriter.write(leaveType + "\n");
            staffApplyLeaveWriter.write(leaveDays + "\n");
            staffApplyLeaveWriter.write(leaveDate + "\n");


            staffApplyLeaveWriter.close();
        }catch (IOException e){
            System.out.println("Error");
            e.printStackTrace();
        }
    }
    public static void cancelLeavePage(){

        String cancelLeaveFie = "staffFile.txt";

        try{
            BufferedWriter cancelLeaveBufferedWriter = new BufferedWriter(new FileWriter(cancelLeaveFie));
            cancelLeaveBufferedWriter.write("");
            cancelLeaveBufferedWriter.close();

            System.out.println("Leave cancel success");

        }catch (IOException e){
            System.out.println("Error");
            e.printStackTrace();
        }

    }




}