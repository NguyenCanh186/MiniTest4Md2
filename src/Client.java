import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Client {
    private static ArrayList<Employee> employees = EmployeeManager.employeesArraylist;

    public static void showAllEmployee(){
        for (Employee e: employees
             ) {
            System.out.println(e);
        }
    }

    public static void main(String[] args) {
        showAllEmployee();
        System.out.println("Menu:");
        System.out.println("1. them nhan vien");
        System.out.println("2. xoa nhan vien ");
        System.out.println("3. chinh sua ");
        System.out.println("nhap lua chon cua ban: ");
        Scanner scanner = new Scanner(System.in);
        int choose = scanner.nextInt();
        switch (choose) {
            case 1:
                Scanner scanner100 = new Scanner(System.in);
                System.out.println("1. them nhan vien fulltime");
                System.out.println("2. them nhan vien parttime");
                System.out.println("nhap lua chon cua ban: ");
                int choose1 = scanner100.nextInt();
                switch (choose1){
                    case 1:
                        addNewEmployeeFullTime();
                        break;
                    case 2:
                        addNewEmployeePartTime();
                        break;
                }
                break;
            case 2:
                deleteEmployeeById();
                break;
            case 3:
                editEmployeeById();
                break;
            default:
                System.out.println("moi ban nhap lai: ");
        }
    }

    public static void editEmployeeById(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("nhap id nhan vien muon chinh sua: ");
        String id = scanner.nextLine();
        for (int i = 0; i < employees.size(); i++) {
            if (employees.get(i).getId().equals(id) &&
                    employees.get(i) instanceof EmployeeFulltime){
                System.out.println("Nhap ho ten: ");
                Scanner scanner2 = new Scanner(System.in);
                String fullName = scanner2.nextLine();

                System.out.println("Nhap tuoi: ");
                Scanner scanner3 = new Scanner(System.in);
                int age = scanner3.nextInt();

                System.out.println("Nhap so dien thoai: ");
                Scanner scanner4 = new Scanner(System.in);
                int phoneNumber = scanner4.nextInt();

                System.out.println("Nhap email: ");
                Scanner scanner5 = new Scanner(System.in);
                String email = scanner5.nextLine();

                System.out.println("nhap so tien thuong: ");
                Scanner scanner6 = new Scanner(System.in);
                double bonus = scanner6.nextDouble();

                System.out.println("nhap so tien phat: ");
                Scanner scanner7 = new Scanner(System.in);
                double fineMoney = scanner7.nextDouble();

                System.out.println("nhap luong co ban: ");
                Scanner scanner8 = new Scanner(System.in);
                double basicSalary = scanner8.nextDouble();

                employees.get(i).setFullName(fullName);
                employees.get(i).setAge(age);
                employees.get(i).setPhoneNumber(phoneNumber);
                employees.get(i).setEmail(email);
                ((EmployeeFulltime) employees.get(i)).setBonus(bonus);
                ((EmployeeFulltime) employees.get(i)).setFineMoney(fineMoney);
                ((EmployeeFulltime) employees.get(i)).setBasicSalary(basicSalary);
                break;
            } else if (employees.get(i).getId().equals(id) &&
                    employees.get(i) instanceof EmployeeParttime){
                System.out.println("Nhap ho ten: ");
                Scanner scanner2 = new Scanner(System.in);
                String fullName = scanner2.nextLine();

                System.out.println("Nhap tuoi: ");
                Scanner scanner3 = new Scanner(System.in);
                int age = scanner3.nextInt();

                System.out.println("Nhap so dien thoai: ");
                Scanner scanner4 = new Scanner(System.in);
                int phoneNumber = scanner4.nextInt();

                System.out.println("Nhap email: ");
                Scanner scanner5 = new Scanner(System.in);
                String email = scanner5.nextLine();

                System.out.println("nhap so gio lam them cua ban: ");
                Scanner scanner6 = new Scanner(System.in);
                double workHour = scanner6.nextDouble();

                employees.get(i).setFullName(fullName);
                employees.get(i).setAge(age);
                employees.get(i).setPhoneNumber(phoneNumber);
                employees.get(i).setEmail(email);
                ((EmployeeParttime) employees.get(i)).setWorkHour(workHour);
                break;
            }
        }
        try {
            EmployeeFile.writeFile(employees);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

        public static void deleteEmployeeById(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("nhap id nhan vien muon xoa: ");
        String id = scanner.nextLine();
        int index = -1;
        for (int i = 0; i < employees.size(); i++) {
            if (employees.get(i).getId().equals(id)){
                index = i;
            }
        }
        if (index == -1){
            System.out.println("id ban nhap khong co trong danh sach");
        } else {
            employees.remove(employees.get(index));
        }
        try {
            EmployeeFile.writeFile(employees);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Employee createNewEmployeeFullTime(){
              Employee ef = null;
             Scanner scanner1 = new Scanner(System.in);
            System.out.println("Nhap ma nhan vien: " );
            String id = scanner1.nextLine();

            System.out.println("Nhap ho ten: ");
            Scanner scanner2 = new Scanner(System.in);
            String fullName = scanner2.nextLine();

            System.out.println("Nhap tuoi: ");
            Scanner scanner3 = new Scanner(System.in);
            int age = scanner3.nextInt();

            System.out.println("Nhap so dien thoai: ");
            Scanner scanner4 = new Scanner(System.in);
            int phoneNumber = scanner4.nextInt();

            System.out.println("Nhap email: ");
            Scanner scanner5 = new Scanner(System.in);
            String email = scanner5.nextLine();

            System.out.println("nhap so tien thuong: ");
            Scanner scanner6 = new Scanner(System.in);
            double bonus = scanner6.nextDouble();

            System.out.println("nhap so tien phat: ");
            Scanner scanner7 = new Scanner(System.in);
            double fineMoney = scanner7.nextDouble();

            System.out.println("nhap luong co ban: ");
            Scanner scanner8 = new Scanner(System.in);
            double basicSalary = scanner8.nextDouble();


        return ef  = new EmployeeFulltime(id, fullName, age, phoneNumber
            , email, bonus, fineMoney, basicSalary);
    }

    public static Employee createNewEmployeePartTime(){
        Employee ep = null;
        Scanner scanner1 = new Scanner(System.in);
        System.out.println("Nhap ma nhan vien: " );
        String id = scanner1.nextLine();

        System.out.println("Nhap ho ten: ");
        Scanner scanner2 = new Scanner(System.in);
        String fullName = scanner2.nextLine();

        System.out.println("Nhap tuoi: ");
        Scanner scanner3 = new Scanner(System.in);
        int age = scanner3.nextInt();

        System.out.println("Nhap so dien thoai: ");
        Scanner scanner4 = new Scanner(System.in);
        int phoneNumber = scanner4.nextInt();

        System.out.println("Nhap email: ");
        Scanner scanner5 = new Scanner(System.in);
        String email = scanner5.nextLine();

        System.out.println("nhap so gio lam them cua ban: ");
        Scanner scanner6 = new Scanner(System.in);
        double workHour = scanner6.nextDouble();
        return ep = new EmployeeParttime(id, fullName, age, phoneNumber, email, workHour);
    }

    public static void addNewEmployeeFullTime(){
        EmployeeManager.employeesArraylist = employees;
        Employee employee = createNewEmployeeFullTime();
        EmployeeManager.addNewEmployee(employee);
    }

    public static void addNewEmployeePartTime(){
        EmployeeManager.employeesArraylist = employees;
        Employee employee1 = createNewEmployeePartTime();
        EmployeeManager.addNewEmployee(employee1);
    }
}
