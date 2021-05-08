package de.htwberlin;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Random;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class GradesOverviewTest {

  private final GradesOverview underTest = new GradesOverview();

  @Test
  @DisplayName("size of grades should be 10 after initialization")
  void testInitialSizeOfGrades() {
    assertEquals(10, underTest.getGrades().length);
  }

  @Test
  @DisplayName("should be saved according to the input sequence")
  void testInputSequence() {
    // when
    underTest.add(3);
    underTest.add(1);
    underTest.add(2);
    underTest.add(5);

    // then
    assertArrayEquals(new int[]{3, 1, 2, 5, 0, 0, 0, 0, 0, 0}, underTest.getGrades());
  }

  @ParameterizedTest(name = "should throw IllegalArgumentException for grade {0}")
  @DisplayName("should if throw IllegalArgumentException for invalid grades")
  @ValueSource(ints = {Integer.MAX_VALUE, -1, 0, 6, Integer.MAX_VALUE})
  void testInvalidValues(int grade) {
    assertThrows(IllegalArgumentException.class, () -> underTest.add(grade));
  }

  @Test
  @DisplayName("should be possible to add more than 10 grades")
  void testMoreThan10Grades() {
    // given
    int amountOfGradesToAdd = 25;
    Random rnd = new Random();

    // when
    for (int i = 0; i < amountOfGradesToAdd; i++) {
      underTest.add(rnd.nextInt(5) + 1);
    }

    // then
    assertEquals(amountOfGradesToAdd, underTest.getGrades().length);
  }

  @ParameterizedTest(name = "The average should be {1}")
  @DisplayName("should calculate the grade average")
  @MethodSource("gradeProvider")
  void testCalcAverage(int[] grades, double expectedAverage) {
    // when
    for (int grade : grades) {
      underTest.add(grade);
    }

    // then
    assertEquals(expectedAverage, underTest.calcAverage());
  }

  private static Stream<Arguments> gradeProvider() {
    return Stream.of(
      Arguments.of(new int[]{1, 1, 1, 1, 1}, 1),
      Arguments.of(new int[]{2}, 2),
      Arguments.of(new int[]{}, 0),
      Arguments.of(new int[]{1, 2, 3, 4, 5}, 3),
      Arguments.of(new int[]{1, 1, 1, 5, 5}, 2.6),
      Arguments.of(new int[]{1, 1, 5, 3, 3, 3, 2}, 2.57)
    );
  }

  @Test
  @DisplayName("should create a full overview of all entered grades")
  void testToString() {
    // given
    String expectedString = "You have entered the following grades: [1, 1, 5, 3, 3, 3, 2]\n" +
            "Grade '1': 1\n" +
            "Grade '2': 1\n" +
            "Grade '3': 5\n" +
            "Grade '4': 3\n" +
            "Grade '5': 3\n" +
            "Grade '6': 3\n" +
            "Grade '7': 2\n" +
            "The total number of grades are 18\n" +
            "The average is 2.57";

    // when
    underTest.add(1);
    underTest.add(1);
    underTest.add(5);
    underTest.add(3);
    underTest.add(3);
    underTest.add(3);
    underTest.add(2);
    String result = underTest.toString();

    // then
    assertEquals(expectedString, result);
  }
}