package codes.meruhz.varnost.api;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.time.OffsetDateTime;
import java.util.Optional;
import java.util.UUID;

public interface Account {

    @NotNull UUID getUniqueId();

    @NotNull Optional<OffsetDateTime> getRegisterDate();

    @Contract(pure = true)
    default boolean isRegistered() {
        return this.getRegisterDate().isPresent();
    }

    @Contract(pure = true)
    boolean isAuthenticated();

    void setAuthenticated(boolean b);
}
