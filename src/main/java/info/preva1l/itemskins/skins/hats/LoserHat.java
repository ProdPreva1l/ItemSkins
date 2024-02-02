package info.preva1l.itemskins.skins.hats;

import info.preva1l.itemskins.types.AbstractHatSkin;

public class LoserHat extends AbstractHatSkin {
    @Override
    public String id() {
        return "LoserHat";
    }

    @Override
    public int modelData() {
        return 69;
    }

    @Override
    public String name() {
        return "&dTake the L";
    }
    @Override
    public String permission() {
        return "itemskins.hats.loser";
    }
}
