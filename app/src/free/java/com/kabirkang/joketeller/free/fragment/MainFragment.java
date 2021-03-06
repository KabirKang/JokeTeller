package com.kabirkang.joketeller.free.fragment;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.kabirkang.joketeller.R;
import com.kabirkang.joketellerlibrary.DisplayJokeActivity;
import com.kabirkang.joketeller.data.GetJokeAsyncTask;

import butterknife.ButterKnife;
import butterknife.OnClick;


/**
 * A placeholder fragment containing a simple view.
 */
public class MainFragment extends Fragment {

    private static final String TAG = MainFragment.class.getName();

    @OnClick(R.id.show_joke)
    public void tellJoke(View view) {
        final AsyncTask<GetJokeAsyncTask.JokeCallback, Void, String> getJokeTask = new GetJokeAsyncTask();
        getJokeTask.execute(new GetJokeAsyncTask.JokeCallback() {
            @Override
            public void done(String result) {
                Log.d(TAG, result);
                Intent i = new Intent(getActivity(), DisplayJokeActivity.class);
                i.putExtra(DisplayJokeActivity.JOKE_EXTRA, result);
                startActivity(i);
            }
        });

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_free, container, false);
        ButterKnife.bind(this, root);
        AdView mAdView = (AdView) root.findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder()
                .addTestDevice(getString(R.string.ad_test_device))
                .build();
        mAdView.loadAd(adRequest);
        return root;
    }
}
