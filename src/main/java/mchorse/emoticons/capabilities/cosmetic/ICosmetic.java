package mchorse.emoticons.capabilities.cosmetic;

import mchorse.emoticons.common.emotes.Emote;
import net.minecraft.entity.EntityLivingBase;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public interface ICosmetic
{
    /**
     * Set current emote 
     */
    void setEmote(Emote emote, EntityLivingBase target);

    /**
     * Get current emote (check for null)
     */
    Emote getEmote();

    /**
     * Update this cosmetics capability based on the provided entity
     */
    void update(EntityLivingBase entity);

    /**
     * Render the entity with this cosmetics capability
     */
    @SideOnly(Side.CLIENT)
    boolean render(EntityLivingBase entity, double x, double y, double z, float partialTicks);
}