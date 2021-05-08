package de.htwberlin;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.Arrays;

public class GradesOverview {
  private int[] grades;
  private int grade ;






  /**
   * method to initialize an array with size of 10
   */
  public GradesOverview() {
    grades = new int[10];
    // for (int x=0; x < grades.length; x++){
    // if (x == grades.length - 1 && grades[grades.length-1] != 0) {}

  }

  /**
   * gitter for the grades
   *
   * @return the grades in an array
   */
  public int[] getGrades() { return grades; }
  public int getGrade() {
    return grade;
  }

  public void add(int grade) {
    // TODO
    if (grade > 5 || grade <=0) {
      throw new IllegalArgumentException("nop");
    }
    for (int i = 0; i < grades.length; i++) {
      if (grades[i] == 0) {
        grades[i] = grade;
        break;
      }

    }
    if ( grades[grades.length -1] != 0){
      grades = Arrays.copyOf(grades, grades.length + 1);
      if (grades.length >25){
        grades = Arrays.copyOf(grades, grades.length  -1);
      }

      for (int x: grades){
        System.out.println(x);}};
    System.out.println(grade);
    this.grade = grade;
    calcAverage();
  }


  double calcAverage() {
    DecimalFormat df2 = new DecimalFormat("#.##");
    double n = 0d;
    double r = 0d;
    int f =0;
    for (int i = 0; i < grades.length; i++) {
      if(getGrades()[i] !=0){
        n += getGrades()[i];
        f++;}
    }
    r = n / f;
    if (n == 0){
      r= 0.00;
    }
    BigDecimal bd = new BigDecimal(r).setScale(2, RoundingMode.HALF_UP);
    double newInput = bd.doubleValue();
    return newInput; // TODO return the calculated average*/
  }



  public void arrayPrinter() {
    for (int i=0; i<25; i++) {
      if (grades[i] !=0){
        System.out.println("["+grades[i]+"]");
      }
    }
  }




  @Override
  public String toString() {
    int sum = getGrades()[0]+getGrades()[1]+getGrades()[2]+getGrades()[3]+getGrades()[4]+getGrades()[5]+getGrades()[6];

    String overview = "You have entered the following grades: "+ "["+getGrades()[0]+", "+ getGrades()[1]+", " +getGrades()[2]+", "+
            + getGrades()[3]+", "+getGrades()[4]+", "+ getGrades()[5]+", "+getGrades()[6]+"]"
            +"\n" +
            "Grade '1': "+getGrades()[0]+"\n" +
            "Grade '2': "+getGrades()[1]+"\n" +
            "Grade '3': "+getGrades()[2]+"\n" +
            "Grade '4': "+getGrades()[3]+"\n" +
            "Grade '5': "+getGrades()[4]+"\n" +
            "Grade '6': "+getGrades()[5]+"\n" +
            "Grade '7': "+getGrades()[6]+"\n" +
            "The total number of grades are "+ sum +"\n" +
            "The average is "+calcAverage();


    return overview; // TODO return the grades overview as String
  }
}
