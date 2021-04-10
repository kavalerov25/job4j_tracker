package transport;

public class Train implements Vehicle  {
    @Override
    public void move() {
        System.out.println(getClass().getSimpleName() + " двигается по рельсам");
    }
}
