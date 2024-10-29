package jaiz.grandadventure.entity.client;
import jaiz.grandadventure.entity.animation.KoiAnimations;
import jaiz.grandadventure.entity.living_entities.KoiEntity;
import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.SinglePartEntityModel;
import net.minecraft.client.util.math.MatrixStack;


public class Koi <T extends KoiEntity> extends SinglePartEntityModel<T> {
	private final ModelPart koi;

	public Koi(ModelPart root) {
		this.koi = root.getChild("koi");

	}
	public static TexturedModelData getTexturedModelData() {
		ModelData modelData = new ModelData();
		ModelPartData modelPartData = modelData.getRoot();
		ModelPartData Koi = modelPartData.addChild("koi", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 24.0F, 0.0F));

		ModelPartData body = Koi.addChild("body", ModelPartBuilder.create().uv(0, 0).cuboid(-1.5F, -2.0F, -3.0F, 3.0F, 4.0F, 6.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -1.5F, 0.0F));

		ModelPartData tail = body.addChild("tail", ModelPartBuilder.create().uv(18, 4).cuboid(-1.0F, -1.0F, 0.0F, 2.0F, 3.0F, 2.0F, new Dilation(0.0F))
		.uv(18, 17).cuboid(-1.0F, -1.0F, 2.0F, 2.0F, 2.0F, 2.0F, new Dilation(0.0F))
		.uv(12, 12).cuboid(0.0F, -3.5F, 0.0F, 0.0F, 3.0F, 4.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -1.0F, 3.0F));

		ModelPartData tail_2 = tail.addChild("tail_2", ModelPartBuilder.create().uv(0, 5).cuboid(0.0F, -2.5F, 0.0F, 0.0F, 5.0F, 6.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, 4.0F));

		ModelPartData anal_fin = tail.addChild("anal_fin", ModelPartBuilder.create().uv(0, 15).cuboid(0.0F, 0.0F, 0.0F, 0.0F, 2.0F, 4.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 1.0F, 0.0F));

		ModelPartData head = body.addChild("head", ModelPartBuilder.create().uv(12, 10).cuboid(-1.0F, -1.5F, -1.5F, 2.0F, 3.0F, 3.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, -4.5F));

		ModelPartData whisker_l = head.addChild("whisker_l", ModelPartBuilder.create().uv(0, 5).cuboid(0.0F, 0.0F, -0.5F, 2.0F, 0.0F, 1.0F, new Dilation(0.0F)), ModelTransform.pivot(1.0F, 0.5F, -1.0F));

		ModelPartData whisker_r = head.addChild("whisker_r", ModelPartBuilder.create().uv(0, 4).cuboid(-2.0F, 0.0F, -0.5F, 2.0F, 0.0F, 1.0F, new Dilation(0.0F)), ModelTransform.pivot(-1.0F, 0.5F, -1.0F));

		ModelPartData dorsal_fin = body.addChild("dorsal_fin", ModelPartBuilder.create().uv(0, 10).cuboid(0.0F, -2.5F, -3.0F, 0.0F, 3.0F, 6.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -2.0F, 0.0F));

		ModelPartData front_l = body.addChild("front_l", ModelPartBuilder.create().uv(9, 3).cuboid(0.0F, 0.0F, -1.5F, 4.0F, 0.0F, 3.0F, new Dilation(0.0F)), ModelTransform.pivot(1.5F, 2.0F, -1.5F));

		ModelPartData front_r = body.addChild("front_r", ModelPartBuilder.create().uv(9, 3).mirrored().cuboid(-4.0F, 0.0F, -1.5F, 4.0F, 0.0F, 3.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.pivot(-1.5F, 2.0F, -1.5F));

		ModelPartData back_l = body.addChild("back_l", ModelPartBuilder.create().uv(0, 0).cuboid(0.0F, 0.0F, -1.0F, 2.0F, 0.0F, 2.0F, new Dilation(0.0F)), ModelTransform.pivot(1.5F, 2.0F, 2.0F));

		ModelPartData back_r = body.addChild("back_r", ModelPartBuilder.create().uv(0, 0).mirrored().cuboid(-2.0F, 0.0F, -1.0F, 2.0F, 0.0F, 2.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.pivot(-1.5F, 2.0F, 2.0F));
		return TexturedModelData.of(modelData, 32, 32);
	}

	@Override
	public void setAngles(KoiEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch)  {
		this.getPart().traverse().forEach(ModelPart::resetTransform);
		this.updateAnimation(entity.swimAnimationState, KoiAnimations.KOI_SWIM, ageInTicks, 1f);
	}

	public void render(MatrixStack matrices, VertexConsumer vertexConsumer, int light, int overlay, float red, float green, float blue, float alpha) {
		koi.render(matrices, vertexConsumer, light, overlay);
	}

	@Override
	public ModelPart getPart() {
		return koi;
	}

}