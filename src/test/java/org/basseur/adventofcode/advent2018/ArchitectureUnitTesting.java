package org.basseur.adventofcode.advent2018;

import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ClassFileImporter;
import com.tngtech.archunit.core.importer.ImportOption;
import org.basseur.adventofcode.advent2018.days.Days;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.springframework.stereotype.Component;

import java.util.List;

import static com.tngtech.archunit.core.domain.JavaClass.Predicates.implement;
import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;
import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.noClasses;
import static org.basseur.adventofcode.advent2018.archUnitTestingUtils.FieldTypePredicate.areOfType;
import static org.basseur.adventofcode.advent2018.archUnitTestingUtils.FieldsCondition.haveFieldsThat;


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

    @Test
    public void theListWithTheImplementedDaysShouldOnlyBeHandledInAdventOfCodeService() {
        noClasses().that().dontHaveSimpleName("AdventOfCodeService")
                .should(haveFieldsThat(areOfType(List.class, Days.class)))
                .because("we want only AdventOfCodeService to handle the access to the implementations of Days.")
                .check(allClasses);
        classes().that().haveSimpleName("AdventOfCodeService")
                .should(haveFieldsThat(areOfType(List.class, Days.class)))
                .because("we want only AdventOfCodeService to handle the access to the implementations of Days.")
                .check(allClasses);
    }

}