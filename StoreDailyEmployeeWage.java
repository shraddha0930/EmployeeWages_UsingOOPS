package EmployeeWageProblem;

import java.util.ArrayList;
import java.util.HashMap;

interface StoreDailyEmployeeWage {
    public void addCompany(String companyName, int wagePerHr, int maxWorkingDays, int maxWorkingHrs);

    public void calculateTotalWage();

}

class DailyCompanyEmpWage {
    // instance constants
    static String COMPANY_NAME = new String();
    final int WAGE_PER_HR;
    final int MAX_WORKING_DAYS;
    final int MAX_WORKING_HRS;
    // instance variable
    int totalEmpWage;

    DailyCompanyEmpWage(String companyName, int wagePerHr, int maxWorkingDays, int maxWorkingHrs)
    {
        COMPANY_NAME = companyName;
        WAGE_PER_HR = wagePerHr;
        MAX_WORKING_DAYS = maxWorkingDays;
        MAX_WORKING_HRS = maxWorkingHrs;
        totalEmpWage = 0;
    }

    void setTotalEmployeeWage(int totalEmpWage)
    {
        this.totalEmpWage = totalEmpWage;
    }

    @Override
    public String toString()
    {
        System.out.println("Details of " + COMPANY_NAME + " employee");
        System.err.println("Wage per hour:" + WAGE_PER_HR);
        System.out.println("Maximum working days:" + MAX_WORKING_DAYS);
        System.out.println("Maximum working hours:" + MAX_WORKING_HRS);
        return "Total wage for company" + COMPANY_NAME + " is: " + totalEmpWage;
    }

    public void setTotalEmpWage(int computeEmpWage) {
        this.totalEmpWage = totalEmpWage;
    }
}

class EmployeeWageDailyComputation implements StoreDailyEmployeeWage {
    // class constants
    public static final int PART_TIME = 1;
    public static final int FULL_TIME = 2;
    // instance variables
    int noOfCompanies;
    ArrayList<TotalCompanyEmpWage> companyEmpWageList;
    HashMap<String, Integer> totalEmpWages;

    public EmployeeWageDailyComputation(int noOfCompanies) {
        companyEmpWageList = new ArrayList<>();
        totalEmpWages = new HashMap<>();

    }

    public void addCompany(String companyName, int wagePerHr, int maxWorkingDays, int maxWorkingHrs) {
        TotalCompanyEmpWage companyEmpWage = new TotalCompanyEmpWage(companyName, wagePerHr, maxWorkingDays, maxWorkingHrs);
        companyEmpWageList.add(companyEmpWage);
        totalEmpWages.put(companyName,0);
    }

    int generateEmployeeType() {
        return (int) (Math.random() * 100) % 3;
    }

    int getWorkingHrs(int empType) {
        switch (empType) {
            case FULL_TIME:
                return 8;
            case PART_TIME:
                return 4;
            default:
                return 0;
        }
    }

    public void calculateTotalWage() {
        for (TotalCompanyEmpWage company : companyEmpWageList) {
            int totalWage = calculateTotalWage(company);
            company.setTotalEmployeeWage(totalWage);
            System.out.println(company);
        }
    }

    int calculateTotalWage(TotalCompanyEmpWage totalCompanyEmpWage) {
        System.out.println("Computation of total wage of " + totalCompanyEmpWage.COMPANY_NAME + " employee");
        System.out.println("Day");
        System.out.println("Workinghrs");
        System.out.println("Wage");
        System.out.println("Total working hrs");

        int workingHrs, totalWage = 0;
        for (int day = 1, totalWorkingHrs = 0; day <= totalCompanyEmpWage.MAX_WORKING_DAYS
                && totalWorkingHrs <= totalCompanyEmpWage.MAX_WORKING_HRS; day++, totalWorkingHrs += workingHrs) {
            int empType = generateEmployeeType();
            workingHrs = getWorkingHrs(empType);
            int wage = workingHrs * totalCompanyEmpWage.WAGE_PER_HR;
            totalWage += wage;
            System.out.println(" " + day + " " + workingHrs + " " + wage + " " + totalWorkingHrs + workingHrs);
        }
        totalEmpWages.put(DailyCompanyEmpWage.COMPANY_NAME, totalWage);
        return totalWage;
    }

    void printTotalEmpWages() {
        System.out.println("The Companies and their total Employee Wages are:");
        for (String companyName : totalEmpWages.keySet())
        {
            System.out.println(companyName + ": " + totalEmpWages.get(companyName));
        }

    }


    public static void main(String args[]) {
        EmployeeWageDailyComputation employeeWageComputation1 = new EmployeeWageDailyComputation(3);
        employeeWageComputation1.addCompany("Microsoft", 4, 30, 100);
        employeeWageComputation1.addCompany("Google", 5, 40, 170);
        employeeWageComputation1.addCompany("Apple", 9, 10, 70);
        employeeWageComputation1.calculateTotalWage();
        employeeWageComputation1.printTotalEmpWages();
    }
}
