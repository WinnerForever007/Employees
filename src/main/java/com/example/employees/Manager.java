package com.example.employees;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Manager extends Employee {
    private static final String MANAGER_REGEX = "\\w+=(?<orgSize>\\w+)," +
            "\\w+=(?<dr>\\w+)";
    private static final Pattern MANAGER_PAT = Pattern.compile(MANAGER_REGEX);

    private int orgSize = 0;
    private int directReports = 0;


    public Manager(String personText) {
        super(personText);
        Matcher manageMat = MANAGER_PAT.matcher(peopleMat.group("details"));
        if (manageMat.find()) {
            this.orgSize = Integer.parseInt(manageMat.group("orgSize"));
            this.directReports = Integer.parseInt(manageMat.group("dr"));
        }
    }

    @Override
    public int getSalary() {
        return 3000 + orgSize * directReports;
    }

    @Override
    public double getBonusPercent() {
        return 0.1;
    }
}
