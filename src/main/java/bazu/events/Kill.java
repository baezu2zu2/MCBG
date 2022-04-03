package bazu.events;

import org.bukkit.entity.LivingEntity;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.PlayerDeathEvent;

public class Kill implements Listener {
    @EventHandler
    public void onPlayerDeath(EntityDamageEvent event){
        if (!(event.getEntity() instanceof LivingEntity)) return; //LivingEntity인지 체크
        LivingEntity entity = (LivingEntity) event.getEntity();

        if (entity.getHealth()-event.getDamage() > 0) return; //죽었는지 체크



    }
}
