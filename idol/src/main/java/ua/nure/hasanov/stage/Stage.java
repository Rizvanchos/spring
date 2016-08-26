package ua.nure.hasanov.stage;

import org.springframework.stereotype.Component;

@Component
public class Stage {

    private Stage() {
    }

    public void afterPropertiesSet() throws Exception {
        System.out.println("Stage.afterPropertiesSet");
    }

    private static class StageSingletonHolder {
        static Stage INSTANCE = new Stage();
    }

    public static Stage getInstance() {
        return StageSingletonHolder.INSTANCE;
    }

    public void turnOnLights() {
        System.out.println("Turning on lights...");
    }

    public void turnOffLights() {
        System.out.println("Turning off lights...");
    }

}
