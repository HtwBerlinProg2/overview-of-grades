package de.htwberlin;

public class GradesOverview {

  private int[] grades;
  private int index=0;
  private double gradesSum;
  private double avarage;
  private String outputString;

  public GradesOverview() {
    grades = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
  }

  public int[] getGrades() {
    return grades;
  }

  public void add(int grade) {
    // TODO
  try{
    if(!((grade == 1) || (grade == 2) || (grade== 3) || (grade== 4) || (grade== 5))) {
      throw new IllegalArgumentException("Dies ist keine gültige Note");
    }
    grades[index] = grade;
    for(int i=0; i<=index; i++){
      System.out.println(grades[i]);
    }
    index++;
  }

      catch (ArrayIndexOutOfBoundsException e){
      System.out.println("Die max Anzahl Noten wurde überschritten");
      }
  calcAverage();
  toString();
    }



  double calcAverage() {
    gradesSum = 0;
    for(int i = 0; i < index; i++ ){
      gradesSum += grades[i];
      avarage = Math.round((gradesSum / index)*100.0)/100.0;
    }

    System.out.println(avarage);
    return avarage;
    // TODO return the calculated average
  }

  @Override
  public String toString() {
    String allGrades = "";
    int ones = 0;
    int twos = 0;
    int threes = 0;
    int fours = 0;
    int fives = 0;


    for (int i = 0 ; i < index ; i++){

      if(i != 0){
        allGrades += ", ";
      }

      allGrades += grades[i];

      switch(grades[i]) {
        case 1:
          ones++;
          break;
        case 2:
          twos++;
          break;
        case 3:
          threes++;
          break;
        case 4:
          fours++;
          break;
        case 5:
          fives++;
          break;


      }
    }

    outputString =
    "You have entered the following grades: ["+
            allGrades
  +"]\n" +
            "Grade '1': "+ ones+"\n" +
            "Grade '2': "+ twos+"\n" +
            "Grade '3': "+ threes+"\n" +
            "Grade '4': "+ fours+"\n" +
            "Grade '5': "+ fives+"\n" +
            "The total number of grades are "+index+"\n" +
            "The average is "+avarage;
    System.out.println(outputString);
    return outputString;
    // TODO return the grades overview as String
  }
}
