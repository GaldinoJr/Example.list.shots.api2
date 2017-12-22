package galdino.examplelistshotsapi.screens.detailShot;

import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

import galdino.examplelistshotsapi.R;

public class DetailShotActivity extends AppCompatActivity {

    public static final String EXTRA_ID_SHOT = "EXTRA_ID_SHOT";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_shot);
        loadControls();
    }

    private void loadControls()
    {
        if(getSupportActionBar() != null) {
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }

        String idExtra = getIntent().getStringExtra(EXTRA_ID_SHOT);
        DetailShotFragment detailShotFragment = DetailShotFragment.newInstance(idExtra);
        FragmentManager supportFragmentManager = getSupportFragmentManager();

        supportFragmentManager
                .beginTransaction()
                .replace(R.id.fl_container,detailShotFragment)
                .commit();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        if(item.getItemId() == android.R.id.home)
        {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
}
