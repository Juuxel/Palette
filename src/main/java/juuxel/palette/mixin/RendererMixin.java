/* This file is a part of the Palette project
 * by Juuxel, licensed under the MIT license.
 * Full code and license: https://github.com/Juuxel/Palette
 */
package juuxel.palette.mixin;

import juuxel.palette.api.PaletteMotive;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.entity.PaintingEntityRenderer;
import net.minecraft.entity.decoration.PaintingEntity;
import net.minecraft.util.Identifier;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Environment(EnvType.CLIENT)
@Mixin(PaintingEntityRenderer.class)
public class RendererMixin {
    @Inject(method = "getTexture", at = @At("HEAD"), cancellable = true)
    private void onGetTexture(PaintingEntity entity, CallbackInfoReturnable<Identifier> info) {
        if (entity.type instanceof PaletteMotive) {
            info.setReturnValue(((PaletteMotive) entity.type).texture);
            info.cancel();
        }
    }
}
