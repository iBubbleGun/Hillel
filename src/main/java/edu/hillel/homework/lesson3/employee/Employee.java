package edu.hillel.homework.lesson3.employee;

public class Employee {
    private String fullName;
    private String jobTitle;
    private String email;
    private String phoneNumber;
    private int employeeAge;

    public String getFullName() {
        return fullName;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public int getEmployeeAge() {
        return employeeAge;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setEmployeeAge(int employeeAge) {
        this.employeeAge = employeeAge;
    }

    public Employee(String fullName,
                    String jobTitle,
                    String email,
                    String phoneNumber,
                    int employeeAge) {
        this.fullName = fullName;
        this.jobTitle = jobTitle;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.employeeAge = employeeAge;
    }

    public void printNewEmployee() {
        System.out.println(
                "Welcome new employee " + getFullName() + "!\n" +
                "Job title: " + getJobTitle() + ";\n" +
                "Email: " + getEmail() + ";\n" +
                "Phone number: " + getPhoneNumber() + ";\n" +
                        "Age: " + getEmployeeAge() + "."
        );
        partingWord();
    }

    private void partingWord() {
        System.out.println("Success in your career! (This text was received from private partingWord() method from Employee class)");
    }
}
