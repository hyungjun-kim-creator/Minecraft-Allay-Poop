package org.hjun.plugin.allaypoop;

import net.md_5.bungee.api.ChatColor;
import org.bukkit.entity.Item;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDropItemEvent;
import org.bukkit.event.entity.ItemSpawnEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import static org.bukkit.Material.BROWN_DYE;
import static org.bukkit.Sound.*;

import static org.hjun.plugin.allaypoop.AllayPoop.allaypoop;
import static org.hjun.plugin.allaypoop.AllayPoop.Allay;
public class apevent implements Listener {

    @EventHandler
    public void allaypoopentitydrop(EntityDropItemEvent e){
        if(allaypoop == 1) {
            if (String.valueOf(e.getEntity()).equals("CraftAllay")) {
                Allay = 1;
            }
        }
    }

    @EventHandler
    public void allaypoopitemspawn(ItemSpawnEvent e){
        if(allaypoop == 1) {
            if (Allay == 1) {
                Allay = 0;
                Item it = e.getEntity();
                ItemStack poop = new ItemStack(BROWN_DYE);
                ItemMeta poopmeta = poop.getItemMeta();
                poopmeta.setDisplayName(ChatColor.of("#825432") + ChatColor.BOLD.toString() + "똥");
                poop.setItemMeta(poopmeta);
                it.setItemStack(poop);
                e.getLocation().getWorld().playSound(e.getLocation(), BLOCK_HONEY_BLOCK_SLIDE, 50.0F, 0.5F);
            }
        }
    }
}
