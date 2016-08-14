package alion88music.com.nfanlivestreaming.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.zip.Inflater;

import alion88music.com.nfanlivestreaming.R;

/**
 * Created by Eliza on 14/08/2016.
 */
public class TopFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_top, container, false);
        return rootView;
    }
}
