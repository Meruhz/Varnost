package codes.meruhz.varnost;

import codes.meruhz.varnost.api.VarnostPlugin;
import codes.meruhz.varnost.compatibility.LanguageAdapter;
import codes.meruhz.varnost.compatibility.langstor.LangstorAdapter;
import org.jetbrains.annotations.NotNull;

import java.util.LinkedHashSet;
import java.util.concurrent.CompletableFuture;

public final class Varnost extends VarnostPlugin {

    private @NotNull LanguageAdapter<?> languageAdapter;

    public Varnost() {
        this.languageAdapter = new LangstorAdapter(new LinkedHashSet<>());
    }

    public @NotNull LanguageAdapter<?> getLanguageAdapter() {
        return this.languageAdapter;
    }

    public void setLanguageAdapter(@NotNull LanguageAdapter<?> languageAdapter) {
        this.languageAdapter = languageAdapter;
    }

    @Override
    protected @NotNull CompletableFuture<Void> start() {
        return new CompletableFuture<>();
    }

    @Override
    protected @NotNull CompletableFuture<Void> stop() {
        return new CompletableFuture<>();
    }
}