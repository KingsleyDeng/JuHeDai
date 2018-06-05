package com.kingsley.juhedai;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TabHost;
import android.widget.TextView;

import com.kingsley.juhedai.bean.Tab;
import com.kingsley.juhedai.fragments.CashFragment;
import com.kingsley.juhedai.fragments.ConsumerFragment;
import com.kingsley.juhedai.fragments.CreditFragment;
import com.kingsley.juhedai.widget.FragmentTabHost;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private LayoutInflater mInflater;

    private FragmentTabHost mTabhost;

    private List<Tab> mTabs = new ArrayList<>(3);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initTab();

    }

    private void initTab() {

        Tab tab_cash = new Tab(CashFragment.class, R.string.cashFragment, R.drawable.selector_icon_cash);
        Tab tab_consumer = new Tab(ConsumerFragment.class, R.string.consumerFragment, R.drawable.selector_icon_consumer);
        Tab tab_credit = new Tab(CreditFragment.class, R.string.creditFragment, R.drawable.selector_icon_credit);

        mTabs.add(tab_cash);
        mTabs.add(tab_consumer);
        mTabs.add(tab_credit);

        mInflater = LayoutInflater.from(this);

        mTabhost = this.findViewById(android.R.id.tabhost);

        mTabhost.setup(this, getSupportFragmentManager(), R.id.realtabcontent);

        for (Tab tab : mTabs) {
            TabHost.TabSpec tabSpec = mTabhost.newTabSpec(getString(tab.getTitle()));

            tabSpec.setIndicator(buildIndicator(tab));

            mTabhost.addTab(tabSpec, tab.getFragment(), null);
        }

        mTabhost.getTabWidget().setShowDividers(LinearLayout.SHOW_DIVIDER_NONE);
        mTabhost.setCurrentTab(0);

    }

    private View buildIndicator(Tab tab) {

        View view = mInflater.inflate(R.layout.tab_indicator, null);
        ImageView img = (ImageView) view.findViewById(R.id.icon_tab);
        TextView text = (TextView) view.findViewById(R.id.txt_indicator);

        img.setBackgroundResource(tab.getIcon());
        text.setText(tab.getTitle());

        return view;
    }
}
























