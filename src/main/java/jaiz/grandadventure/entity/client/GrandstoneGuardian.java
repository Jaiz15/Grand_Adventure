
package jaiz.grandadventure.entity.client;
import jaiz.grandadventure.entity.animation.GradstoneGuardianAnimations;
import jaiz.grandadventure.entity.living_entities.GrandstoneGuardianEntity;
import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.SinglePartEntityModel;
import net.minecraft.client.util.math.MatrixStack;
   
public class GrandstoneGuardian <T extends GrandstoneGuardianEntity> extends SinglePartEntityModel<T> {
	private final ModelPart grandstone_guardian;



	public GrandstoneGuardian(ModelPart root) {
		this.grandstone_guardian = root.getChild("grandstone_guardian");

	}
	public static TexturedModelData getTexturedModelData() {
		ModelData modelData = new ModelData();
		ModelPartData modelPartData = modelData.getRoot();
		ModelPartData grandstone_guardian = modelPartData.addChild("grandstone_guardian", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 24.0F, 0.0F));

		ModelPartData leg_l = grandstone_guardian.addChild("leg_l", ModelPartBuilder.create().uv(20, 45).cuboid(-2.0F, 0.0F, -3.0F, 4.0F, 13.0F, 6.0F, new Dilation(0.0F)), ModelTransform.pivot(2.0F, -13.0F, 0.0F));

		ModelPartData leg_r = grandstone_guardian.addChild("leg_r", ModelPartBuilder.create().uv(0, 45).cuboid(-2.0F, 0.0F, -3.0F, 4.0F, 13.0F, 6.0F, new Dilation(0.0F)), ModelTransform.pivot(-2.0F, -13.0F, 0.0F));

		ModelPartData body = grandstone_guardian.addChild("body", ModelPartBuilder.create().uv(0, 19).cuboid(-4.0F, -11.0F, -3.0F, 8.0F, 11.0F, 6.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -13.0F, 0.0F));

		ModelPartData head = body.addChild("head", ModelPartBuilder.create().uv(0, 0).cuboid(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -11.0F, 0.0F));

		ModelPartData arm_l = body.addChild("arm_l", ModelPartBuilder.create().uv(28, 19).cuboid(0.0F, -2.0F, -2.5F, 5.0F, 9.0F, 5.0F, new Dilation(0.0F)), ModelTransform.of(4.0F, -8.5F, 0.0F, -1.5708F, 0.0F, 0.0F));

		ModelPartData arm_l2 = arm_l.addChild("arm_l2", ModelPartBuilder.create().uv(44, 33).cuboid(-2.0F, 2.5F, -2.5F, 4.0F, 4.0F, 5.0F, new Dilation(0.0F)), ModelTransform.of(2.5F, 5.0F, 0.0F, 0.0F, 0.0F, 1.5708F));

		ModelPartData arm_r = body.addChild("arm_r", ModelPartBuilder.create().uv(32, 0).cuboid(-5.0F, -2.0F, -2.5F, 5.0F, 9.0F, 5.0F, new Dilation(0.0F)), ModelTransform.of(-4.0F, -8.5F, 0.0F, -1.5708F, 0.0F, 0.0F));

		ModelPartData arm_r2 = arm_r.addChild("arm_r2", ModelPartBuilder.create().uv(44, 33).cuboid(-2.25F, 2.0F, -2.5F, 4.0F, 4.0F, 5.0F, new Dilation(0.0F)), ModelTransform.of(-2.0F, 4.75F, 0.0F, 0.0F, 0.0F, -1.5708F));
		return TexturedModelData.of(modelData, 64, 64);
	}



	public void render(MatrixStack matrices, VertexConsumer vertexConsumer, int light, int overlay, float red, float green, float blue, float alpha) {
		grandstone_guardian.render(matrices, vertexConsumer, light, overlay);
	}

	@Override
	public ModelPart getPart() {
		return grandstone_guardian;
	}

	@Override
	public void setAngles(GrandstoneGuardianEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.getPart().traverse().forEach(ModelPart::resetTransform);
		this.animateMovement(GradstoneGuardianAnimations.GRANDSTONE_GAURDIAN_WALK, limbSwing, limbSwingAmount, 2f, 2.5f);

	}
}