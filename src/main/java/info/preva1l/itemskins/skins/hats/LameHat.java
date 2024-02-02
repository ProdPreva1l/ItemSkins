package info.preva1l.itemskins.skins.hats;

import info.preva1l.itemskins.types.AbstractHatSkin;

public class LameHat extends AbstractHatSkin {
    @Override
    public String id() {
        return "LameHat";
    }

    @Override
    public int modelData() {
        return 5;
    }

    @Override
    public String name() {
        return "&dThe person wearing this is lame!!";
    }
    @Override
    public String permission() {
        return "itemskins.hats.lame";
    }
}
