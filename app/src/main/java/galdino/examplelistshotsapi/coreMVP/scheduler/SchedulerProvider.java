package galdino.examplelistshotsapi.coreMVP.scheduler;

import io.reactivex.Scheduler;

/**
 * Created by galdino on 31/10/17.
 */

public interface SchedulerProvider
{
    Scheduler io();
    Scheduler ui();
}
