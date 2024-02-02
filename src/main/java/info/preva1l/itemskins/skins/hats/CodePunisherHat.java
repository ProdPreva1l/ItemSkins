package info.preva1l.itemskins.skins.hats;

import info.preva1l.itemskins.types.AbstractHatSkin;

public class CodePunisherHat extends AbstractHatSkin {
    @Override
    public String id() {
        return "CodePunisherHat";
    }

    @Override
    public int modelData() {
        return 58;
    }

    @Override
    public String permission() {
        return "itemskins.hats.codepunisher";
    }

    @Override
    public String name() {
        return "&4CodePunisher";
    }
}