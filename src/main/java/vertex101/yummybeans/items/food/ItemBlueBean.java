package vertex101.yummybeans.items.food;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import vertex101.yummybeans.YummyBeans;

public class ItemBlueBean extends ItemFood {
    public ItemBlueBean() {
        super(2, 1F, false);
        setAlwaysEdible();
        setTranslationKey(YummyBeans.MODID + ".bluebean");
        setRegistryName(new ResourceLocation(YummyBeans.MODID, "bluebean"));
        setCreativeTab(YummyBeans.creativeTab);
    }

    @SideOnly(Side.CLIENT)
    public void initModel() {
        ModelLoader.setCustomModelResourceLocation(this, 0, new ModelResourceLocation(getRegistryName(), "inventory"));
    }

    @Override
    protected void onFoodEaten(ItemStack stack, World worldIn, EntityPlayer player) {
        Potion[] affects = new Potion[] {
                MobEffects.SPEED, MobEffects.SLOWNESS, MobEffects.HASTE, MobEffects.MINING_FATIGUE,
                MobEffects.STRENGTH, MobEffects.INSTANT_DAMAGE, MobEffects.JUMP_BOOST, MobEffects.NAUSEA,
                MobEffects.REGENERATION, MobEffects.INVISIBILITY, MobEffects.BLINDNESS, MobEffects.HUNGER,
                MobEffects.WEAKNESS, MobEffects.POISON, MobEffects.WITHER, MobEffects.HEALTH_BOOST,
                MobEffects.ABSORPTION, MobEffects.SATURATION, MobEffects.GLOWING, MobEffects.LEVITATION, MobEffects.LUCK,
                MobEffects.UNLUCK
        };
        int chance = (int) (Math.random() * 100);
        int rand = worldIn.rand.nextInt(affects.length), rand0 = worldIn.rand.nextInt(affects.length), rand1 = worldIn.rand.nextInt(affects.length), rand2 = worldIn.rand.nextInt(affects.length), rand3 = worldIn.rand.nextInt(affects.length);
        if(!worldIn.isRemote) {
            if(chance <= 20){
                player.addPotionEffect(new PotionEffect(affects[rand], 60*20, 5, false, true));
            }else if(chance <= 40){
                player.addPotionEffect(new PotionEffect(affects[rand], 60*20, 5, false, true));
                player.addPotionEffect(new PotionEffect(affects[rand0], 60*20, 5, false, true));
            }else if(chance <= 60){
                player.addPotionEffect(new PotionEffect(affects[rand], 60*20, 5, false, true));
                player.addPotionEffect(new PotionEffect(affects[rand0], 60*20, 5, false, true));
                player.addPotionEffect(new PotionEffect(affects[rand1], 60*20, 5, false, true));
            }else if(chance <= 80){
                player.addPotionEffect(new PotionEffect(affects[rand], 60*20, 5, false, true));
                player.addPotionEffect(new PotionEffect(affects[rand0], 60*20, 5, false, true));
                player.addPotionEffect(new PotionEffect(affects[rand1], 60*20, 5, false, true));
                player.addPotionEffect(new PotionEffect(affects[rand2], 60*20, 5, false, true));
            }else if(chance <= 100){
                player.addPotionEffect(new PotionEffect(affects[rand], 60*20, 5, false, true));
                player.addPotionEffect(new PotionEffect(affects[rand0], 60*20, 5, false, true));
                player.addPotionEffect(new PotionEffect(affects[rand1], 60*20, 5, false, true));
                player.addPotionEffect(new PotionEffect(affects[rand2], 60*20, 5, false, true));
                player.addPotionEffect(new PotionEffect(affects[rand3], 60*20, 5, false, true));
            }
        }
    }
}
