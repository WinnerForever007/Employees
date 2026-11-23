package com.example.employees;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CEO extends Employee implements Flyer {
    private static final String CEO_REGEX = "\\w+=(?<avgStockPrice>\\w+)";
    private static final Pattern CEO_PAT = Pattern.compile(CEO_REGEX);

    private int avgStockPrice = 1; // 1 or 0?
    private final Flyer pilot = new Pilot(1000, true);


    public CEO(String personText) {
        super(personText);
        Matcher ceoMat = CEO_PAT.matcher(peopleMat.group("details"));
        if (ceoMat.find()) {
            this.avgStockPrice = Integer.parseInt(ceoMat.group("avgStockPrice"));
        }
    }

    public void fly() {
        pilot.fly();
    }

    public int getHoursFlown() {
        return pilot.getHoursFlown();
    }

    public void setHoursFlown(int hoursFlown) {
        pilot.setHoursFlown(hoursFlown);
    }

    public boolean isIfr() {
        return pilot.isIfr();
    }

    public void setIfr(boolean ifr) {
        pilot.setIfr(ifr);
    }

    @Override
    public int getSalary() {
        return 5000 * avgStockPrice;
    }

    @Override
    public double getBonusPercent() {
        return 0.2;
    }
}
