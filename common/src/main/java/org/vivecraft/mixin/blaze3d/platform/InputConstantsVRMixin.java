package org.vivecraft.mixin.blaze3d.platform;

import com.mojang.blaze3d.platform.InputConstants;
import org.lwjgl.glfw.GLFW;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import org.vivecraft.provider.InputSimulator;

@Mixin(InputConstants.class)
public class InputConstantsVRMixin {

    @Inject(at = @At("HEAD"), method = "isKeyDown", cancellable = true)
    private static void keyDown(long l, int i, CallbackInfoReturnable<Boolean> cir){
        cir.setReturnValue(GLFW.glfwGetKey(l,i) == 1 || InputSimulator.isKeyDown(i)) ;
    }
}
