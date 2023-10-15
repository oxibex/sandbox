package visitor;

/**
 * @author nchechenko
 * @since 01.09.2023
 */
public class Cow implements Animal {
    @Override
    public void say() {
        System.out.println("Muuuu");
    }

    @Override
    public void accept(AnimalVisitor visitor) {
        visitor.visit(this);
    }
}
