package galdino.examplelistshotsapi.coreMVP;

/**
 * Created by galdino on 31/10/17.
 */

public interface MvpPresenter <V extends MvpView>{
    void attach(V view);
    void detachView();
}
