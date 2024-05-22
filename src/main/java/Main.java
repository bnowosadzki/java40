  import java.util.Scanner;
  import java.io.IOException;
  import java.text.ParseException;
  import java.text.SimpleDateFormat;
  import java.util.Date;

  class Main {
    public static void main(String[] args) {
      try {
        Service s = new Service();
        Scanner scanner = new Scanner(System.in);

        while (true) {

          System.out.println("1. Dodaj studenta");
          System.out.println("2. Wyświetl wszystkich studentów");
          System.out.println("3. Wyjdz");

          int choice = scanner.nextInt();
          scanner.nextLine();
          switch (choice) {
            case 1:
              System.out.println("Podaj imię studenta:");
              String name = scanner.nextLine();
              System.out.println("Podaj nazwisko studenta:");
              String nazwisko = scanner.nextLine();
              System.out.println("Podaj wiek studenta:");
              int wiek = scanner.nextInt();
              scanner.nextLine();
              System.out.println("Podaj datę urodzenia studenta (yyyy-MM-dd):");
              String dateOfBirth = scanner.nextLine();

              if (isValidDate(dateOfBirth)) {
                s.addStudent(new Student(name, nazwisko, wiek, dateOfBirth));
              } else {
                System.out.println("Niepoprawny format daty. Użyj formatu yyyy-MM-dd.");
              }
              break;
            case 2:
              var students = s.getStudents();
              for (Student current : students) {
                System.out.println(current.toString());
              }
              break;
            case 3:
              System.exit(0);
              break;
            default:
              System.out.println("Niepoprawny wybór.");
              continue;
          }
          System.out.println("Czy chcesz dodać kolejnego studenta? (T/N)");
          String answer = scanner.nextLine();
          if (!answer.equalsIgnoreCase("T")) {
            break;
          }
        }

        var students = s.getStudents();
        for (Student current : students) {
          System.out.println(current.toString());
        }
      } catch (IOException e) {
        System.out.println("Wystąpił błąd I/O: " + e.getMessage());
      }
    }

    private static boolean isValidDate(String date) {
      SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
      sdf.setLenient(false);
      try {
        Date parsedDate = sdf.parse(date);
        return true;
      } catch (ParseException e) {
        return false;
      }
    }
  }
