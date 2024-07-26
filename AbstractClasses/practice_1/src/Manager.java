package src;

public class Manager implements Employee {
    Company company;
    double monthSalary;
    double bonusSalary=0.05;
    double earnind;

    public Manager(Company company){
        this.company=company;
        this.earnind=(int)(Math.random()*25_001+115_000);
        this.monthSalary= fixSalary()+earnind*bonusSalary;
        company.setIncome(earnind);

    }


    @Override
    public double getMonthSalary(){

        return monthSalary;
    }
    public String toString(){
        return  "\n" + getMonthSalary()+" руб.";
    }
    public double fixSalary(){
        monthSalary=60000;
        return  monthSalary;
    }
}
