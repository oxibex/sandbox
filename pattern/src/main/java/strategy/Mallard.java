package strategy;


public class Mallard extends Duck {

    public Mallard() {
        setFlyStrategy(new NormalFlying());
        setQuackStrategy(new CommonQuack());
    }
}
