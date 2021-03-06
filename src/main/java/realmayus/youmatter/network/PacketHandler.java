package realmayus.youmatter.network;

import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import net.minecraftforge.fml.relauncher.Side;
import realmayus.youmatter.YouMatter;

public class PacketHandler {
    public static SimpleNetworkWrapper INSTANCE;

    private static int ID = 0;
    private static int nextID() {return ID++;}

    public static void registerMessages() {
        INSTANCE = NetworkRegistry.INSTANCE.newSimpleChannel(YouMatter.MODID);

        INSTANCE.registerMessage(PacketUpdateReplicatorClient.Handler.class, PacketUpdateReplicatorClient.class, nextID(), Side.CLIENT);
        INSTANCE.registerMessage(PacketUpdateCreatorClient.Handler.class, PacketUpdateCreatorClient.class, nextID(), Side.CLIENT);
        INSTANCE.registerMessage(PacketUpdateEncoderClient.Handler.class, PacketUpdateEncoderClient.class, nextID(), Side.CLIENT);
        INSTANCE.registerMessage(PacketUpdateScannerClient.Handler.class, PacketUpdateScannerClient.class, nextID(), Side.CLIENT);

        INSTANCE.registerMessage(PacketShowPrevious.Handler.class, PacketShowPrevious.class, nextID(), Side.SERVER);
        INSTANCE.registerMessage(PacketShowNext.Handler.class, PacketShowNext.class, nextID(), Side.SERVER);
        INSTANCE.registerMessage(PacketChangeSettingsReplicatorServer.Handler.class, PacketChangeSettingsReplicatorServer.class, nextID(), Side.SERVER);
        INSTANCE.registerMessage(PacketChangeSettingsCreatorServer.Handler.class, PacketChangeSettingsCreatorServer.class, nextID(), Side.SERVER);

    }
}
