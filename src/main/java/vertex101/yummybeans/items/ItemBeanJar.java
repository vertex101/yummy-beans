package vertex101.yummybeans.items;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.World;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import vertex101.yummybeans.YummyBeans;
import vertex101.yummybeans.init.ModItems;

public class ItemBeanJar extends Item {
    public ItemBeanJar() {
        setTranslationKey(YummyBeans.MODID + ".beanjar");
        setRegistryName(new ResourceLocation(YummyBeans.MODID, "beanjar"));
        setCreativeTab(YummyBeans.creativeTab);
    }

    @SideOnly(Side.CLIENT)
    public void initModel() {
        ModelLoader.setCustomModelResourceLocation(this, 0, new ModelResourceLocation(getRegistryName(), "inventory"));
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn) {
        Item[] beans = new Item[] {ModItems.itemBlackBean, ModItems.itemBlueBean, ModItems.itemGreenBean, ModItems.itemPurpleBean, ModItems.itemRedBean, ModItems.itemYellowBean};
        ItemStack item = playerIn.getHeldItem(handIn);
        if(!worldIn.isRemote && !playerIn.isSneaking()){
            int rand = worldIn.rand.nextInt(beans.length);
            playerIn.inventory.addItemStackToInventory(new ItemStack(beans[rand]));
            playerIn.sendMessage(new TextComponentString("You have gotten a BEAN!"));
            return new ActionResult(EnumActionResult.PASS, item);
        }else if(!worldIn.isRemote && playerIn.isSneaking()){
            int rand0 = worldIn.rand.nextInt(beans.length);
            int rand1 = worldIn.rand.nextInt(beans.length);
            int rand2 = worldIn.rand.nextInt(beans.length);
            int rand3 = worldIn.rand.nextInt(beans.length);
            int rand4 = worldIn.rand.nextInt(beans.length);
            playerIn.inventory.addItemStackToInventory(new ItemStack(beans[rand0]));
            playerIn.inventory.addItemStackToInventory(new ItemStack(beans[rand1]));
            playerIn.inventory.addItemStackToInventory(new ItemStack(beans[rand2]));
            playerIn.inventory.addItemStackToInventory(new ItemStack(beans[rand3]));
            playerIn.inventory.addItemStackToInventory(new ItemStack(beans[rand4]));
            playerIn.sendMessage(new TextComponentString("You have given 5 BEANS!"));
            return new ActionResult(EnumActionResult.PASS, item);
        }else {
            return new ActionResult(EnumActionResult.FAIL, item);
        }

    }
}
