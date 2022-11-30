import java.util.ArrayList;
import java.util.Arrays;

public class Patient {
    private String name;
    private int id;
    private int age;
    private String gender;
    private ArrayList<String> disabilities = new ArrayList<>();
    private ArrayList<Operation> operation_list = new ArrayList<>();

    public Patient(String nname, String iid, String aage, String ggender, String dddisabilities, String ooop_list) {
        name = nname;
        id = Integer.parseInt(iid);
        age = Integer.parseInt(aage);
        gender = ggender;
        String ddisabilities[] = dddisabilities.split(" ");
        for (int i = 0; i < ddisabilities.length; i++) {
            disabilities.add(ddisabilities[i]);
        }
        String oop_list[] = ooop_list.split(" ");
        for (int i = 0; i < oop_list.length; i++) {
            String op_name = oop_list[i].split(";")[0];
            String op_date = oop_list[i].split(";")[1];
            operation_list.add(new Operation(op_name, op_date));
        }
    }

    public String get_name() {
        return name;
    }

    public int get_id() {
        return id;
    }

    public int get_age() {
        return age;
    }

    public String get_gender() {
        return gender;
    }

    public ArrayList<String> get_disabilities() {
        return disabilities;
    }

    public String get_disabilities_toString() {
        String disabilities_str = "";
        for (int i = 0; i < disabilities.size(); i++) {
            if (i != disabilities.size()) {
                disabilities_str += disabilities.get(i) + ", ";
            } else {
                disabilities_str += disabilities.get(i);
            }
        }
        return disabilities_str;
    }

    public ArrayList<Operation> get_operation_list() {
        return operation_list;
    }

    public String get_operations_toString() {
        String operations_str = "";
        for (int i = 0; i < operation_list.size(); i++) {
            if (i != operation_list.size()) {
                operations_str += operation_list.get(i).get_name() + ", ";
            } else {
                operations_str += operation_list.get(i).get_name();
            }
        }
        return operations_str;
    }

    public void change_name(String nname) {
        name = nname;
    }

    public void change_id(int iid) {
        id = iid;
    }

    public void change_age(int aage) {
        age = aage;
    }

    public void change_gender(String ggender) {
        gender = ggender;
    }

    public void change_disabilities(String dddisabilities) {
        String[] ddisabilities = dddisabilities.split(" ");
        disabilities = (ArrayList<String>) Arrays.asList(ddisabilities);
    }

    public void add_disability(String disability) {
        disabilities.add(disability);
    }

    public void remove_disability(String disability) {
        for (int i = 0; i < disabilities.size(); i++) {
            if (disabilities.get(i) == disability) {
                disabilities.remove(i);
            }
        }
    }

    public void add_operation(Operation operation) {
        operation_list.add(operation);
    }

    public void remove_operation(Operation operation) {
        for (int i = 0; i < operation_list.size(); i++) {
            if (operation_list.get(i).equals(operation)) {
                operation_list.remove(i);
            }
        }
    }
    /*
     * public void change_operations(String oooperations) {
     * Operation[] ooperations = new Operation(oooperations.split(" ")[i]);
     * operation_list = (ArrayList<Operation>) Arrays.asList(ooperations);
     * }
     */
}
