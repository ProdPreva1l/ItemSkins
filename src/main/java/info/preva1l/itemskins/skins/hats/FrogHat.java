package info.preva1l.itemskins.skins.hats;

import info.preva1l.itemskins.types.AbstractHatSkin;
import info.preva1l.itemskins.utils.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class FrogHat extends AbstractHatSkin {
    @Override
    public String id() {
        return "FrogHat";
    }


    @Override
    public int modelData() {
        return 50;
    }

    @Override
    public String name() {
        return "&a&lFrog Hat";
    }
    @Override
    public String permission() {
        return "itemskins.hats.frog";
    }

    @Override
    public List<String> lore() {
        List<String> lore = new ArrayList<>();
        lore.add(name());
        lore.add("&2\"Ribbit\" &fsaid the frog!");
        return StringUtils.colorizeList(lore);
    }
}
