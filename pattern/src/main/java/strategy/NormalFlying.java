package strategy;


public class NormalFlying implements FlyStrategy {
    @Override
    public void fly() {
        System.out.println("Normal fly...");
    }
}
