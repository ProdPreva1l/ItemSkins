package info.preva1l.itemskins.skins.hats;

import info.preva1l.itemskins.types.AbstractHatSkin;

public class Preva1lHat extends AbstractHatSkin {
    @Override
    public String id() {
        return "Preva1lHat";
    }
    @Override
    public int modelData() {
        return 84;
    }

    @Override
    public String name() {
        return "&9&lPreva1l's Hat";
    }
    @Override
    public String permission() {
        return "itemskins.hats.preva1l";
    }
}
