package com.kobatsu.fragmentstests;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;


public class MainActivity extends ActionBarActivity {

    private boolean isA;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (savedInstanceState == null) {
            isA = true;
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, new PlaceholderFragment())
                    .commit();
        }
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
        switch (id) {
            case R.id.action_fragment:
                changeFragment();
                return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void changeFragment() {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container, isA ? new PlaceholderFragment() : new PlaceholderFragmentB())
                .commit();
        isA = !isA;
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {

        private String TAG = "Fragment A";

        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_main, container, false);
            return rootView;
        }

        @Override
        public void onPause() {
            Log.d(TAG, "A onPause()");
            super.onPause();
        }

        @Override
        public void onDestroyView() {
            Log.d(TAG, "A onDestroyView()");
            super.onDestroyView();
        }

        @Override
        public void onDestroy() {
            Log.d(TAG, "A onDestroy()");
            super.onDestroy();
        }

        @Override
        public void onDetach() {
            Log.d(TAG, "A onDetach()");
            super.onDetach();
            //System.gc();
        }
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragmentB extends Fragment {

        public PlaceholderFragmentB() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragmen_b, container, false);
            return rootView;
        }
    }
}
