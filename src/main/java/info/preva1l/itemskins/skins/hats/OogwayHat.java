package info.preva1l.itemskins.skins.hats;

import info.preva1l.itemskins.types.AbstractHatSkin;
import info.preva1l.itemskins.utils.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class OogwayHat extends AbstractHatSkin {
    @Override
    public String id() {
        return "OogwayHat";
    }
    @Override
    public int modelData() {
        return 76;
    }

    @Override
    public String name() {
        return "&#FF0000&lOOGWAY!";
    }
    @Override
    public String permission() {
        return "itemskins.hats.oogway";
    }

    @Override
    public List<String> lore() {
        List<String> lore = new ArrayList<>();
        lore.add(name());
        lore.add("&a&oMasta Oogway");

        return StringUtils.colorizeList(lore);
    }
}
