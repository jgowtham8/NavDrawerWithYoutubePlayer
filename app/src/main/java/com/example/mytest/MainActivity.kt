package com.example.mytest

import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.core.view.iterator
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import com.example.mytest.fragments.MusicFragment
import com.example.mytest.fragments.VideoFragment
import com.example.mytest.fragments.VideoListFragment
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.toolbar.*


class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    private lateinit var drawer: DrawerLayout
    private lateinit var navigationView: NavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initNavDrawer()
        initNavItemSelectedListener()
        initUI()

    }

    private fun initUI() {
        changeFragment(VideoListFragment.newInstance("",""))
        navigationView.menu.getItem(2).isChecked = true

        initHeaderUI()
    }

    private fun initHeaderUI() {
        headerHeading?.text = "Movie Hut"
        btnDrawer?.setOnClickListener {
            if (drawer.isDrawerOpen(GravityCompat.START)){
                drawer.closeDrawer(GravityCompat.START)
            }
            else{
                drawer.openDrawer(GravityCompat.START)
            }
        }
    }

    private fun initNavItemSelectedListener() {
        navigationView = findViewById(R.id.nav_view)
        navigationView.setNavigationItemSelectedListener(this)
    }

    private fun initNavDrawer() {

        drawer = findViewById(R.id.drawer_layout)
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.nav_item_video ->    {
                changeFragment(VideoFragment.newInstance("",""))
                //item.isChecked = true
            }

            R.id.nav_item_music -> {
                changeFragment(MusicFragment.newInstance("",""))
                //item.isChecked = true
            }

            R.id.nav_item_video_list ->{
                changeFragment(VideoListFragment.newInstance("",""))
                //item.isChecked = true
            }

            R.id.nav_item_four ->{
                Toast.makeText(this, "Clicked item four", Toast.LENGTH_SHORT).show()
                //item.isChecked = true
            }

        }
        drawer.closeDrawer(GravityCompat.START)
        return true
    }

    override fun onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    private fun changeFragment(fragment: Any){
        val frag = fragment as Fragment
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.fragmentSwitcher, frag)
        transaction.setTransition(androidx.fragment.app.FragmentTransaction.TRANSIT_FRAGMENT_FADE)
        transaction.commit()
    }

    private fun makeOthersUnchecked() {
        for (item in navigationView.menu.iterator()){
            item.isChecked = false
        }
        //navigationView.menu.getItem(0).isChecked = false
    }
}
