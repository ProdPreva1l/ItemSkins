package info.preva1l.itemskins.skins;

import info.preva1l.itemskins.ItemSkins;
import info.preva1l.itemskins.types.AbstractSkin;
import info.preva1l.itemskins.utils.StringUtils;
import info.preva1l.itemskins.utils.ItemBuilder;
import lombok.Getter;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;

import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataType;
import org.reflections.Reflections;

import java.util.*;
public class SkinHelper {
    private static final NamespacedKey nsKey = new NamespacedKey("itemskins", "skinid");
    private static final NamespacedKey nsKeyRedeem = new NamespacedKey("itemskins", "skintoredeem");
    @Getter private static final List<String> hats = new ArrayList<>();
    @Getter private static final List<String> pickaxes = new ArrayList<>();
    @Getter private static final List<String> axes = new ArrayList<>();
    @Getter private static final List<String> swords = new ArrayList<>();
    @Getter private static final List<String> hoes = new ArrayList<>();
    @Getter private static final List<String> shovels = new ArrayList<>();
    @Getter private static final List<String> defaultList = List.of(new String[]{""});
    @Getter private static final Map<String, AbstractSkin> skinMap = new HashMap<>();
    public static void registerSkins(String... packageNames) {
        Reflections reflections = new Reflections((Object) packageNames);
        Set<Class<? extends AbstractSkin>> subTypes = reflections.getSubTypesOf(AbstractSkin.class);

        for (Class<? extends AbstractSkin> skinClass : subTypes) {
            try {
                if (skinClass.getSimpleName().contains("Abstract")) continue;
                AbstractSkin skinInstance = skinClass.getDeclaredConstructor().newInstance();
                if (skinInstance.enabled()) {
                    skinInstance.addToList();
                    skinMap.put(StringUtils.removeColorCodes(skinInstance.id()), skinInstance);
                    ItemSkins.getInstance().getConsole().info(StringUtils.colorize("[Skin Loader] " + skinInstance.id() + " Enabled"));
                } else {
                    ItemSkins.getInstance().getConsole().info(StringUtils.colorize("[Skin Loader] " + skinInstance.id() + " Disabled"));
                }
            } catch (Exception e) {
                ItemSkins.getInstance().getConsole().severe(skinClass.getSimpleName());
                e.printStackTrace();
            }
        }
    }
    @SuppressWarnings("deprecation")
    public static void applySkin(Player player, AbstractSkin skin) {
        String skinName = skin.name();
        int skinModelData = skin.modelData();

        ItemStack item = player.getItemInHand();
        List<String> lore = item.getLore();
        ItemMeta meta = item.getItemMeta();

        if (lore != null) {
            lore.addAll(skin.lore());
            meta.setLore(lore);
        } else {
            meta.setLore(skin.lore());
        }

        meta.setCustomModelData(skinModelData);
        meta.getPersistentDataContainer().set(nsKey, PersistentDataType.STRING, skin.id());
        item.setItemMeta(meta);

        player.sendActionBar(StringUtils.colorize("&aItem Skin &f\""+ skinName + "&f\" &aHas Been Applied To Your Item!"));
    }
    @SuppressWarnings({"deprecation", "ConstantConditions"})
    public static void removeSkin(Player player) {
        AbstractSkin skin = getSkin(player.getItemInHand());
        if (skin == null) {
            player.sendActionBar(StringUtils.colorize("&cThis item does not have a custom skin on it!"));
            return;
        };

        ItemStack item = player.getItemInHand();
        ItemMeta meta = item.getItemMeta();
        List<String> lore = item.getLore();
        if (lore != null) {
            lore.removeAll(skin.lore());
            meta.setLore(lore);
        }
        meta.setCustomModelData(0);
        meta.getPersistentDataContainer().remove(nsKey);
        item.setItemMeta(meta);

        player.sendActionBar(StringUtils.colorize("&aItem Skin &f\"" + skin.name() + "&f\"&a has been removed from the item!"));
    }
    public static boolean checkSkin(ItemStack item, AbstractSkin skin) {
        return getSkin(item) == skin;
    }

    public static AbstractSkin getSkin(ItemStack item) {
        return getSkinMap().get(item.getItemMeta().getPersistentDataContainer().get(nsKey, PersistentDataType.STRING));
    }

    public static void giveSkinAsRedeemableItem(Player player, AbstractSkin skin) {
        ItemStack item = new ItemBuilder(Material.ORANGE_CANDLE).name(StringUtils.colorize(skin.name() + " &7(Right Click to redeem!)")).lore(StringUtils.colorize("&fRedeeming this will give you access to the " + skin.name() + " item skin!\n&7Apply this skin once redeemed with /skin")).build();
        item.getItemMeta().getPersistentDataContainer().set(nsKeyRedeem, PersistentDataType.STRING, skin.id());
        if (player.getInventory().firstEmpty() == -1) {
            player.getWorld().dropItem(player.getLocation(), item);
            return;
        }
        player.getInventory().addItem(item);
    }
}