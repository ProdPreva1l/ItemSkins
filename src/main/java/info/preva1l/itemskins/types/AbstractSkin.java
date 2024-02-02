package info.preva1l.itemskins.types;

import info.preva1l.itemskins.utils.StringUtils;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractSkin {
    /**
     * Whether the skin is able to be applied.
     *
     * @default true
     * @return boolean
     */
    public boolean enabled() {
        return true;
    }
    /**
     * Unique Identifier, plain text only
     *
     * @return String (id)
     */
    public abstract String id();
    /**
     * Implement the function to add the skin to the correct list
     */
    public abstract void addToList();
    /**
     * Custom Model Data to apply to the item
     *
     * @return int (model data)
     */
    public abstract int modelData();
    /**
     * Visual Name (Colour Code/Hex Support)
     *
     * @return String (name)
     */
    public abstract String name();

    /**
     * What permission the player needs to be able to apply this skin
     * @return string permission
     */
    public abstract String permission();
    /**
     * Lore of the skin, defaults to skin name
     *
     * @return List (id)
     */
    public List<String> lore() {
        List<String> lore = new ArrayList<>();
        lore.add(name());
        return StringUtils.colorizeList(lore);
    }
}
