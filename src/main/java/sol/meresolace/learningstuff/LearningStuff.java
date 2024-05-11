package sol.meresolace.learningstuff;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;

public final class LearningStuff extends JavaPlugin implements Listener{

    @Override
    public void onEnable(){
        System.out.println("The plugin has started.");
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event){
        System.out.println("Young son thinks he's hip with a name like \"" + event.getPlayer().getDisplayName() + "\"");
    }
}
