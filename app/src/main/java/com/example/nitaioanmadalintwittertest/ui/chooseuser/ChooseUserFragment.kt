package com.example.nitaioanmadalintwittertest.ui.chooseuser

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.nitaioanmadalintwittertest.R
import com.example.nitaioanmadalintwittertest.data.api.ApiHelper
import com.example.nitaioanmadalintwittertest.data.api.RetrofitBuilder
import com.example.nitaioanmadalintwittertest.data.utils.CallStatus
import com.example.nitaioanmadalintwittertest.ui.main.MainActivity
import com.example.nitaioanmadalintwittertest.utils.KeyboardUtils
import com.example.nitaioanmadalintwittertest.utils.livedatautils.EventObserver
import kotlinx.android.synthetic.main.fragment_choose_user.*

class ChooseUserFragment : Fragment() {

    private val viewModel: ChooseUserFragmentViewModel by viewModels {
        ChooseUserFragmentViewModelFactory(
            ApiHelper(RetrofitBuilder.apiTwitterService)
        )
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_choose_user, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (activity as MainActivity).hideBackButton()

        setupObserver()

        get_user_data_btn.setOnClickListener {
            viewModel.getUserData(textInputEditText.text.toString())
        }

        textInputEditText.onFocusChangeListener =
            View.OnFocusChangeListener { v, hasFocus ->
                if (!hasFocus) {
                    KeyboardUtils.hideKeyboard(v, activity)
                }
            }
    }

    private fun setupObserver() {
        viewModel.getTwitterResponse().observe(viewLifecycleOwner, EventObserver {
            it.let { resource ->
                when (resource.status) {
                    CallStatus.SUCCESS -> {
                        progressBar.visibility = View.GONE
                        ChooseUserFragmentDirections
                        val action =
                            ChooseUserFragmentDirections.actionChooseUserFragmentToTwitterUserDataFragment(
                                resource.data!!
                            )
                        findNavController().navigate(action)
                    }
                    CallStatus.ERROR -> {
                        progressBar.visibility = View.GONE
                        AlertDialog.Builder(requireContext())
                            .setTitle(getString(R.string.error_encountered))
                            .setMessage(it.message)
                            .setPositiveButton(
                                getString(R.string.ok)
                            ) { _, _ -> }
                            .show()
                    }
                    CallStatus.LOADING -> {
                        progressBar.visibility = View.VISIBLE
                    }
                }
            }
        }
        )
    }


}