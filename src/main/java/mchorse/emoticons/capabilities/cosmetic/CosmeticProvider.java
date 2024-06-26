package mchorse.emoticons.capabilities.cosmetic;

import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityInject;
import net.minecraftforge.common.capabilities.ICapabilityProvider;

import javax.annotation.Nonnull;

public class CosmeticProvider implements ICapabilityProvider
{
    @CapabilityInject(ICosmetic.class)
    public static final Capability<ICosmetic> COSMETIC = null;

    private final ICosmetic instance = COSMETIC.getDefaultInstance();

    @Override
    public boolean hasCapability(@Nonnull Capability<?> capability, EnumFacing facing)
    {
        return capability == COSMETIC;
    }

    @Override
    public <T> T getCapability(@Nonnull Capability<T> capability, EnumFacing facing)
    {
        return capability == COSMETIC ? COSMETIC.<T>cast(this.instance) : null;
    }
}