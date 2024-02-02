package info.preva1l.itemskins.types;

import info.preva1l.itemskins.skins.SkinHelper;

public abstract class AbstractHatSkin extends AbstractSkin {
    @Override
    public abstract String id();

    @Override
    public void addToList() {
        SkinHelper.getHats().add(id());
    }

    @Override
    public abstract int modelData();

    @Override
    public abstract String name();
}
