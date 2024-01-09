package codes.meruhz.varnost.api.security;

import org.bukkit.OfflinePlayer;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jsoup.Connection;
import org.jsoup.Jsoup;

import java.util.Objects;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;

public final class Response {

    public static @NotNull CompletableFuture<Response> retrieve(@NotNull OfflinePlayer player, @NotNull String password) {
        @NotNull CompletableFuture<Response> future = new CompletableFuture<>();

        CompletableFuture.runAsync(() -> {
            try {
                final @NotNull Connection.Response response = Jsoup.connect("http://localhost/Authenticator/api/encrypt.php")
                        .method(Connection.Method.GET)

                        .ignoreContentType(true)
                        .ignoreHttpErrors(true)

                        .header("Content-Type", "application/json")
                        .data("u", player.getUniqueId().toString())
                        .data("p", password)
                        .execute();

                future.complete(new Response(player.getUniqueId(), response.body()));

            } catch (@NotNull Throwable throwable) {
                future.completeExceptionally(throwable);
            }
        });

        return future;
    }

    private final @NotNull UUID uniqueId;
    private final @NotNull String password;

    private Response(@NotNull UUID uniqueId, @NotNull String password) {
        this.uniqueId = uniqueId;
        this.password = password;
    }

    @Contract(pure = true)
    public @NotNull UUID getUniqueId() {
        return this.uniqueId;
    }

    @Contract(pure = true)
    public @NotNull String getPassword() {
        return this.password;
    }

    @Override
    @Contract(pure = true)
    public boolean equals(@Nullable Object object) {
        if (this == object) return true;
        if (object == null || this.getClass() != object.getClass()) return false;
        Response response = (Response) object;
        return Objects.equals(this.getUniqueId(), response.getUniqueId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.getUniqueId(), this.getPassword());
    }
}
