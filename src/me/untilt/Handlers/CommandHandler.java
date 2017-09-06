package me.untilt.Handlers;

import me.untilt.Main;
import me.untilt.Objects.Match;
import me.untilt.Objects.Team;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

/**
 * Created by henry27 on 8/31/2017.
 */
public class CommandHandler implements CommandExecutor {


    private void handleJoinTeam(Player player,String[] args) {
        if (args.length > 1) {
            if (!Main.match.equals(null)) {
                switch (args[1]) {
                    case "blue":
                        player.setDisplayName(ChatColor.BLUE + player.getName());
                        Match.blue.addPlayer(player);
                        Match.red.removePlayer(player);
                        player.sendMessage(ChatColor.GOLD + "You have joined team: " + ChatColor.BLUE + "blue");
                        Match.blue.teleportPlayer(player);
                        Main.match.updateTeams();
                        break;
                    case "red":
                        player.setDisplayName(ChatColor.RED + player.getName());
                        Match.red.addPlayer(player);
                        Match.blue.removePlayer(player);
                        player.sendMessage(ChatColor.GOLD + "You have joined team: " + ChatColor.RED + "red");
                        Match.red.teleportPlayer(player);
                        Main.match.updateTeams();
                        break;
                    default:
                        player.sendMessage(ChatColor.GOLD + "Please choose either red or blue.");
                }

            }

        } else {
            player.sendMessage("Please use /tdm help to get help using the plugin..");
        }
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (sender instanceof Player) {
            if (args.length > 0) {
                switch (args[0]) {
                    case "join":
                        handleJoinTeam(((Player) sender).getPlayer(),args);
                       switch (args[1].toLowerCase()) {
                           case "blue":
                               sender.getServer().broadcastMessage(ChatColor.AQUA + sender.getName() + " has joined the " + ChatColor.BLUE + "blue " + ChatColor.AQUA + "team.");
                               break;
                           case "red":
                               sender.getServer().broadcastMessage(ChatColor.AQUA + sender.getName() + " has joined the " + ChatColor.RED + "red " + ChatColor.AQUA + "team.");
                               break;
                       }
                        break;
                    case "leave":
                        if (Match.red.getPlayersOnTeam().contains(sender) || Match.blue.getPlayersOnTeam().contains(sender)) {
                            Match.red.removePlayer(((Player) sender).getPlayer());
                            Match.blue.removePlayer(((Player) sender).getPlayer());
                            sender.sendMessage(ChatColor.RED + "You have left your team.");

                        } else {
                            sender.sendMessage("You are not on a team!");
                        }
                        break;
                    case "printteams":
                        sender.sendMessage(Match.red.showTeam());
                        sender.sendMessage(Match.blue.showTeam());
                        break;
                    case "score":
                        if (Main.match.isMatchPlaying && !(Main.match.score.equals(null))) {
                            sender.sendMessage("The score of the game is: " + ChatColor.RED + Main.match.score.get(0) + ChatColor.WHITE + ":" +ChatColor.BLUE + Main.match.score.get(1));
                        } else {
                            sender.sendMessage("Game is not in progress!");
                        }
                        break;
                    case "stats":
                        SQLManager sql = new SQLManager();
                        int kills = sql.getKills(((Player) sender).getUniqueId());
                        System.out.println(kills);
                        break;
                    case "setspawn":
                        if (sender.hasPermission("tdm.setspawn")) {
                            switch (args[1].toLowerCase()) {
                                case "red":
                                    ;
                                    break;
                                case "blue":
                                    break;
                            }
                            break;
                        } else {
                            sender.sendMessage(ChatColor.RED + "You do not have permission!");
                        }
                    default:
                        sender.sendMessage(ChatColor.GOLD + "Command not recognized. Do /help TeamDeathMatch for command help.");
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
