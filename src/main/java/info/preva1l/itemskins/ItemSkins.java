package info.preva1l.itemskins;

import info.preva1l.itemskins.commands.ApplySkinCommand;
import info.preva1l.itemskins.commands.RemoveSkinCommand;
import info.preva1l.itemskins.commands.SkinsCommand;
import info.preva1l.itemskins.skins.SkinHelper;
import info.preva1l.itemskins.utils.FastInvManager;
import lombok.Getter;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Logger;


public final class ItemSkins extends JavaPlugin {

    //TODO: Make redeem item work and redeem, make it not be placeable
    //TODO: Fix error when trying to redeem with no item in hand
    //TODO: Fix error when trying to open all menus (except main) when an item that is not air or a skinnable item is held

    @Getter private final Logger console = getLogger();
    @Override
    public void onEnable() {
        FastInvManager.register(this);
        registerCommands();
        SkinHelper.registerSkins("info.preva1l.itemskins.skins.hats",
                "info.preva1l.itemskins.skins.pickaxes",
                "info.preva1l.itemskins.skins.axes");
        console.info("ItemSkins By Preva1l has started!");
    }

    @Override
    public void onDisable() {

    }


    @SuppressWarnings("ConstantConditions")
    private void registerCommands() {
        getCommand("skins").setExecutor(new SkinsCommand());
        getCommand("applyskin").setExecutor(new ApplySkinCommand());
        getCommand("applyskin").setTabCompleter(new ApplySkinCommand());
        getCommand("removeskin").setExecutor(new RemoveSkinCommand());
    }

    public static ItemSkins getInstance() {
        return getPlugin(ItemSkins.class);
    }
}
