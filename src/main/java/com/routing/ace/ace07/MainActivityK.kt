package com.routing.ace.ace07

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentTransaction
import android.support.v4.content.ContextCompat
import android.util.Log
import android.view.Window
import com.aurelhubert.ahbottomnavigation.AHBottomNavigation
import com.aurelhubert.ahbottomnavigation.AHBottomNavigationItem
import com.bet365.wb.frag.FragmentAK
import com.bet365.wb.frag.FragmentBK
import com.bet365.wb.frag.FragmentCK
import kotlinx.android.synthetic.main.common_content.*
import kotlinx.android.synthetic.main.common_title.*

class MainActivityK : AppCompatActivity() {

    var fragmentA: FragmentAK? = null
    var fragmentB: FragmentBK? = null
    var fragmentC: FragmentCK? = null
    var fragment: Fragment? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.requestWindowFeature(Window.FEATURE_NO_TITLE)
        setContentView(R.layout.activity_main_k)
        initView()
        initData()
        initListener()
    }

    fun initView() {
        val item1 = AHBottomNavigationItem("xml 布局效果", R.mipmap.icon_pailie)
        val item2 = AHBottomNavigationItem("Kotlin 代码效果", R.mipmap.icon_more)
        val item3 = AHBottomNavigationItem("一键灰度", R.mipmap.icon_seqiu)
        bottom_navigation.addItem(item1)
        bottom_navigation.addItem(item2)
        bottom_navigation.addItem(item3)
        // 默认背景颜色
        bottom_navigation.setDefaultBackgroundColor(ContextCompat.getColor(this, R.color.bg_bottom_navigation))
        // 切换时颜色的转变
        bottom_navigation.setAccentColor(ContextCompat.getColor(this, R.color.colorAccent))
        bottom_navigation.setInactiveColor(ContextCompat.getColor(this, R.color.inactive_bottom_navigation))
        // 强制着色
        bottom_navigation.setForceTint(true)
        // 强制展示标题
        bottom_navigation.setForceTitlesDisplay(true)
        // 使用圆圈效果
        bottom_navigation.setColored(false)
        bottom_navigation.setCurrentItem(0)
    }

    fun initListener() {
        bottom_navigation.setOnTabSelectedListener(AHBottomNavigation.OnTabSelectedListener { position, wasSelected ->
            clickFragmentLay(position)
            true
        })
    }

    fun initData() {
        if (fragmentA == null) {
            fragmentA = FragmentAK()
        }
        if (!fragmentA!!.isAdded()) {
            supportFragmentManager.beginTransaction().add(R.id.fl_content, fragmentA).commitAllowingStateLoss()
        } else {
            supportFragmentManager.beginTransaction().show(fragmentA).commitAllowingStateLoss()
        }
        tv_toolbar_title.text = "xml 布局效果"
        fragment = fragmentA
    }

    fun addOrShowFragment(transaction: FragmentTransaction, frag: Fragment) {
        if (fragment === frag) {
            return
        }
        if (!frag.isAdded) { // 如果当前fragment未被添加，则添加到Fragment管理器中
            transaction.hide(fragment).add(R.id.fl_content, frag).commitAllowingStateLoss()
        } else {
            transaction.hide(fragment).show(frag).commitAllowingStateLoss()
        }
        fragment = frag as Fragment
    }

    private fun clickFragmentLay(position: Int) {
        when (position) {
            0 -> {
                if (fragmentA == null) {
                    fragmentA = FragmentAK()
                }
                addOrShowFragment(supportFragmentManager.beginTransaction(), fragmentA!!)
                tv_toolbar_title.text = "xml 布局效果"
            }
            1 -> {
                if (fragmentB == null) {
                    fragmentB = FragmentBK()
                }
                addOrShowFragment(supportFragmentManager.beginTransaction(), fragmentB!!)
                tv_toolbar_title.text = "Kotlin 代码效果"
            }
            2 -> {
                if (fragmentC == null) {
                    fragmentC = FragmentCK()
                }
                addOrShowFragment(supportFragmentManager.beginTransaction(), fragmentC!!)
                tv_toolbar_title.text = "一键灰度"
            }
        }
    }

}
