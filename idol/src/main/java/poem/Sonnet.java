package poem;

public class Sonnet implements Poem {

    private static final String[] LINES = {"First line", "Second line", "Third line"};

    public void recite() {
        for (int i = 0; i < LINES.length; i++) {
            System.out.println(LINES[i]);
        }
    }
}
