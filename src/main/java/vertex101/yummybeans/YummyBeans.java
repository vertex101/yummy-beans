package vertex101.yummybeans;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.Logger;
import vertex101.yummybeans.init.ModItems;
import vertex101.yummybeans.proxy.CommonProxy;

@Mod(modid = YummyBeans.MODID, name = YummyBeans.NAME, version = YummyBeans.VERSION)
public class YummyBeans {
    public static final String MODID = "yummybeans";
    public static final String NAME = "Yummy Beans";
    public static final String VERSION = "0.0.2";

    private static Logger logger;

    @SidedProxy(clientSide = "vertex101.yummybeans.proxy.ClientProxy", serverSide = "vertex101.yummybeans.proxy.ServerProxy")
    public static CommonProxy proxy;

    public static CreativeTabs creativeTab = new CreativeTabs("yummybeans") {
        @Override
        public ItemStack createIcon() {
            return new ItemStack(ModItems.itemBlackBean);
        }
    };

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        logger = event.getModLog();
        proxy.preInit(event);
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent e) {
        proxy.init(e);
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent e) {
        proxy.postInit(e);
    }
}
