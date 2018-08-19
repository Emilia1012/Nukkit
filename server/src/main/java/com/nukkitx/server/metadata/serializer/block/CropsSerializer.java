package com.nukkitx.server.metadata.serializer.block;

import com.flowpowered.math.GenericMath;
import com.nukkitx.api.item.ItemType;
import com.nukkitx.api.metadata.block.Crops;
import com.nukkitx.server.metadata.serializer.MetadataSerializer;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class CropsSerializer implements MetadataSerializer<Crops> {

    public static final MetadataSerializer INSTANCE = new CropsSerializer();

    @Override
    public short readMetadata(Crops data) {
        return (short) data.getStage();
    }

    @Override
    public Crops writeMetadata(ItemType type, short metadata) {
        metadata = (short) GenericMath.clamp(metadata, 0, 7);

        return Crops.of(metadata);
    }
}
