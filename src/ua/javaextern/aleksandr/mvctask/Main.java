package ua.javaextern.aleksandr.mvctask;

public class Main {
    public static void main(String[] args) {
        Controller controller = new Controller(new View(),new Model());
        controller.run(0,100,10);
    }
}
