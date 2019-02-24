package vertex101.yummybeans.items;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
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
        int chance = (int) (Math.random() * 100);
        if(!worldIn.isRemote) {
            if(chance <= 20){
                player.addPotionEffect(new PotionEffect(MobEffects.GLOWING, 60*20, 5, false, true));
            }else if(chance <= 40){
                player.addPotionEffect(new PotionEffect(MobEffects.JUMP_BOOST, 60*20, 5, false, true));
            }else if(chance <= 60){
                player.addPotionEffect(new PotionEffect(MobEffects.POISON, 60*20, 5, false, true));
                player.addPotionEffect(new PotionEffect(MobEffects.BLINDNESS, 60*20, 5, false, true));
                player.addPotionEffect(new PotionEffect(MobEffects.NAUSEA, 60*20, 5, false, true));
            }else if(chance <= 80){
                player.addPotionEffect(new PotionEffect(MobEffects.HUNGER, 60*20, 5, false, true));
            }else if(chance <= 100){
                player.addPotionEffect(new PotionEffect(MobEffects.INVISIBILITY, 60*20, 5, false, true));
                player.addPotionEffect(new PotionEffect(MobEffects.LEVITATION, 60*20, 5, false, true));
            }
        }
    }
}
