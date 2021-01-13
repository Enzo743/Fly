package fr.enzoooo.fly;

import fr.enzoooo.fly.commands.CommandFConfig;
import fr.enzoooo.fly.commands.FlyCommand;
import fr.enzoooo.fly.utils.UpdateChecker;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Logger;

public class Main extends JavaPlugin {

    static Main INSTANCE;

    Logger logger = this.getLogger();

    @Override
    public void onEnable() {
        INSTANCE = this;

        new UpdateChecker(this, 85279).getVersion(version -> {
            if (this.getDescription().getVersion().equalsIgnoreCase(version)) {
                logger.info("Le plugin de Fly va s'allumer !");
            } else {
                logger.info("Une nouvelle version est disponible !");
            }
        });

        getConfig().options().copyDefaults(true);
        saveConfig();

        getCommand("fly").setExecutor(new FlyCommand());
        getCommand("fconfig").setExecutor(new CommandFConfig());
    }

    public static Main getInstance() {
        return INSTANCE;
    }
}
