package dev.ywan.fogremover.mixin;

import net.minecraft.client.render.BackgroundRenderer;
import net.minecraft.client.render.Camera;
import net.minecraft.client.render.Fog;
import org.joml.Vector4f;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(BackgroundRenderer.class)
public class BackgroundRendererMixin {
	@Inject(at = @At("HEAD"), method = "applyFog", cancellable = true)
    private static void applyFog(Camera camera, BackgroundRenderer.FogType fogType, Vector4f color, float viewDistance, boolean thickenFog, float tickDelta, CallbackInfoReturnable<Fog> cir) {
		cir.cancel();
		cir.setReturnValue(Fog.DUMMY);
	}
}