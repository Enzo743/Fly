package fr.enzoooo.fly;

import fr.enzoooo.fly.commands.FlyCommand;
import fr.enzoooo.fly.utils.UpdateChecker;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Logger;

public class Main extends JavaPlugin {

    Logger logger = this.getLogger();

    @Override
    public void onEnable() {

        new UpdateChecker(this, 85279).getVersion(version -> {
            if (this.getDescription().getVersion().equalsIgnoreCase(version)) {
                logger.info("Le plugin de Fly va s'allumer !");
            } else {
                logger.info("Une nouvelle version est disponible !");
            }
        });

        getCommand("fly").setExecutor(new FlyCommand());
    }
}
