package visitor;

/**
 * @author nchechenko
 * @since 05.09.2023
 */
public class AnimalVisitorImpl implements AnimalVisitor {
    @Override
    public void visit(Cat cat) {
        System.out.println("Cat visited");
    }

    @Override
    public void visit(Dog dog) {
        System.out.println("Dog visited");
    }

    @Override
    public void visit(Cow cow) {
        System.out.println("Cow visited");
    }
}
