package jaiz.grandadventure.entity.client;// Made with Blockbench 4.11.1
// Exported for Minecraft version 1.17+ for Yarn
// Paste this class into your mod and generate all required imports

import jaiz.grandadventure.entity.living_entities.GrandCannonEntity;
import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.render.entity.model.SinglePartEntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.math.MathHelper;

public class GrandCannon <T extends GrandCannonEntity> extends SinglePartEntityModel<T> {
	private final ModelPart grand_cannon;
	private final ModelPart bow;

	public GrandCannon(ModelPart root) {
		this.grand_cannon = root.getChild("grand_cannon");
		this.bow = grand_cannon.getChild("bow");

	}
	public static TexturedModelData getTexturedModelData() {
		ModelData modelData = new ModelData();
		ModelPartData modelPartData = modelData.getRoot();
		ModelPartData grand_cannon = modelPartData.addChild("grand_cannon", ModelPartBuilder.create().uv(74, 115).cuboid(-3.0F, -23.0F, -3.0F, 6.0F, 23.0F, 6.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 24.0F, 0.0F));

		ModelPartData bow = grand_cannon.addChild("bow", ModelPartBuilder.create().uv(106, 62).cuboid(-5.0F, -5.0F, -9.0F, 10.0F, 10.0F, 20.0F, new Dilation(0.0F))
				.uv(0, 62).cuboid(-3.0F, -4.0F, -25.0F, 6.0F, 6.0F, 47.0F, new Dilation(0.0F))
				.uv(98, 119).cuboid(-4.0F, -4.0F, -31.0F, 8.0F, 4.0F, 6.0F, new Dilation(0.0F))
				.uv(0, 121).cuboid(6.0F, -2.0F, -2.0F, 2.0F, 4.0F, 4.0F, new Dilation(0.0F))
				.uv(24, 121).cuboid(5.0F, -1.0F, -1.0F, 1.0F, 2.0F, 2.0F, new Dilation(0.0F))
				.uv(98, 115).cuboid(-6.0F, -1.0F, -1.0F, 1.0F, 2.0F, 2.0F, new Dilation(0.0F))
				.uv(12, 121).cuboid(-8.0F, -2.0F, -2.0F, 2.0F, 4.0F, 4.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -17.0F, 0.0F));

		ModelPartData cube_r1 = bow.addChild("cube_r1", ModelPartBuilder.create().uv(0, 115).cuboid(-31.0F, -4.0F, -1.0F, 33.0F, 2.0F, 4.0F, new Dilation(0.0F)), ModelTransform.of(-4.0F, 0.5F, -23.25F, 0.0F, 0.4363F, 0.0F));

		ModelPartData cube_r2 = bow.addChild("cube_r2", ModelPartBuilder.create().uv(106, 113).cuboid(-2.0F, -4.0F, -1.0F, 33.0F, 2.0F, 4.0F, new Dilation(0.0F)), ModelTransform.of(4.0F, 0.5F, -23.25F, 0.0F, -0.4363F, 0.0F));

		ModelPartData bone = bow.addChild("bone", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, -2.5F, -8.0F));

		ModelPartData cube_r3 = bone.addChild("cube_r3", ModelPartBuilder.create().uv(0, 0).cuboid(-16.0F, 0.0F, -31.0F, 46.0F, 0.0F, 62.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, -1.0F, 0.0F, -1.5708F, 0.0F));
		return TexturedModelData.of(modelData, 256, 256);
	}

	public void render(MatrixStack matrices, VertexConsumer vertexConsumer, int light, int overlay, float red, float green, float blue, float alpha) {
		grand_cannon.render(matrices, vertexConsumer, light, overlay);
	}

	private void setHeadAngles(float headYaw, float headPitch) {
		headYaw = MathHelper.clamp(headYaw, -20.0f, 20.0f);
		headPitch = MathHelper.clamp(headPitch, -20.0f, 20.0f);

		this.bow.yaw = headYaw * 0.017453292F;
		this.bow.pitch = headPitch * 0.017453292F;

	}

	@Override
	public void setAngles(GrandCannonEntity entity, float limbAngle, float limbDistance, float animationProgress, float headYaw, float headPitch) {
		this.getPart().traverse().forEach(ModelPart::resetTransform);
		this.setHeadAngles(headYaw, headPitch);
	}

	@Override
	public ModelPart getPart() {
		return grand_cannon;
	}
}