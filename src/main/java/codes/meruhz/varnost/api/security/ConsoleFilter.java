package codes.meruhz.varnost.api.security;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.Marker;
import org.apache.logging.log4j.core.Filter;
import org.apache.logging.log4j.core.LogEvent;
import org.apache.logging.log4j.core.Logger;
import org.apache.logging.log4j.message.Message;
import org.bukkit.command.PluginCommand;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

public final class ConsoleFilter implements Filter {
    
    private final @NotNull List<@NotNull String> commands = new ArrayList<>();
    
    public @NotNull List<@NotNull String> getCommands() {
        return this.commands;
    }
    
    public void block(@NotNull PluginCommand command) {
        this.getCommands().add(command.getName());
        this.getCommands().addAll(command.getAliases());
    }
    
    @Override
    public @NotNull Result filter(@NotNull LogEvent record) {
        if(record.getMessage() != null && record.getMessage().getFormattedMessage() != null) {
            
            for(String message : this.getCommands()) {
                
                if(record.getMessage().getFormattedMessage().toLowerCase().contains(message)) {
                    return Result.DENY;
                }
            }
        }

        return Result.NEUTRAL;
    }
    
    @Override
    public @NotNull Result filter(@NotNull Logger logger, @NotNull Level level, @NotNull Marker marker, @NotNull String message, @NotNull Object... objects) {
        for(String msg : this.getCommands()) {
            
            if(message.toLowerCase().contains(msg)) {
                return Result.DENY;
            }
        }

        return Result.NEUTRAL;
    }
    
    @Override
    public @NotNull Result filter(@NotNull Logger logger, @NotNull Level level, @NotNull Marker marker, @NotNull String message, @NotNull Object object) {
        for(String msg : this.getCommands()) {
            
            if(message.toLowerCase().contains(msg)) {
                return Result.DENY;
            }
        }

        return Result.NEUTRAL;
    }
    
    @Override
    public @NotNull Result filter(@NotNull Logger logger, @NotNull Level level, @NotNull Marker marker, @NotNull String message, @NotNull Object object1, @NotNull Object object2) {
        for(String msg : this.getCommands()) {
            
            if(message.toLowerCase().contains(msg)) {
                return Result.DENY;
            }
        }

        return Result.NEUTRAL;
    }
    
    @Override
    public @NotNull Result filter(@NotNull Logger logger, @NotNull Level level, @NotNull Marker marker, @NotNull String message, @NotNull Object object1, @NotNull Object object2, @NotNull Object object3) {
        for(String msg : this.getCommands()) {
            
            if(message.toLowerCase().contains(msg)) {
                return Result.DENY;
            }
        }

        return Result.NEUTRAL;
    }
    
    @Override
    public @NotNull Result filter(@NotNull Logger logger, @NotNull Level level, @NotNull Marker marker, @NotNull String message, @NotNull Object object1, @NotNull Object object2, @NotNull Object object3, @NotNull Object object4) {
        for(String msg : this.getCommands()) {
            
            if(message.toLowerCase().contains(msg)) {
                return Result.DENY;
            }
        }

        return Result.NEUTRAL;
    }
    
    @Override
    public @NotNull Result filter(@NotNull Logger logger, @NotNull Level level, @NotNull Marker marker, @NotNull String message, @NotNull Object object1, @NotNull Object object2, @NotNull Object object3, @NotNull Object object4, @NotNull Object object5) {
        for(String msg : this.getCommands()) {
            
            if(message.toLowerCase().contains(msg)) {
                return Result.DENY;
            }
        }

        return Result.NEUTRAL;
    }
    
    @Override
    public @NotNull Result filter(@NotNull Logger logger, @NotNull Level level, @NotNull Marker marker, @NotNull String message, @NotNull Object object1, @NotNull Object object2, @NotNull Object object3, @NotNull Object object4, @NotNull Object object5, @NotNull Object object6) {
        for(String msg : this.getCommands()) {
            
            if(message.toLowerCase().contains(msg)) {
                return Result.DENY;
            }
        }

        return Result.NEUTRAL;
    }
    
    @Override
    public @NotNull Result filter(@NotNull Logger logger, @NotNull Level level, @NotNull Marker marker, @NotNull String message, @NotNull Object object1, @NotNull Object object2, @NotNull Object object3, @NotNull Object object4, @NotNull Object object5, @NotNull Object object6, @NotNull Object object7) {
        for(String msg : this.getCommands()) {
            
            if(message.toLowerCase().contains(msg)) {
                return Result.DENY;
            }
        }

        return Result.NEUTRAL;
    }
    
    @Override
    public @NotNull Result filter(@NotNull Logger logger, @NotNull Level level, @NotNull Marker marker, @NotNull String message, @NotNull Object object1, @NotNull Object object2, @NotNull Object object3, @NotNull Object object4, @NotNull Object object5, @NotNull Object object6, @NotNull Object object7, @NotNull Object object8) {
        for(String msg : this.getCommands()) {
            
            if(message.toLowerCase().contains(msg)) {
                return Result.DENY;
            }
        }

        return Result.NEUTRAL;
    }
    
    @Override
    public @NotNull Result filter(@NotNull Logger logger, @NotNull Level level, @NotNull Marker marker, @NotNull String message, @NotNull Object object1, @NotNull Object object2, @NotNull Object object3, @NotNull Object object4, @NotNull Object object5, @NotNull Object object6, @NotNull Object object7, @NotNull Object object8, @NotNull Object object9) {
        for(String msg : this.getCommands()) {
            
            if(message.toLowerCase().contains(msg)) {
                return Result.DENY;
            }
        }

        return Result.NEUTRAL;
    }
    
    @Override
    public @NotNull Result filter(@NotNull Logger logger, @NotNull Level level, @NotNull Marker marker, @NotNull String message, @NotNull Object object1, @NotNull Object object2, @NotNull Object object3, @NotNull Object object4, @NotNull Object object5, @NotNull Object object6, @NotNull Object object7, @NotNull Object object8, @NotNull Object object9, @NotNull Object object10) {
        for(String msg : this.getCommands()) {
            
            if(message.toLowerCase().contains(msg)) {
                return Result.DENY;
            }
        }

        return Result.NEUTRAL;
    }
    
    @Override
    public @NotNull Result filter(@NotNull Logger logger, @NotNull Level level, @NotNull Marker marker, @NotNull Object message, @NotNull Throwable throwable) {
        for(String msg : this.getCommands()) {
            
            if(message.toString().toLowerCase().contains(msg)) {
                return Result.DENY;
            }
        }

        return Result.NEUTRAL;
    }
    
    @Override
    public @NotNull Result filter(@NotNull Logger logger, @NotNull Level level, @NotNull Marker marker, @NotNull Message message, @NotNull Throwable throwable) {
        for(String msg : this.getCommands()) {
            
            if(message.toString().toLowerCase().contains(msg)) {
                return Result.DENY;
            }
        }

        return Result.NEUTRAL;
    }
    
    @Override
    public @NotNull Result getOnMatch() {
        return Result.NEUTRAL;
    }
    
    @Override
    public @NotNull Result getOnMismatch() {
        return Result.NEUTRAL;
    }

    @Override
    public @Nullable State getState() {
        return null;
    }

    @Override
    public void initialize() {

    }

    @Override
    public void start() {

    }

    @Override
    public void stop() {

    }

    @Override
    public boolean isStarted() {
        return false;
    }

    @Override
    public boolean isStopped() {
        return false;
    }
}

