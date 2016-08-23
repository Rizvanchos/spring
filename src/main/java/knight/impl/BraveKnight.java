package knight.impl;

import knight.Knight;
import quest.Quest;

public class BraveKnight implements Knight {

    private final Quest knightQuest;

    public BraveKnight(final Quest knightQuest) {
        this.knightQuest = knightQuest;
    }

    public void embarkQuest() {
        knightQuest.quest();
    }

}
