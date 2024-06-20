
import java.io.IOException;
import java.util.Scanner;
class Main {
  public static void main(String[] args) {
    try {
      Scanner scanner = new Scanner(System.in);
      Service s = new Service();
      System.out.println("1 - Dodawanie studenta 2 - Wyswietlanie informacji 3 - Wyszukiwanie studenta po nazwisku 4 - Wyjscie");
      int wybor = scanner.nextInt();
      switch(wybor){
        case 1:
          System.out.println("Podaj imie studenta:");
          String imie = scanner.next();
          System.out.println("Podaj nazwisko studenta");
          String nazwisko = scanner.next();
          System.out.println("Podaj wiek:");
          int wiek = scanner.nextInt();
          System.out.println("Podaj dzien urodzenia: ");
          int datad = scanner.nextInt();
          if(datad > 31 || datad < 1){
            System.out.println("Podano niepoprawny dzien urodzenia, prosze wpisac liczbe od 1 do 31. Zacznij wprowadzanie danych od nowa");
            break;
          }
          System.out.println("Podaj miesiac urodzenia: ");
          int datam = scanner.nextInt();
          if(datam > 12 || datam < 1){
            System.out.println("Podano niepoprawny miesiac urodzenia, prosze wpisac liczbe od 1 do 12. Zacznij wprowadzanie danych od nowa");
            break;
          }
          System.out.println("Podaj rok urodzenia: ");
          int datar = scanner.nextInt();
          if(datar > 2024 || datar < 1900){
            System.out.println("Podano niepoprawny rok urodzenia, prosze wpisac liczbe od 1900 do 2024. Zacznij wprowadzanie danych od nowa");
            break;
          }
          s.addStudent(new Student(imie, nazwisko, wiek, datad, datam, datar));
          break;
        case 2:
          var students = s.getStudents();
          for(Student current : students) {
            System.out.println(current.ToString());
          }
          break;
        case 3:
          System.out.println("Podaj nazwisko studenta do wyszukania:");
          String nazwiskowyszuk = scanner.next();
          Student studentFound = s.findStudentByName(nazwiskowyszuk);
          if (studentFound != null) {
              System.out.println("Znaleziono studenta: " + studentFound.ToString());
          } else {
              System.out.println("Nie znaleziono studenta o nazwisku: " + nazwiskowyszuk);
          }
          break;
        case 4:
          System.exit(0);
          break;
          
      }

    } catch (IOException e) {

    }
  }
}
