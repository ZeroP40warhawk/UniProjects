package com.example.rory.swipy_dex;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

public class AllPokemon extends AppCompatActivity {


    private SectionsPagerAdapter mSectionsPagerAdapter;
    /**
     * The {@link ViewPager} that will host the section contents.
     */
    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_pokemon);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */
        public static final String ARG_SECTION_NUMBER = "section_number";

        public PlaceholderFragment() {
        }

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        public static PlaceholderFragment newInstance(int sectionNumber) {
            PlaceholderFragment fragment = new PlaceholderFragment();
            Bundle args = new Bundle();
            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
            fragment.setArguments(args);
            return fragment;
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView;
            rootView = inflater.inflate(R.layout.content_bulbasaur, container, false);
            switch(getArguments().getInt(ARG_SECTION_NUMBER)) {
                case 1:
                    rootView = inflater.inflate(R.layout.content_bulbasaur, container, false);
                    break;
                case 2:
                    rootView = inflater.inflate(R.layout.content_ivy, container, false);
                    break;
                case 3:
                    rootView = inflater.inflate(R.layout.content_venusaur, container, false);
                    break;
                case 4:
                    rootView = inflater.inflate(R.layout.p4, container, false);
                    break;
                case 5:
                    rootView = inflater.inflate(R.layout.p5, container, false);
                    break;
                case 6:
                    rootView = inflater.inflate(R.layout.p6, container, false);
                    break;
                case 7:
                    rootView = inflater.inflate(R.layout.p7, container, false);
                    break;
                case 8:
                    rootView = inflater.inflate(R.layout.p8, container, false);
                    break;
                case 9:
                    rootView = inflater.inflate(R.layout.p9, container, false);
                    break;
                case 10:
                    rootView = inflater.inflate(R.layout.p10, container, false);
                    break;
                case 11:
                    rootView = inflater.inflate(R.layout.p11, container, false);
                    break;
                case 12:
                    rootView = inflater.inflate(R.layout.p12, container, false);
                    break;
                case 13:
                    rootView = inflater.inflate(R.layout.p13, container, false);
                    break;
                case 14:
                    rootView = inflater.inflate(R.layout.p14, container, false);
                    break;
                case 15:
                    rootView = inflater.inflate(R.layout.p15, container, false);
                    break;
                case 16:
                    rootView = inflater.inflate(R.layout.p16, container, false);
                    break;
                case 17:
                    rootView = inflater.inflate(R.layout.p17, container, false);
                    break;
                case 18:
                    rootView = inflater.inflate(R.layout.p18, container, false);
                    break;
                case 19:
                    rootView = inflater.inflate(R.layout.p19, container, false);
                    break;
                case 20:
                    rootView = inflater.inflate(R.layout.p20, container, false);
                    break;
                case 21:
                    rootView = inflater.inflate(R.layout.p21, container, false);
                    break;
                case 22:
                    rootView = inflater.inflate(R.layout.p22, container, false);
                    break;
                case 23:
                    rootView = inflater.inflate(R.layout.p23, container, false);
                    break;
                case 24:
                    rootView = inflater.inflate(R.layout.p24, container, false);
                    break;
                case 25:
                    rootView = inflater.inflate(R.layout.p25, container, false);
                    break;
                case 26:
                    rootView = inflater.inflate(R.layout.p26, container, false);
                    break;
                case 27:
                    rootView = inflater.inflate(R.layout.p27, container, false);
                    break;
                case 28:
                    rootView = inflater.inflate(R.layout.p28, container, false);
                    break;
                case 29:
                    rootView = inflater.inflate(R.layout.p29, container, false);
                    break;
                case 30:
                    rootView = inflater.inflate(R.layout.p30, container, false);
                    break;
                case 31:
                    rootView = inflater.inflate(R.layout.p31, container, false);
                    break;
                case 32:
                    rootView = inflater.inflate(R.layout.p32, container, false);
                    break;
                case 33:
                    rootView = inflater.inflate(R.layout.p33, container, false);
                    break;
                case 34:
                    rootView = inflater.inflate(R.layout.p34, container, false);
                    break;
                case 35:
                    rootView = inflater.inflate(R.layout.p35, container, false);
                    break;
                case 36:
                    rootView = inflater.inflate(R.layout.p36, container, false);
                    break;
                case 37:
                    rootView = inflater.inflate(R.layout.p37, container, false);
                    break;
                case 38:
                    rootView = inflater.inflate(R.layout.p38, container, false);
                    break;
                case 39:
                    rootView = inflater.inflate(R.layout.p39, container, false);
                    break;
                case 40:
                    rootView = inflater.inflate(R.layout.p40, container, false);
                    break;
                case 41:
                    rootView = inflater.inflate(R.layout.p41, container, false);
                    break;
                case 42:
                    rootView = inflater.inflate(R.layout.p42, container, false);
                    break;
                case 43:
                    rootView = inflater.inflate(R.layout.p43, container, false);
                    break;
                case 44:
                    rootView = inflater.inflate(R.layout.p44, container, false);
                    break;
                case 45:
                    rootView = inflater.inflate(R.layout.p45, container, false);
                    break;
                case 46:
                    rootView = inflater.inflate(R.layout.p46, container, false);
                    break;
                case 47:
                    rootView = inflater.inflate(R.layout.p47, container, false);
                    break;
                case 48:
                    rootView = inflater.inflate(R.layout.p48, container, false);
                    break;
                case 49:
                    rootView = inflater.inflate(R.layout.p49, container, false);
                    break;
                case 50:
                    rootView = inflater.inflate(R.layout.p50, container, false);
                    break;
                case 51:
                    rootView = inflater.inflate(R.layout.p51, container, false);
                    break;
                case 52:
                    rootView = inflater.inflate(R.layout.p52, container, false);
                    break;
                case 53:
                    rootView = inflater.inflate(R.layout.p53, container, false);
                    break;
                case 54:
                    rootView = inflater.inflate(R.layout.p54, container, false);
                    break;
                case 55:
                    rootView = inflater.inflate(R.layout.p55, container, false);
                    break;
                case 56:
                    rootView = inflater.inflate(R.layout.p56, container, false);
                    break;
                case 57:
                    rootView = inflater.inflate(R.layout.p57, container, false);
                    break;
                case 58:
                    rootView = inflater.inflate(R.layout.p58, container, false);
                    break;
                case 59:
                    rootView = inflater.inflate(R.layout.p59, container, false);
                    break;
                case 60:
                    rootView = inflater.inflate(R.layout.p60, container, false);
                    break;
                case 61:
                    rootView = inflater.inflate(R.layout.p61, container, false);
                    break;
                case 62:
                    rootView = inflater.inflate(R.layout.p62, container, false);
                    break;
                case 63:
                    rootView = inflater.inflate(R.layout.p63, container, false);
                    break;
                case 64:
                    rootView = inflater.inflate(R.layout.p64, container, false);
                    break;
                case 65:
                    rootView = inflater.inflate(R.layout.p65, container, false);
                    break;
                case 66:
                    rootView = inflater.inflate(R.layout.p66, container, false);
                    break;
                case 67:
                    rootView = inflater.inflate(R.layout.p67, container, false);
                    break;
                case 68:
                    rootView = inflater.inflate(R.layout.p68, container, false);
                    break;
                case 69:
                    rootView = inflater.inflate(R.layout.p69, container, false);
                    break;
                case 70:
                    rootView = inflater.inflate(R.layout.p70, container, false);
                    break;
                case 71:
                    rootView = inflater.inflate(R.layout.p71, container, false);
                    break;
                case 72:
                    rootView = inflater.inflate(R.layout.p72, container, false);
                    break;
                case 73:
                    rootView = inflater.inflate(R.layout.p73, container, false);
                    break;
                case 74:
                    rootView = inflater.inflate(R.layout.p74, container, false);
                    break;
                case 75:
                    rootView = inflater.inflate(R.layout.p75, container, false);
                    break;
                case 76:
                    rootView = inflater.inflate(R.layout.p76, container, false);
                    break;
                case 77:
                    rootView = inflater.inflate(R.layout.p77, container, false);
                    break;
                case 78:
                    rootView = inflater.inflate(R.layout.p78, container, false);
                    break;
                case 79:
                    rootView = inflater.inflate(R.layout.p79, container, false);
                    break;
                case 80:
                    rootView = inflater.inflate(R.layout.p80, container, false);
                    break;
                case 81:
                    rootView = inflater.inflate(R.layout.p81, container, false);
                    break;
                case 82:
                    rootView = inflater.inflate(R.layout.p82, container, false);
                    break;
                case 83:
                    rootView = inflater.inflate(R.layout.p83, container, false);
                    break;
                case 84:
                    rootView = inflater.inflate(R.layout.p84, container, false);
                    break;
                case 85:
                    rootView = inflater.inflate(R.layout.p85, container, false);
                    break;
                case 86:
                    rootView = inflater.inflate(R.layout.p86, container, false);
                    break;
                case 87:
                    rootView = inflater.inflate(R.layout.p87, container, false);
                    break;
                case 88:
                    rootView = inflater.inflate(R.layout.p88, container, false);
                    break;
                case 89:
                    rootView = inflater.inflate(R.layout.p89, container, false);
                    break;
                case 90:
                    rootView = inflater.inflate(R.layout.p90, container, false);
                    break;
                case 91:
                    rootView = inflater.inflate(R.layout.p91, container, false);
                    break;
                case 92:
                    rootView = inflater.inflate(R.layout.p92, container, false);
                    break;
                case 93:
                    rootView = inflater.inflate(R.layout.p93, container, false);
                    break;
                case 94:
                    rootView = inflater.inflate(R.layout.p94, container, false);
                    break;
                case 95:
                    rootView = inflater.inflate(R.layout.p95, container, false);
                    break;
                case 96:
                    rootView = inflater.inflate(R.layout.p96, container, false);
                    break;
                case 97:
                    rootView = inflater.inflate(R.layout.p97, container, false);
                    break;
                case 98:
                    rootView = inflater.inflate(R.layout.p98, container, false);
                    break;
                case 99:
                    rootView = inflater.inflate(R.layout.p99, container, false);
                    break;
                case 100:
                    rootView = inflater.inflate(R.layout.p100, container, false);
                    break;
                case 101:
                    rootView = inflater.inflate(R.layout.p101, container, false);
                    break;
                case 102:
                    rootView = inflater.inflate(R.layout.p102, container, false);
                    break;
                case 103:
                    rootView = inflater.inflate(R.layout.p103, container, false);
                    break;
                case 104:
                    rootView = inflater.inflate(R.layout.p104, container, false);
                    break;
                case 105:
                    rootView = inflater.inflate(R.layout.p105, container, false);
                    break;
                case 106:
                    rootView = inflater.inflate(R.layout.p106, container, false);
                    break;
                case 107:
                    rootView = inflater.inflate(R.layout.p107, container, false);
                    break;
                case 108:
                    rootView = inflater.inflate(R.layout.p108, container, false);
                    break;
                case 109:
                    rootView = inflater.inflate(R.layout.p109, container, false);
                    break;
                case 110:
                    rootView = inflater.inflate(R.layout.p110, container, false);
                    break;
                case 111:
                    rootView = inflater.inflate(R.layout.p111, container, false);
                    break;
                case 112:
                    rootView = inflater.inflate(R.layout.p112, container, false);
                    break;
                case 113:
                    rootView = inflater.inflate(R.layout.p113, container, false);
                    break;
                case 114:
                    rootView = inflater.inflate(R.layout.p114, container, false);
                    break;
                case 115:
                    rootView = inflater.inflate(R.layout.p115, container, false);
                    break;
                case 116:
                    rootView = inflater.inflate(R.layout.p116, container, false);
                    break;
                case 117:
                    rootView = inflater.inflate(R.layout.p117, container, false);
                    break;
                case 118:
                    rootView = inflater.inflate(R.layout.p118, container, false);
                    break;
                case 119:
                    rootView = inflater.inflate(R.layout.p119, container, false);
                    break;
                case 120:
                    rootView = inflater.inflate(R.layout.p120, container, false);
                    break;
                case 121:
                    rootView = inflater.inflate(R.layout.p121, container, false);
                    break;
                case 122:
                    rootView = inflater.inflate(R.layout.p122, container, false);
                    break;
                case 123:
                    rootView = inflater.inflate(R.layout.p123, container, false);
                    break;
                case 124:
                    rootView = inflater.inflate(R.layout.p124, container, false);
                    break;
                case 125:
                    rootView = inflater.inflate(R.layout.p125, container, false);
                    break;
                case 126:
                    rootView = inflater.inflate(R.layout.p126, container, false);
                    break;
                case 127:
                    rootView = inflater.inflate(R.layout.p127, container, false);
                    break;
                case 128:
                    rootView = inflater.inflate(R.layout.p128, container, false);
                    break;
                case 129:
                    rootView = inflater.inflate(R.layout.p129, container, false);
                    break;
                case 130:
                    rootView = inflater.inflate(R.layout.p130, container, false);
                    break;
                case 131:
                    rootView = inflater.inflate(R.layout.p131, container, false);
                    break;
                case 132:
                    rootView = inflater.inflate(R.layout.p132, container, false);
                    break;
                case 133:
                    rootView = inflater.inflate(R.layout.p133, container, false);
                    break;
                case 134:
                    rootView = inflater.inflate(R.layout.p134, container, false);
                    break;
                case 135:
                    rootView = inflater.inflate(R.layout.p135, container, false);
                    break;
                case 136:
                    rootView = inflater.inflate(R.layout.p136, container, false);
                    break;
                case 137:
                    rootView = inflater.inflate(R.layout.p137, container, false);
                    break;
                case 138:
                    rootView = inflater.inflate(R.layout.p138, container, false);
                    break;
                case 139:
                    rootView = inflater.inflate(R.layout.p139, container, false);
                    break;
                case 140:
                    rootView = inflater.inflate(R.layout.p140, container, false);
                    break;
                case 141:
                    rootView = inflater.inflate(R.layout.p141, container, false);
                    break;
                case 142:
                    rootView = inflater.inflate(R.layout.p142, container, false);
                    break;
                case 143:
                    rootView = inflater.inflate(R.layout.p143, container, false);
                    break;
                case 144:
                    rootView = inflater.inflate(R.layout.p144, container, false);
                    break;
                case 145:
                    rootView = inflater.inflate(R.layout.p145, container, false);
                    break;
                case 146:
                    rootView = inflater.inflate(R.layout.p146, container, false);
                    break;
                case 147:
                    rootView = inflater.inflate(R.layout.p147, container, false);
                    break;
                case 148:
                    rootView = inflater.inflate(R.layout.p148, container, false);
                    break;
                case 149:
                    rootView = inflater.inflate(R.layout.p149, container, false);
                    break;
                case 150:
                    rootView = inflater.inflate(R.layout.p150, container, false);
                    break;
                case 151:
                    rootView = inflater.inflate(R.layout.p151, container, false);
                    break;
            }
            return rootView;
        }
    }

    /**
     * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     */
    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            // getItem is called to instantiate the fragment for the given page.
            // Return a PlaceholderFragment (defined as a static inner class below).
            return PlaceholderFragment.newInstance(position + 1);
        }

        @Override
        public int getCount() {
            // Show 3 total pages.
            return 151;
        }


    }

}
