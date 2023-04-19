package com.yuchiapi.fusionSolarClient;

import lombok.NoArgsConstructor;

import static lombok.AccessLevel.PRIVATE;

/**
 * Factory for creating instances of {@link FusionSolarClient}.
 */
@NoArgsConstructor(access = PRIVATE)
public class FusionSolarClientFactory {

    /**
     * Creates an instance of {@link FusionSolarClient}.
     */
    public static FusionSolarClient createFusionSolarClient() {
        return new FusionSolarClientImpl();
    }
}
