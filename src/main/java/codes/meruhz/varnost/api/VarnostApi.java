package codes.meruhz.varnost.api;

import codes.meruhz.varnost.api.security.Response;
import org.jetbrains.annotations.NotNull;

import java.time.OffsetDateTime;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;

public interface VarnostApi {

    @NotNull Optional<Account> getAccount(@NotNull UUID user);

    default boolean hasAccount(@NotNull UUID user) {
        @NotNull Optional<Account> accountOptional = this.getAccount(user);

        return accountOptional.isPresent() && accountOptional.get().isRegistered();
    }

    @NotNull CompletableFuture<Void> createAccount(@NotNull Response response, @NotNull OffsetDateTime registerDate, boolean authenticated);

    @NotNull CompletableFuture<Void> unregister(@NotNull Account account);
}
