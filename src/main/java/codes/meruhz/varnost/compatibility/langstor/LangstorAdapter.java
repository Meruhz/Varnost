package codes.meruhz.varnost.compatibility.langstor;

import codes.meruhz.langstor.md5.chat.ComponentMessage;
import codes.meruhz.langstor.md5.chat.ComponentStorage;
import codes.meruhz.varnost.compatibility.LanguageAdapter;
import net.md_5.bungee.api.chat.BaseComponent;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.concurrent.CompletableFuture;

public class LangstorAdapter extends LanguageAdapter<ComponentStorage> {

    public LangstorAdapter(@NotNull Set<@NotNull ComponentStorage> storages) {
        super(storages);
    }

    @Override
    public BaseComponent @NotNull [] getText(@NotNull Locale locale, @NotNull String id, @NotNull Object... replaces) {
        return this.getMessage(id).getStorage().getText(locale, id, replaces);
    }

    @Override
    public @NotNull List<BaseComponent @NotNull []> getArrayText(@NotNull Locale locale, @NotNull String id, @NotNull Object... replaces) {
        return this.getMessage(id).getStorage().getArrayText(locale, id, replaces);
    }

    @Override
    public @NotNull String getLegacyText(@NotNull Locale locale, @NotNull String id, @NotNull Object... replaces) {
        return ((ComponentStorage) this.getMessage(id).getStorage()).getLegacyText(id, locale, replaces);
    }

    @Override
    public @NotNull List<@NotNull String> getLegacyArray(@NotNull Locale locale, @NotNull String id, @NotNull Object... replaces) {
        return ((ComponentStorage) this.getMessage(id).getStorage()).getLegacyArray(id, locale, replaces);
    }

    @Override
    public @NotNull CompletableFuture<Void> load() {
        @NotNull CompletableFuture<Void> completableFuture = new CompletableFuture<>();

        CompletableFuture.runAsync(() -> {

            try {

                completableFuture.complete(null);

            } catch (Exception e) {
                completableFuture.completeExceptionally(e);
            }
        });

        return completableFuture;
    }

    public @NotNull ComponentMessage getMessage(@NotNull String id) {
        return super.getStorages().stream().map(storage -> {

                    try {
                        return (ComponentMessage) storage.getMessage(id);

                    } catch (NullPointerException e) {
                        throw new RuntimeException(e);
                    }

                }).findFirst().orElseThrow(() -> new NullPointerException("Message '" + id + "' could not be found on Langstor storages"));
    }
}
