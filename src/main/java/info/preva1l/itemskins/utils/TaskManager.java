package info.preva1l.itemskins.utils;

import org.bukkit.plugin.java.JavaPlugin;

public class TaskManager {
    public static class Sync {
        public static void run(Runnable runnable) {
            JavaPlugin.getPlugin(JavaPlugin.class).getServer().getScheduler().runTask(JavaPlugin.getPlugin(JavaPlugin.class), runnable);
        }

        public static void runTask(Runnable runnable, long interval) {
            JavaPlugin.getPlugin(JavaPlugin.class).getServer().getScheduler().runTaskTimer(JavaPlugin.getPlugin(JavaPlugin.class), runnable, 0L, interval);
        }

        public static void runLater(Runnable runnable, long delay) {
            JavaPlugin.getPlugin(JavaPlugin.class).getServer().getScheduler().runTaskLater(JavaPlugin.getPlugin(JavaPlugin.class), runnable, delay);
        }
    }
    public static class Async {
        public static void run(Runnable runnable) {
            JavaPlugin.getPlugin(JavaPlugin.class).getServer().getScheduler().runTaskAsynchronously(JavaPlugin.getPlugin(JavaPlugin.class), runnable);
        }

        public static void runTask(Runnable runnable, long interval) {
            JavaPlugin.getPlugin(JavaPlugin.class).getServer().getScheduler().runTaskTimerAsynchronously(JavaPlugin.getPlugin(JavaPlugin.class), runnable, 0L, interval);
        }

        public static void runLater(Runnable runnable, long delay) {
            JavaPlugin.getPlugin(JavaPlugin.class).getServer().getScheduler().runTaskLaterAsynchronously(JavaPlugin.getPlugin(JavaPlugin.class), runnable, delay);
        }
    }
}