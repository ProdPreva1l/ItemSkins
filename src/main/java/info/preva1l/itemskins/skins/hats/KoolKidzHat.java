package info.preva1l.itemskins.skins.hats;

import info.preva1l.itemskins.types.AbstractHatSkin;

public class KoolKidzHat extends AbstractHatSkin {
    @Override
    public String id() {
        return "KoolKidzHat";
    }

    @Override
    public int modelData() {
        return 4;
    }

    @Override
    public String name() {
        return "!!Kool Kidz Wear this!!";
    }
    @Override
    public String permission() {
        return "itemskins.hats.koolkidz";
    }
}
