package src;

import java.util.Comparator;

public class ComparatorBySalary implements Comparator<Employee> {

    @Override
    public int compare(Employee o1,Employee o2){return  Double.compare(o1.getMonthSalary(),o2.getMonthSalary());}
}
