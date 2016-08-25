package magic;

import perform.Performable;

public class Magician implements Performable {

    private MagicBox magicBox;

    public void setMagicBox(MagicBox magicBox) {
        this.magicBox = magicBox;
    }

    @Override
    public void perform() {
        System.out.println("Prepare for magic magic: " +  magicBox.getContent());
    }
}
