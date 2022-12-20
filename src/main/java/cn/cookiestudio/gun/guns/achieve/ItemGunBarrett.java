package cn.cookiestudio.gun.guns.achieve;

import cn.cookiestudio.gun.guns.ItemGunBase;
import cn.cookiestudio.gun.guns.ItemMagBase;
import cn.nukkit.item.customitem.data.Offset;
import cn.nukkit.item.customitem.data.RenderOffsets;
import lombok.Getter;

@Getter
public class ItemGunBarrett extends ItemGunBase {

    public ItemGunBarrett() {
        super(getGunData(ItemGunBarrett.class).getGunName());
        gunData = getGunData(this.getClass());
        this.setCustomName(gunData.getGunName());
        if (!this.getNamedTag().contains("ammoCount")) {
            this.setAmmoCount(this.getGunData().getMagSize());
        } else {
            this.setAmmoCount(this.getAmmoCount());
        }
    }


    public void doInit() {
    }

    @Override
    public int getSkinId() {
        return 7;
    }

    @Override
    public Offset scaleOffset() {
        Offset offset = Offset.builder().scale(0,0,0).position(0,0,0).rotation(0,0,0);
        return offset;
    }

    @Override
    public float getDropItemScale() {
        return 0.08f;
    }

    @Override
    public ItemMagBase getItemMagObject() {
        return new ItemMagBarrett();
    }

    public static class ItemMagBarrett extends ItemMagBase {
        public ItemMagBarrett() {
            super(getGunData(ItemGunBarrett.class).getMagName());
            this.setCustomName(getGunData(ItemGunBarrett.class).getMagName());
        }

        @Override
        public int getSkinId() {
            return 8;
        }

        @Override
        public float getDropItemScale() {
            return 0.15f;
        }
    }
}
