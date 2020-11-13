package fr.enzoooo.fly.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class FlyCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender.hasPermission("fly.use")){
            Player p = (Player) sender;

            if (p.getAllowFlight() == false){
                p.setAllowFlight(true);
                p.sendMessage("§aVous pouvez désormais voler !");
            } else if (p.getAllowFlight() == true){
                p.setAllowFlight(false);
                p.sendMessage("§cVous ne pouvez plus voler !");
            }
        } else {
            sender.sendMessage("§cVous n'avez pas la permission d'utiliser cette commande !");
        }
        return false;
    }
}
