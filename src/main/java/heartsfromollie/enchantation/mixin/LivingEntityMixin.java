package heartsfromollie.enchantation.mixin;

import heartsfromollie.enchantation.Enchantation;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.server.MinecraftServer;
import net.minecraft.sound.SoundEvents;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(LivingEntity.class)
public abstract class LivingEntityMixin extends Entity {
	protected LivingEntityMixin(EntityType entityType, World world) {
		super(entityType, world);
	}
	@Inject(method = "tick", at = @At("HEAD"))
	protected void tick(CallbackInfo ci) {
		LivingEntity currentEntity = (LivingEntity) (Object) this;
		int obscurityApplied = EnchantmentHelper.getEquipmentLevel(Enchantation.OBSCURITY, currentEntity);
		if (obscurityApplied > 0) {
			currentEntity.addStatusEffect(new StatusEffectInstance(StatusEffects.INVISIBILITY,
					360, 0, true, false, false));
			currentEntity.getWorld().playSound(null, currentEntity.getBlockPos(), SoundEvents.BLOCK_CANDLE_AMBIENT,
					currentEntity.getSoundCategory(), 0.1f, 1f);
		}

		int areyouAdept = EnchantmentHelper.getEquipmentLevel(Enchantation.ADEPT, currentEntity);
		if (areyouAdept > 0) {
			currentEntity.setStepHeight(areyouAdept + 0.1F);
		} else if (currentEntity instanceof PlayerEntity) {
			currentEntity.setStepHeight(0.6F);
		}
	}
}
