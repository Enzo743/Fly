package fr.enzoooo.fly;

import fr.enzoooo.fly.commands.FlyCommand;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        System.out.println("Le plugin de Fly va s'allumer !");

        getCommand("fly").setExecutor(new FlyCommand());
    }
}
