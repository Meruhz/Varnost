package codes.meruhz.varnost.api;

import codes.meruhz.varnost.api.providers.VarnostApiProvider;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.Blocking;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.CompletableFuture;

public abstract class VarnostPlugin extends JavaPlugin {

    private final @NotNull String id;
    private @NotNull VarnostApi varnostApi;
    private volatile boolean loaded;

    public VarnostPlugin() {
        this.id = "Varnost Plugin";
        this.varnostApi = new VarnostApiProvider();
    }

    public final @NotNull String getId() {
        return this.id;
    }

    public final boolean isLoaded() {
        return this.loaded;
    }

    public @NotNull VarnostApi getVarnostApi() {
        return this.varnostApi;
    }

    public synchronized void setVarnostApi(@NotNull VarnostApi varnostApi) {
        this.varnostApi = varnostApi;
    }

    @Blocking
    public final @NotNull CompletableFuture<Void> load() {
        @NotNull CompletableFuture<Void> completableFuture = new CompletableFuture<>();

        CompletableFuture.runAsync(() -> {
            try {
                if(this.isLoaded()) {
                    throw new NullPointerException("Task '" + this.getId() + "' already is started");
                }

                this.start().join();
                this.loaded = true;
                completableFuture.complete(null);

            } catch (Exception var3) {
                completableFuture.completeExceptionally(var3);
            }
        });

        return completableFuture;
    }

    @Blocking
    public final @NotNull CompletableFuture<Void> unload() {
        @NotNull CompletableFuture<Void> completableFuture = new CompletableFuture<>();

        CompletableFuture.runAsync(() -> {
            try {
                if(!this.isLoaded()) {
                    throw new NullPointerException("Task '" + this.getId() + "' already is not started");
                }

                this.stop().join();
                this.loaded = false;
                completableFuture.complete(null);

            } catch (Exception var3) {
                completableFuture.completeExceptionally(var3);
            }
        });

        return completableFuture;
    }

    @ApiStatus.OverrideOnly
    protected abstract @NotNull CompletableFuture<Void> start();

    @ApiStatus.OverrideOnly
    protected abstract @NotNull CompletableFuture<Void> stop();

    @Override
    public final void onDisable() {
        this.unload().join();
    }

    @Override
    public final void onEnable() {
        this.load().join();
    }
}
