package sas.ita.com.yusr;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.GridView;
import android.widget.TextView;

import sas.ita.com.yusr.main.ServiceFragment;
import sas.ita.com.yusr.main.ServiceListFragment;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener,
        ServiceFragment.OnFragmentInteractionListener,
        ServiceListFragment.OnFragmentInteractionListener,MainFragment.OnFragmentInteractionListener {
    ActionBarDrawerToggle toggle;
    DrawerLayout drawer;
    GridView grid;
    Dialog mydilode;
private Context context;
    String[] web={
            "Business",
            "Individual"
    };
    int[] image={
      R.drawable.business  ,
            R.drawable.individuals
    };
//    RecyclerView.LayoutManager layoutmanager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mydilode=new Dialog(this);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        toggle = new ActionBarDrawerToggle(this, drawer,toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        //getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        MainFragment service = new MainFragment();
        getSupportFragmentManager().beginTransaction()
                .setCustomAnimations(R.animator.enter, R.animator.exit, R.animator.pop_enter, R.animator.pop_exit)
                .replace(R.id.main_content, service)
                .commit();
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

    }

       @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if(toggle.onOptionsItemSelected(item))
        {
            return true;
        }
        return super.onOptionsItemSelected(item);

    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.website) {
            // Handle the camera Fragment

        } else if (id == R.id.Language) {
            // Handle the Gallery Fragment

        } else if (id == R.id.Home) {
            // Handle the SlideShow Fragment

        } else if (id == R.id.Countactus) {
            // Handle the Tools Fragment

        } else if (id == R.id.Aboutus) {

            TextView textclose;
            TextView email;
            TextView message;
            TextView call;
            mydilode.setContentView(R.layout.sharepopup);
            textclose=(TextView)mydilode.findViewById(R.id.textcolse);
            email=(TextView)mydilode.findViewById(R.id.email);
            message=(TextView)mydilode.findViewById(R.id.message);
            call=(TextView)mydilode.findViewById(R.id.call);
            textclose.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v) {
                    mydilode.dismiss();
                }

            });
            mydilode.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
            mydilode.show();

        } else if (id == R.id.Account) {
            // Handle the Send Fragment
            Services shareFragment = new Services();
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.content_frame,shareFragment)
                    .addToBackStack(null)
                    .commit();
        }
        else if (id == R.id.setting) {
            // Handle the Send Fragment

        } else if (id == R.id.Share) {


        } else if (id == R.id.Account) {
            // Handle the Send Fragment

        }
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
