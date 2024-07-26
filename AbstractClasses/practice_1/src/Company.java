package src;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Company {
    ArrayList<Employee> employeeArrayList = new ArrayList<>();


    private int income;
    public double getCompanyIncome(){
        return income;
    }
    public void hire(Employee employee){employeeArrayList.add(employee);}
    public void fire(Employee employee){employeeArrayList.remove(employee);}
    public void hireAll(Collection<Employee> employee){employeeArrayList.addAll(employee);}
    public  void  setIncome(double amount){income+=amount;}
    public List<Employee> getTopSalaryStaff(int count){
        List<Employee> arrayListTopSalary = new ArrayList<>();
       Collections.sort(employeeArrayList,new ComparatorBySalary().reversed());
        for (int i = 0;i<count;i++){
            arrayListTopSalary.add(employeeArrayList.get(i));
        }
        return arrayListTopSalary;
    }
    public List<Employee> getLowesSalaryStaff(int count){
        List<Employee> arrayListLowesSalary = new ArrayList<>();
        Collections.sort(employeeArrayList,new ComparatorBySalary());

        for (int i = 0;i<count;i++){
            arrayListLowesSalary.add(employeeArrayList.get(i));
        }
        return arrayListLowesSalary;
    }
}
