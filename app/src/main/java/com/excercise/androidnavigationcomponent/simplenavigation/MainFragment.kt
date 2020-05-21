package com.excercise.androidnavigationcomponent.simplenavigation


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.excercise.androidnavigationcomponent.R
import com.excercise.androidnavigationcomponent.dialog.MyDialog2Fragment
import kotlinx.android.synthetic.main.fragment_main.*

/**
 * A simple [Fragment] subclass.
 */
class MainFragment : Fragment(), View.OnClickListener, MyDialog2Fragment.OnChooseDialogButtonListener {

    var navController: NavController? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view) // reference to a view
        view_transactions_btn.setOnClickListener(this)
        view_balance_btn.setOnClickListener(this)
        send_money_btn.setOnClickListener(this)
        dialog_btn.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when(v!!.id) {
            R.id.view_transactions_btn -> navController?.navigate(
                R.id.action_mainFragment_to_viewTransactionFragment
            )
            R.id.view_balance_btn -> navController?.navigate(
                R.id.action_mainFragment_to_viewBalanceFragment
            )
            R.id.send_money_btn -> navController?.navigate(
                R.id.action_mainFragment_to_chooseRecipientFragment
            )
            R.id.dialog_btn -> {
                /*val fm = childFragmentManager
                val dialogFragment = MyDialogFragment.newInstance("Judul")
                dialogFragment.show(fm, MyDialogFragment::class.java.simpleName)*/

                /*val dialog2Fragment = MyDialog2Fragment.newInstance("Judul")
                dialog2Fragment.setOnChooseDialogButtonListener(this)
                dialog2Fragment.show(fm, MyDialog2Fragment::class.java.simpleName)*/
                val args = Bundle()
                args.putString("title", "judul")
                navController?.navigate(R.id.action_mainFragment_to_myDialogFragment, args)
            }
        }
    }

    override fun onChooseDialogButton(option: String) {
        Toast.makeText(context, option, Toast.LENGTH_SHORT).show()
    }
}
