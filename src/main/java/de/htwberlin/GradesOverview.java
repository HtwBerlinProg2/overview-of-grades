package de.htwberlin;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Collectors.*;
import java.util.stream.IntStream;
import java.lang.Integer.*;

import static java.lang.String.valueOf;
import static java.util.stream.Collectors.counting;

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
    String returnString = "You have entered the following grades: " + alternativeGrades + "\n" ;
    List<Integer> gradeTypes = Arrays.asList(1,2,3,4,5);
    Map<Integer,Long> resultMap= alternativeGrades.stream().collect(Collectors.groupingBy(i -> i,counting()));
    for(int i = 1; i <= 5;i++){
      if(!resultMap.containsKey(i)){
       returnString += "Grade \'" + i +"\': 0" + "\n";
      }
      else{
        returnString += ("Grade \'" + i +"\': " + resultMap.get(i) + "\n");
      }
    }
    returnString += "The total number of grades are " + alternativeGrades.size() + "\n" + "The average is " + this.calcAverage();
    return returnString;
  }

}