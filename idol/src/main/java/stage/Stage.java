package stage;

public class Stage {

    private Stage() {
    }

    private static class StageSingletonHolder {
        static Stage INSTANCE = new Stage();
    }

    public static Stage getInstance() {
        return StageSingletonHolder.INSTANCE;
    }

}
