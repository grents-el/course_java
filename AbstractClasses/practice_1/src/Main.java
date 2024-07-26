package src;

public class Main {
    public static void main(String[] args){
        Company company = new Company();
        int countManager = 80;
        int countOperator = 180;
        int countTopManager=10;

        for (int o = 0;o< countOperator;o++){
            company.hire(new Operator());
        }
        for (int m = 0;m< countManager;m++){
            company.hire(new Manager(company));
        }
        for (int tM = 0;tM< countTopManager;tM++){
            company.hire(new TopManager(company));
        }
        System.out.println("Самые высокие зарплаты в компании "+company.getTopSalaryStaff(5));
        System.out.println("Самые низкие зарплаты в компании "+company.getLowesSalaryStaff(5));

        for(int o =0;o<countOperator/2;o++){
            company.fire(company.employeeArrayList.get(o));
        }
        for(int m =0;m<countManager/2;m++){
            company.fire(company.employeeArrayList.get(m));
        }
        for(int tM =0;tM<countTopManager/2;tM++){
            company.fire(company.employeeArrayList.get(tM));
        }
        System.out.println("После увольнения: ");
        System.out.println("Самые высокие зарплаты в компании "+company.getTopSalaryStaff(5));
        System.out.println("Самые низкие зарплаты в компании "+company.getLowesSalaryStaff(5));

}

}

