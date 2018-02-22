package me.proj.allen.weibotuto.activity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.TextView;
import com.synnapps.carouselview.CarouselView;
import com.synnapps.carouselview.ImageListener;
import me.proj.allen.weibotuto.R;
import me.proj.allen.weibotuto.dummy.DummyDataGenerator;
import me.proj.allen.weibotuto.fragment.HomeCoursePanel;
import me.proj.allen.weibotuto.util.ImageProcessor;

public class HomeActivity extends AppCompatActivity
        implements
        NavigationView.OnNavigationItemSelectedListener,
        HomeCoursePanel.OnFragmentInteractionListener {

    private CarouselView carouselView;

    int[] carouselImages = {R.drawable.makeup_01, R.drawable.makeup_02, R.drawable.makeup_03, R.drawable.makeup_04,
            R.drawable.makeup_05};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        /*Configure the toolbar*/
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

        /*Configure the drawer*/
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);


        /*Configure the carousel layout*/
        carouselView = (CarouselView) findViewById(R.id.carousel);
        carouselView.setPageCount(carouselImages.length);
        carouselView.setImageListener(new ImageListener() {
            @Override
            /*TODO
                Optimize the image rendering.
            * */
            public void setImageForPosition(int position, ImageView imageView) {
                imageView.setImageResource(carouselImages[position]);
            }
        });

        /*Set the Home Panel*/
        final DummyDataGenerator dummyDataGenerator = new DummyDataGenerator();

        TextView sectionTitleOne = (TextView) findViewById(R.id.section_one_home_course_panel).findViewById(R.id.section_title_home_course_panel);
        sectionTitleOne.setText("New Year Trends");

        TextView sectionTitleTwo = (TextView) findViewById(R.id.section_one_home_course_panel).findViewById(R.id.section_title_home_course_panel);
        sectionTitleTwo.setText("Make Up");

        TextView sectionTitleThree = (TextView) findViewById(R.id.section_one_home_course_panel).findViewById(R.id.section_title_home_course_panel);
        sectionTitleThree.setText("School Trends");

        // First
        View itemViewOne = findViewById(R.id.section_one_home_course_panel).findViewById(R.id.item_one_home_course_panel);
        itemViewOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickItem();
            }
        });
        final ImageView imageViewOne = (ImageView) itemViewOne.findViewById(R.id.item_cover_home_course_panel);
        imageViewOne.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                imageViewOne.setImageResource(dummyDataGenerator.getCourses().get(0).getCover_pic_res_id());
                imageViewOne.setImageBitmap(ImageProcessor.decodeSampledBitmapFromResource(
                        getResources(),
                        dummyDataGenerator.getCourses().get(0).getCover_pic_res_id(),
                        imageViewOne.getWidth(),
                        imageViewOne.getHeight()));

                Log.d("TEST", "ImageView.width = " + imageViewOne.getWidth());
            }
        });

        TextView textViewOne = (TextView) itemViewOne.findViewById(R.id.item_title_home_course_panel);
        textViewOne.setText(dummyDataGenerator.getCourses().get(0).getTitle());


        // Second
        View itemViewTwo = findViewById(R.id.section_one_home_course_panel).findViewById(R.id.item_two_home_course_panel);
        itemViewTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickItem();
            }
        });
        final ImageView imageViewTwo = (ImageView) itemViewTwo.findViewById(R.id.item_cover_home_course_panel);
        imageViewTwo.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                imageViewTwo.setImageResource(dummyDataGenerator.getCourses().get(1).getCover_pic_res_id());
                imageViewTwo.setImageBitmap(ImageProcessor.decodeSampledBitmapFromResource(
                        getResources(),
                        dummyDataGenerator.getCourses().get(1).getCover_pic_res_id(),
                        imageViewTwo.getWidth(),
                        imageViewTwo.getHeight()));

                Log.d("TEST", "ImageView.width = " + imageViewTwo.getWidth());
            }
        });

        TextView textViewTwo = (TextView) itemViewTwo.findViewById(R.id.item_title_home_course_panel);
        textViewTwo.setText(dummyDataGenerator.getCourses().get(1).getTitle());

        // Third
        View itemViewThree = findViewById(R.id.section_one_home_course_panel).findViewById(R.id.item_three_home_course_panel);
        itemViewThree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickItem();
            }
        });
        final ImageView imageViewThree = (ImageView) itemViewThree.findViewById(R.id.item_cover_home_course_panel);
        imageViewThree.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                imageViewThree.setImageResource(dummyDataGenerator.getCourses().get(2).getCover_pic_res_id());
                imageViewThree.setImageBitmap(ImageProcessor.decodeSampledBitmapFromResource(
                        getResources(),
                        dummyDataGenerator.getCourses().get(2).getCover_pic_res_id(),
                        imageViewThree.getWidth(),
                        imageViewThree.getHeight()));

                Log.d("TEST", "ImageView.width = " + imageViewThree.getWidth());
            }
        });

        TextView textViewThree = (TextView) itemViewThree.findViewById(R.id.item_title_home_course_panel);
        textViewThree.setText(dummyDataGenerator.getCourses().get(2).getTitle());

        // Fourth
        View itemViewFourth = findViewById(R.id.section_two_home_course_panel).findViewById(R.id.item_one_home_course_panel);
        itemViewFourth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickItem();
            }
        });
        final ImageView imageViewFourth = (ImageView) itemViewFourth.findViewById(R.id.item_cover_home_course_panel);
        imageViewFourth.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                imageViewFourth.setImageResource(dummyDataGenerator.getCourses().get(3).getCover_pic_res_id());
                imageViewFourth.setImageBitmap(ImageProcessor.decodeSampledBitmapFromResource(
                        getResources(),
                        dummyDataGenerator.getCourses().get(3).getCover_pic_res_id(),
                        imageViewFourth.getWidth(),
                        imageViewFourth.getHeight()));

                Log.d("TEST", "ImageView.width = " + imageViewFourth.getWidth());
            }
        });

        TextView textViewFourth = (TextView) itemViewFourth.findViewById(R.id.item_title_home_course_panel);
        textViewFourth.setText(dummyDataGenerator.getCourses().get(3).getTitle());

        // Fifth
        View itemViewFifth = findViewById(R.id.section_three_home_course_panel).findViewById(R.id.item_one_home_course_panel);
        itemViewFifth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickItem();
            }
        });
        final ImageView imageViewFifth = (ImageView) itemViewFifth.findViewById(R.id.item_cover_home_course_panel);
        imageViewFifth.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                imageViewFifth.setImageResource(dummyDataGenerator.getCourses().get(4).getCover_pic_res_id());
                imageViewFifth.setImageBitmap(ImageProcessor.decodeSampledBitmapFromResource(
                        getResources(),
                        dummyDataGenerator.getCourses().get(4).getCover_pic_res_id(),
                        imageViewFifth.getWidth(),
                        imageViewFifth.getHeight()));

                Log.d("TEST", "ImageView.width = " + imageViewFifth.getWidth());
            }
        });

        TextView textViewFifth = (TextView) itemViewFifth.findViewById(R.id.item_title_home_course_panel);
        textViewFifth.setText(dummyDataGenerator.getCourses().get(4).getTitle());
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
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_available_courses) {

        } else if (id == R.id.nav_my_enrollments) {

        } else if (id == R.id.nav_settings) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onFragmentInteraction(Uri uri) {
        //TODO
    }

    public void onClickItem() {
        /*TEST*/
        this.startActivity(new Intent(this, ScrollingActivity.class));
    }
}
