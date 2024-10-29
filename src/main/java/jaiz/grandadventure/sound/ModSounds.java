package jaiz.grandadventure.sound;
import jaiz.grandadventure.GrandAdventure;
import net.minecraft.block.jukebox.JukeboxSong;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;

public class ModSounds {

    public static RegistryKey<JukeboxSong> of(String id) {
        return RegistryKey.of(RegistryKeys.JUKEBOX_SONG, Identifier.of(GrandAdventure.MOD_ID, id));
    }

    public static final SoundEvent GUITAR = registerSoundEvent("guitar");
    public static final SoundEvent MARACA = registerSoundEvent("maraca");
    public static final SoundEvent DRUM = registerSoundEvent("drum");

    private static void registerReference(String name) {
        Identifier ID = Identifier.of(GrandAdventure.MOD_ID, name);
        Registry.registerReference(Registries.SOUND_EVENT, ID, SoundEvent.of(ID));
    }


    public static void registerSounds() {
        GrandAdventure.LOGGER.info(("Registering sounds for " + GrandAdventure.MOD_ID));
        ModSounds.registerReference("pools_of_life");
        ModSounds.registerReference("slum_space");
        ModSounds.registerReference("industrial_devolution");
        ModSounds.registerReference("survivors_melody");
    }

    private static SoundEvent registerSoundEvent(String name) {
        Identifier id = Identifier.of(GrandAdventure.MOD_ID, name);
        return Registry.register(Registries.SOUND_EVENT, id, SoundEvent.of(id));

    }
}
