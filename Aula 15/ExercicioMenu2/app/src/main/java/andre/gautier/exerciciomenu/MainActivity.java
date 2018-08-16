package andre.gautier.exerciciomenu;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.DrawableRes;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.mikepenz.google_material_typeface_library.GoogleMaterial;
import com.mikepenz.materialdrawer.AccountHeader;
import com.mikepenz.materialdrawer.AccountHeaderBuilder;
import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.DrawerBuilder;
import com.mikepenz.materialdrawer.model.DividerDrawerItem;
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem;
import com.mikepenz.materialdrawer.model.ProfileDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IProfile;

public class MainActivity extends AppCompatActivity {

    private static final int MENU_TELA3 = 300;
    private static final int MENU_TELA4 = 400;

    private Intent it;
    private Drawer result = null;
    private Toolbar toolbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();

            }
        });

        AccountHeader headerResult = new AccountHeaderBuilder()
                .withActivity(this)
                .withHeaderBackground(R.drawable.fundo)
                .addProfiles(
                        new ProfileDrawerItem().withName("André Alves").withEmail("andrealves591.aa@gmail.com").withIcon(getResources().getDrawable(R.drawable.ic_action_account_box))
                )
                .withOnAccountHeaderListener(new AccountHeader.OnAccountHeaderListener() {
                    @Override
                    public boolean onProfileChanged(View view, IProfile profile, boolean currentProfile) {
                        return false;
                    }
                })
                .build();

        result = new DrawerBuilder()
                .withActivity(this)
                .withTranslucentStatusBar(false)
                .withToolbar(toolbar)
                .withAccountHeader(headerResult)
                .withSavedInstance(savedInstanceState)
                .addDrawerItems(
                        new PrimaryDrawerItem().withName("Tela5").withIdentifier(0).withIcon(getResources().getDrawable(R.drawable.ic_action_color_lens_orange)),
                        new PrimaryDrawerItem().withName("Tela6").withIdentifier(1).withIcon(getResources().getDrawable(R.drawable.ic_action_color_lens_pink)),
                        new DividerDrawerItem(),
                        new PrimaryDrawerItem().withName("Tela7").withIdentifier(2).withIcon(getResources().getDrawable(R.drawable.ic_action_color_lens_black)),
                        new PrimaryDrawerItem().withName("Tela8").withIdentifier(3).withIcon(getResources().getDrawable(R.drawable.ic_action_color_lens_purple))

                )
                .withOnDrawerItemClickListener(new Drawer.OnDrawerItemClickListener() {
                    @Override
                    public boolean onItemClick(View view, int position, IDrawerItem drawerItem) {

                        switch ((int) drawerItem.getIdentifier()) {
                            case 0:
                                it = new Intent(MainActivity.this, Tela5.class);
                                startActivity(it);
                                break;

                            case 1:
                                it = new Intent(MainActivity.this, Tela6.class);
                                startActivity(it);
                                break;
                            case 2:
                                it = new Intent(MainActivity.this, Tela7.class);
                                startActivity(it);
                                break;

                            case 3:
                                it = new Intent(MainActivity.this, Tela8.class);
                                startActivity(it);
                                break;
                        }
                        return false;
                    }
                }).build();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu_main, menu);
        menu.add(MENU_TELA3, MENU_TELA3, MENU_TELA3, "Tela 3")
                .setTitleCondensed("T3")
                .setIcon(R.drawable.ic_action_color_lens_green)
                .setShowAsAction(MenuItem.SHOW_AS_ACTION_ALWAYS);

        menu.add(MENU_TELA4, MENU_TELA4, MENU_TELA4, "Tela 4")
                .setTitleCondensed("T4")
                .setIcon(R.drawable.ic_action_color_lens_yellow)
                .setShowAsAction(MenuItem.SHOW_AS_ACTION_ALWAYS);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.menu_tela1:
                it = new Intent(MainActivity.this, Tela1.class);
                startActivity(it);
                break;

            case R.id.menu_tela2:
                it = new Intent(MainActivity.this, Tela2.class);
                startActivity(it);
                break;

            case MENU_TELA3:
                it = new Intent(MainActivity.this, Tela3.class);
                startActivity(it);
                ;
                break;

            case MENU_TELA4:
                it = new Intent(MainActivity.this, Tela4.class);
                startActivity(it);
                break;
        }


        return super.onOptionsItemSelected(item);
    }

    private void toast(String msg) {
        Toast.makeText(getBaseContext(), msg, Toast.LENGTH_SHORT).show();
    }

}