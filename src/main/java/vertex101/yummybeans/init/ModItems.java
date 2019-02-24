package vertex101.yummybeans.init;

import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.registries.IForgeRegistry;
import vertex101.yummybeans.items.*;
import vertex101.yummybeans.items.food.*;


public class ModItems {
    @GameRegistry.ObjectHolder("yummybeans:blackbean")
    public static ItemBlackBean itemBlackBean;
    @GameRegistry.ObjectHolder("yummybeans:bluebean")
    public static ItemBlueBean itemBlueBean;
    @GameRegistry.ObjectHolder("yummybeans:greenbean")
    public static ItemGreenBean itemGreenBean;
    @GameRegistry.ObjectHolder("yummybeans:purplebean")
    public static ItemPurpleBean itemPurpleBean;
    @GameRegistry.ObjectHolder("yummybeans:redbean")
    public static ItemRedBean itemRedBean;
    @GameRegistry.ObjectHolder("yummybeans:yellowbean")
    public static ItemYellowBean itemYellowBean;
    @GameRegistry.ObjectHolder("yummybeans:beanjar")
    public static ItemBeanJar itemBeanJar;

    @SideOnly(Side.CLIENT)
    public static void initModels() {
        itemBlackBean.initModel();
        itemBlueBean.initModel();
        itemGreenBean.initModel();
        itemPurpleBean.initModel();
        itemRedBean.initModel();
        itemYellowBean.initModel();
        itemBeanJar.initModel();
    }

    public static void register(IForgeRegistry<Item> registry) {
        registry.register(new ItemBlackBean());
        registry.register(new ItemBlueBean());
        registry.register(new ItemGreenBean());
        registry.register(new ItemPurpleBean());
        registry.register(new ItemRedBean());
        registry.register(new ItemYellowBean());
        registry.register(new ItemBeanJar());
    }
}
