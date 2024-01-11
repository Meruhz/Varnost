package codes.meruhz.varnost.events.bukkit;

import codes.meruhz.varnost.api.Account;
import codes.meruhz.varnost.events.AccountEvent;
import org.bukkit.Bukkit;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

public class LoginAccountEvent extends Event implements AccountEvent, Cancellable {

    private static final @NotNull HandlerList HANDLERS = new HandlerList();

    private final @NotNull Account account;

    private boolean cancelled;

    public LoginAccountEvent(@NotNull Account account) {
        this(!Bukkit.isPrimaryThread(), account);
    }

    public LoginAccountEvent(boolean isAsync, @NotNull Account account) {
        super(isAsync);
        this.account = account;
    }

    @Override
    public final @NotNull Account getAccount() {
        return this.account;
    }

    @Override
    public boolean isCancelled() {
        return this.cancelled;
    }

    @Override
    public void setCancelled(boolean b) {
        this.cancelled = b;
    }

    @Override
    public @NotNull HandlerList getHandlers() {
        return LoginAccountEvent.HANDLERS;
    }

    public static @NotNull HandlerList getHandlerList() {
        return LoginAccountEvent.HANDLERS;
    }
}
