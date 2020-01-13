package strategy;


public class DomesticDuck extends Duck {

    public DomesticDuck() {
        setFlyStrategy(new NotFlying());
        setQuackStrategy(new CommonQuack());
    }
}
