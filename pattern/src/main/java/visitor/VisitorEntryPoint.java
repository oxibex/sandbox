package visitor;

/**
 * @author nchechenko
 * @since 01.09.2023
 */
public class VisitorEntryPoint {

    public static void main(String[] args) {
        AnimalVisitorImpl animalVisitor = new AnimalVisitorImpl();

        Cat cat = new Cat();
        cat.say();
        cat.accept(animalVisitor);

        Dog dog = new Dog();
        dog.say();
        dog.accept(animalVisitor);

    }

}
