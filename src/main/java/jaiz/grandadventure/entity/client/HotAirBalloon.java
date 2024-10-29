package jaiz.grandadventure.entity.client;

import jaiz.grandadventure.entity.living_entities.HotAirBalloonEntity;
import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.SinglePartEntityModel;
import net.minecraft.client.util.math.MatrixStack;

   
public class HotAirBalloon <T extends HotAirBalloonEntity> extends SinglePartEntityModel<T> {

	private final ModelPart HotAirBalloon;

	public HotAirBalloon(ModelPart root) {
		this.HotAirBalloon = root.getChild("HotAirBalloon");
	}
	public static TexturedModelData getTexturedModelData() {
		ModelData modelData = new ModelData();
		ModelPartData modelPartData = modelData.getRoot();
		ModelPartData HotAirBalloon = modelPartData.addChild("HotAirBalloon", ModelPartBuilder.create().uv(0, 102).cuboid(-8.0F, -2.0F, -8.0F, 16.0F, 2.0F, 16.0F, new Dilation(0.0F))
		.uv(80, 86).cuboid(-8.0F, -37.0F, -8.0F, 16.0F, 21.0F, 16.0F, new Dilation(0.0F))
		.uv(0, 72).cuboid(-12.0F, -41.0F, -12.0F, 24.0F, 6.0F, 24.0F, new Dilation(0.0F))
		.uv(0, 0).cuboid(-18.0F, -77.0F, -18.0F, 36.0F, 36.0F, 36.0F, new Dilation(0.0F))
		.uv(0, 120).cuboid(-8.0F, -14.0F, -8.0F, 2.0F, 12.0F, 14.0F, new Dilation(0.0F))
		.uv(50, 109).cuboid(6.0F, -14.0F, -6.0F, 2.0F, 12.0F, 14.0F, new Dilation(0.0F))
		.uv(103, 123).cuboid(6.0F, -16.0F, -9.0F, 3.0F, 2.0F, 15.0F, new Dilation(0.0F))
		.uv(125, 11).cuboid(-9.0F, -16.0F, -6.0F, 3.0F, 2.0F, 15.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 24.0F, 0.0F));

		ModelPartData cube_r1 = HotAirBalloon.addChild("cube_r1", ModelPartBuilder.create().uv(124, 125).cuboid(6.0F, -10.0F, -9.0F, 3.0F, 2.0F, 15.0F, new Dilation(0.0F))
		.uv(67, 123).cuboid(-9.0F, -10.0F, -6.0F, 3.0F, 2.0F, 15.0F, new Dilation(0.0F))
		.uv(108, 0).cuboid(6.0F, -8.0F, -6.0F, 2.0F, 12.0F, 14.0F, new Dilation(0.0F))
		.uv(0, 0).cuboid(-8.0F, -8.0F, -8.0F, 2.0F, 12.0F, 14.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -6.0F, 0.0F, 0.0F, 1.5708F, 0.0F));
		return TexturedModelData.of(modelData, 216, 216);
	}

	@Override
	public void setAngles(HotAirBalloonEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
	}

	public void render(MatrixStack matrices, VertexConsumer vertexConsumer, int light, int overlay, float red, float green, float blue, float alpha) {
		HotAirBalloon.render(matrices, vertexConsumer, light, overlay);
	}

	@Override
	public ModelPart getPart() {
		return HotAirBalloon;
	}
}