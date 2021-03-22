package space.basyk.changemoney.screen.start

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import space.basyk.changemoney.R
import space.basyk.changemoney.databinding.FragmentStartBinding
import space.basyk.changemoney.utils.APP_ACTIVITY


class StartFragment : Fragment() {

    private var binding: FragmentStartBinding ?= null
    private val mBinding get() = binding!!
    lateinit var recyclerView: RecyclerView
    private val adapter by lazy { StartAdapter() }
    lateinit var viewModel: StartViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentStartBinding.inflate(layoutInflater, container, false)
        APP_ACTIVITY.supportActionBar?.title = "Наличный курс"
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
        viewModel = ViewModelProvider(this).get(StartViewModel::class.java)
        recyclerView = mBinding.recView
        recyclerView.adapter = adapter
        viewModel.getCurrentMon()
        viewModel.myMoney.observe(this, {list ->
            list.body()?.let { adapter.setList(it) }
        })
    }

}