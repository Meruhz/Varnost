package codes.meruhz.varnost;

import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;

public final class Varnost extends JavaPlugin {

    @Override
    public void onLoad() {
        super.onLoad();
    }

    @Override
    public void onDisable() {
        super.onDisable();
    }

    @Override
    public void onEnable() {
        super.onEnable();
    }

    public static @NotNull Varnost varnost() {
        return Varnost.getPlugin(Varnost.class);
    }

    public static void main(String[] args) {
        System.out.println("Hello World!");
    }
}