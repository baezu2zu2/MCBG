package bazu;

import org.bukkit.Bukkit;
import org.bukkit.GameRule;
import org.bukkit.World;
import org.bukkit.plugin.java.JavaPlugin;

public class MCBG extends JavaPlugin {
    @Override
    public void onEnable() {
        initalize();
    }

    private void initalize(){
        for (World world: Bukkit.getWorlds()) {
            world.setGameRule(GameRule.KEEP_INVENTORY, true);
        }
    }
}
