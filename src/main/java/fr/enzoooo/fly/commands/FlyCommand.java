package fr.enzoooo.fly.commands;

import fr.enzoooo.fly.Main;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.Map;

public class FlyCommand implements CommandExecutor {

    private Map<Player, Long> flyCooldown = new HashMap<>();

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Player p = (Player) sender;

        if(flyCooldown.containsKey(p)){
            long time = (System.currentTimeMillis() - flyCooldown.get(p)) / 1000;

            if(time < Main.getInstance().getConfig().getLong("cooldown")){
                p.sendMessage("§cMerci de patienter entre chaque permission de voler !");
                return false;
            } else {
                flyCooldown.remove(p);
            }
        }

        if (sender.hasPermission("fly.use")){
            if (!p.getAllowFlight()){
                p.setAllowFlight(true);
                p.sendMessage("§aVous pouvez désormais voler !");
            } else if (p.getAllowFlight()){
                p.setAllowFlight(false);
                p.sendMessage("§cVous ne pouvez plus voler !");
                flyCooldown.put(p, System.currentTimeMillis());
            }
        } else {
            sender.sendMessage("§cVous n'avez pas la permission d'utiliser cette commande !");
        }
        return false;
    }
}
