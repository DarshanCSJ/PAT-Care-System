import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;

public class Patient_Manager {
    private File patient_doc;
    private Scanner reader;
    private ArrayList<Patient> patient_list = new ArrayList<>();

    public Patient_Manager(String doc_name) {
        try {
            patient_doc = new File(doc_name);
            reader = new Scanner(patient_doc);
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred when trying to open the file");
            e.printStackTrace();
        }
        make_patients_list();
    }

    public void make_patients_list() {
        try {
            while (reader.hasNextLine()) {
                String line = reader.nextLine();
                String patient[] = line.split(" ");
                patient_list.add(new Patient(patient[0], patient[1], patient[2], patient[3], patient[4], patient[5]));
            }
        } catch (IllegalStateException e) {
            System.out.println("An error occurred when trying to read the file");
            e.printStackTrace();
        }
    }

    public ArrayList<Patient> get__patient_list() {
        return patient_list;
    }

    public boolean check_patient(Patient patient) {
        for (int i = 0; i < patient_list.size(); i++) {
            if (patient_list.get(i).equals(patient)) {
                return true;
            }
        }
        return false;
    }

    public void add_patient(Patient patient) {
        for (int i = 0; i < patient_list.size(); i++) {
            if (patient_list.get(i).equals(patient)) {
                return;
            }
        }
        patient_list.add(patient);
    }
}
