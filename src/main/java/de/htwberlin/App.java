package de.htwberlin;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.*;

import static java.util.stream.Collectors.counting;

public class App {

  private final GradesOverview gradesOverview;
  private final Scanner scanner;

  public App() {
    gradesOverview = new GradesOverview();
    scanner = new Scanner(System.in);
  }

  public void start() {
    System.out.println("Please enter the grades line by line. Press [ENTER] after each grade.\n" +
                       "Enter 'exit' to finish and get an evaluation.");
    while (true) {
      String input = scanner.nextLine();

      if (input.equalsIgnoreCase("exit")) {
        break;
      }

      int grade;
      try {
        grade = Integer.parseInt(input);
      }
      catch (NumberFormatException nfe) {
        System.err.println("Invalid input. Only integers and 'exit' is allowed.");
        continue;
      }

      try {
        gradesOverview.add(grade);
      }
      catch (IllegalArgumentException iae) {
        System.err.println(iae.getMessage());
      }
    }

    System.out.println(gradesOverview.toString());
  }

  public static void main(String[] args) {
    //new App().start();
    List<Integer> alternativeGrades = Arrays.asList(1,2,1,1,3,4,4,2,1);
    String returnString = "You have entered the following grades: " + alternativeGrades + "\n" ;
    /*List<Integer> gradeTypes = Arrays.asList(1,2,3,4,5);
    gradeTypes.stream()
            .map(i -> alternativeGrades.stream()
                    .filter(j -> j == i)
                    .collect(Collectors.counting()))
            .forEach(i -> System.out.println("Grades :"+i));*/
    List<Integer> gradeTypes = Arrays.asList(1,2,3,4,5);
    Map<Integer,Long> resultMap= alternativeGrades.stream().collect(Collectors.groupingBy(i -> i,counting()));
    for(int i = 1; i <= 5;i++){
      if(!resultMap.containsKey(i)){
        System.out.println("Grades: \'" + i +"\' : 0" );
      }
      else {System.out.println("Grades: \'" + i +"\' : " + resultMap.get(i));}
    }
    returnString += "The total number of grades are " + alternativeGrades.size() + "\n" + "The average is " + "check";
    System.out.println(returnString );
  }

}

