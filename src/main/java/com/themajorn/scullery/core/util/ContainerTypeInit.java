package com.themajorn.scullery.core.util;

import com.themajorn.scullery.Scullery;
import com.themajorn.scullery.common.containers.DesiccatorContainer;
import net.minecraft.inventory.container.ContainerType;
import net.minecraftforge.common.extensions.IForgeContainerType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ContainerTypeInit {

    public static final DeferredRegister<ContainerType<?>> CONTAINER_TYPE = DeferredRegister.create(
            ForgeRegistries.CONTAINERS, Scullery.MOD_ID);

    public static final RegistryObject<ContainerType<DesiccatorContainer>> DESICCATOR_CONTAINER = CONTAINER_TYPE
            .register("desiccator", () -> IForgeContainerType.create(DesiccatorContainer::new));

}
