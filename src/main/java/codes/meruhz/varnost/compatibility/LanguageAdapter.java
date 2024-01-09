package codes.meruhz.varnost.compatibility;

import net.md_5.bungee.api.chat.BaseComponent;
import org.jetbrains.annotations.NotNull;

import java.util.*;

public abstract class LanguageAdapter<T> {

    private final @NotNull Set<@NotNull T> storages;

    protected LanguageAdapter(@NotNull Set<@NotNull T> storages) {
        this.storages = storages;
    }

    public @NotNull Set<@NotNull T> getStorages() {
        return this.storages;
    }

    public abstract BaseComponent @NotNull [] getText(@NotNull Locale locale, @NotNull String id, @NotNull Object... replaces);

    public abstract @NotNull List<BaseComponent @NotNull []> getArrayText(@NotNull Locale locale, @NotNull String id, @NotNull Object... replaces);

    public abstract @NotNull String getLegacyText(@NotNull Locale locale, @NotNull String id, @NotNull Object... replaces);

    public abstract @NotNull List<@NotNull String> getLegacyArray(@NotNull Locale locale, @NotNull String id, @NotNull Object... replaces);

    @Override
    public boolean equals(Object o) {
        if(this == o) return true;
        if(o == null || getClass() != o.getClass()) return false;

        LanguageAdapter<?> that = (LanguageAdapter<?>) o;

        return storages.equals(that.storages);
    }

    @Override
    public int hashCode() {
        return storages.hashCode();
    }
}
