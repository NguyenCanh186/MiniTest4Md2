package storage;

import model.Employee;

import java.io.*;
import java.util.ArrayList;

public class EmployeeFromFileBinary implements iEmployeeData{
    @Override
    public ArrayList<Employee> readFile() {
        File file = new File("list.employee");
        try {
            FileInputStream fis = new FileInputStream(file);
            ObjectInputStream ois = new ObjectInputStream(fis);
            Object result = ois.readObject();
            ArrayList<Employee> employees = (ArrayList<Employee>) result;
            ois.close();
            fis.close();
            return employees;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
    }

    @Override
    public void writeFile(ArrayList<Employee> arrayList) throws IOException {
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        try {
            fos = new FileOutputStream("list.employee");
            oos = new ObjectOutputStream(fos);
            oos.writeObject(arrayList);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            oos.close();
            fos.close();
        }
    }
}
