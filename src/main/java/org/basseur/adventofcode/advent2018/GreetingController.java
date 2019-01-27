package org.basseur.adventofcode.advent2018;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@RestController
public class GreetingController {

    private static final String template = "Hello, %s!";
    private static final List<String> TAGE = Arrays.asList("Montag", "Dienstag", "Mittwoch", "Donnerstag", "Freitag", "Samstag", "Sonntag");
    private static final List<String> ERLAUBTE_TAGE = Arrays.asList("Freitag", "Samstag");
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/greeting")
    public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
        return new Greeting(counter.incrementAndGet(),
                String.format(template, name));
    }

    @RequestMapping("/portwein")
    public String portwein(@RequestParam(value = "tag", required = false) String tag) {
        if (TAGE.contains(tag)) {
            if (ERLAUBTE_TAGE.contains(tag)) {
                return "Ja, am " + tag + " darfst Du Portwein trinken!";
            } else {
                return "Nein, am " + tag + " solltest Du vernünftig sein!";
            }
        } else if (tag == null) {
            return "Du musst schon irgendwas eingeben. Versuchs mal mit http://localhost:8080/portwein?tag=bla";
        } else if (tag.isEmpty()) {
            return "Gebe einen der folgenden Tage an: " + String.join(", ", TAGE);
            //return "Gebe einen der folgenden Tage an: " + TAGE.stream().collect(Collectors.joining(", "));
        } else {
            return "Du bist wohl betrunken! " + tag + " ist kein Wochentag!";
        }
    }
}
