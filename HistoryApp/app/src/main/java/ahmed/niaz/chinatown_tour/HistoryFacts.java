package ahmed.niaz.chinatown_tour;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class HistoryFacts extends AppCompatActivity {

    private ViewPager mSlideViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history_facts);

        mSlideViewPager = (ViewPager) findViewById(R.id.slideViewPager);

    }
}
