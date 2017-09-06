package me.untilt.Objects;


import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

/**
 * Created by henry27 on 8/31/2017.
 */
public class Kit {

    public enum KITS {
        KNIGHT,
        MAGE,
        TANK;
        public String toString() {
            switch (this) {
                case KNIGHT:
                    return "Knight";
                case MAGE:
                    return "Mage";
                case TANK:
                    return "Tank";
                default:
                    return "NULL";
            }

        }
    }

    public Kit() {

    }

    public void giveKit(Player player) {
        player.getInventory().clear();
        Inventory inventory = player.getInventory();
        player.getEquipment().setHelmet(new ItemStack(Material.LEATHER_HELMET));
        player.getEquipment().setChestplate(new ItemStack(Material.LEATHER_CHESTPLATE));
        player.getEquipment().setLeggings(new ItemStack(Material.LEATHER_LEGGINGS));
        player.getEquipment().setBoots(new ItemStack(Material.LEATHER_BOOTS));
        inventory.addItem(new ItemStack(Material.STONE_SWORD,1));

    }

}
