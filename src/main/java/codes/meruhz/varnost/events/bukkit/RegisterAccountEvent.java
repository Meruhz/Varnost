package codes.meruhz.varnost.events.bukkit;

import codes.meruhz.varnost.api.Account;
import org.jetbrains.annotations.NotNull;

public class RegisterAccountEvent extends LoginAccountEvent {

    public RegisterAccountEvent(@NotNull Account account) {
        super(account);
    }

    public RegisterAccountEvent(boolean isAsync, @NotNull Account account) {
        super(isAsync, account);
    }
}
