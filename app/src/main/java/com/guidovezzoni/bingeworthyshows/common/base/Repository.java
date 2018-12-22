package com.guidovezzoni.bingeworthyshows.common.base;

import io.reactivex.Single;

public interface Repository<M, P> {
    Single<M> get(P params);

    Single<M> getLatest(P params);
}
