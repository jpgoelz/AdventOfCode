package org.basseur.adventofcode.advent2018;

import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ClassFileImporter;
import com.tngtech.archunit.core.importer.ImportOption;
import org.junit.experimental.categories.Category;


@Category(ArchitectureUnitTest.class)
public class ArchitectureUnitTesting {

    private final JavaClasses allClasses = new ClassFileImporter()
            .withImportOption(new ImportOption.DontIncludeTests())
            .importPackages("org.basseur.adventofcode");

    /*@Test
    public void publicMethodsInServicesMustReturnServiceCallResults() {
        all(methods())
                .that(are(implementedIn("service"))
                        .and(have(publicModifier())))
                .should(beReturning(string()))
                .check(allClasses);
    }*/

}