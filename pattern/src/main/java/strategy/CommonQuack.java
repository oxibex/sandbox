package strategy;

public class CommonQuack implements QuackStrategy {

    @Override
    public void quack() {
        System.out.println("quack!");
    }
}
