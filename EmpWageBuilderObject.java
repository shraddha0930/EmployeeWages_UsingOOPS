package EmployeeWageProblem;

public class EmpWageBuilderObject {
    public static final int IS_PART_TIME = 1;
    public static final int IS_FULL_TIME = 2;

    private final String company;
    private final int empRatePerHour;
    private final int numOfWorkingDays;
    private final int maxHrsPerMonth;
    private int totalEmpWage;

    public EmpWageBuilderObject(String company, int empRatePerHour, int numOfWorkingDays, int maxHrsPerMonth ){
        this.company = company;
        this.empRatePerHour = empRatePerHour;
        this.numOfWorkingDays = numOfWorkingDays;
        this.maxHrsPerMonth = maxHrsPerMonth;
    }


    public void EmpWage() {
        int empHrs = 0;
        int totalEmpHrs = 0;
        int totalWorkingDays = 0;
        while (totalEmpHrs <= maxHrsPerMonth &&
                totalWorkingDays < numOfWorkingDays){
            totalWorkingDays++;
            int empCheck = (int) Math.floor(Math.random() * 10) % 3;
            switch (empCheck) {

                case IS_PART_TIME:
                    empHrs = 4;
                    break;
                case IS_FULL_TIME:
                    empHrs = 8;
                    break;
                default:
                    empHrs = 0;

            }
            totalEmpHrs += empHrs;
            System.out.println("Day#:" + totalWorkingDays + "Emp Hr:" +empHrs);
        }
        int totalEmpWage= totalEmpHrs * empRatePerHour;
    }
    public String tostring(){
        return "Total EmpWage for company" +company+ "is:" +totalEmpWage;

    }


    public static void main(String[] args) {
        EmpWageBuilderObject c1 = new EmpWageBuilderObject("tcs", 20, 30, 100 );
        System.out.println(c1);
        c1.EmpWage();
        EmpWageBuilderObject c2 = new EmpWageBuilderObject("wipro", 40, 30, 200 );
        System.out.println(c2);
        c2.EmpWage();
    }
}
