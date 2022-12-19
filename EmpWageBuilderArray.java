package EmployeeWageProblem;

public class EmpWageBuilderArray {
    public static final int IS_PART_TIME = 1;
    public static final int IS_FULL_TIME = 2;
    private int numOfCompany = 0;
    private TotalCompanyEmpWage[] totalCompanyEmpWage;

    public EmpWageBuilderArray(){
        totalCompanyEmpWage = new TotalCompanyEmpWage[5];

    }

    private void addCompanyEmpWage(String company, int empRatePerHour, int numOfWorkingDays, int maxHrsPerMonth){
        totalCompanyEmpWage[numOfCompany] = new TotalCompanyEmpWage(company, empRatePerHour, numOfWorkingDays, maxHrsPerMonth);

        numOfCompany++;
    }

    private void computeEmpWage(){
        for (int i = 0; i < numOfCompany; i++){
            totalCompanyEmpWage[i].setTotalEmpWage(this.computeEmpWage(totalCompanyEmpWage[i]));
            System.out.println(totalCompanyEmpWage[i]);
        }
    }



    public int computeEmpWage(TotalCompanyEmpWage totalCompanyEmpWage) {
        int empHrs = 0;
        int totalEmpHrs = 0;
        int totalWorkingDays = 0;

        String company;
        int empRatePerHour = 0;
        int numOfWorkingDays = 0;
        int maxHrsPerMonth = 0;
        int totalEmpWage = 0;


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


        return totalEmpWage= totalEmpHrs * empRatePerHour;

    }


    public static void main(String[] args) {
        EmpWageBuilderArray c1 = new EmpWageBuilderArray();
        c1.addCompanyEmpWage("tcs", 20, 30, 100);
        c1.addCompanyEmpWage("wipro", 30, 30, 200);
        c1.computeEmpWage();
    }
}

 class CompanyEmpWage {
    private final String company;
    private final int empRatePerHour;
    private final int numOfWorkingDays;
    private final int maxHrsPerMonth;
    private int totalEmpWage;

    public CompanyEmpWage(String company, int empRatePerHour, int numOfWorkingDays, int maxHrsPerMonth) {
        this.company = company;
        this.empRatePerHour = empRatePerHour;
        this.numOfWorkingDays = numOfWorkingDays;
        this.maxHrsPerMonth = maxHrsPerMonth;
    }

    public void setTotalEmpWage(int totalEmpWage) {
        this.totalEmpWage = totalEmpWage;
    }

    public String toString() {
        return "Total EmpWage for Company" + company + "is:" + totalEmpWage;
    }
}
