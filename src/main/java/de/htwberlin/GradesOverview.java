package de.htwberlin;

public class GradesOverview {

  private int[] grades;

  public GradesOverview() {
    grades = new int[10];
  }

  public int[] getGrades() {
    return grades;
  }

  public void add(int grade) {
    // TODO
  }

  double calcAverage() {
    return 0.0;
    // TODO return the calculated average
  }

  @Override
  public String toString() {
    return "The overview is currently not available ;("; // TODO return the grades overview as String
  }
}
