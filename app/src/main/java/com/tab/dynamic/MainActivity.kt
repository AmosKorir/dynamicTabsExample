package com.tab.dynamic

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentTransaction
import com.google.android.material.tabs.TabLayout.OnTabSelectedListener
import com.google.android.material.tabs.TabLayout.Tab
import kotlinx.android.synthetic.main.activity_main.tabLayout

class MainActivity : AppCompatActivity() {

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)
    addTabs()
  }

  private fun addTabs() {

//    clear all the tabs first
    tabLayout.removeAllTabs()
    val countries = getCountries()
    for (n in countries) {

      tabLayout.addTab(tabLayout.newTab().setText(n.name).setTag(n.id))

    }

    //set listen for the tab selected
    tabLayout.addOnTabSelectedListener(object : OnTabSelectedListener {
      override fun onTabReselected(tab: Tab?) {
      }

      override fun onTabUnselected(tab: Tab?) {
      }

      override fun onTabSelected(tab: Tab?) {
//        the tab is selected , create the fragment
//        get the tag of the tab you had set
        var id: Int = tab?.tag as Int
        showFragment(id)
      }

    })

  }

  //show fragment
  private fun showFragment(id: Int) {
    val exampleFragment = ExampleFragment.newInstance(id)
    exampleFragment?.passedId = id
    val fragmentTransaction: FragmentTransaction = supportFragmentManager.beginTransaction()
    fragmentTransaction.replace(R.id.fragmentContainter, exampleFragment!!)
    fragmentTransaction.commit()
  }

  //assume this is from the api
  private fun getCountries(): List<Country> {
    val countries = ArrayList<Country>()
    countries.add(Country(1, "kenya"))
    countries.add(Country(2, "uganda"))
    return countries
  }
}
