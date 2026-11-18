package com.example.employees;

import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Analyst {
    private static final String PEOPLE_REGEX = "(?<lastName>\\w+),\\s*(?<firstName>\\w+)," +
            "\\s*(?<dob>\\d{1,2}/\\d{1,2}/\\d{4}),\\s*(?<role>\\w+)," +
            "\\s*\\{(?<details>.*)\\}\\n?";
    private static final Pattern PEOPLE_PAT = Pattern.compile(PEOPLE_REGEX);
    private static final String ANALYST_REGEX = "\\w+=(?<projectCount>\\w+)";
    private static final Pattern ANALYST_PAT = Pattern.compile(ANALYST_REGEX);
    private static final DateTimeFormatter DTF = DateTimeFormatter.ofPattern("M/d/yyyy");
    private static final NumberFormat MONEY_FORMAT = NumberFormat.getCurrencyInstance(Locale.US);

    private String lastName;
    private String firstName;
    private LocalDate dob;
    private int projectCount = 0;


    public Analyst(String personText) {
        Matcher peopleMat = PEOPLE_PAT.matcher(personText);
        if(peopleMat.find()) {
            this.lastName = peopleMat.group("lastName");
            this.firstName = peopleMat.group("firstName");
            this.dob = LocalDate.parse(peopleMat.group("dob"), DTF);
            Matcher analystMat = ANALYST_PAT.matcher(peopleMat.group("details"));
            if(analystMat.find()) {
                this.projectCount = Integer.parseInt(analystMat.group("projectCount"));
            }
        }
    }

    public int getSalary() {
        return 2500 + projectCount * 2;
    }

    @Override
    public String toString() {
        return String.format("%s, %s: %s", lastName, firstName,
                MONEY_FORMAT.format(getSalary()));
    }

}
