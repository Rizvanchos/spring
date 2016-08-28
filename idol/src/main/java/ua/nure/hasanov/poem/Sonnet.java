package ua.nure.hasanov.poem;

import org.springframework.stereotype.Component;

@Component
public class Sonnet implements Poem {

    private static final String[] LINES = {"First line", "Second line", "Third line"};

    private void init() {
        System.out.println("Opening poem...");
    }

    @Override
    public void recite() {
        for (int i = 0; i < LINES.length; i++) {
            System.out.println(LINES[i]);
        }
    }

    private void destroy() {
        System.out.println("Closing poem...");
    }
}
