package com.bloomtech.welcomeletter.models;

import java.time.LocalDate;

public class Employee {
    private static int maxId = 1;

    private int id;
    private String firstname;
    private String lastname;
    private String phonenumber;
    private String email;
    private int salary;
    private LocalDate startdate;
    private Role role;
    private Company company;

    //TODO: Implement Builder Pattern

    public static EmployeeBuilder builder() { return new EmployeeBuilder(); }

    //TODO: Replace with Builder Constructor
    private Employee(EmployeeBuilder builder) { // String firstname, String lastname, String phonenumber, String email, int salary, LocalDate startdate, Role role, Company company
        //Auto-generate an id
        id = maxId;
        maxId++;

        //TODO: Initialize fields:
        this.firstname = builder.firstname;
        this.lastname = builder.lastname;
        this.phonenumber = builder.phonenumber;
        this.email = builder.email;
        this.salary = builder.salary;
        this.startdate = builder.startdate;
        this.role = builder.role;
        this.company = builder.company;
    }

    //TODO: Create Builder Class
    public static class EmployeeBuilder {
        private static int maxId = 1;

        private int id;
        private String firstname;
        private String lastname;
        private String phonenumber;
        private String email;
        private int salary;
        private LocalDate startdate;
        private Role role;
        private Company company;

        public EmployeeBuilder withMaxId(int maxIdToUse) {
            this.maxId = maxIdToUse;
            return this;
        }

        public EmployeeBuilder withID(int IDToUse) {
            this.id = IDToUse;
            return this;
        }

        public EmployeeBuilder withFirstname(String firstNameToUse) {
            this.firstname = firstNameToUse;
            return this;
        }

        public EmployeeBuilder withLastname(String lastNameToUse) {
            this.lastname = lastNameToUse;
            return this;
        }

        public EmployeeBuilder withPhonenumber(String phoneNumberToUse) {
            this.phonenumber = phoneNumberToUse;
            return this;
        }

        public EmployeeBuilder withEmail(String emailToUse) {
            this.email = emailToUse;
            return this;
        }

        public EmployeeBuilder withSalary(int salaryToUse) {
            this.salary = salaryToUse;
            return this;
        }

        public EmployeeBuilder withStartdate(LocalDate startDateToUse) {
            this.startdate = startDateToUse;
            return this;
        }

        public EmployeeBuilder withRole(Role roleToUse) {
            this.role = roleToUse;
            return this;
        }

        public EmployeeBuilder withCompany(Company companyToUse) {
            this.company = companyToUse;
            return this;
        }

        public Employee build() {
         if (firstname == null) { throw new RuntimeException("First name cannot be null."); }
         if (company == null) { throw new RuntimeException("Company cannot be null."); }
         return new Employee(this);
        }

    }

    //Getters
    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public String getEmail() {
        return email;
    }

    public int getSalary() {
        return salary;
    }

    public LocalDate getStartdate() {
        return startdate;
    }

    public Role getRole() {
        return role;
    }

    public Company getCompany() {
        return company;
    }

    public int getId() {
        return id;
    }
}
