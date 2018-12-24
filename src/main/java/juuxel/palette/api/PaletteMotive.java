/* This file is a part of the Palette project
 * by Juuxel, licensed under the MIT license.
 * Full code and license: https://github.com/Juuxel/Palette
 */
package juuxel.palette.api;

import net.minecraft.sortme.PaintingMotive;
import net.minecraft.util.Identifier;

import java.util.Objects;

public class PaletteMotive extends PaintingMotive {
    public final Identifier texture;

    public PaletteMotive(int width, int height, int textureX, int textureY, Identifier texture) {
        super(width, height, textureX, textureY);
        Objects.requireNonNull(texture);
        this.texture = texture;
    }
}
