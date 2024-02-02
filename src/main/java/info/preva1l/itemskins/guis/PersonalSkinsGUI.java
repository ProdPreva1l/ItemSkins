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

public class PersonalSkinsGUI extends FastInv {
    private int page;
    private final int maxItemsPerPage = 15;
    private int index = 0;
    private final String category;
    private final Player player;
    private final List<String> checkedItemList;
    private final List<String> appliableSkins;
    public PersonalSkinsGUI(Player player, String category,  int page) {
        super(54, StringUtils.colorize("&fItem Skins &7Your " + StringUtils.capitalize(category) + " Skins"));

        this.player = player;

        this.category = category;

        this.page = page;

        this.checkedItemList = switch (category) {
            case "axe" -> SkinHelper.getAxes();
            case "pickaxe" -> SkinHelper.getPickaxes();
            case "hat" -> SkinHelper.getHats();
            case "sword" -> SkinHelper.getSwords();
            case "hoe" -> SkinHelper.getHoes();
            case "shovel" -> SkinHelper.getShovels();
            default -> SkinHelper.getDefaultList();
        };

        if (player.getItemInHand().isEmpty()) {
            this.appliableSkins = SkinHelper.getDefaultList();
        } else {
            this.appliableSkins = switch (player.getItemInHand().getType().getKey().getKey().split("_")[1]) {
                case "axe" -> SkinHelper.getAxes();
                case "pickaxe" -> SkinHelper.getPickaxes();
                case "hat" -> SkinHelper.getHats();
                case "sword" -> SkinHelper.getSwords();
                case "hoe" -> SkinHelper.getHoes();
                case "shovel" -> SkinHelper.getShovels();
                default -> SkinHelper.getDefaultList();
            };
        }

        fillBackground();
        addCategoryItems();
        setPaginatedItems();
        addNavigationButtons();

        setItem(45, createNavigationItem(Material.RED_CONCRETE, "&c&lRemove Skin", "&7\u279C Click to remove the skin from your item!"), e -> {
            if (player.getItemInHand().isEmpty()) {
                SoundUtils.fail(player);
                return;
            }
            SkinHelper.removeSkin(player);
            SoundUtils.success(player);
        });
    }

    private void setPaginatedItems() {
        if (checkedItemList != null && !checkedItemList.isEmpty()) {
            for (int i = 0; i < maxItemsPerPage; i++) {
                index = maxItemsPerPage * page + i;
                if (index >= checkedItemList.size()) break;
                AbstractSkin skin = SkinHelper.getSkinMap().get(checkedItemList.get(index));
                if (player.hasPermission(skin.permission())) {
                    addItem(skinItem(player, skin).build(), e -> {
                        if (e.getClick().isShiftClick()) {
                            if (SkinHelper.getSkin(player.getItemInHand()) == skin) {
                                SoundUtils.fail(player);
                                return;
                            }
                            SkinHelper.giveSkinAsRedeemableItem(player, skin);
                            SoundUtils.success(player);
                            return;
                        }
                        if (!appliableSkins.contains(skin.id())) {
                            SoundUtils.fail(player);
                            return;
                        }
                        SkinHelper.removeSkin(player);
                        SkinHelper.applySkin(player, skin);
                        SoundUtils.click(player);
                    });
                } else {
                    checkedItemList.remove(index);
                    i -= 1;
                }
            }
        }
    }

    private ItemBuilder skinItem(Player player, AbstractSkin skin) {
        List<String> lore = skin.lore();
        lore.add(" ");
        if (!appliableSkins.contains(skin.id())){
            lore.add(StringUtils.colorize("&7Skin is not compatible with held item!"));
        } else {
            if (SkinHelper.getSkin(player.getItemInHand()) == skin) {
                lore.add(StringUtils.colorize("&7This skin is already applied!"));
                lore.add(StringUtils.colorize("&7Unapply this skin to be able to withdraw it!"));
            } else {
                lore.add(StringUtils.colorize("&fClick to apply!"));
                lore.add(StringUtils.colorize("&fShift Click to withdraw this skin!"));
                lore.add(StringUtils.colorize("&cWithdrawing will remove access to this skin!"));
            }
        }

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
                .lore(lore)
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
            new PersonalSkinsGUI(player, category.toLowerCase(), 0).open(player);
            SoundUtils.click(player);
        });
    }

    @SuppressWarnings("ConstantConditions")
    private void addNavigationButtons() {
        setItem(53, createNavigationItem(Material.ARROW, "&c&lGo Back", "&7\u279C Click to go back"), e -> {
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
                new PersonalSkinsGUI(player, category, page).open(player);
            });
        }
        if (checkedItemList.size() >= index + 2) {
            setItem(50, createNavigationItem(Material.FEATHER, "&aNext Page", "&7\u279C Click to go to the next page"), e -> {
                SoundUtils.click(player);
                page += 1;
                new PersonalSkinsGUI(player, category, page).open(player);
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
