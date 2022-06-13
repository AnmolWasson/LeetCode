import javax.xml.stream.util.StreamReaderDelegate;

// java is platform independent 

// c is a  procedural or structural language 
// C++ / Java is Object oriented 
 

// nouns , verbs , adjectives 

// noun ==> class
// verbs ==> functions 

// adjectives ==>data members 

// C lang only have functions 
//  where as C++ and java have class, obj , functions and data members also


public class lecture1{

// the lecture1 class is dependent on Student class therefore before the execution of the main the blue print of all dependent classes came inside the heap
    public class student{

        // data members 
         String name ;// null
         //String is itself a class and therefor its default value is null
         // STring is created inside heap inside intern pool
         int age;// 0



    }

// client 
    public static void main(String[] args) {
         
        Student s1=new Student();  // when ever we use new we allocate space in heap
        // left side runs first and creates an instance inside the heap 

        // right side runs and creates a referance 
        // in stack  s1 =(address of stdent (in heap)  ) 4k
        // where as in heap when the instance is created initially default values are assigned to the class data members


           
    }
}
