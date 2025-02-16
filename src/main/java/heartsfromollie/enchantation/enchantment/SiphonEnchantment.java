package heartsfromollie.enchantation.enchantment;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.DamageUtil;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.particle.ParticleTypes;

public class SiphonEnchantment extends Enchantment {
    public SiphonEnchantment() {
        super(Rarity.RARE, EnchantmentTarget.WEAPON, new EquipmentSlot[]{EquipmentSlot.MAINHAND});

    }
    @Override
    public void onTargetDamaged(LivingEntity user, Entity target, int level) {
        if (target.getWorld().isClient) {
            for (int i = 0; i < 6; i++) {
                target.getWorld().addParticle(ParticleTypes.DAMAGE_INDICATOR, target.getParticleX(1), target.getBodyY(0.5), target.getParticleZ(1), 0, 0, 0);
            }
        } else {
            user.heal(0.5F);
        }
    }
}
