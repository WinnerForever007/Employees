package com.example.employees;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Analyst extends Employee {
    private static final String ANALYST_REGEX = "\\w+=(?<projectCount>\\w+)";
    private static final Pattern ANALYST_PAT = Pattern.compile(ANALYST_REGEX);

    private int projectCount = 0;


    public Analyst(String personText) {
        super(personText);
        Matcher analystMat = ANALYST_PAT.matcher(peopleMat.group("details"));
        if (analystMat.find()) {
            this.projectCount = Integer.parseInt(analystMat.group("projectCount"));
        }
    }

    @Override
    public int getSalary() {
        return 2500 + projectCount * 2;
    }

    @Override
    public double getBonusPercent() {
        return 0.1;
    }
}
