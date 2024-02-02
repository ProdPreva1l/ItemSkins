package info.preva1l.itemskins.skins.hats;

import info.preva1l.itemskins.types.AbstractHatSkin;

public class TestHat extends AbstractHatSkin {
    @Override
    public String id() {
        return "TestHat";
    }
    @Override
    public int modelData() {
        return 50;
    }

    @Override
    public String name() {
        return "&d&lTest Hat";
    }
    @Override
    public String permission() {
        return "itemskins.hats.test";
    }

}
