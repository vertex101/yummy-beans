package vertex101.yummybeans.items;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.ItemFood;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import vertex101.yummybeans.YummyBeans;

public class ItemPurpleBean extends ItemFood {
    public ItemPurpleBean() {
        super(2, 1F, false);
        setAlwaysEdible();
        setTranslationKey(YummyBeans.MODID + ".purplebean");
        setRegistryName(new ResourceLocation(YummyBeans.MODID, "purplebean"));
        setCreativeTab(YummyBeans.creativeTab);
    }

    @SideOnly(Side.CLIENT)
    public void initModel() {
        ModelLoader.setCustomModelResourceLocation(this, 0, new ModelResourceLocation(getRegistryName(), "inventory"));
    }
}
