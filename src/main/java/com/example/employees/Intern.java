package com.example.employees;

import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Intern extends Employee {
    private static final String PEOPLE_REGEX = "(?<lastName>\\w+),\\s*(?<firstName>\\w+)," +
            "\\s*(?<dob>\\d{1,2}/\\d{1,2}/\\d{4}),\\s*(?<role>\\w+)," +
            "\\s*\\{(?<details>.*)\\}\\n?";
    private static final Pattern PEOPLE_PAT = Pattern.compile(PEOPLE_REGEX);
    private static final String INTERN_REGEX = "\\w+=(?<hoursPerWeek>\\w+)";
    private static final Pattern INTERN_PAT = Pattern.compile(INTERN_REGEX);
    private static final DateTimeFormatter DTF = DateTimeFormatter.ofPattern("M/d/yyyy");
    private static final NumberFormat MONEY_FORMAT = NumberFormat.getCurrencyInstance(Locale.US);

    private String lastName;
    private String firstName;
    private LocalDate dob;
    private int hoursPerWeek = 20;


    public Intern(String personText) {
        super(personText);
        Matcher analystMat = INTERN_PAT.matcher(peopleMat.group("details"));
        if (analystMat.find()) {
            this.hoursPerWeek = Integer.parseInt(analystMat.group("hoursPerWeek"));
        }

//        Matcher peopleMat = PEOPLE_PAT.matcher(personText);
//        if(peopleMat.find()) {
//            this.lastName = peopleMat.group("lastName");
//            this.firstName = peopleMat.group("firstName");
//            this.dob = LocalDate.parse(peopleMat.group("dob"), DTF);
//            Matcher internMat = INTERN_PAT.matcher(peopleMat.group("details"));
//            if(internMat.find()) {
//                this.hoursPerWeek = Integer.parseInt(internMat.group("hoursPerWeek"));
//            }
//        }
    }

    public int getSalary() {
        return 15 * hoursPerWeek * 4;
    }

    //Exercise 2.3
    public int getAge() {
        return Period.between(dob, LocalDate.now()).getYears();
    }

    @Override
    public String toString() {
        return String.format("%s, %s: %s", lastName, firstName,
                MONEY_FORMAT.format(getSalary()));
    }

    @Override
    public double getBonusPercent() {
        return 0.1;
    }
}
