package strategy;


public class Main {

    public static void main(String[] args) {
        Duck mallard = new Mallard();
        mallard.doFly();
        mallard.doQuack();

        Duck domesticDuck = new DomesticDuck();
        domesticDuck.doFly();
        domesticDuck.doQuack();

    }

}
