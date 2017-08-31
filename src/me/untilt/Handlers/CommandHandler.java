package me.untilt.Handlers;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

/**
 * Created by henry27 on 8/31/2017.
 */
public class CommandHandler implements CommandExecutor {


    private void handleJoinTeam(Player player,String[] args) {
        if (args.length == 2) {

        }
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (sender instanceof Player) {
            if (args.length > 0) {
                switch (args[0]) {
                    case "join":
                        handleJoinTeam(((Player) sender).getPlayer(),args);
                        break;
                    default:
                        sender.sendMessage("Command not recognized. Do /help minigame for command help.");
                        break;
                }
                return true;
            } else {
                sender.sendMessage("Please include some arguments!");
                return true;
            }
        } else {
            sender.sendMessage("You must be a player to use this command!");
            return true;
        }
    }

}
