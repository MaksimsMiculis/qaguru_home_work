package oop;

import org.junit.jupiter.api.Test;

public class StudentTest {
    @Test
    public void checkStudent(){

        Student alisa = new Student();
        alisa.setFirstName("Stepanovna");
        alisa.setSecondName("Alisovna");
        alisa.setAge(18);
        alisa.setSex(true);

        Student arturik = new Student ();
        arturik.setFirstName("Arturio");
        arturik.setSecondName("Griffin");
        arturik.setAge(17);
        arturik.setSex(false);
        arturik.setDebts(true);



        System.out.println("Full name is: " + alisa.getFirstName() + " " + alisa.getSecondName());
        System.out.println("Full name is: " + arturik.getFirstName() + " " + arturik.getSecondName());
        System.out.println(alisa.getFullName());

    }
}

