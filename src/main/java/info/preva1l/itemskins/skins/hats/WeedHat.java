package info.preva1l.itemskins.skins.hats;

import info.preva1l.itemskins.types.AbstractHatSkin;

public class WeedHat extends AbstractHatSkin {
    @Override
    public String id() {
        return "WeedHat";
    }

    @Override
    public int modelData() {
        return 420;
    }

    @Override
    public String name() {
        return "&2Weed Hat";
    }

    @Override
    public String permission() {
        return "itemskins.hats.weed";
    }
}
