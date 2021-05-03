package de.htwberlin;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Collectors.*;
import java.util.stream.IntStream;
import java.lang.Integer.*;

public class GradesOverview {

  private int[] grades;
  private List<Integer> alternativeGrades = new ArrayList<>();

  public GradesOverview() {
    grades = new int[10];
  }

  public int[] getGrades() {
    return grades;
  }


  public void add(int grade) {
    // TODO
    alternativeGrades.add(grade);
    if(alternativeGrades.size()>10)
    {
      grades = new int[alternativeGrades.size()];
      for(int i = 0 ; i < grades.length ; i++ ){
        grades[i] = alternativeGrades.get(i);
      }
    }
    else{
    for (int i = 0;i< grades.length; i++) {
      if (grades[i] == 0) {
        grades[i] = grade;
        break;
      }
    }}

    if(grade < 1 || grade > 5){
      this.invalidScores();
    }
  }


  public double calcAverage() {
    double result = alternativeGrades.stream().collect(Collectors.averagingInt(x -> x));
    result = Math.floor(result*100)/100;
    return result;
    // TODO return the calculated average
  }

  private void invalidScores() {
    throw new IllegalArgumentException();
  }

  /*You have entered the following grades: [1, 1, 1, 1, 5, 4, 3, 4, 5]
Grade '1': 4
Grade '2': 0
Grade '3': 1
Grade '4': 2
Grade '5': 2
The total number of grades are 9
The average is 2.78
*/
  @Override
  public String toString() {
    Map<Integer,Long> gradeMap=
    alternativeGrades.stream().collect(Collectors.groupingBy(e -> e,Collectors.counting()));
    String returnString = "You have entered the following grades: " + alternativeGrades.toString() + "\n" ;
    for (Map.Entry<Integer,Long> entry : gradeMap.entrySet())
      returnString += ("Grade \'" + entry.getKey() +
              "\': " + entry.getValue()) + "\n";
    returnString += "The total number of grades are " + alternativeGrades.size() + "\n" + "The average is " + this.calcAverage();
    return returnString;
  }

}