package heartsfromollie.enchantation;

import heartsfromollie.enchantation.enchantment.AdeptEnchantment;
import heartsfromollie.enchantation.enchantment.ObscurityEnchantment;
import heartsfromollie.enchantation.enchantment.SiphonEnchantment;
import heartsfromollie.enchantation.enchantment.ToxicShockEnchantment;
import net.fabricmc.api.ModInitializer;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Enchantation implements ModInitializer {
	public static final String MOD_ID = "enchantation";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);
	public static Enchantment TOXICSHOCK = new ToxicShockEnchantment();
	public static Enchantment OBSCURITY = new ObscurityEnchantment();
	public static Enchantment ADEPT = new AdeptEnchantment();
	public static Enchantment SIPHON = new SiphonEnchantment();

	@Override
	public void onInitialize() {
		Registry.register(Registries.ENCHANTMENT, new Identifier("enchantation", "toxshock"), TOXICSHOCK);
		Registry.register(Registries.ENCHANTMENT, new Identifier("enchantation", "obscurity"), OBSCURITY);
		Registry.register(Registries.ENCHANTMENT, new Identifier("enchantation", "adept"), ADEPT);
		Registry.register(Registries.ENCHANTMENT, new Identifier("enchantation", "siphon"), SIPHON);

	}
}