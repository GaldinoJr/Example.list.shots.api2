package galdino;

import galdino.examplelistshotsapi.coreMVP.scheduler.SchedulerProvider;
import galdino.examplelistshotsapi.coreMVP.scheduler.TestSchedulerProvider;
import io.reactivex.schedulers.TestScheduler;

/**
 * Created by Galdino on 23/12/2017.
 */

public class BasePresenterTest
{
    protected TestScheduler mTestScheduler = new TestScheduler();
    protected SchedulerProvider mTestSchedulerProvider = new TestSchedulerProvider(mTestScheduler);
}
