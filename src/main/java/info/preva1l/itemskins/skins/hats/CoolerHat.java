package info.preva1l.itemskins.skins.hats;

import info.preva1l.itemskins.types.AbstractHatSkin;
public class CoolerHat extends AbstractHatSkin {
    @Override
    public String id() {
        return "CoolerHat";
    }
    @Override
    public int modelData() {
        return 69;
    }

    @Override
    public String name() {
        return "&4&lCooler Hat";
    }
    @Override
    public String permission() {
        return "itemskins.hats.cooler";
    }
}
