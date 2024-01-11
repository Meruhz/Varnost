package codes.meruhz.varnost.api.providers;

import codes.meruhz.varnost.api.Account;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.time.OffsetDateTime;
import java.util.Optional;
import java.util.UUID;

public class AccountProvider implements Account {

    private final @NotNull UUID user;
    private final @Nullable OffsetDateTime registerDate;

    private boolean authenticated;

    public AccountProvider(@NotNull UUID user) {
        this(user, null, false);
    }

    public AccountProvider(@NotNull UUID user, @Nullable OffsetDateTime registerDate, boolean authenticated) {
        this.user = user;
        this.registerDate = registerDate;
        this.authenticated = authenticated;
    }

    @Override
    public final @NotNull UUID getUniqueId() {
        return this.user;
    }

    @Override
    public final @NotNull Optional<OffsetDateTime> getRegisterDate() {
        return Optional.ofNullable(this.registerDate);
    }

    @Override
    public boolean isAuthenticated() {
        return this.authenticated;
    }

    @Override
    public void setAuthenticated(boolean b) {
        this.authenticated = b;
    }

    @Override
    public boolean equals(Object o) {
        if(this == o) return true;
        if(o == null || getClass() != o.getClass()) return false;

        AccountProvider that = (AccountProvider) o;

        return user.equals(that.user);
    }

    @Override
    public int hashCode() {
        return user.hashCode();
    }
}
