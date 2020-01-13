package strategy;


public class Silent implements QuackStrategy {
    @Override
    public void quack() {
        System.out.println("...");
    }
}
