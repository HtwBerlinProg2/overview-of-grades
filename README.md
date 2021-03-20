# Overview of grades

Erstellen Sie zur Erfassung von Schulnoten inklusiver anschließender Darstellung eines Notenspiegels ein simples Programm. Sowohl Ein- als auch Ausgabe soll über die Konsole erfolgen. Dazu sind die Klassen `App` und `GradesOverview` gegeben. Es befindet sich auch bereits eine `main` Methode in der Klasse `App`, mit der Sie das Programm starten können. 

## Hinweise

- Bitte nehmen Sie keine Änderungen in der Klasse `App` vor.
- Für die Klasse `GradesOverview` existieren Unit-Tests in der Klasse `GradesOverviewTest`. Jeder Testfall muss am Ende Ihrer Implementierung erfolgreich durchlaufen. Zu jeder Aufgabe ist der dazugehörige Testfall am Ende der Aufgabenbeschreibung angegeben.

## Aufgaben

1. Machen Sie sich mit dem aktuellen Stand des Programms vertraut und starten Sie es über Ihre Entwicklungsumgebung. Lesen Sie die Anweisungen auf der Konsole und erfassen Sie ein paar Schulnoten. Beenden Sie anschließend die Erfassung über die Eingabe von `exit`. Das könnte auf Ihrer Konsole bspw. wie folgt aussehen:

  ```shell
  Please enter the grades line by line. Press [ENTER] after each grade.
  Enter 'exit' to finish and get an evaluation.
  2
  3
  5
  4
  3
  g
  Invalid input. Only integers and 'exit' is allowed.
  exit
  The overview is currently not available ;(
  ```

2. Ein Array ist ein Datentyp, der zur Speicherung mehrerer Werte eines Typs verwendet wird. Bei der Initialisierung eines Arrays muss immer eine Größe angegeben werden. Die Größe definiert wie viele Elemente einem Array hinzugefügt werden können. Werden dem Array mehr Elemente hinzugefügt, als es Platz hat, kommt es zu einem Fehler bei Ausführung des Programms. Schauen Sie in der Klasse `GradesOverview` wo das Array `grades` initialisiert wird. Setzen Sie die initiale Größe auf 10, sodass 10 Noten ohne Fehler erfasst werden können. (Testfall `GradesOverviewTest.testInitialSizeOfGrades()`)


3. Die Klasse `GradesOverview` ist eine Art Notenspeicher mit Funktionen zur Durchschnittsberechnung und Darstellung eines Notenspiegels. Alle vom Nutzer über die Konsole eingegebenen Noten sollen im Array `grades` der Klasse `GradesOverview` gespeichert werden. Damit dies möglich ist, müssen Sie die Methode `public void add(int grade)` implementieren. Der Parameter `grade` muss dem Array `grades` hinzugefügt werden. Bitte beachten Sie, dass die Methode `add` zur Laufzeit des Programms mehrfach aufgerufen wird, und zwar immer dann, wenn der Nutze eine Note auf der Konsole eingibt. Die Note, die zuerst eingegeben wurde, muss sich daher auf dem ersten Index im Array befinden und die Note, die als zweites eingegeben wurde, muss sich auf dem zweiten Index im Array befinden usw. (Testfall `GradesOverviewTest.testInputSequence()`)


4. Fügen Sie der Methode `add` eine Validierung hinzu. Gültige Noten sind 1, 2, 3, 4 und 5. Bei allen anderen Werten soll eine `IllegalArgumentException` geworfen werden. (Testfall `GradesOverviewTest.testInvalidValues()`)


5. Das `grades` Array hat eine feste Größe von 10, d. h. es können nicht mehr als 10 Noten erfasst werden. Finden Sie eine Lösung, um eine beliebige Anzahl von Noten zu erfassen. Verändern Sie dazu nicht die initiale Größe des Arrays. (Testfall `GradesOverviewTest.testMoreThan10Grades()`)


6. Für alle eingegeben Noten soll der Durchschnitt berechnet werden. Implementieren Sie dazu die Methode `calcAverage` in der Klasse `GradesOverview`. Geben Sie den berechneten Durchschnitt auf 2 Nachkommastellen gerundet als `double` zurück. Sind keine Noten vorhanden, dann soll `0.0` als Durchschnitt zurückgegeben werden. Bei einem Array der Größe 10 sind alle Felder per Default mit 0 initialisiert. Bei der Durchschnittsberechnung sollen nur echte Noten berücksichtigt werden. (Testfall `GradesOverviewTest.testCalcAverage()`)


7. Der eigentliche Notenspiegel ist eine Übersicht über alle eingegeben Noten, deren Verteilung sowie eine Darstellung der Gesamtanzahl an eingegebenen Noten inkl. Durchschnitt. Implementieren Sie diese Übersicht in der Methode `toString`. Es soll ein String in der folgenden Form zurückgegeben werden:

```
You have entered the following grades: [1, 1, 1, 1, 5, 4, 3, 4, 5]
Grade '1': 4
Grade '2': 0
Grade '3': 1
Grade '4': 2
Grade '5': 2
The total number of grades are 9
The average is 2.78
```
(Testfall `GradesOverviewTest.testToString()`)


8. Führen Sie nun das Programm noch einmal wie in Aufgabe 1 beschrieben aus und testen Sie!
