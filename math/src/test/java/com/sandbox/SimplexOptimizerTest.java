package com.sandbox;

import org.apache.commons.math3.analysis.MultivariateFunction;
import org.apache.commons.math3.optim.InitialGuess;
import org.apache.commons.math3.optim.MaxEval;
import org.apache.commons.math3.optim.PointValuePair;
import org.apache.commons.math3.optim.nonlinear.scalar.GoalType;
import org.apache.commons.math3.optim.nonlinear.scalar.ObjectiveFunction;
import org.apache.commons.math3.optim.nonlinear.scalar.noderiv.NelderMeadSimplex;
import org.apache.commons.math3.optim.nonlinear.scalar.noderiv.SimplexOptimizer;
import org.apache.commons.math3.util.FastMath;
import org.junit.jupiter.api.Test;

/**
 * Nikolay Chechenko
 * on 02.03.2020
 */
public class SimplexOptimizerTest {

    @Test
    void simplexOptimizer() {
        MultivariateFunction f = getMultivariateFunction();
        SimplexOptimizer optimizer = new SimplexOptimizer(1e-10, 1e-30);
        PointValuePair optimize = optimizer.optimize(new MaxEval(10000),
                new ObjectiveFunction(f),
                GoalType.MINIMIZE,
                new InitialGuess(new double[]{20}),
                new NelderMeadSimplex(new double[]{1}, 1.0, 1.0, 1, 1.0));

        System.out.println("Optimun " + optimize.getValue() + " at point " + optimize.getPoint()[0]);
    }

    private MultivariateFunction getMultivariateFunction() {
        return point -> {
            System.out.println("Current iteration X = " + point[0]);
            return 2 * FastMath.pow(point[0], 2) + 3 * point[0] + 5;
        };
    }
}
