package org.basseur.adventofcode.advent2018;

import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ClassFileImporter;
import com.tngtech.archunit.core.importer.ImportOption;
import org.junit.Test;
import org.junit.experimental.categories.Category;

import static com.tngtech.archunit.lang.conditions.ArchPredicates.are;
import static com.tngtech.archunit.lang.conditions.ArchPredicates.have;
import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.all;
import static org.basseur.adventofcode.advent2018.archUnitTestingUtils.MethodCondition.beReturning;
import static org.basseur.adventofcode.advent2018.archUnitTestingUtils.MethodTransformer.implementedIn;
import static org.basseur.adventofcode.advent2018.archUnitTestingUtils.MethodTransformer.methods;
import static org.basseur.adventofcode.advent2018.archUnitTestingUtils.MethodTransformer.publicModifier;
import static org.basseur.adventofcode.advent2018.archUnitTestingUtils.MethodTransformer.string;


@Category(ArchitectureUnitTest.class)
public class ArchitectureUnitTesting {

    private final JavaClasses allClasses = new ClassFileImporter()
            .withImportOption(new ImportOption.DontIncludeTests())
            .importPackages("org.basseur.adventofcode");

    @Test
    public void publicMethodsInServicesMustReturnServiceCallResults() {
        all(methods())
                .that(are(implementedIn("dummy"))
                        .and(have(publicModifier())))
                .should(beReturning(string()))
                .check(allClasses);
    }

}