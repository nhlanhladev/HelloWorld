package com.geekhouze.qwikbuy;

import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.MenuItemCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.SearchView;
import android.widget.Toast;

import com.geekhouze.qwikbuy.model.User;
import com.geekhouze.qwikbuy.service.QuickbuyServiceClient;

import java.util.List;
import java.util.logging.Logger;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class MainActivity extends AppCompatActivity {

    private DrawerLayout mDrawerLayout;

    private ActionBarDrawerToggle mToggle;

    private final static Logger LOGGER = Logger.getLogger(MainActivity.class.getName());


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        /**
         * Retrofit allows us to call REST WebService
         * easily and conveniently
         * **/

        setContentView(R.layout.activity_main);

        Retrofit.Builder builder = new Retrofit.Builder()
                .baseUrl("http://160.119.100.194:8080/")
                .addConverterFactory(GsonConverterFactory.create());

        Retrofit retrofit = builder.build();

        QuickbuyServiceClient quickbuyServiceClient = retrofit.create(QuickbuyServiceClient.class);

        Call<List<User>> call = quickbuyServiceClient.getUsers();

        call.enqueue(new Callback<List<User>>() {
            @Override
            public void onResponse(Call<List<User>> call, Response<List<User>> response) {
                Log.d("myTag", response.toString());
                List<User> users = response.body();
                for (User user : users) {
                    System.out.println(user);
                }
                Toast.makeText(MainActivity.this, "Success :-)", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<List<User>> call, Throwable t) {
                Toast.makeText(MainActivity.this,"error :-(", Toast.LENGTH_SHORT).show();
                LOGGER.warning(t.getCause().toString());
            }
        });


        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer);
        mToggle = new ActionBarDrawerToggle(this, mDrawerLayout, R.string.open, R.string.close);
        mDrawerLayout.addDrawerListener(mToggle);
        NavigationView navigationViewDrawer = (NavigationView) findViewById(R.id.navigationViewDrawer);
        mToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setupDrawerContent(navigationViewDrawer);


        Fragment mFragment=null ;
        Class mFragmentClass;
        mFragmentClass = Home.class;
        try {
            mFragment = (Fragment) mFragmentClass.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.flcontent, mFragment).commit();


    }

       @Override
       public boolean onOptionsItemSelected(MenuItem item) {
           if (mToggle.onOptionsItemSelected(item)) {
               return true;
           }
           return super.onOptionsItemSelected(item);
       }


       public void selectItemDrawer(MenuItem menuItem) {
        Fragment mFragment = null;
        Class mFragmentClass;
        switch (menuItem.getItemId()) {
            case R.id.dashboard:
                mFragmentClass = Home.class;
                break;
            case R.id.wishList:
                mFragmentClass = WishList.class;
                break;
            case R.id.settings:
                mFragmentClass = Settings.class;
                break;
            case R.id.logout:
                mFragmentClass = Home.class;
                break;
            case R.id.mostSelling:
                mFragmentClass = MostSelling.class;
                break;
            case R.id.dailyDeals:
                mFragmentClass = DailyDeals.class;
                break;
            case R.id.sale:
                mFragmentClass = Sale.class;
                break;
            case R.id.help:
                mFragmentClass = Help.class;
                break;
            case R.id.Orders:
                mFragmentClass = Orders.class;
                break;
            default:
                mFragmentClass = Home.class;
                break;
        }

        try {
            mFragment = (Fragment) mFragmentClass.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }


        FragmentManager fragmentManager = getSupportFragmentManager();

        fragmentManager.beginTransaction().replace(R.id.flcontent, mFragment).commit();
        menuItem.setChecked(true);
        setTitle(menuItem.getTitle());
        mDrawerLayout.closeDrawers();

    }

    private void setupDrawerContent(NavigationView navigationView) {

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                selectItemDrawer(item);
                return true;
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);

        MenuItem item = menu.findItem(R.id.action_search);
        // searchView.MenuItem(item);

        return true;

    }


    public void onCreateOptionMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        MenuItem searchItem = menu.findItem(R.id.action_search);
        SearchView searchView = (SearchView) MenuItemCompat.getActionView(searchItem);

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });
    }


    }
