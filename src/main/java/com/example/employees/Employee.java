package com.example.employees;

import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class Employee implements IEmployee {
    private static final String PEOPLE_REGEX = "(?<lastName>\\w+),\\s*(?<firstName>\\w+)," +
            "\\s*(?<dob>\\d{1,2}/\\d{1,2}/\\d{4}),\\s*(?<role>\\w+)," +
            "\\s*\\{(?<details>.*)\\}\\n?";
    public static final Pattern PEOPLE_PAT = Pattern.compile(PEOPLE_REGEX);
    private static final DateTimeFormatter DTF = DateTimeFormatter.ofPattern("M/d/yyyy");
    private static final NumberFormat MONEY_FORMAT = NumberFormat.getCurrencyInstance(Locale.US);
    protected Matcher peopleMat;
    protected String lastName;
    protected String firstName;
    protected LocalDate dob;

    protected Employee() {
        peopleMat = null;
        lastName = "N/A";
        firstName = "N/A";
        dob = null;
    }

    public Employee(String personText) {
        peopleMat = PEOPLE_PAT.matcher(personText);
        if (peopleMat.find()) {
            this.lastName = peopleMat.group("lastName");
            this.firstName = peopleMat.group("firstName");
            this.dob = LocalDate.parse(peopleMat.group("dob"), DTF);
        }
    }

    public static IEmployee createEmployee(String employeeText) {
        Matcher peopleMat = PEOPLE_PAT.matcher(employeeText);
        if(peopleMat.find()) {
            return switch (peopleMat.group("role")) {
                case "Programmer" -> new Programmer(peopleMat.group());
                case "Manager" -> new Manager(peopleMat.group());
                case "Analyst" -> new Analyst(peopleMat.group());
                case "CEO" -> new CEO(peopleMat.group());
                case "Intern" -> new Intern(peopleMat.group());
                default -> () -> 0;
            };
        } else {
            return () -> 0;
            //return new DummyEmployee(employeeText);
        }
    }

    private static final class DummyEmployee extends Employee {
        private DummyEmployee(String personText) {
            super(personText);
        }

        @Override
        public int getSalary() {
            return 0;
        }

        @Override
        public double getBonus() {
            return super.getBonus();
        }

        class MyInnerClass {
            String getStuff() {
                return firstName;
            }
        }

        @Override
        public double getBonusPercent() {
            return 0;
        }
    }

    public abstract int getSalary();

    public double getBonus() {
        return getSalary() * getBonusPercent();
    }

    public abstract double getBonusPercent();

    @Override
    public String toString() {
        return String.format("%s, %s: %s - %s", lastName, firstName,
                MONEY_FORMAT.format(getSalary()), MONEY_FORMAT.format(getBonus()));
    }
}
