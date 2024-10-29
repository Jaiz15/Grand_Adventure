package jaiz.grandadventure.entity.client;// Made with Blockbench 4.11.1
// Exported for Minecraft version 1.17+ for Yarn
// Paste this class into your mod and generate all required imports


import jaiz.grandadventure.entity.animation.GradstoneGuardianAnimations;
import jaiz.grandadventure.entity.animation.GrandstoneMiteAnimations;
import jaiz.grandadventure.entity.living_entities.GrandstoneMiteEntity;
import net.minecraft.client.render.entity.model.SinglePartEntityModel;
import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.render.entity.model.SinglePartEntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.math.MathHelper;

public class GrandstoneMite <T extends GrandstoneMiteEntity> extends SinglePartEntityModel<T> {
	private final ModelPart GrandstoneMite;

	public GrandstoneMite(ModelPart root) {
		this.GrandstoneMite = root.getChild("GrandstoneMite");
	}
	public static TexturedModelData getTexturedModelData() {
		ModelData modelData = new ModelData();
		ModelPartData modelPartData = modelData.getRoot();
		ModelPartData GrandstoneMite = modelPartData.addChild("GrandstoneMite", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 24.0F, 0.0F));

		ModelPartData legs1 = GrandstoneMite.addChild("legs1", ModelPartBuilder.create().uv(0, 50).cuboid(0.0F, -6.0F, -8.0F, 8.0F, 6.0F, 4.0F, new Dilation(0.0F))
		.uv(24, 56).cuboid(4.0F, -6.0F, -4.0F, 4.0F, 6.0F, 4.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

		ModelPartData legs2 = GrandstoneMite.addChild("legs2", ModelPartBuilder.create().uv(32, 26).cuboid(-8.0F, -6.0F, -8.0F, 8.0F, 6.0F, 4.0F, new Dilation(0.0F))
		.uv(40, 56).cuboid(-8.0F, -6.0F, -4.0F, 4.0F, 6.0F, 4.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

		ModelPartData legs3 = GrandstoneMite.addChild("legs3", ModelPartBuilder.create().uv(32, 46).cuboid(-8.0F, -6.0F, 4.0F, 8.0F, 6.0F, 4.0F, new Dilation(0.0F))
		.uv(56, 26).cuboid(-8.0F, -6.0F, 0.0F, 4.0F, 6.0F, 4.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

		ModelPartData legs4 = GrandstoneMite.addChild("legs4", ModelPartBuilder.create().uv(32, 36).cuboid(0.0F, -6.0F, 4.0F, 8.0F, 6.0F, 4.0F, new Dilation(0.0F))
		.uv(56, 36).cuboid(4.0F, -6.0F, 0.0F, 4.0F, 6.0F, 4.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

		ModelPartData head = GrandstoneMite.addChild("head", ModelPartBuilder.create().uv(0, 0).cuboid(-8.0F, -16.0F, -8.0F, 16.0F, 10.0F, 16.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

		ModelPartData head2 = head.addChild("head2", ModelPartBuilder.create().uv(0, 26).cuboid(-4.0F, -16.0F, -4.0F, 8.0F, 16.0F, 8.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

		ModelPartData bone = head2.addChild("bone", ModelPartBuilder.create().uv(24, 11).cuboid(-4.0F, -7.0F, -4.0F, 8.0F, 7.0F, 8.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, 0.0F));
		return TexturedModelData.of(modelData, 128, 128);
	}
	@Override
	public void setAngles(GrandstoneMiteEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.getPart().traverse().forEach(ModelPart::resetTransform);
		this.animateMovement(GrandstoneMiteAnimations.MITE_WALK, limbSwing, limbSwingAmount, 2f, 2.5f);


	}


	public void render(MatrixStack matrices, VertexConsumer vertexConsumer, int light, int overlay, float red, float green, float blue, float alpha) {
		GrandstoneMite.render(matrices, vertexConsumer, light, overlay);
	}

	@Override
	public ModelPart getPart() {
		return GrandstoneMite;
	}
}