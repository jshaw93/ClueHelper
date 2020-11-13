package me.twoeggs.maphelper;

import net.minecraft.client.MainWindow;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.player.ClientPlayerEntity;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.nbt.INBT;
import net.minecraft.util.text.ITextComponent;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

@Mod(MapHelper.MOD_ID)
@Mod.EventBusSubscriber(Dist.CLIENT)
public class MapHelper {
    public static MapHelper instance;
    public static final String MOD_ID = "maphelper";
    public static final Logger LOGGER = LogManager.getLogger();

    private String egg;
    private String egg2;

    private boolean used = false;
    private int ticks = 0;

    public MapHelper() {
        final IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        instance = this;
        MinecraftForge.EVENT_BUS.register(this);
    }

    @SubscribeEvent
    @OnlyIn(Dist.CLIENT)
    public void onTick(TickEvent.ClientTickEvent e) {
        // Tick counter 5 seconds
        if(ticks > 100 && used) {
            ticks = 0;
            used = false;
        }
        if(used) {
            ticks++;
        }
        //
        Minecraft mc = Minecraft.getInstance();
        ClientPlayerEntity player = mc.player;
        if (player == null) return;
        ItemStack item = player.getHeldItemMainhand();
        String newString = "";
        String display;
        String display2;
        if(item.hasTag()) {
            CompoundNBT itemNBT = item.getTag();
            ITextComponent po;
            try {
                INBT g = itemNBT.get("display");
                po = g.toFormattedComponent();
            } catch(NullPointerException err) {
                return;
            }
            List<ITextComponent> lst = po.getSiblings();
            for(ITextComponent i : lst) {
                String lg = i.toString();
                if(lg.contains("Clue Scroll ID: \"")) {
                    for(int j = 1; j <= 37; j++) {
                        if(!lg.contains("\"" + j + "\"")) {
                            continue;
                        }
                        newString = Integer.toString(j);
                    }
                }
            }
        }
        switch(newString) {
            case "1":
                display = "/compass set 455 63 -541";
                display2 = "Between G.E. and Varrock Treasure Chest area";
                break;
            case "2":
                display = "/compass set 612 65 -410";
                display2 = "South of Varrock Platebody store";
                break;
            case "3":
                display = "/compass set 548 65 84";
                display2 = "South-east of Fred the Farmer's house";
                break;
            case "4":
                display = "/compass set 623 65 399";
                display2 = "West of Lumbridge East Mine";
                break;
            case "5":
                display = "/compass set 459 63 217";
                display2 = "West of Lumbridge Castle";
                break;
            case "6":
                display = "/compass set 430 65 -243";
                display2 = "West of the Champion's Guild";
                break;
            case "7":
                display = "/compass set 4 72 355";
                display2 = "South of Port Sarim docks";
                break;
            case "8":
                display = "/compass set -258 65 395";
                display2 = "West of Karamja General Store";
                break;
            case "9":
                display = "/compass set -131 65 179";
                display2 = "South of Rimmington Mine";
                break;
            case "10":
                display = "/compass set 4 65 -18";
                display2 = "West of the Falador farm";
                break;
            case "11":
                display = "/compass set 930 67 390";
                display2 = "South-east of Al Kharid";
                break;
            case "12":
                display = "/compass set 809 65 -46";
                display2 = "West of the Al Kharid Mine";
                break;
            case "13":
                display = "/compass set 660 65 18";
                display2 = "West of the Lumbridge Cow pen (Eastern)";
                break;
            case "14":
                display = "/compass set 676 65 -192";
                display2 = "South of Varrock, inside the fencing";
                break;
            case "15":
                display = "/compass set 338 65 -648";
                display2 = "West of the G.E.";
                break;
            case "16":
                display = "/compass set 357 65 64";
                display2 = "North-west of the H.A.M. Hideout";
                break;
            case "17":
                display = "/compass set 687 63 -35";
                display2 = "Lumbridge cow pen (Eastern)";
                break;
            case "18":
                display = "/compass set 134 68 -477";
                display2 = "West of Barbarian Village";
                break;
            case "19":
                display = "/compass set 264 63 -695";
                display2 = "YSITARLIK; Krystilia in Edgeville";
                break;
            case "20":
                display = "/compass set -132 68 -174";
                display2 = "UESRIQ; Squire in Falador";
                break;
            case "21":
                display = "/compass set 202 62 70";
                display2 = "GEGIA; Aggie in Draynor";
                break;
            case "22":
                display = "/compass set 237 63 78";
                display2 = "NED; Ned in Draynor";
                break;
            case "23":
                display = "/compass set 296 65 65";
                display2 = "LEEAL; Leela near Draynor Jail";
                break;
            case "24":
                display = "/compass set 321 63 133";
                display2 = "ELLKAIDY; Lady Keli in Draynor Jail";
                break;
            case "25":
                display = "/compass set 309 63 133";
                display2 = "OEJ; Joe in Draynor Jail";
                break;
            case "26":
                display = "/compass set 48 66 247";
                display2 = "LAASIS RMREON; Seaman Lorris in Port Sarim";
                break;
            case "27":
                display = "/compass set 708 63 -358";
                display2 = "RBUAUY; Aubury in Varrock";
                break;
            case "28":
                display = "/compass set -204 65 415";
                display2 = "OSMCFSEFROTIUC; Customs Officer on Karamja";
                break;
            case "29":
                display = "/compass set -162 63 239";
                display2 = "ETTYH; Hetty in Rimmington";
                break;
            case "30":
                display = "/compass set -112 79 -174";
                display2 = "YNIRVVISV; Sir Vyvin in Falador";
                break;
            case "31":
                display = "/compass set -87 65 408";
                display2 = "GRTUHO; Thurgo near Port Sarim";
                break;
            case "32":
                display = "/compass set -207 61 -508";
                display2 = "IDOCR; Doric north of Falador";
                break;
            case "33":
                display = "/compass set 569 62 -639";
                display2 = "DORLE; Reldo in Varrock Castle";
                break;
            case "34":
                display = "/compass set 576 71 185";
                display2 = "OHRUKA ECDOI; Duke Horacio in Lumbridge Castle";
                break;
            case "35":
                display = "/compass set 284 49 376";
                display2 = "RDRRIS ODIWZAE; Wizard Sedridor in Wizards Tower";
                break;
            case "36":
                display = "/compass set 687 64 228";
                display2 = "TAFEERCKARNE; Father Aereck in Lumbridge church";
                break;
            case "37":
                display = "/compass set 751 66 292";
                display2 = "RAMIK; Karim in Al Kharid";
                break;
            default:
                display = "";
                display2 = "";
        }
        egg = display;
        egg2 = display2;
    }

    @SubscribeEvent
    @OnlyIn(Dist.CLIENT)
    public void gameRenderEvent(RenderGameOverlayEvent.Post e) {
        String x;
        try {
            x = egg;
        } catch(NullPointerException n) {
            return;
        }
        Minecraft mc = Minecraft.getInstance();
        MainWindow res = e.getWindow();
        FontRenderer renderer = mc.fontRenderer;
        int width = res.getScaledWidth()-10-renderer.getStringWidth(x);
        int width2 = res.getScaledWidth()-10-renderer.getStringWidth(egg2);
        int height = res.getScaledHeight()/2+50;
        int height2 = height+10;
        renderer.drawString(x, width, height, 0xFFFFFFFF);
        renderer.drawString(egg2, width2, height2, 0xFFFFFFFF);
    }

    @SubscribeEvent
    @OnlyIn(Dist.CLIENT)
    public void useItemEvent(PlayerInteractEvent.RightClickItem e) {
        if(used) return;
        if(egg.isEmpty()) return;
        used = true;
        ClientPlayerEntity player = (ClientPlayerEntity) e.getPlayer();
        player.sendChatMessage(egg);
    }
}
