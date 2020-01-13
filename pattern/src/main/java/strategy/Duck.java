package strategy;


public class Duck {

    private FlyStrategy flyStrategy;
    private QuackStrategy quackStrategy;

    public void setFlyStrategy(FlyStrategy flyStrategy) {
        this.flyStrategy = flyStrategy;
    }

    public void setQuackStrategy(QuackStrategy quackStrategy) {
        this.quackStrategy = quackStrategy;
    }

    public void doFly(){
        flyStrategy.fly();
    }

    public void doQuack(){
        quackStrategy.quack();
    }
}
