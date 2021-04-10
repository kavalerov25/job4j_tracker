package transport;

public class Airplane implements Vehicle {
    @Override
    public void move() {
        System.out.println(getClass().getSimpleName() + " двигается  по воздуху");
    }

    public static void main(String[] args) {
        Vehicle airplane = new Airplane();
        Vehicle train = new Train();
        Vehicle bus = new Bus();
        Vehicle[] array = new Vehicle[]{airplane, train, bus};
        for (Vehicle a : array) {
            a.move();
        }
    }
}