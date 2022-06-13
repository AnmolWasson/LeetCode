import java.util.*;

// java is platform independent

// c is a  procedural or structural language
// C++ / Java is Object oriented

// nouns , verbs , adjectives

// noun ==> class
// verbs ==> functions

// adjectives ==>data members

// C lang only have functions
//  where as C++ and java have class, obj , functions and data members also

public class lecture1 {

  // the lecture1 class is dependent on Student class therefore before the execution of the main the blue print of all dependent classes came inside the heap
  static class Student {

    // data members
    String name; // null
    //String is itself a class and therefor its default value is null
    // STring is created inside heap inside intern pool
    int age; // 0

// this refers to teh crt obj of teh class
void introduceYourSelf(){

    // this cant be used with local variables of the function
    //this is used with the data members of the class
    System.out.println(this.name+ "is "+ this.age+" years old");
}

void introduceYourSelf(String name,int age){

    this .name=name;
    this.age=age;
    System.out.println(this.name+ "is "+ this.age+" years old");
}

void test(Student s){
  s.introduceYourSelf();
  System.out.println(s.name);
}

  

  }

  // client
  public static void main(String[] args) {
    Student s1 = new Student();

    // when ever we use new we allocate space in heap
    // left side runs first and creates an instance inside the heap

    // right side runs and creates a referance
    // in stack  s1 =(address of stdent (in heap)  ) 4k
    // where as in heap when the instance is created initially default values are assigned to the class data members

    //****   object means instance( the right side which is created inside heap) ****//

    System.out.println(s1.name); // null
    System.out.println(s1.age); //0
    System.out.println(s1); // it will print the address of the object or the instance
    s1.name = "Amit";
    s1.age = 10;
    // this will make change for the object s1 only
    System.out.println(s1.name); // Amit
    System.out.println(s1.age); //10

    // Creating a new reference
    Student s2 = s1;
    // s1=s2=4k;
    // they both points to the same memory locations

    s2.name = "Rohan";
    System.out.println(s1.name); //Rohan

    Student s3 = new Student();
    s3.age = 10;
    s3.name = "A";

    Student s4 = new Student();
    s3.age = 20;
    s3.name = "B";

    Test1(s3, s4);

    // no changes will occour
    //  bcz Java is pass by value
    System.out.println(s3.age + " " + s3.name); // 10 A
    System.out.println(s4.age + " " + s4.name); // 20 B

    // Case 2

    Test2(s3, s4);
    // it will make the changes
    System.out.println(s3.age + " " + s3.name); // 20 B
    System.out.println(s4.age + " " + s4.name); // 10 A
    // for case 3
    //  20 A
    //  10 null

    //for case 4
    // 0 A
    // 20  B

    // case 5
    int myAge = 30;
    String myName = "C";
    Test3(s3, s4.age, s4.name, myAge, myName);

    System.out.println(s3.age + " " + s3.name);
    System.out.println(s4.age + " " + s4.name);


    s1.introduceYourSelf();
    s2.introduceYourSelf();


  }

  static void Test3(Student s1,int age,String name,int myAge,String myName) {
    //this will create changes  in the heap  
    s1.age = 0;
    s1.name = "_";

    // these all are the  local variables
    age = 0;
    name = "_";
    myAge = 0;
    myName = "_";
  }

  // it will make changes in the heap
  private static void Test2(Student s3, Student s4) {
    // case 4
    s4 = new Student();

    int temp = s3.age;
    s3.age = s4.age;
    s4.age = temp;

    //Case 3
    // if we add this sattement
    s3 = new Student();
    // a new instance is created
    // giving new address to s3

    String tempn = s3.name;
    s3.name = s4.name;
    s4.name = tempn;
  }

  static void Test1(Student s1, Student s2) {
    // s1 and s2  are the local variables of Test1
    //s1= 3k and s2=5k
    Student temp = s1; // temp=3k;
    s1 = s2; //s1=5k
    s2 = temp; // s2=3k
    // as the function end these variables are distroyed there for no changes are performed

  }
}
