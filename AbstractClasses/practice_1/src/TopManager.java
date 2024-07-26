package src;

public class TopManager implements Employee {
    Company company;
    double monthSalary;
    double bonusSalary=1.5;

    public  TopManager(Company company){
        this.company=company;
        monthSalary=calcMonthS();
    }

    public double calcMonthS(){
        if (company.getCompanyIncome()>=10_000_000){
            monthSalary = fixSalary()+fixSalary()*bonusSalary;
        }
        return  monthSalary;
    }
    public double getMonthSalary(){
        return monthSalary;
    }
    public String toString(){
        return  "\n" + getMonthSalary()+" руб.";
    }
    public double fixSalary(){
        monthSalary=(int)(Math.random()*25_001+60_000);
        return  monthSalary;
    }
}
