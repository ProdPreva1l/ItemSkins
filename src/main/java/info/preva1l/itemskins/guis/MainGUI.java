package info.preva1l.itemskins.guis;

import info.preva1l.itemskins.utils.StringUtils;
import info.preva1l.itemskins.utils.FastInv;
import info.preva1l.itemskins.utils.ItemBuilder;
import info.preva1l.itemskins.utils.SoundUtils;
import org.bukkit.Material;
import org.bukkit.entity.Player;

import java.util.List;

public class MainGUI extends FastInv {
    private static List<String> confCategory = List.of(
            "axe",
            "sword",
            "pickaxe",
            "helmet",
            "shovel",
            "hoe");

    public MainGUI(Player inventoryOwner) {
        super(27, StringUtils.colorize("&fItem Skins"));

        setItems(new int[]{0, 4, 8, 9, 13, 17, 18, 22, 26}, new ItemBuilder(Material.BLACK_STAINED_GLASS_PANE).name(" ").build());
        setItems(new int[]{1, 2 , 3, 10, 11, 12, 19, 20, 21}, new ItemBuilder(Material.PLAYER_HEAD).skullOwner(inventoryOwner).name(StringUtils.colorize("&fYour Skins")).build(), e -> {
            if (e.getWhoClicked() instanceof Player player) {
                String category = player.getItemInHand().isEmpty() ? "sword" :
                        confCategory.contains(getItemCategory(player)) ? getItemCategory(player) : "sword";

                if (category.equalsIgnoreCase("helmet")) category = "hat";

                SoundUtils.click(player);
                new PersonalSkinsGUI(player, category, 0).open(player);
            }
        });

        setItems(new int[]{5, 6, 7, 14, 15, 16, 23, 24, 25}, new ItemBuilder(Material.TOTEM_OF_UNDYING).name(StringUtils.colorize("&3All Skins")).build(), e -> {
            if (e.getWhoClicked() instanceof Player player) {
                String category = player.getItemInHand().isEmpty() ? "sword" :
                        confCategory.contains(getItemCategory(player)) ? getItemCategory(player) : "sword";

                if (category.equalsIgnoreCase("helmet")) category = "hat";

                SoundUtils.click(player);
                new AllSkinsGUI(player, category, 0).open(player);
            }
        });
    }

    private String getItemCategory(Player player) {
        String[] sList = player.getItemInHand().getType().getKey().getKey().split("_");
        if (sList.length == 0) return player.getItemInHand().getType().getKey().getKey();
        return player.getItemInHand().getType().getKey().getKey().split("_")[1];
    }
}
