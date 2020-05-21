package com.excercise.androidnavigationcomponent.simplenavigation


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavArgs
import androidx.navigation.NavController
import androidx.navigation.NavOptionsBuilder
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.excercise.androidnavigationcomponent.R
import kotlinx.android.synthetic.main.fragment_confirmation.*

/**
 * A simple [Fragment] subclass.
 */
class ConfirmationFragment : Fragment() {

    private val args: ConfirmationFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_confirmation, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val amount = args.amountReceived
        confirmation_message.text = "$$amount was sent to Mitch"
        btn_to_conditional_graph.setOnClickListener {
            // navigate to start destination from other nav graph
            /*val args = Bundle()
            args.putString("data", "passed data")
            findNavController().setGraph(R.navigation.conditional_nav_graph, args)*/

            // start activity
            findNavController().navigate(R.id.action_confirmationFragment_to_main2Activity)
            //requireActivity().finish() // to kill current activity before going to the next activity
        }
        btn_start_activity.setOnClickListener {
            findNavController().navigate(R.id.action_confirmationFragment_to_main3Activity)
        }
    }
}
