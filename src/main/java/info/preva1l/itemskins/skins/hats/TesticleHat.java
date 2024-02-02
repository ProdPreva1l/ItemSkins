package info.preva1l.itemskins.skins.hats;

import info.preva1l.itemskins.types.AbstractHatSkin;

public class TesticleHat extends AbstractHatSkin {
    @Override
    public String id() {
        return "TesticleHat";
    }

    @Override
    public int modelData() {
        return 56;
    }

    @Override
    public String name() {
        return "&cTess &eTickle &fHat";
    }
    @Override
    public String permission() {
        return "itemskins.hats.testicle";
    }
}
