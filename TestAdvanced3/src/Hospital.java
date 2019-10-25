import java.util.*;

public class Hospital {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Map<String, List<String>> patientsByDoctors = new HashMap<>();
        Map<String, Map<Integer, List<String>>> departments = new LinkedHashMap<>();
        Map<String, Integer> currentDepartmentRoom = new HashMap<>();

        while (true) {
            String input = scan.nextLine();

            if (input.equals("Output")) {
                break;
            }

            String[] data = input.split(" ");

            String department = data[0];
            String doctor = data[1] + " " + data[2];
            String patient = data[3];

            patientsByDoctors.putIfAbsent(doctor, new ArrayList<>());
            patientsByDoctors.get(doctor).add(patient);

            if (!departments.containsKey(department)) {
                departments.put(department, new LinkedHashMap<>());
                currentDepartmentRoom.put(department, 1);
                departments.get(department).put(1, new ArrayList<>());
                departments.get(department).get(1).add(patient);
            } else {
                if (departments.get(department).size() < 20) {
                    if (departments.get(department).get(currentDepartmentRoom.get(department)).size() == 3) {
                        currentDepartmentRoom.replace(department, currentDepartmentRoom.get(department) + 1);
                        departments.get(department).put(currentDepartmentRoom.get(department), new ArrayList<>());
                        departments.get(department).get(currentDepartmentRoom.get(department)).add(patient);
                    } else {
                        departments.get(department).get(currentDepartmentRoom.get(department)).add(patient);
                    }
                } else if (departments.get(department).size() == 20) {
                    if (departments.get(department).get(currentDepartmentRoom.get(department)).size() < 3) {
                        departments.get(department).get(currentDepartmentRoom.get(department)).add(patient);
                    }
                }
            }
        }

        while (true) {
            String input = scan.nextLine();

            if (input.equals("End")) {
                break;
            }

            String[] cmd = input.split(" ");

            if (cmd.length == 2) {
                if (isInteger(cmd[1])) {
                    String department = cmd[0];
                    int room = Integer.parseInt(cmd[1]);

                    departments.get(department).get(room).stream()
                            .sorted(String::compareTo)
                            .forEach(System.out::println);

                } else {
                    String doctor = cmd[0] + " " + cmd[1];

                    patientsByDoctors.get(doctor).stream()
                            .sorted(String::compareTo)
                            .forEach(System.out::println);
                }

            } else {
                departments.get(input).entrySet().stream().forEach(entry -> {
                    for (String patient : entry.getValue()) {
                        System.out.println(patient);
                    }
                });
            }
        }
    }

    private static boolean isInteger(String value) {
        try {
            Integer.parseInt(value);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
