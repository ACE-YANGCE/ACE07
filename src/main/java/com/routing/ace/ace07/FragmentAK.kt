package com.bet365.wb.frag

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.routing.ace.ace07.R

/**
 * Created by yangc on 2018/4/13.
 */
class FragmentAK : Fragment(), View.OnClickListener {

    var tv1: TextView?=null
    var tv2: TextView?=null
    var tv3: TextView?=null
    var tv4: TextView?=null
    var tv5: TextView?=null

    override fun onClick(v: View?) {
        when (v!!.id) {
            R.id.drawable_tv1 -> {
            }
            R.id.drawable_tv2 -> {
            }
            R.id.drawable_tv3 -> {
            }
            R.id.drawable_tv4 -> {
            }
        }
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater!!.inflate(R.layout.fragment_drawable, container, false)
        tv1 = view?.findViewById(R.id.drawable_tv1) as TextView
        tv1!!.setOnClickListener(this)
        tv2 = view?.findViewById(R.id.drawable_tv2) as TextView
        tv2!!.setOnClickListener(this)
        tv3 = view?.findViewById(R.id.drawable_tv3) as TextView
        tv3!!.setOnClickListener(this)
        tv4 = view?.findViewById(R.id.drawable_tv4) as TextView
        tv4!!.setOnClickListener(this)
        tv5 = view?.findViewById(R.id.drawable_tv5) as TextView
        tv5!!.setOnClickListener(this)
        return view
    }

}