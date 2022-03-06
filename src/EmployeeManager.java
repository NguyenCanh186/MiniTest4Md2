import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class EmployeeManager {
    public static ArrayList<Employee> employeesArraylist = EmployeeFile.readFile();

    public static void addNewEmployee(Employee newEmployee){
        employeesArraylist.add(newEmployee);
        try {
            EmployeeFile.writeFile(employeesArraylist);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
//    public static void main(String[] args) {
//        showAllEmployee();
//        System.out.println("Menu:");
//        System.out.println("1. them nhan vien");
//        System.out.println("2. xoa nhan vien ");
//        System.out.println("nhap lua chon cua ban: ");
//        Scanner scanner = new Scanner(System.in);
//        int choose = scanner.nextInt();
//        switch (choose){
//            case 1:
//                addNewEmployee();
//            case 2:
//                deleteEmployeeById();
//            default:
//                System.out.println("moi ban nhap lai: ");
//        }
//    }
//
//    public static void showAllEmployee(){
//        for (Employee e: employees
//             ) {
//            System.out.println(e);
//        }
//    }
//
//    public static void deleteEmployeeById(){
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("nhap id nhan vien muon xoa: ");
//        String id = scanner.nextLine();
//        int index = -1;
//        for (int i = 0; i < employees.size(); i++) {
//            if (employees.get(i).getId().equals(id)){
//                index = i;
//            }
//        }
//        if (index == -1){
//            System.out.println("id ban nhap khong co trong danh sach");
//        } else {
//            employees.remove(employees.get(index));
//        }
//        try {
//            EmployeeFile.writeFile(employees);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//
//    public static void addNewEmployee() {
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("nhap thong tin nhan vien: ");
//        System.out.println("1. nhan vien fulltime");
//        System.out.println("2. nhan vien parttime");
//        System.out.println("nhap lua chon cua ban: ");
//        int choose = scanner.nextInt();
//        Employee e = null;
//        if (choose == 1) {
//             e = new EmployeeFulltime();
//            e.input();
//        } else if (choose == 2) {
//             e = new EmployeeParttime();
//            e.input();
//        }
//        if(e != null){
//            employees.add(e);
//        } else {
//            System.out.println("moi ban nhap lai: ");
//        }
//        try {
//            EmployeeFile.writeFile(employees);
//        } catch (IOException ex) {
//            ex.printStackTrace();
//        }
//    }
}
