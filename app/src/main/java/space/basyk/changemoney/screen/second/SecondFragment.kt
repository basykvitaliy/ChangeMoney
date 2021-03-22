package space.basyk.changemoney.screen.second

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import space.basyk.changemoney.R
import space.basyk.changemoney.databinding.FragmentSecondBinding
import space.basyk.changemoney.utils.APP_ACTIVITY


class SecondFragment : Fragment() {

    private var binding: FragmentSecondBinding ?= null
    private val mBinding get() = binding!!
    lateinit var viewModel: SecondViewModel
    lateinit var recyclerView: RecyclerView
    private val adapter by lazy { SecondAdapter() }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSecondBinding.inflate(layoutInflater, container, false)
        APP_ACTIVITY.supportActionBar?.title = "Безналичный курс"
        return mBinding.root
    }

    override fun onStart() {
        super.onStart()
        init()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
        recyclerView.adapter = null
    }
    private fun init() {
        viewModel = ViewModelProvider(this).get(SecondViewModel::class.java)
        recyclerView = mBinding.recBeznal
        recyclerView.adapter = adapter
        viewModel.getPrivatMoney()
        viewModel.myPrivat.observe(this, {list ->
            adapter.setList(list)
        })
    }


}