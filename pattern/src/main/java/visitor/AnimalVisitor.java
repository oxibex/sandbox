package visitor;

/**
 * @author nchechenko
 * @since 01.09.2023
 */
public interface AnimalVisitor {

    void visit(Cat cat);
    void visit(Dog dog);
    void visit(Cow cow);

}
