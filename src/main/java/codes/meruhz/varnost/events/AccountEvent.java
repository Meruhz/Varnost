package codes.meruhz.varnost.events;

import codes.meruhz.varnost.api.Account;
import org.jetbrains.annotations.NotNull;

@FunctionalInterface
public interface AccountEvent {

    @NotNull Account getAccount();
}
