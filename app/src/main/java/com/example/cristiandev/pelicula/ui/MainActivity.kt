package com.example.cristiandev.pelicula.ui

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.widget.DrawerLayout
import android.support.v7.app.ActionBarDrawerToggle
import android.view.MenuItem
import android.view.View
import com.example.cristiandev.pelicula.R
import com.example.cristiandev.pelicula.ui.fragments.main.MainFragment
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.support.HasSupportFragmentInjector
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity @Inject constructor(): AppCompatActivity(), HasSupportFragmentInjector,DrawerLayout.DrawerListener {

    @Inject
    lateinit var injector: DispatchingAndroidInjector<Fragment>

    override fun supportFragmentInjector(): AndroidInjector<Fragment> = injector

    val toggle: ActionBarDrawerToggle by lazy {
        ActionBarDrawerToggle(this, drawer,
                R.string.opened_menu, R.string.closed_menu)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        drawer.addDrawerListener(this)
        nav.setNavigationItemSelectedListener { setContent(it) }
        putFragment(R.id.container, MainFragment.instance(R.string.movie_popular,R.string.type_pelicula))
    }

    fun putFragment(container: Int, fragment: Fragment) {
        supportFragmentManager.beginTransaction()
                .replace(container, fragment)
                .addToBackStack(fragment.tag)
                .commit()
    }

    fun setContent(item: MenuItem?): Boolean {
        drawer.closeDrawers()
        when(item?.itemId){
            R.id.movie_popular -> putFragment(R.id.container, MainFragment.instance(R.string.movie_popular,R.string.type_pelicula))
            R.id.movie_toprated -> putFragment(R.id.container, MainFragment.instance(R.string.movie_top_rated,R.string.type_pelicula))
            R.id.movie_upcoming -> putFragment(R.id.container, MainFragment.instance(R.string.movie_upcoming,R.string.type_pelicula))
            R.id.series_popular -> putFragment(R.id.container, MainFragment.instance(R.string.serie_popular,R.string.type_serie))
            R.id.series_top_rated -> putFragment(R.id.container, MainFragment.instance(R.string.serie_top_rated,R.string.type_serie))
        }
        return true
    }

    override fun onPostCreate(savedInstanceState: Bundle?) {
        super.onPostCreate(savedInstanceState)
        toggle.syncState()
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        if (toggle.onOptionsItemSelected(item)) {
            return true
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onDrawerStateChanged(newState: Int) {
        toggle.onDrawerStateChanged(newState)
    }

    override fun onDrawerSlide(drawerView: View, slideOffset: Float) {
        toggle.onDrawerSlide(drawerView, slideOffset)
    }

    override fun onDrawerClosed(drawerView: View) {
        toggle.onDrawerClosed(drawerView)
    }

    override fun onDrawerOpened(drawerView: View) {
        toggle.onDrawerOpened(drawerView)
    }


}
