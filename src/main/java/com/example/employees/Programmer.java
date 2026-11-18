package com.example.employees;

import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Programmer {
    private static final String PEOPLE_REGEX = "(?<lastName>\\w+),\\s*(?<firstName>\\w+)," +
            "\\s*(?<dob>\\d{1,2}/\\d{1,2}/\\d{4}),\\s*(?<role>\\w+)," +
            "\\s*\\{(?<details>.*)\\}\\n?";
    private static final Pattern PEOPLE_PAT = Pattern.compile(PEOPLE_REGEX);
    private static final String PROG_REGEX = "\\w+=(?<locpd>\\w+),\\w+=(?<yoe>\\w+)," +
            "\\w+=(?<iq>\\w+)";
    private static final Pattern PROG_PAT = Pattern.compile(PROG_REGEX);
    private static final DateTimeFormatter DTF = DateTimeFormatter.ofPattern("M/d/yyyy");
    private static final NumberFormat MONEY_FORMAT = NumberFormat.getCurrencyInstance(Locale.US);

    private String lastName;
    private String firstName;
    private LocalDate dob;
    private int linesOfCode = 0;
    private int yearsOfExp = 0;
    private int iq = 0;


    public Programmer(String personText) {
        Matcher peopleMat = PEOPLE_PAT.matcher(personText);
        if(peopleMat.find()) {
            this.lastName = peopleMat.group("lastName");
            this.firstName = peopleMat.group("firstName");
            this.dob = LocalDate.parse(peopleMat.group("dob"), DTF);
            Matcher progMat = PROG_PAT.matcher(peopleMat.group("details"));
            if(progMat.find()) {
                this.linesOfCode = Integer.parseInt(progMat.group("locpd"));
                this.yearsOfExp = Integer.parseInt(progMat.group("yoe"));
                this.iq = Integer.parseInt(progMat.group("iq"));
            }
        }
    }

    public int getSalary() {
        return 3000 + linesOfCode * yearsOfExp * iq;
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

}
