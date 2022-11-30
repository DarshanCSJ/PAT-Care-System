public class Operation {
    private String name;
    private int[] date = { 0, 0, 0 };

    public Operation(String nname, String dddate) {
        name = nname;
        String[] ddate = dddate.split("/");
        for (int i = 0; i < 3; i++) {
            date[i] = Integer.parseInt(ddate[i]);
        }
    }

    public String get_name() {
        return name;
    }

    public String get_date_string() {
        return date[0] + "-" + date[1] + "-" + date[2];
    }

    public String operation_to_string() {
        return name + " done on " + get_date_string();
    }
}
