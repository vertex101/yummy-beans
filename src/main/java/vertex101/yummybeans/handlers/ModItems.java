package vertex101.yummybeans.handlers;

import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.registries.IForgeRegistry;
import vertex101.yummybeans.items.*;

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

    @SideOnly(Side.CLIENT)
    public static void initModels() {
        itemBlackBean.initModel();
        //itemBlueBean.initModel();
        //itemGreenBean.initModel();
        //itemPurpleBean.initModel();
        //itemRedBean.initModel();
       // itemYellowBean.initModel();
    }

    public static void register(IForgeRegistry<Item> registry) {
        registry.register(new ItemBlackBean());
    }
}
