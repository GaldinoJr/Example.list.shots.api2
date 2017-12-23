package galdino.examplelistshotsapi.coreMVP.scheduler;

import io.reactivex.Scheduler;
import io.reactivex.schedulers.TestScheduler;

/**
 * Created by Galdino on 23/12/2017.
 */

public class TestSchedulerProvider  implements SchedulerProvider {
    private final TestScheduler mTestScheduler;

    public TestSchedulerProvider(TestScheduler testScheduler) {
        mTestScheduler = testScheduler;
    }

    @Override
    public Scheduler io() {
        return mTestScheduler;
    }

    @Override
    public Scheduler ui() {
        return mTestScheduler;
    }
}