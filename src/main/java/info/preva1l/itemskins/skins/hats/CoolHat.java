package info.preva1l.itemskins.skins.hats;

import info.preva1l.itemskins.types.AbstractHatSkin;

public class CoolHat extends AbstractHatSkin {
    @Override
    public String id() {
        return "CoolHat";
    }

    @Override
    public int modelData() {
        return 67;
    }

    @Override
    public String name() {
        return "&c&lCool Hat";
    }
    @Override
    public String permission() {
        return "itemskins.hats.cool";
    }
}
