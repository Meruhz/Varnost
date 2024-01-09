package codes.meruhz.varnost;

import codes.meruhz.varnost.api.VarnostPlugin;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.CompletableFuture;

public final class Varnost extends VarnostPlugin {

    @Override
    protected @NotNull CompletableFuture<Void> start() {
        return null;
    }

    @Override
    protected @NotNull CompletableFuture<Void> stop() {
        return null;
    }
}