package visitor;

/**
 * @author nchechenko
 * @since 01.09.2023
 */
public class Cat implements Animal {

    @Override
    public void say() {
        System.out.println("May may");
    }

    @Override
    public void accept(AnimalVisitor visitor) {
        visitor.visit(this);
    }
}
