package com.bet365.wb.frag

import android.graphics.drawable.BitmapDrawable
import android.graphics.drawable.GradientDrawable
import android.os.Build
import android.os.Bundle
import android.support.annotation.RequiresApi
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.graphics.ColorMatrixColorFilter
import android.graphics.ColorMatrix
import com.routing.ace.ace07.BitmapUtil
import com.routing.ace.ace07.R


/**
 * Created by yangc on 2018/4/13.
 */
class FragmentCK : Fragment(), View.OnClickListener {

    var tv1: TextView? = null
    var tv2: TextView? = null
    var tv3: TextView? = null
    var tv4: TextView? = null
    var tv5: TextView? = null
    var tv6: TextView? = null
    var iv1: ImageView? = null
    var iv2: ImageView? = null
    var iv3: ImageView? = null

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

    @RequiresApi(Build.VERSION_CODES.JELLY_BEAN)
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
        tv6 = view?.findViewById(R.id.drawable_tv6) as TextView
        tv6!!.setOnClickListener(this)
        iv1 = view?.findViewById(R.id.drawable_iv1) as ImageView
        iv2 = view?.findViewById(R.id.drawable_iv2) as ImageView
        iv3 = view?.findViewById(R.id.drawable_iv3) as ImageView
        initUI()

        return view
    }

    @RequiresApi(Build.VERSION_CODES.JELLY_BEAN)
    fun initUI() {
        tv1!!.text = "Kotlin 代码实现一键灰度"
        var myGrad = tv2!!.getBackground() as GradientDrawable
        myGrad.setStroke(1, resources.getColor(R.color.inactive_bottom_navigation))

        var myGrad5 = tv3!!.getBackground() as GradientDrawable
        myGrad5.setStroke(1, resources.getColor(R.color.inactive_bottom_navigation))
        myGrad5.setColor(resources.getColor(R.color.inactive_bottom_navigation))
        tv3!!.setTextColor(resources.getColor(R.color.white))
        tv3!!.background = myGrad5

        var myGrad2 = GradientDrawable()
        var farr = floatArrayOf(80.0f, 80.0f, 0.0f, 0.0f, 0.0f, 0.0f, 80.0f, 80.0f)
        myGrad2.cornerRadii = farr
        myGrad2.setStroke(1, resources.getColor(R.color.inactive_bottom_navigation))
        myGrad2.setColor(resources.getColor(R.color.inactive_bottom_navigation))
        tv6!!.background = myGrad2

        var myGrad3 = GradientDrawable()
        myGrad3.setStroke(1, resources.getColor(R.color.inactive_bottom_navigation))
        myGrad3.cornerRadius = 80.0f
        myGrad3.setColor(resources.getColor(R.color.inactive_bottom_navigation))
        tv4!!.background = BitmapUtil.addStateDrawable2(context, myGrad3, R.drawable.drawable_test1, R.drawable.drawable_test1, R.drawable.drawable_test1)

        var myGrad4 = GradientDrawable()
        myGrad4.setStroke(1, resources.getColor(R.color.inactive_bottom_navigation))
        myGrad4.cornerRadius = 80.0f
        myGrad4.setColor(resources.getColor(R.color.white))

        tv5!!.background = BitmapUtil.addStateDrawable1(context, myGrad3, myGrad4, myGrad4, myGrad4)
        tv5!!.setTextColor(BitmapUtil.createColorStateList(getResources().getColor(R.color.white), getResources().getColor(R.color.inactive_bottom_navigation),
                getResources().getColor(R.color.inactive_bottom_navigation), getResources().getColor(R.color.inactive_bottom_navigation)));

        var plabit = BitmapUtil.drawableToBitmap3(resources.getDrawable(R.mipmap.icon_zan))
        plabit = BitmapUtil.tintBitmap(plabit, resources.getColor(R.color.inactive_bottom_navigation))
        iv2!!.setImageDrawable(BitmapDrawable(plabit))

        val matrixpic = ColorMatrix()
        matrixpic.setSaturation(0f)//饱和度 0灰色 100过度彩色，50正常
        val filter = ColorMatrixColorFilter(matrixpic)
        iv1!!.setColorFilter(filter)
        iv3!!.setColorFilter(filter)
    }

}