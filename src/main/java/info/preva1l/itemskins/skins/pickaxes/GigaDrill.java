package info.preva1l.itemskins.skins.pickaxes;

import info.preva1l.itemskins.types.AbstractPickaxeSkin;
import info.preva1l.itemskins.utils.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class GigaDrill extends AbstractPickaxeSkin {

    @Override
    public String id() {
        return "GigaDrill";
    }

    @Override
    public int modelData() {
        return 3;
    }

    @Override
    public String name() {
        return "&c&lGiga Drill";
    }

    @Override
    public String permission() {
        return "itemskins.pickaxes.gigadrill";
    }

    @Override
    public List<String> lore(){
        List<String> lore = new ArrayList<>();
        lore.add(name());
        lore.add("Another Line of lore");
        return StringUtils.colorizeList(lore);
    }
}
