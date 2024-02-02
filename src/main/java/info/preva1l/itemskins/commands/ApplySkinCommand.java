package info.preva1l.itemskins.commands;

import info.preva1l.itemskins.types.AbstractSkin;
import info.preva1l.itemskins.skins.SkinHelper;
import info.preva1l.itemskins.utils.StringUtils;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("deprecation")
public class ApplySkinCommand implements CommandExecutor, TabCompleter {
    private static final List<String> list = new ArrayList<>();
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (sender instanceof Player player) {
            if (args.length == 0) return false;
            if (!list.contains(args[0])){
                player.sendActionBar(StringUtils.colorize("&cItem Skin &f\""+ args[0] + "\" &cDoes Not Exist For This Item!"));
                return true;
            }
            String inputSkin = args[0];
            AbstractSkin selectedSkin = SkinHelper.getSkinMap().get(inputSkin);
            if (selectedSkin != null) {
                SkinHelper.applySkin(player, selectedSkin);
            } else {
               System.out.println(SkinHelper.getSkinMap());
            }
            return true;
        }
        return false;
    }

    @Override
    public @Nullable List<String> onTabComplete(@NotNull CommandSender sender, @NotNull Command command, @NotNull String alias, @NotNull String[] args) {
        if (args.length == 1) {
            if (sender instanceof Player player) {
                if (player.getItemInHand().isEmpty()) return SkinHelper.getDefaultList();
                list.clear();
                list.addAll(switch (player.getItemInHand().getType().getKey().getKey().split("_")[1]) {
                    case "pickaxe" -> SkinHelper.getPickaxes();
                    case "helmet" -> SkinHelper.getHats();
                    case "axe" -> SkinHelper.getAxes();
                    default -> SkinHelper.getDefaultList();
                });
                return list;
            }
        }
        return SkinHelper.getDefaultList();
    }
}
