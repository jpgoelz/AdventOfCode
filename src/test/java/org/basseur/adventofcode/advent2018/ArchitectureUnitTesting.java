package org.basseur.adventofcode.advent2018;

import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ClassFileImporter;
import com.tngtech.archunit.core.importer.ImportOption;
import org.basseur.adventofcode.advent2018.days.Days;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.springframework.stereotype.Component;

import static com.tngtech.archunit.core.domain.JavaClass.Predicates.implement;
import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;


@Category(ArchitectureUnitTest.class)
public class ArchitectureUnitTesting {

    private final JavaClasses allClasses = new ClassFileImporter()
            .withImportOption(new ImportOption.DontIncludeTests())
            .importPackages("org.basseur.adventofcode");

    @Test
    public void classesImplementingDaysShouldBeAnnotatedAsComponents() {
        classes().that(implement(Days.class))
                .should().beAnnotatedWith(Component.class)
                .because("we need to register the Day's solutions within the application context.")
                .check(allClasses);
    }

}