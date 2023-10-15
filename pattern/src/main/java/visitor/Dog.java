package visitor;

/**
 * @author nchechenko
 * @since 01.09.2023
 */
public class Dog implements Animal {
    @Override
    public void say() {
        System.out.println("Uaf");
    }

    @Override
    public void accept(AnimalVisitor visitor) {
        visitor.visit(this);
    }
}
