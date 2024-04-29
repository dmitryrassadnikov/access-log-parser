package oopintro;

public class StartMyClass {
    public static void main(String[] args) {
        MyClass myObject = new MyClass("Иван");
        System.out.println(myObject.toString()); // Вызовем метод toString()
        System.out.println(myObject.toString()); // Вызовем метод toString() ещё раз
    }
}

