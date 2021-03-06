package com.guidovezzoni.bingeworthyshows.config.repository.source;

import com.guidovezzoni.bingeworthyshows.common.baselibrary.BaseCacheDataSource;
import com.guidovezzoni.bingeworthyshows.common.baselibrary.CacheHelper;
import com.guidovezzoni.bingeworthyshows.common.model.datalayer.ConfigurationResponse;

import java.util.concurrent.TimeUnit;

public class ConfigCacheSource extends BaseCacheDataSource<ConfigurationResponse, Void> {

    public ConfigCacheSource(CacheHelper cacheHelper) {
        super(cacheHelper);
        setCacheValiditySeconds(TimeUnit.HOURS.toSeconds(24));
    }
}
