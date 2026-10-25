package org.holowknight.HollowKnightsz

// do re mi fo la si do
import cn.nukkit.Player;
import org.powernukkitx.command.Command;
import org.powernukkitx.command.CommandSender;
import org.powernukkitx.plugin.annotation.CommandDefinition;
import org.powernukkitx.plugin.annotation.CommandDefinition.CommandMode;

public class SuicideCommand extends Command {

    public SuicideCommand() {
        // Command name, description, usage, and aliases
        super("suicide", "Allows a player to reset their character", "/suicide", new String[]{"suicidecmd"});
        // Set the permission node required to use the command
        this.setPermission("server.command.suicide");
    }

    @Override
    public boolean execute(CommandSender sender, String commandLabel, String[] args) {
        // Check if the command sender has the correct permission
        if (!this.testPermission(sender)) {
            return true;
        }

        // Ensure the sender is a player, not the console
        if (!(sender instanceof Player)) {
            sender.sendMessage(TextFormat.RED + "This command can only be used by players in-game.");
            return true;
        }

        Player player = (Player) sender;

        // Apply 0 health to reset the player's status
        player.setHealth(0.0f);
        player.sendMessage(TextFormat.YELLOW + "You have reset your character status.");

        return true;
    }
}
