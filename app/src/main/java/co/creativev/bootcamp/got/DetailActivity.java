package co.creativev.bootcamp.got;

import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class DetailActivity extends AppCompatActivity {

    public static final String EXTRA_CHARACTER = "character";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setHomeButtonEnabled(true);
        }
        GoTCharacter gotCharacter = getIntent().getParcelableExtra(EXTRA_CHARACTER);
        setTitle(gotCharacter.name);
        Picasso.with(this)
                .load(Uri.parse(gotCharacter.fullUrl))
                .placeholder(R.drawable.profile_placeholder_full)
                .error(R.drawable.profile_placeholder_error_full)
                .into((ImageView) findViewById(R.id.image_character));
        ((ImageView) findViewById(R.id.image_house)).setImageResource(gotCharacter.houseResId);
        ((TextView) findViewById(R.id.text_house_name)).setText(gotCharacter.house);
        ((TextView) findViewById(R.id.text_character_story)).setText(gotCharacter.description);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            onBackPressed();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
