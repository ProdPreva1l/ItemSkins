package info.preva1l.itemskins.skins.hats;

import info.preva1l.itemskins.types.AbstractHatSkin;

public class Y2KHat extends AbstractHatSkin {
    @Override
    public String id() {
        return "Y2KHat";
    }

    @Override
    public int modelData() {
        return 85;
    }

    @Override
    public String name() {
        return "&a&lY2K Problem";
    }
    @Override
    public String permission() {
        return "itemskins.hats.y2k";
    }
}
