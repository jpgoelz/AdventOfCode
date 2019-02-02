package org.basseur.adventofcode.advent2018.archUnitTestingUtils;

import com.tngtech.archunit.base.DescribedPredicate;
import com.tngtech.archunit.core.domain.JavaMethod;

import javax.annotation.Nonnull;

/**
 * Checks if the number of parameters in a method exceeds a given threshold.
 */
public class MethodPredicates extends DescribedPredicate<JavaMethod> {

    private final int allowedNumberOfParameters;

    @Nonnull
    public static MethodPredicates moreParametersThan(final int allowedNumberOfParameters) {
        return new MethodPredicates(allowedNumberOfParameters);
    }

    public MethodPredicates(final int allowedNumberOfParameters) {
        super("more than %s parameters", allowedNumberOfParameters);
        this.allowedNumberOfParameters = allowedNumberOfParameters;
    }

    @Override
    public boolean apply(JavaMethod method) {
        return method.getParameters().size() > allowedNumberOfParameters;
    }
}
