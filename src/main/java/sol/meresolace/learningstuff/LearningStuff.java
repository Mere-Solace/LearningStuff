package sol.meresolace.learningstuff;

import org.bukkit.Color;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Particle;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;

public final class LearningStuff extends JavaPlugin implements Listener{

    @Override
    public void onEnable(){
        System.out.println("The plugin has started.");

        getServer().getPluginManager().registerEvents(this, this);
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event){
        Player player = event.getPlayer();
        event.setJoinMessage("Young son thinks he's cool with a name like \"" + player.getDisplayName() + "\"");
    }

    @EventHandler
    public void onSwing(PlayerInteractEvent event){
        Player player = event.getPlayer();
        if (event.getItem().getType() == Material.WOODEN_SWORD &&
                (event.getAction() == Action.LEFT_CLICK_AIR
                || event.getAction() == Action.LEFT_CLICK_BLOCK)){
            double radius = 1.5;
            for (double theta = 0; theta <= (Math.toRadians(360))/4 ; theta += (Math.toRadians(1))*9){
                double x = radius*Math.cos(theta) + player.getLocation().getX();
                double z = radius*Math.sin(theta) + player.getLocation().getZ();
                Location particle = new Location(player.getWorld(), x, player.getLocation().getY(), z);
                System.out.println("Theta (converted to degrees): " + Math.toDegrees(theta));
                player.spawnParticle(Particle.REDSTONE, particle, 3, new Particle.DustOptions(Color.GRAY, 1f));
            }
        }
    }


}
