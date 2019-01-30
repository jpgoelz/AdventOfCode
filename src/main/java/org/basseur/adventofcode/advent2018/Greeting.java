package org.basseur.adventofcode.advent2018;

/**
 * Greeting is "just for fun".
 * Will be removed later.
 *
 * @author Michelle Fernandez Bieber
 */
public class Greeting {

    private final long id;
    private final String content;

    public Greeting(long id, String content) {
        this.id = id;
        this.content = content;
    }

    public long getId() {
        return id;
    }

    public String getContent() {
        return content;
    }
}
