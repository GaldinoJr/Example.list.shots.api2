package galdino.examplelistshotsapi.screens.detailShot;

import android.graphics.Color;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import galdino.examplelistshotsapi.R;

public class DetailShotActivity extends AppCompatActivity implements View.OnClickListener {

    public static final String EXTRA_ID_SHOT = "EXTRA_ID_SHOT";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_shot);
        loadControls();
    }

    private void loadControls()
    {
        ImageView imageView = (ImageView) findViewById(R.id.iv_back);
        imageView.setOnClickListener(this);
        Integer idExtra = getIntent().getIntExtra(EXTRA_ID_SHOT,-1);
        DetailShotFragment detailShotFragment = DetailShotFragment.newInstance(idExtra);
        FragmentManager supportFragmentManager = getSupportFragmentManager();

        supportFragmentManager
                .beginTransaction()
                .replace(R.id.fl_container,detailShotFragment)
                .commit();
    }

    @Override
    public void onClick(View v) {
       finish();
    }
}
