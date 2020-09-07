package com.gutotech.narutogame.ui.home.signup

import android.app.AlertDialog
import android.app.Dialog
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import androidx.annotation.StringRes
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.gutotech.narutogame.R
import com.gutotech.narutogame.databinding.DialogFastSignupBinding
import com.gutotech.narutogame.ui.ResultListener
import com.gutotech.narutogame.ui.loggedin.LoggedInActivity
import com.gutotech.narutogame.utils.SoundUtil
import es.dmoral.toasty.Toasty

class FastSignUpDialogFragment : DialogFragment() {
    internal lateinit var listener: SignUpDialogListener

    interface SignUpDialogListener {
        fun onAccountCreated()
    }

    private lateinit var binding: DialogFastSignupBinding
    private lateinit var viewModel: SignUpViewModel

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        viewModel = ViewModelProvider(this).get(SignUpViewModel::class.java)
        viewModel.setAuthListener(object : ResultListener {
            override fun onSuccess() {
                listener.onAccountCreated()
                dismiss()
            }

            override fun onFailure(resId: Int) {
                context?.let { Toasty.error(it, resId, Toasty.LENGTH_SHORT).show() }
            }
        })

        binding = DataBindingUtil.inflate(inflater, R.layout.dialog_fast_signup,
                container, false)
        binding.viewModel = viewModel

        return binding.root
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val dialog = super.onCreateDialog(savedInstanceState)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.window?.setBackgroundDrawableResource(android.R.color.transparent)
        return dialog
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)

        try {
            listener = targetFragment as SignUpDialogListener
        } catch (e: ClassCastException) {
            throw ClassCastException("$context must implement SignUpDialogListener")
        }
    }

    companion object {
        @JvmStatic
        fun show(fragment: Fragment) {
            val dialog = FastSignUpDialogFragment()
            dialog.setTargetFragment(fragment, 0)
            dialog.show(fragment.parentFragmentManager, "FastSignUpDialogFragment")
        }
    }
}