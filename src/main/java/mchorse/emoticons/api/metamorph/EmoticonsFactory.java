package mchorse.emoticons.api.metamorph;

import mchorse.emoticons.api.metamorph.gui.GuiEmoticonsMorph;
import mchorse.metamorph.api.IMorphFactory;
import mchorse.metamorph.api.MorphManager;
import mchorse.metamorph.api.morphs.AbstractMorph;
import mchorse.metamorph.client.gui.editor.GuiAbstractMorph;
import net.minecraft.client.Minecraft;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.List;

/**
 * Animated factory class. This class is responsible for creating 
 * animated morphs.
 */
public class EmoticonsFactory implements IMorphFactory
{
    @Override
    public void register(MorphManager manager)
    {
        manager.list.sections.add(new EmoticonsSection("assets/emoticons"));
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerMorphEditors(Minecraft mc, List<GuiAbstractMorph> editors)
    {
        editors.add(new GuiEmoticonsMorph(mc));
    }

    @Override
    public boolean hasMorph(String name)
    {
        return name.startsWith("emoticons.");
    }

    @Override
    public AbstractMorph getMorphFromNBT(NBTTagCompound tag)
    {
        EmoticonsMorph morph = new EmoticonsMorph();

        if (!tag.hasKey("Animation"))
        {
            tag.setString("Animation", tag.getString("Name").split("\\.")[1]);
        }

        morph.fromNBT(tag);

        return morph;
    }
}