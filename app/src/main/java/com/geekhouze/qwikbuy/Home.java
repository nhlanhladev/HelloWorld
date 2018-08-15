package com.geekhouze.qwikbuy;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;


import com.geekhouze.qwikbuy.cardview.Album;
import com.synnapps.carouselview.CarouselView;
import com.synnapps.carouselview.ImageListener;

import java.util.ArrayList;
import java.util.List;

import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link Home.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link Home#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Home extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private RecyclerView mRecyclerView;
    private RecyclerView mRecyclerView2;
    private RecyclerView.LayoutManager mLayoutManager;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.Adapter mAdapter2;
    private RecyclerView.Adapter mAdapter3;
    private ArrayList<String> mDataset;
    private CarouselView carouselView;
    private Button mMore1;
    private Button mMore2;
    View rootView;

    private CardView deal;


    private RecyclerView mRecyclerView1;
    private boolean mHorizontal;


    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public Home() {
        // Required empty public constructor
    }


    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Home.
     */
    // TODO: Rename and change types and number of parameters
    public static Home newInstance(String param1, String param2) {
        Home fragment = new Home();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }




    Integer[] images = {R.drawable.slide1, R.drawable.slide2, R.drawable.slide3};


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootView = inflater.inflate(R.layout.fragment_home, container, false);

        mDataset = new ArrayList<>();
        for (int i = 0; i < 30; i++) {
            mDataset.add("New Title # " + i);
        }

        mMore1 = rootView.findViewById(R.id.more1);
        mMore2 = rootView.findViewById(R.id.more2);

        mMore1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(),MoreItems.class);
                v.getContext().startActivity(intent);
            }
        });

        mMore2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(),MoreItems.class);
                v.getContext().startActivity(intent);
            }
        });

        mRecyclerView2 = (RecyclerView) rootView.findViewById(R.id.recycler_view2);
        mRecyclerView2.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(rootView.getContext(), LinearLayoutManager.HORIZONTAL, false);
        mRecyclerView2.setLayoutManager(mLayoutManager);
        mAdapter2 = new MainAdapter(mDataset);
        mRecyclerView2.setAdapter(mAdapter2);


        mRecyclerView1 = (RecyclerView) rootView.findViewById(R.id.recyclerView1);
        mRecyclerView1.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(rootView.getContext(), LinearLayoutManager.HORIZONTAL, false);
        mRecyclerView1.setLayoutManager(mLayoutManager);
        mAdapter3 = new DailyAdapter(getAlbums());
        mRecyclerView1.setAdapter(mAdapter3);

        mRecyclerView = (RecyclerView) rootView.findViewById(R.id.recycler_view);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(rootView.getContext(), LinearLayoutManager.HORIZONTAL, false);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mAdapter = new MainAdapter(mDataset);
        mRecyclerView.setAdapter(mAdapter);







//   carouselView =(CarouselView) rootView.findViewById(R.id.carouselView);
//        carouselView.setPageCount(images.length);
//
//        carouselView.setImageListener(imageListener);

        return rootView;
}






    private List<Album> getAlbums() {
        List<Album> Albums = new ArrayList<>();
        Albums.add(new Album("12 Apr", 560, 600) );
        Albums.add(new Album("02 Oct", 450, 670) );
        Albums.add(new Album("22 May", 670, 700) );
        Albums.add(new Album("09 Mar", 450, 990) );
        Albums.add(new Album("17 Jan", 360, 490) );
        Albums.add(new Album("11 Feb", 770, 800) );
        Albums.add(new Album("04 Dec", 570, 960) );
        return Albums;
    }



    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }

    ImageListener imageListener = new ImageListener() {
        @Override
        public void setImageForPosition(int position, ImageView imageView) {
            imageView.setImageResource(images[position]);
        }
    };

}

