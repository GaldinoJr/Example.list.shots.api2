package galdino.examplelistshotsapi.coreMVP;

import galdino.examplelistshotsapi.coreMVP.scheduler.SchedulerProvider;

/**
 * Created by galdino on 05/11/17.
 */

public abstract class BasePresenter <T extends MvpView> implements MvpPresenter<T>
{
    private SchedulerProvider mSchedulerProvider;

    public BasePresenter(SchedulerProvider schedulerProvider)
    {
        mSchedulerProvider = schedulerProvider;
    }

    public SchedulerProvider getSchedulerProvider()
    {
        return mSchedulerProvider;
    }
}
