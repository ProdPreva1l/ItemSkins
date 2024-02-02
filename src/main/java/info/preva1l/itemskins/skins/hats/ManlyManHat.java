package info.preva1l.itemskins.skins.hats;

import info.preva1l.itemskins.types.AbstractHatSkin;

public class ManlyManHat extends AbstractHatSkin {
    @Override
    public String id() {
        return "ManlyManHat";
    }

    @Override
    public int modelData() {
        return 55;
    }

    @Override
    public String name() {
        return "&eManly Man!!!";
    }
    @Override
    public String permission() {
        return "itemskins.hats.manlyman";
    }
}
