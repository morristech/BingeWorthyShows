package com.guidovezzoni.bingeworthyshows.config.repository.source;

import com.guidovezzoni.bingeworthyshows.common.api.ApiHandler;
import com.guidovezzoni.bingeworthyshows.common.api.MovieDbServiceApi;
import com.guidovezzoni.bingeworthyshows.common.model.datalayer.ConfigurationResponse;
import com.guidovezzoni.bingeworthyshows.common.utils.RxUtils;

import io.reactivex.Single;

/**
 * This class fetches the info from the retrofit service and onSuccess returns the result
 * on stream - or returns an errors if that is the case
 */
public class ConfigNetworkSource {
    private final MovieDbServiceApi movieDbServiceApi;
    private final String apiKey;

    public ConfigNetworkSource(ApiHandler<MovieDbServiceApi> apiHandler, String apiKey) {
        this.movieDbServiceApi = apiHandler.getService();
        this.apiKey = apiKey;
    }

    public Single<ConfigurationResponse> get() {
        return movieDbServiceApi.getConfiguration(apiKey)
                .compose(RxUtils.unWrapResponseWithErrorOnStream());
    }
}