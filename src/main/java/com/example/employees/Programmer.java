package com.example.employees;

import java.time.LocalDate;
import java.time.Period;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Programmer extends Employee {
    private static final String PROG_REGEX = "\\w+=(?<locpd>\\w+),\\w+=(?<yoe>\\w+)," +
            "\\w+=(?<iq>\\w+)";
    private static final Pattern PROG_PAT = Pattern.compile(PROG_REGEX);

    private int linesOfCode = 0;
    private int yearsOfExp = 0;
    private int iq = 0;


    public Programmer(String personText) {
        super(personText);
        Matcher progMat = PROG_PAT.matcher(peopleMat.group("details"));
        if (progMat.find()) {
            this.linesOfCode = Integer.parseInt(progMat.group("locpd"));
            this.yearsOfExp = Integer.parseInt(progMat.group("yoe"));
            this.iq = Integer.parseInt(progMat.group("iq"));
        }
    }

    @Override
    public int getSalary() {
        return 3000 + linesOfCode * yearsOfExp * iq;
    }

    @Override
    public double getBonusPercent() {
        return 0.1;
    }

    //Exercise 2.3
    public int getAge() {
        return Period.between(dob, LocalDate.now()).getYears();
    }


}
