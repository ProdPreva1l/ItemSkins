package info.preva1l.itemskins.skins.hats;

import info.preva1l.itemskins.types.AbstractHatSkin;

public class NewYears extends AbstractHatSkin {
    @Override
    public String id() {
        return "NewYears";
    }

    @Override
    public int modelData() {
        return 2;
    }
    @Override
    public String name() {
        return "&b&lNew Years &fHat";
    }
    @Override
    public String permission() {
        return "itemskins.hats.newyears";
    }
}