package com.example.employees;

import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Manager {
    private static final String PEOPLE_REGEX = "(?<lastName>\\w+),\\s*(?<firstName>\\w+)," +
            "\\s*(?<dob>\\d{1,2}/\\d{1,2}/\\d{4}),\\s*(?<role>\\w+)," +
            "\\s*\\{(?<details>.*)\\}\\n?";
    private static final Pattern PEOPLE_PAT = Pattern.compile(PEOPLE_REGEX);
    private static final String MANAGER_REGEX = "\\w+=(?<orgSize>\\w+)," +
            "\\w+=(?<dr>\\w+)";
    private static final Pattern MANAGER_PAT = Pattern.compile(MANAGER_REGEX);
    private static final DateTimeFormatter DTF = DateTimeFormatter.ofPattern("M/d/yyyy");
    private static final NumberFormat MONEY_FORMAT = NumberFormat.getCurrencyInstance(Locale.US);

    private String lastName;
    private String firstName;
    private LocalDate dob;
    private int orgSize = 0;
    private int directReports = 0;


    public Manager(String personText) {
        Matcher peopleMat = PEOPLE_PAT.matcher(personText);
        if(peopleMat.find()) {
            this.lastName = peopleMat.group("lastName");
            this.firstName = peopleMat.group("firstName");
            this.dob = LocalDate.parse(peopleMat.group("dob"), DTF);
            Matcher manageMat = MANAGER_PAT.matcher(peopleMat.group("details"));
            if(manageMat.find()) {
                this.orgSize = Integer.parseInt(manageMat.group("orgSize"));
                this.directReports = Integer.parseInt(manageMat.group("dr"));
            }
        }
    }

    public int getSalary() {
        return 3000 + orgSize * directReports;
    }

    @Override
    public String toString() {
        return String.format("%s, %s: %s", lastName, firstName,
                MONEY_FORMAT.format(getSalary()));
    }

}
