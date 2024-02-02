package info.preva1l.itemskins.skins.hats;

import info.preva1l.itemskins.types.AbstractHatSkin;
public class ChristmasHat extends AbstractHatSkin {
    @Override
    public String id() {
        return "ChristmasHat";
    }

    @Override
    public int modelData() {
        return 4;
    }

    @Override
    public String name() {
        return "&nChristmas Hat";
    }
    @Override
    public String permission() {
        return "itemskins.hats.christmas";
    }
}
