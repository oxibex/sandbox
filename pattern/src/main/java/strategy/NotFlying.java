package strategy;

public class NotFlying implements FlyStrategy {
    @Override
    public void fly() {
        System.out.println("I can't fly...");
    }
}
