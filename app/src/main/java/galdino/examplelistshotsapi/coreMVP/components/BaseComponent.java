package galdino.examplelistshotsapi.coreMVP.components;

import galdino.examplelistshotsapi.screens.detailShot.DetailShotFragment;
import galdino.examplelistshotsapi.screens.listShots.ListShotsFragment;

/**
 * Created by galdino on 05/11/17.
 */

public interface BaseComponent {
    void inject(ListShotsFragment telaCadastroPassos);
    void inject(DetailShotFragment cadastroPasso2Fragment);
}
