package info.preva1l.itemskins.commands;

import info.preva1l.itemskins.guis.MainGUI;
import info.preva1l.itemskins.utils.SoundUtils;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class SkinsCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        if (sender instanceof Player player) {
            SoundUtils.click(player);
            new MainGUI(player).open(player);
            return true;
        }
        return false;
    }
}
