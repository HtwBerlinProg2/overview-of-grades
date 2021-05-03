package de.htwberlin;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.*;

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
    new App().start();

  }
}

