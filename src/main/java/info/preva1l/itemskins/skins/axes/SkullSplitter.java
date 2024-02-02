package info.preva1l.itemskins.skins.axes;

import info.preva1l.itemskins.types.AbstractAxeSkin;
import info.preva1l.itemskins.utils.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class SkullSplitter extends AbstractAxeSkin {
    @Override
    public String id() {
        return "SkullSplitter";
    }

    @Override
    public int modelData() {
        return 20;
    }

    @Override
    public String name() {
        return "&4&lSkull Splitter";
    }
    @Override
    public String permission() {
        return "itemskins.axes.skullsplitter";
    }

    @Override
    public List<String> lore() {
        List<String> lore = new ArrayList<>();
        lore.add(name());
        lore.add("&cOnly the strongest are worthy!");
        return StringUtils.colorizeList(lore);
    }
}
