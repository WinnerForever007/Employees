package com.example.employees;

import java.text.NumberFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    static String peopleText = """
            Flintstone, Fred, 1/1/1900, Programmer, {locpd=2000,yoe=10,iq=140}
            Flintstone2, Fred2, 1/1/1900, Programmer, {locpd=1300,yoe=14,iq=100}
            Flintstone3, Fred3, 1/1/1900, Programmer, {locpd=2300,yoe=8,iq=105}
            Flintstone4, Fred4, 1/1/1900, Programmer, {locpd=1630,yoe=3,iq=115}
            Flintstone5, Fred5, 1/1/1900, Programmer, {locpd=5,yoe=10,5=100}
            Rubble, Barney, 2/2/1905, Manager, {orgSize=300,dr=10}
            Rubble2, Barney2, 2/2/1905, Manager, {orgSize=100,dr=4}
            Rubble3, Barney3, 2/2/1905, Manager, {orgSize=200,dr=2}
            Rubble4, Barney4, 2/2/1905, Manager, {orgSize=500,dr=8}
            Rubble5, Barney5, 2/2/1905, Manager, {orgSize=175,dr=20}
            Flintstone, Wilma, 3/3/1910, Analyst, {projectCount=3}
            Flintstone2, Wilma2, 3/3/1910, Analyst, {projectCount=4}
            Flintstone3, Wilma3, 3/3/1910, Analyst, {projectCount=5}
            Flintstone4, Wilma4, 3/3/1910, Analyst, {projectCount=6}
            Flintstone5, Wilma5, 3/3/1910, Analyst, {projectCount=9}
            Rubble, Betty, 4/4/1915, CEO, {avgStockPrice=300}
            """;


    public static void main(String[] args) {
        String peopleText = """
                Flintstone, Fred, 1/1/1900, Programmer
                Rubble, Barney, 2/2/1905, Manager
                Flintstone, Wilma, 3/3/1910, Analyst
                Rubble, Betty, 4/4/1915, CEO
                """;
        String peopleRegex = "(?<lastName>\\w+),\\s*(?<firstName>\\w+)," +
                "\\s*(?<dob>\\d{1,2}/\\d{1,2}/\\d{4}),\\s*(?<role>\\w+)\\n";
        Pattern peoplePat = Pattern.compile(peopleRegex);
        Matcher peopleMat = peoplePat.matcher(peopleText);

        /*while(peopleMat.find()) {
            System.out.printf("%s %s, born %s%n", peopleMat.group("firstName"),
                    peopleMat.group("lastName"), peopleMat.group("dob"));
        }*/

        int totalSalaries = 0;
        while (peopleMat.find()) {
            totalSalaries += switch (peopleMat.group("role")) {
                case "Programmer" -> 3000;
                case "Manager" -> 3500;
                case "Analyst" -> 2500;
                case "CEO" -> 5000;
                default -> 0;
            };
        }

        NumberFormat currencyInstance = NumberFormat.getCurrencyInstance(Locale.US);

//        System.out.printf("The total payout should be %s%n",
//                currencyInstance.format(totalSalaries));
//        peopleRegex = "(?<lastName>\\w+),\\s*(?<firstName>\\w+)," +
//                "\\s*(?<dob>\\d{1,2}/\\d{1,2}/\\d{4}),\\s*(?<role>\\w+)," +
//                "\\s*\\{(?<details>.*)\\}\\n";
//        peoplePat = Pattern.compile(peopleRegex);


        peopleMat = Employee.PEOPLE_PAT.matcher(Main.peopleText);
        totalSalaries = 0;

        //Collections
        List<IEmployee> employees = new LinkedList<>();
        populateEmployees(peopleMat, employees);

//        List<String> undesirables = new ArrayList<>();
//        undesirables.add("Wilma5");
//        undesirables.add("Barney4");
//        undesirables.add("Fred2");
        List<String> undesirables = List.of("Wilma5", "Barney4", "Fred2");

        removeUndesirables(employees, undesirables);

        totalSalaries = tabulateSalaries(employees);

        /*while (peopleMat.find()) {
            IEmployee employee = Employee.createEmployee(peopleMat.group());
            System.out.println(employee);
            totalSalaries += employee.getSalary();
        }*/

        System.out.printf("The total payout should be %s%n",
                currencyInstance.format(totalSalaries));

        IEmployee first = employees.get(0);
        IEmployee second = employees.get(1);
        IEmployee third = employees.get(2);

        //Exercise 1.1 Collections
        List<String> listOfNames = new ArrayList<>();
        listOfNames.add("Name1");
        listOfNames.add("Name2");
        listOfNames.add("Name3");
        listOfNames.add("Name4");

        for(String list : listOfNames) {
            System.out.println(list);
        }

        String[] arrayOfNames = {"Name1", "Name2", "Name3"};
        arrayOfNames = Arrays.copyOf(arrayOfNames, 4);
        arrayOfNames[3] = "Name4";

        for(String elem : arrayOfNames) {
            System.out.println(elem);
        }

        //Exercise 1.4 Collections
        List<Integer> timing = new ArrayList<>();
        long start = System.currentTimeMillis();
        for(int i = 0; i < 100000; i++) {
            timing.add(0, i);
        }
        System.out.println("ArrayList " + (System.currentTimeMillis() - start));
        start = System.currentTimeMillis();
        for(int i = 0; i < 100000; i++) {
            timing.get(i);
        }
        System.out.println((System.currentTimeMillis() - start));

        List<Integer> timing2 = new LinkedList<>();
        start = System.currentTimeMillis();
        for(int i = 0; i < 100000; i++) {
            timing2.add(0, i);
        }
        System.out.println("LinkedList " + (System.currentTimeMillis() - start));
        start = System.currentTimeMillis();
        for(int i = 0; i < 100000; i++) {
            timing2.get(i);
        }
        System.out.println(System.currentTimeMillis() - start);

        //Exercise 1.5 Collections
        List<Integer> listOfNumbers = new ArrayList<>();
        for(int i = 0; i < 10; i++) {
            listOfNumbers.add(i);
        }
        for(Iterator<Integer> it = listOfNumbers.iterator(); it.hasNext(); ) {
            Integer wholeNumber = it.next();
                if(wholeNumber % 2 == 0) {
                    it.remove();
            }
        }
        for(Integer evenNumber : listOfNumbers) {
            System.out.println(evenNumber);
        }

        //Exercise 1.6 Collections
        listOfNumbers = new ArrayList<>();
        for(int i = 0; i < 10; i++) {
            listOfNumbers.add(i);
        }
        listOfNumbers.removeIf(number -> number % 2 == 0);
        System.out.println("Exercise 1.6 Collections");
        for(Integer evenNumber : listOfNumbers) {
            System.out.println(evenNumber);
        }

        //Exercise 1.7 Collections
        List<Integer> newList = new ArrayList<>(List.of(1, 3, 4));
        newList.add(5);
        System.out.println(newList);


    }

    //Exercise 1.10 Collections
    private static int tabulateSalaries(List<IEmployee> employees) {
        int totalSalaries = 0;
        for(IEmployee worker : employees) {
            System.out.println(worker);
            totalSalaries += worker.getSalary();
        }
        return totalSalaries;
    }

    //Exercise 1.10 Collections
    private static void populateEmployees(Matcher peopleMat, List<IEmployee> employees) {
        while(peopleMat.find()) {
            IEmployee employee = Employee.createEmployee((peopleMat.group()));
            employees.add(employee);
        }
    }

    //Exercise 1.10 Collections
    private static void removeUndesirables(List<IEmployee> employees, List<String> removalNames) {
        for(Iterator<IEmployee> it = employees.iterator(); it.hasNext();) {
            IEmployee worker = it.next();
            if(worker instanceof Employee tempWorker) {
                if(removalNames.contains(tempWorker.firstName)) {
                    it.remove();
                }
            }
        }
    }
}
