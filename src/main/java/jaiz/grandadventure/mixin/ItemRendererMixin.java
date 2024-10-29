package jaiz.grandadventure.mixin;


import jaiz.grandadventure.GrandAdventure;
import jaiz.grandadventure.block.ModBlocks;
import jaiz.grandadventure.item.ModItems;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.item.ItemRenderer;
import net.minecraft.client.render.model.BakedModel;
import net.minecraft.client.render.model.json.ModelTransformationMode;
import net.minecraft.client.util.ModelIdentifier;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

@Mixin(ItemRenderer.class)
public abstract class ItemRendererMixin {
    @ModifyVariable(method = "renderItem", at = @At(value = "HEAD"), argsOnly = true)
    public BakedModel useRubyStaffModel(BakedModel value, ItemStack stack, ModelTransformationMode renderMode, boolean leftHanded, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, int overlay) {
        if (stack.isOf(ModItems.MARACA) && renderMode != ModelTransformationMode.GUI) {
            return ((ItemRendererAccessor) this).grandadventure$getModels().getModelManager().getModel(new ModelIdentifier(Identifier.of("grandadventure", "maraca_3d"), "inventory"));
        }
        if (stack.isOf(ModItems.DRUM) && renderMode != ModelTransformationMode.GUI) {
            return ((ItemRendererAccessor) this).grandadventure$getModels().getModelManager().getModel(new ModelIdentifier(Identifier.of("grandadventure", "drum_3d"), "inventory"));
        }
        if (stack.isOf(ModItems.GUITAR) && renderMode != ModelTransformationMode.GUI) {
            return ((ItemRendererAccessor) this).grandadventure$getModels().getModelManager().getModel(new ModelIdentifier(Identifier.of("grandadventure", "guitar_3d"), "inventory"));
        }
        if (stack.isOf(ModItems.BH_HAT) && renderMode != ModelTransformationMode.GUI) {
            return ((ItemRendererAccessor) this).grandadventure$getModels().getModelManager().getModel(new ModelIdentifier(Identifier.of("grandadventure", "bh_adventure_hat_3d"), "inventory"));
        }
        return value;
    }
}
