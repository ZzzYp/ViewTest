package com.mine.test.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.mine.test.R

/**
 * A simple [Fragment] subclass.
 */
class PiePicViewFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {


        return inflater.inflate(R.layout.piepic_view_fragment, container, false)
    }


}// Required empty public constructor