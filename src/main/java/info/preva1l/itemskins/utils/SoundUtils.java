package info.preva1l.itemskins.utils;

import org.bukkit.Sound;
import org.bukkit.entity.Player;

public class SoundUtils {
    public static void success(Player player) { player.playSound(player.getLocation(), Sound.BLOCK_NOTE_BLOCK_PLING, 20, 2); }
    public static void fail(Player player) { player.playSound(player.getLocation(), Sound.ENTITY_VILLAGER_NO, 20, 2); }
    public static void click(Player player) { player.playSound(player.getLocation(), Sound.UI_BUTTON_CLICK, 20, 2); }
}
