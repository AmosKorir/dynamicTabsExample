package com.tab.dynamic

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_example.passedTextView

/**
 * A simple [Fragment] subclass.
 */
class ExampleFragment : Fragment() {
  var passedId: Int? = null

companion object {
  fun newInstance(id: Int): ExampleFragment? {
    val myFragment = ExampleFragment()
    val args = Bundle()
    args.putInt("id", id)
    myFragment.setArguments(args)
    return myFragment
  }
}
  override fun onCreateView(
    inflater: LayoutInflater, container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {
    // Inflate the layout for this fragment
    return inflater.inflate(R.layout.fragment_example, container, false)
  }

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    passedId= arguments?.getInt("id")
//    i am toast the passed data, here  you can use it to fetch the data
      Toast.makeText(context,passedId.toString(),Toast.LENGTH_LONG).show()
  }

}
