package poly;

public class Bus implements Transport {

    private int countOfPassengers = 0;

    @Override
    public void drive() {
        System.out.println("Автобус едет по маршруту");
    }

    @Override
    public void passengers(int countPassengers) {
        this.countOfPassengers = countPassengers;
    }

    @Override
    public int refuel(int liters) {
        int price = liters * 50;
        System.out.println("it cost " + price);
        return price;
    }
}
