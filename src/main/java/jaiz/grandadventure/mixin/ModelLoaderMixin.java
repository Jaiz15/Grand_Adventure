package jaiz.grandadventure.mixin;

import net.minecraft.client.color.block.BlockColors;
import net.minecraft.client.render.model.ModelLoader;
import net.minecraft.client.util.ModelIdentifier;
import net.minecraft.util.Identifier;
import net.minecraft.util.profiler.Profiler;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.Map;

@Mixin(ModelLoader.class)
public abstract class ModelLoaderMixin {
    @Shadow protected abstract void loadItemModel(ModelIdentifier id);


    @Inject(method = "<init>", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/render/model/ModelLoader;loadItemModel(Lnet/minecraft/client/util/ModelIdentifier;)V", ordinal = 1, shift = At.Shift.AFTER))
    public void loadCustomModels(BlockColors blockColors, Profiler profiler, Map jsonUnbakedModels, Map blockStates, CallbackInfo ci) {
        this.loadItemModel(new ModelIdentifier(Identifier.of("grandadventure", "guitar_3d"), "inventory"));
        this.loadItemModel(new ModelIdentifier(Identifier.of("grandadventure", "maraca_3d"), "inventory"));
        this.loadItemModel(new ModelIdentifier(Identifier.of("grandadventure", "drum_3d"), "inventory"));
        this.loadItemModel(new ModelIdentifier(Identifier.of("grandadventure", "bh_adventure_hat_3d"), "inventory"));

    }

}
