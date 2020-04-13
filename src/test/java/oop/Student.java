package oop;

public class Student {
    //-------------------PROPERTIES------------


    private String firstName;
    private String secondName;
    private boolean debts;
    private int age;
    private boolean sex;
    //getteri могут сюда попасть

    //------------------------------------------

    //-------------CONSTRUCTOR---------------------
    //как только мы заполняем студента, мы сразу хотим получить всё это
    //getteri не могут сюда попасть

    public Student(String firstName, String secondName, boolean debts, int age, boolean sex) {
        firstName = firstName;
        secondName = secondName;
        this.debts = debts;
        this.age = age;
        this.sex = sex;
    }

    public Student() {

    }
    //------------------------------------------

    //------------FUNCTIONALITY-----------------

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public boolean isDebts() {
        return debts;
    }

    public void setDebts(boolean debts) {
        this.debts = debts;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isSex() {
        return sex;
    }

    public void setSex(boolean sex) {
        this.sex = sex;
    }

    //------------------------------------------

    //------------CUSTOM FUNCTIONS--------------

    public String getFullName() {
        return firstName + " " + secondName;


    }

    //------------------------------------------


}










