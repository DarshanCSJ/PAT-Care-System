import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.*;
import javax.swing.*;

public class Edit_Patient_GUI extends JFrame {
    private JTextField text_name;
    private JTextField text_id;
    private JTextField text_age;
    private JTextField text_gender;
    private JTextField text_disabilities;
    private JTextField text_operations;

    private JButton cmdSave;
    private JButton cmdClose;

    private JPanel pnlCommand;
    private JPanel pnlDisplay;

    private Patient patient;
    private JFrame this_frame;

    public Edit_Patient_GUI(Patient patient, JFrame host) {
        this.setTitle("Edit the information for " + patient.get_name());
        this.patient = patient;

        pnlCommand = new JPanel();
        pnlDisplay = new JPanel();

        // Initializing text fields
        text_name = new JTextField(20);
        text_name.setText(patient.get_name());
        text_id = new JTextField(20);
        text_id.setText(Integer.toString(patient.get_id()));
        text_age = new JTextField(20);
        text_age.setText(Integer.toString(patient.get_age()));
        text_gender = new JTextField(20);
        text_gender.setText(patient.get_gender());
        text_disabilities = new JTextField(40);
        text_disabilities.setText(patient.get_disabilities_toString());
        text_operations = new JTextField(100);
        text_operations.setText(patient.get_operations_toString());

        // Creating and adding the text fields to the frame
        pnlDisplay.add(new JLabel("Patient Name:"));
        pnlDisplay.add(text_name);
        pnlDisplay.add(new JLabel("Patient ID#:"));
        pnlDisplay.add(text_id);
        pnlDisplay.add(new JLabel("Patient Age:"));
        pnlDisplay.add(text_age);
        pnlDisplay.add(new JLabel("Patient Gender:"));
        pnlDisplay.add(text_gender);
        pnlDisplay.add(new JLabel("Patient Disabilities:"));
        pnlDisplay.add(text_disabilities);
        pnlDisplay.add(new JLabel("Patient Operations:"));
        pnlDisplay.add(text_operations);
        pnlDisplay.setLayout(new GridLayout(6, 3));

        // Creating, giving functionality to and adding the save and close buttons
        cmdSave = new JButton("Save");
        cmdSave.addActionListener(new savepatientButton());
        cmdClose = new JButton("Close");
        cmdClose.addActionListener(new setVisibleFalse());
        pnlCommand.add(cmdSave);
        pnlCommand.add(cmdClose);

        add(pnlDisplay, BorderLayout.CENTER);
        add(pnlCommand, BorderLayout.SOUTH);
        pack();
        setVisible(true);
    }

    private class savepatientButton implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String name = text_name.getText();
            String id = text_id.getText();
            String age = text_age.getText();
            String gender = text_gender.getText();
            String disabilities = text_disabilities.getText();
            String operations = text_operations.getText();
            /*
             * String[] age = text_age.getText().split("/");
             * int[] date = { 0, 0, 0 };
             * date[0] = Integer.parseInt(ddate[0]);
             * date[1] = Integer.parseInt(ddate[1]);
             * date[2] = Integer.parseInt(ddate[2]);
             * String[] ttime = textTime.getText().split(":");
             * int[] time = { 0, 0 };
             * time[0] = Integer.parseInt(ttime[0]);
             * time[1] = Integer.parseInt(ttime[1]);
             * int expGuests = Integer.parseInt(textGuests.getText());
             */

            // toBeEdited = new Event(name, date, time, id, expGuests);
            patient.change_name(name);
            patient.change_id(Integer.parseInt(id));
            patient.change_age(Integer.parseInt(age));
            patient.change_gender(gender);
            patient.change_disabilities(disabilities);
            // patient.change_operations(name);
            this_frame.setVisible(false);
            JFrame newframe = new JFrame();
            // newframe.add(new patientDetailsGUI(patient, this_frame));
            newframe.pack();
            newframe.setTitle("Patient Details");
            newframe.setVisible(true);
            this_frame.setVisible(false);
        }
    }

    private class setVisibleFalse implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            this_frame.setVisible(false);
        }
    }
}
