package codes.meruhz.varnost.api.providers;

import codes.meruhz.varnost.api.Account;
import codes.meruhz.varnost.api.VarnostApi;
import codes.meruhz.varnost.api.security.Response;
import codes.meruhz.varnost.events.bukkit.RegisterAccountEvent;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.time.OffsetDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;

public class VarnostApiProvider implements VarnostApi {

    private final @NotNull Map<@NotNull UUID, @Nullable Account> accounts = new HashMap<>();

    public VarnostApiProvider() {
    }

    public @NotNull Map<@NotNull UUID, @Nullable Account> getAccounts() {
        return this.accounts;
    }

    @Override
    public @NotNull Optional<Account> getAccount(@NotNull UUID user) {
        return Optional.ofNullable(this.getAccounts().getOrDefault(user, new AccountProvider(user)));
    }

    @Override
    public @NotNull CompletableFuture<Void> createAccount(@NotNull Response response, @NotNull OffsetDateTime registerDate, boolean authenticated) {
        @NotNull CompletableFuture<Void> completableFuture = new CompletableFuture<>();

        CompletableFuture.runAsync(() -> {

            try {
                @NotNull UUID user = response.getUniqueId();
                @Nullable Player player = Bukkit.getPlayer(user);

                @NotNull Account account = new AccountProvider(user, registerDate, false);
                @NotNull RegisterAccountEvent registerAccountEvent = new RegisterAccountEvent(account);

                if(this.hasAccount(user)) {
                    throw new IllegalStateException("User '" + user + "' are already registered");

                } else if(!registerAccountEvent.isCancelled() && (account.isRegistered() && player != null)) {
                    Bukkit.getPluginManager().callEvent(registerAccountEvent);
                    account.setAuthenticated(true);
                }


                this.getAccounts().put(user, account);
                completableFuture.complete(null);

            } catch (Exception e) {
                completableFuture.completeExceptionally(e);
            }
        });

        return completableFuture;
    }

    @Override
    public @NotNull CompletableFuture<Void> unregister(@NotNull Account account) {
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

    @Override
    public boolean equals(Object o) {
        if(this == o) return true;
        if(o == null || getClass() != o.getClass()) return false;

        VarnostApiProvider that = (VarnostApiProvider) o;

        return accounts.equals(that.accounts);
    }

    @Override
    public int hashCode() {
        return accounts.hashCode();
    }
}
