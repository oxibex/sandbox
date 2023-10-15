package visitor;

/**
 * @author nchechenko
 * @since 01.09.2023
 */
public interface Animal {

    void say();
    void accept(AnimalVisitor visitor);

}
