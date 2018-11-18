package com.guidovezzoni.bingeworthyshows.tvshow.repository;

import com.guidovezzoni.bingeworthyshows.common.model.datalayer.PopularResult;
import com.guidovezzoni.bingeworthyshows.tvshow.repository.source.TvShowsNetworkSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import io.reactivex.Single;
import io.reactivex.observers.TestObserver;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class TvShowRepositoryTest {

    @Mock
    private TvShowsNetworkSource tvShowsNetworkSource;
    @InjectMocks
    private TvShowRepository sut;


    @Test
    public void whenGetThenSourceInvoked() {
        PopularResult popularResult = new PopularResult();

        TestObserver<PopularResult> testObserver = TestObserver.create();
        when(tvShowsNetworkSource.get(2)).thenReturn(Single.just(popularResult));

        sut.get(2)
                .subscribe(testObserver);

        testObserver.assertComplete()
                .assertNoErrors();
        verify(tvShowsNetworkSource).get(2);
    }

}