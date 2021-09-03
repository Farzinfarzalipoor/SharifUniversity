import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static EmployeeArray employees = new EmployeeArray();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        int input = 0;
        do {
            System.out.println("Choose your option: \n" +
                    "1)Add employee \n" +
                    "2)Add spouse \n" +
                    "3)Is married? \n" +
                    "4)Is invited? \n" +
                    "5)Invited employees list \n" +
                    "6)Exit");
            input = sc.nextInt();

            switch (input) {
                case 1:
                    addEmployee();
                    break;
                case 2:
                    addSpouse();
                    break;
                case 3:
                    married();
                    break;
                case 4:
                    System.out.println("Enter employee id: ");
                    int employeeId = sc.nextInt();
                    if (invited(employeeId)) {
                        System.out.println(employees.getEmployeeById(employeeId).getName() +
                                employees.getEmployeeById(employeeId).getLastName() +
                                " Is invited");
                    } else {
                        System.out.println(employees.getEmployeeById(employeeId).getName() +
                                employees.getEmployeeById(employeeId).getLastName()
                                + " Is not invited");
                    }
                    break;
                case 5:
                    invitedList();
                    break;
                case 6:
                    System.out.println("Exit");
                default:
                    System.out.println("You entered a wrong number");

            }
        } while (input != 6);
    }

    private static void addEmployee() {
        System.out.println("Enter employee id: ");
        int id = sc.nextInt();
        System.out.println("Enter employee name: ");
        String name = sc.next();
        System.out.println("Enter employee last name: ");
        String lastName = sc.next();
        System.out.println("Enter employee gender: ");
        char gender = sc.next().charAt(0);
        System.out.println("Enter employee latitude: ");
        double latitude = sc.nextDouble();
        System.out.println("Enter employee longitude: ");
        double longitude = sc.nextDouble();
        employees.add(new Employee(id, name, lastName, gender, latitude, longitude));
    }

    private static void addSpouse() {
        System.out.println("Enter employee id: ");
        int employeeId = sc.nextInt();
        System.out.println("Enter spouse id: ");
        int spouseId = sc.nextInt();
        employees.getEmployeeById(employeeId).setSpouseId(spouseId);
        employees.getEmployeeById(spouseId).setSpouseId(employeeId);
    }

    private static void married() {
        System.out.println("Enter employee id: ");
        int employeeId = sc.nextInt();
        Employee temp = employees.getEmployeeById(employeeId);
        if (temp.isMarried()) {
            System.out.println("Employee is married to employee " +
                    employees.getEmployeeById(temp.getSpouseId()).getName() +
                    employees.getEmployeeById(temp.getSpouseId()).getLastName() +
                    " with id " + temp.getSpouseId());
        } else {
            System.out.println(employees.getEmployeeById(employeeId).getName() +
                    employees.getEmployeeById(temp.getSpouseId()).getLastName() +
                    " Employee is single");
        }
    }

    private static boolean invited(int employeeId) {
        Employee temp = employees.getEmployeeById(employeeId);
        if (temp != null && temp.isMarried() && getDistance(temp.getLatitude(), temp.getLongitude()) < 30) {
            return true;
        } else {
            return false;
        }
    }

    public static double getDistance(double latEmployee, double longEmployee) {
        final double radius = 6391.2;
        double latEmployeeRad = Math.toRadians(latEmployee);
        double longEmployeeRad = Math.toRadians(longEmployee);
        double latSharif = Math.toRadians(SharifUni.LATITUDE);
        double longSharif = Math.toRadians(SharifUni.LONGITUDE);
        double x1 = Math.sin(latEmployeeRad);
        double z1 = Math.cos(latEmployeeRad);
        double x2 = Math.sin(latSharif);
        double z2 = Math.cos(latSharif);
        double x3 = Math.cos(longSharif - longEmployeeRad);
        double a = (x1 * x2) + (z1 * z2 * x3);
        return ((radius * Math.acos(a)) + 0.5);
    }

    private static void invitedList() {
        for (int i = 0; i < employees.getIndex(); i++) {
            if (invited(employees.getEmployeeByIndex(i).getId())) {
                System.out.println(employees.getEmployeeByIndex(i));
            }
        }
    }

}

