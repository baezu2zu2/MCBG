package bazu.events;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.data.BlockData;
import org.bukkit.block.Chest;
import org.bukkit.entity.Item;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;

public class Kill implements Listener {
    @EventHandler
    public void onPlayerDeath(EntityDamageEvent event){
        if (!(event.getEntity() instanceof Player)) return; //Player인지 체크
        Player player = (Player) event.getEntity();

        if (player.getHealth()-event.getDamage() > 0) return; //죽었는지 체크

        if (player.getKiller() == null) return;

        playerItemChest(player); //Player면서 사람에게 죽었어야 템이 상자에 담김
        player.getInventory().clear();
    }

    private void playerItemChest(Player player){
        Inventory inv = player.getInventory();
        Location loc = player.getLocation();
        ArrayList<Chest> chests = new ArrayList<>();

        for (int i = 0; i < (inv.getSize() / 27); i++) {
            BlockData data = Material.CHEST.createBlockData();
            loc.getWorld().setBlockData(loc.add(0, i, 0), data);

            Block block = loc.add(0, i, 0).getBlock();
            if (block instanceof Chest)chests.add((Chest)block);
        }

        for (int i = 0; i < inv.getSize(); i++) {
            chests.get(i/27).getBlockInventory().addItem(inv.getItem(i));
        }
    }
}
