package src;

public class Operator implements Employee {
    double monthSalary =60000;
    public  String toString(){return "\n" + getMonthSalary()+" руб.";}
    public double getMonthSalary(){
        return fixSalary();
    }
    public double fixSalary(){
        monthSalary = 60000;
        return monthSalary;
    }

}
