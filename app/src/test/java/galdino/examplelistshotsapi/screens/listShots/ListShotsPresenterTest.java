package galdino.examplelistshotsapi.screens.listShots;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;

import galdino.BasePresenterTest;
import galdino.examplelistshotsapi.model.Shot;
import io.reactivex.Completable;
import io.reactivex.Single;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by Galdino on 23/12/2017.
 */

public class ListShotsPresenterTest extends BasePresenterTest
{
    ListShotsMvpPresenter mPresenter;

    @Mock
    ListShotsMvpDataManager mDataManager;
    @Mock
    ListShotsMvpView mView;
    @Mock
    private List<Shot> mShots;

    @Before
    public void setUp()
    {
        MockitoAnnotations.initMocks(this);
        mPresenter = new ListShotsPresenter(mTestSchedulerProvider, mDataManager);
        mPresenter.attach(mView);
        when(mDataManager.loadShots()).thenReturn(Single.just(mShots));
    }

    @Test
    public void whenLoadShots_callDataManagerLoadShots_success()
    {
        mPresenter.loadShots();
        verify(mDataManager).loadShots();
    }

    @Test
    public void whenLoadShots_callDataManagerLoadShotsSuccess_success()
    {
        mPresenter.loadShots();
        mTestScheduler.triggerActions();

        verify(mView).showShots(mShots);
    }

    @Test
    public void whenLoadShots_callDataManagerLoadShotsError_success()
    {
        Exception exception = new Exception();
        when(mDataManager.loadShots()).thenReturn(Single.<List<Shot>>error(exception));
        mPresenter.loadShots();
        mTestScheduler.triggerActions();

        verify(mView).onErrorGettingShots();
    }
}
