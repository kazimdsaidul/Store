package com.nytimes.android.external.store.base;

import javax.annotation.Nonnull;

import rx.Observable;

/**
 * Interface for fetching data from persister
 * when implementing also think about implementing PathResolver to ease in creating primary keys
 *
 * @param <Raw> data type before parsing
 */
public interface Persister<Raw, Key> extends DiskRead<Raw, Key>, DiskWrite<Raw, Key> {

    /**
     * @param key to use to get data from persister
     *                If data is not available implementer needs to
     *                either return Observable.empty or throw an exception
     */
    @Nonnull
    Observable<Raw> read(final Key key);

    /**
     * @param key to use to store data to persister
     * @param raw     raw string to be stored
     */
    @Nonnull
    Observable<Boolean> write(final Key key, final Raw raw);
}
