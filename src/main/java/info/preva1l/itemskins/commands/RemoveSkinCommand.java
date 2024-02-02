package info.preva1l.itemskins.commands;

import info.preva1l.itemskins.skins.SkinHelper;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class RemoveSkinCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (sender instanceof Player player) {
            SkinHelper.removeSkin(player);
            return true;
        }
        return false;
    }
}
