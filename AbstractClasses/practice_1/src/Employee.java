package src;

public interface Employee extends Comparable<Employee>{
    double getMonthSalary();
    default int compareTo(Employee o){return Integer.compare((int) o.getMonthSalary(), (int) this.getMonthSalary());}
}
