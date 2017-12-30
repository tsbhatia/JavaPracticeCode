import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

/*
This class do the sorting of the input data  by 
student name and search the data by student name. 
Student data is given as file. Each line has name 
and gpa score separated by space. This search is 
based on java library binary search.
*/
class BinarySearchStudents{
 public static class Student{
  public String name;
  public double gpa;
  Student(String name, double gpa){
   this.name = name;
   this.gpa = gpa;
  }

  @Override
  public String toString(){
   return String.format("%s %.2f", name, gpa);
  }
 }
 
 public static final Comparator<Student> compGPA = new Comparator<Student>(){
  public int compare(Student a, Student b){
   return a.name.compareTo(b.name);
  }
 };

 public static int searchGPA(List<Student> students, Student target, Comparator<Student> compgpa){
  return Collections.binarySearch(students, target, compgpa);
 }

 public static void main(String args[]){
  List<Student> students = new ArrayList<Student>();
  System.out.println("Enter the student file name");
  Scanner sc = new Scanner(System.in);
  String filename = sc.nextLine();
  File file = new File(filename);
  if(file.exists()){
    System.out.println("Reading file: "+ filename);
    try{
     sc = new Scanner(file);
    }catch (FileNotFoundException e){
     System.out.println("No such file found: "+ filename);
     System.exit(0);
    }
    while(sc.hasNext()){
      String line = sc.nextLine();
      System.out.println("Processing following data: "+ line);
      String delimiter = "[ ]+";
      String[] linedata = line.split(delimiter);
      String name = linedata[0];
      double gpa = Double.parseDouble(linedata[1]);
      students.add(new Student(name, gpa));
    }
    sc.close();
  }else{
    System.out.println("No such file exist");
    System.exit(0);
  }
  if(!students.isEmpty()){
    Collections.sort(students, compGPA);
  }
  System.out.println("Data after sorting: "+students);
  
  sc = new Scanner(System.in);
  System.out.println("Enter student name to be searched: ");
  String stud = sc.nextLine();
  
  int index = Collections.binarySearch(students, new Student(stud, 0.0), compGPA);
  if(index != -1){
   System.out.println(String.format("Student: %s, has GPA: %.2f", 
                                        students.get(index).name, 
                                        students.get(index).gpa));
  } else{
   System.out.println("No such record found in student data");
  }
 }

}
