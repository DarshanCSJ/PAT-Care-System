import java.util.Scanner;
import java.util.ArrayList;
import java.io.File;  // Import the File class
import java.io.IOException;

public class DataCollection {
    public static void main(String[] args){

        String patient_name1;
        String patient_name2;
        String patient_DOB;
        String patient_gender;
        String patient_last_surgery;
        String lastop_time;
        String op_time;
        String correct_op;
        String patient_operation;
        String DOB_edit;
        String patient_id;
        String id_edit;
        int DOB_length;
        String patient_disability1;
        String patient_disability2;
        String disability_checker;
        String disability_yes;
        String multiplicity;
        String finalcheck;

        File myObj = new File("patientdata.txt");

        ArrayList<String> patient_data = new ArrayList<String>();

        Scanner sc = new Scanner(System.in);

        System.out.print( "Welcome XXX, please enter the following required patient data." );

        System.out.print("Please enter the patient's name.");
        patient_name1 = sc.nextLine();
            
        if(patient_name1.matches("[a-zA-Z]+")){
            System.out.print("The first name, " +patient_name1+ " , has been accepted.\n");
            patient_data.add(patient_name1);
            
        }
        else if(patient_name1.matches("[a-zA-Z]+") == false){
            System.out.print("The given name contains an invalid character.\n");
            System.exit(0); 
            
        }
        else if(patient_name1 == "" ){
            System.out.print( "No name was entered." );
            System.exit(0); 
        }

        System.out.print("Please enter " +patient_name1+ "'s last name.\n");
        patient_name2 = sc.nextLine();
            
        if(patient_name2.matches("[a-zA-Z]+")){
            System.out.print("The last name, " +patient_name2+ " , has been accepted.\n");
            patient_data.add(patient_name2);
            
        }
        else if(patient_name1.matches("[a-zA-Z]+") == false){
            System.out.print("The given name contains an invalid character.\n");
            System.exit(0); 
            
        }
        else if(patient_name1 == "" ){
            System.out.print( "No name was entered.\n" );
            System.exit(0); 
        }


       System.out.print("What is " +patient_name1+ "'s D.O.B ? N.B Please do it as XX/XX/XX\n");
       patient_DOB = sc.nextLine();
       patient_data.add(patient_DOB);

       DOB_length = patient_DOB.length();

       if(DOB_length >= 9){
        System.out.print("Too many characters have been entered for the DOB\n");
        System.out.print("Please enter a valid DOB.");
        patient_DOB = sc.nextLine();
       }
       else if(DOB_length < 8){
        System.out.print("Too little characters have been entered for the DOB\n");
        System.out.print("Please enter a valid DOB.");
        patient_DOB = sc.nextLine();
       }

       System.out.print("To confirm " +patient_name1+ " " +patient_name2+ " 's DOB is " +patient_DOB+ " ?\n");
       System.out.print("Please respond with Y for yes or N for no.\n");
       DOB_edit=sc.nextLine();

       if(DOB_edit.matches("Y")){
        System.out.print("The given DOB has been recorded for " +patient_name1+ ".\n");

       }
       else if(DOB_edit.matches("N")){
        System.out.print("Please enter the correct DOB\n");
        patient_DOB=sc.nextLine();
        patient_data.add(patient_DOB);
        System.out.print("The new DOB " +patient_DOB+ ".\n");
       }

       System.out.print("Please enter " +patient_name1+ "'s ID number.\n");
       patient_id = sc.nextLine();
       patient_data.add(patient_id);

       System.out.print("To confirm the id number is " +patient_id+ " .\n");
       System.out.print("Please respond with Y for yes or N for no.\n");
       id_edit=sc.nextLine();

       if(id_edit.matches("Y")){
        System.out.print("The given ID number has been recorded for " +patient_name1+ ".\n");
       }
       else if(id_edit.matches("N")){
        System.out.print("Please enter the correct ID number.\n");
        patient_id=sc.nextLine();
        patient_data.add(patient_id);
        System.out.print("The new ID number is  " +patient_id+ ".\n");
       }

       System.out.print("What gender is " +patient_name1+ "'s ? Please respond with M for male or F for female.\n");
        patient_gender = sc.nextLine();
        patient_data.add(patient_gender);
        if(patient_gender.matches("M")){
            System.out.print("The stored gender is male.\n");
        }
        else if(patient_gender.matches("F")){
            System.out.print("The recorded gender is female.\n");
        }

        System.out.print("Does " +patient_name1+ " have any disabilities?\n");
        System.out.print("Respond with Y for yes and N for no\n");
        disability_checker = sc.nextLine();
        if(disability_checker.matches("N")){
            System.out.print("No disability will be recorded for " +patient_name1+ ".\n");

        }
        else if(disability_checker.matches("Y")){
            System.out.print("How many disabilities does " +patient_name1+ " have? Please select only 1 or 2. \n");
            disability_yes=sc.nextLine();
            if(disability_yes.matches("1")){
                System.out.print("What disability does " +patient_name1+ " have?\n");
                patient_disability1 = sc.nextLine();
                patient_data.add(patient_disability1);
            }
            else if(disability_yes.matches("2")){
                System.out.print("Please enter" +patient_name1+ "first disability\n");
                patient_disability1 = sc.nextLine();
                patient_data.add(patient_disability1);
                System.out.print("Please enter " +patient_name1+ "second disability\n");
                patient_disability2 = sc.nextLine();
                patient_data.add(patient_disability2);

                System.out.print("The recorded disabilities are" +patient_disability1+ " and " +patient_disability2+ " .\n");

            }
            }

            System.out.print("What was " +patient_name1+ " last surgery? Please eneter N/A if there aren't any.\n ");
            patient_last_surgery = sc.nextLine();
            patient_data.add(patient_last_surgery);
            
            if(patient_last_surgery.matches("N/A")){
                System.out.print("No recent surgery has been stored in " +patient_name1+ "'s file. \n");
            }
            else{
                System.out.print("The last recorded surgey is " +patient_last_surgery+ " . \n");
                System.out.print("What was the date of " +patient_last_surgery+ " ? Please enter it as XX/XX/XX\n");
                lastop_time = sc.nextLine();
                patient_data.add(lastop_time);
                System.out.print("The date of the last operation has been recorded.\n");
            }

            System.out.print("What is the current opperation required for " +patient_name1+ " ?\n" );
            patient_operation = sc.nextLine();
            System.out.print(patient_operation+ " has been recorded as the current operation for " +patient_name1+ ".\n");
            System.out.print("What is the date of the upcoming operation?\n");
            op_time = sc.nextLine();
            patient_data.add(op_time);
            System.out.print("The recorded date for the upcoming operation has been stored as " +op_time+ ", is this correct? Please respond with Y for yes and N for no.\n");
            correct_op = sc.nextLine();
            if(correct_op.matches("Y")){
                System.out.print("The date " +op_time+ " has been recorded.\n");

            }
            else if(correct_op.matches("N")){
                System.out.print("What is the correct date?\n");
                op_time = sc.nextLine();
                patient_data.add(op_time);
            }

            else{
                System.out.print("An invalid character has been recorded.\n");
                System.exit(0);
            }

            System.out.print("What is the current multiplicity of the upcoming operation?\n");
            multiplicity = sc.nextLine();
            patient_data.add(multiplicity);
            System.out.print("The recorded multiplicity is " +multiplicity+ ".\n");


            //saving to arraylist


            System.out.print("To confirm is the current information correct? " +patient_data+ " ?\n");
            System.out.print("Please respond with Y for yes and N for no\n");
            finalcheck=sc.nextLine();
            if(finalcheck.matches("Y")){
                System.out.print("The data for " +patient_name1+ " has been recorded\n");
            }
            

            









            









        }
        











    
}


