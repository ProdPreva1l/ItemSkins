package info.preva1l.itemskins.guis;

import info.preva1l.itemskins.types.AbstractSkin;
import info.preva1l.itemskins.skins.SkinHelper;
import info.preva1l.itemskins.utils.StringUtils;
import info.preva1l.itemskins.utils.FastInv;
import info.preva1l.itemskins.utils.ItemBuilder;
import info.preva1l.itemskins.utils.SoundUtils;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;

import java.util.List;

public class AllSkinsGUI extends FastInv {
    private int page;
    private final int maxItemsPerPage = 15;
    private int index = 0;
    private final String category;
    private final Player player;
    private final List<String> itemList;
    public AllSkinsGUI(Player player, String category,  int page) {
        super(54, StringUtils.colorize("&fItem Skins &7All " + StringUtils.capitalize(category) + " Skins"));

        this.player = player;

        this.category = category;
        this.page = page;

        this.itemList = switch (category) {
            case "axe" -> SkinHelper.getAxes();
            case "pickaxe" -> SkinHelper.getPickaxes();
            case "hat" -> SkinHelper.getHats();
            case "sword" -> SkinHelper.getSwords();
            case "hoe" -> SkinHelper.getHoes();
            case "shovel" -> SkinHelper.getShovels();
            default -> SkinHelper.getDefaultList();
        };

        fillBackground();
        addCategoryItems();
        setPaginatedItems();
        addNavigationButtons();
    }

    private void setPaginatedItems() {
        if (itemList != null && !itemList.isEmpty()) {
            for (int i = 0; i < maxItemsPerPage; i++) {
                index = maxItemsPerPage * page + i;
                if (index >= itemList.size()) break;
                AbstractSkin skin = SkinHelper.getSkinMap().get(itemList.get(index));
                addItem(skinItem(skin).build(), e -> {
                    SoundUtils.click(player);
                });
            }
        }
    }

    private ItemBuilder skinItem(AbstractSkin skin) {
        return new ItemBuilder(switch (category) {
            case "axe" -> Material.DIAMOND_AXE;
            case "pickaxe" -> Material.DIAMOND_PICKAXE;
            case "hat" -> Material.DIAMOND_HELMET;
            case "sword" -> Material.DIAMOND_SWORD;
            case "hoe" -> Material.DIAMOND_HOE;
            case "shovel" -> Material.DIAMOND_SHOVEL;
            default -> Material.BARRIER;
        })
                .name(StringUtils.colorize(skin.name()))
                .lore(skin.lore())
                .modelData(skin.modelData())
                .flags(ItemFlag.HIDE_ENCHANTS);
    }

    private void fillBackground() {
        setItems(1, 7, createBackgroundItem().build());
        setItems(36, 53, createBackgroundItem().build());
        setItems(new int[]{10, 16, 19, 25, 27, 28, 34, 35}, createBackgroundItem().build());
    }
    private ItemBuilder createBackgroundItem() {
        return new ItemBuilder(Material.BLACK_STAINED_GLASS_PANE).name(" ");
    }

    private void addCategoryItems() {
        addCategoryItem(Material.DIAMOND_SWORD, "Sword", 0);
        addCategoryItem(Material.DIAMOND_PICKAXE, "Pickaxe", 9);
        addCategoryItem(Material.DIAMOND_AXE, "Axe", 18);
        addCategoryItem(Material.DIAMOND_HOE, "Hoe", 8);
        addCategoryItem(Material.DIAMOND_SHOVEL, "Shovel", 17);
        addCategoryItem(Material.DIAMOND_HELMET, "Hat", 26);
    }
    private void addCategoryItem(Material material, String category, int slot) {
        ItemBuilder itemBuilder = new ItemBuilder(material)
                .name(StringUtils.colorize("&b" + category + " Skins"))
                .enchant(Enchantment.DURABILITY)
                .flags(ItemFlag.HIDE_ENCHANTS);

        if (!this.category.equalsIgnoreCase(category.toLowerCase())) {
            itemBuilder.removeEnchants();
        }

        setItem(slot, itemBuilder.build(), e->{
            new AllSkinsGUI(player, category.toLowerCase(), 0).open(player);
            SoundUtils.click(player);
        });
    }

    @SuppressWarnings("ConstantConditions")
    private void addNavigationButtons() {
        setItem(45, createNavigationItem(Material.ARROW, "&c&lGo Back", "&7\u279C Click to go back"), e -> {
            SoundUtils.click(player);
            new MainGUI(player).open(player);
        });
        setItem(49, createNavigationItem(Material.BARRIER, "&c&lClose", "&7\u279C Click to close"), e -> {
            SoundUtils.click(player);
            e.getClickedInventory().close();
        });
        if (page > 0) {
            setItem(48, createNavigationItem(Material.FEATHER, "&cPrevious Page", "&7\u279C Click to go to the previous page"), e -> {
                SoundUtils.click(player);
                page -= 1;
                new AllSkinsGUI(player, category, page).open(player);
            });
        }
        if (itemList.size() >= index + 2) {
            setItem(50, createNavigationItem(Material.FEATHER, "&aNext Page", "&7\u279C Click to go to the next page"), e -> {
                SoundUtils.click(player);
                page += 1;
                new AllSkinsGUI(player, category, page).open(player);
            });
        }
    }

    private ItemStack createNavigationItem(Material material, String displayName, String lore) {
        return new ItemBuilder(material)
                .flags(ItemFlag.HIDE_ATTRIBUTES)
                .name(StringUtils.colorize(displayName))
                .addLore(StringUtils.colorize(lore))
                .build();
    }
}
