package sandbox.linear;


import org.apache.commons.math3.optim.PointValuePair;
import org.apache.commons.math3.optim.linear.LinearConstraint;
import org.apache.commons.math3.optim.linear.LinearConstraintSet;
import org.apache.commons.math3.optim.linear.LinearObjectiveFunction;
import org.apache.commons.math3.optim.linear.NonNegativeConstraint;
import org.apache.commons.math3.optim.linear.Relationship;
import org.apache.commons.math3.optim.linear.SimplexSolver;
import org.apache.commons.math3.optim.nonlinear.scalar.GoalType;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;

/**
 * oxibex@gmail.com
 * on 07.10.2019
 */
public class LinearTest {

    /**
     * Linear optimization problem. Try to repeat the results after author of video  https://youtu.be/tpEo85lS4-o
     */
    @Test
    public void linearTest() {
        LinearObjectiveFunction function = new LinearObjectiveFunction(new double[]{10,12,8},0);
        Collection constraints = new ArrayList<LinearConstraint>();
        constraints.add(new LinearConstraint(new double[]{3,4,2}, Relationship.LEQ, 1020));
        constraints.add(new LinearConstraint(new double[]{4,3,3}, Relationship.LEQ, 940));
        constraints.add(new LinearConstraint(new double[]{5,3,5}, Relationship.LEQ, 1010));

        PointValuePair solution = new SimplexSolver()
                .optimize(
                        function,
                        new LinearConstraintSet(constraints),
                        GoalType.MAXIMIZE,
                        new NonNegativeConstraint(true)
                );
        Assert.assertEquals(solution.getPoint()[0], 0, 0);
        Assert.assertEquals(solution.getPoint()[1], 220, 0);
        Assert.assertEquals(solution.getPoint()[2], 70, 0);
    }

}
