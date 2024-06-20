public class Student {

  private String Name;
  private int Age;
  private String Surname;
  private int Datad;
  private int Datam;
  private int Datar;

  public Student(String name, String surname, int age, int datad, int datam, int datar) {
    Name = name;
    Age = age;
    Surname = surname;
    Datad = datad;
    Datam = datam;
    Datar = datar;
  }

  public String GetName() {return Name;}
  public int GetAge() {return Age;}
  public String GetSurname() {return Surname;}
  public int GetDatad() {return Datad;}
  public int GetDatam() {return Datam;}
  public int GetDatar() {return Datar;}

  public String ToString() {
    return Name + " " + Surname + " " + Integer.toString(Age) + " " + Integer.toString(Datad) + "-" + Integer.toString(Datam) + "-" + Integer.toString(Datar);
  }

  public static Student Parse(String str) {
    String[] data = str.split("[ -]");
    if(data.length != 6) 
      return new Student("Parse error","Parse Error", -1, -1, -1, -1);
    return new Student(data[0], data[1], Integer.parseInt(data[2]),Integer.parseInt(data[3]),Integer.parseInt(data[4]),Integer.parseInt(data[5]));
  }
}
