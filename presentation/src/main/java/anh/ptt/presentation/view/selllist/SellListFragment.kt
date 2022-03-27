package anh.ptt.presentation.view.selllist

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import anh.ptt.core.ResultType
import anh.ptt.presentation.R
import anh.ptt.presentation.databinding.FragmentSelllistBinding
import anh.ptt.presentation.view.buylist.adapter.BuyListAdapter
import anh.ptt.presentation.view.selllist.adapter.SellListAdapter
import anh.ptt.presentation.viewmodel.DashboardViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SellListFragment : Fragment() {

    private var _binding: FragmentSelllistBinding? = null

    private val binding get() = _binding!!

    private val viewModel: DashboardViewModel by viewModels()
    private lateinit var adapter: SellListAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = DataBindingUtil.inflate(inflater, R.layout.fragment_selllist, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupAdapter()
        getSellList()
    }

    private fun setupAdapter() {
        adapter = SellListAdapter()
        binding.rvSellList.apply {
            layoutManager = LinearLayoutManager(requireContext())
            addItemDecoration(DividerItemDecoration(requireContext(), 1))
            adapter = this@SellListFragment.adapter
        }
    }

    private fun getSellList() {
        viewModel.getSellList()
        viewModel.sellList.observe(viewLifecycleOwner) { result ->
            when (result.resultType) {
                ResultType.SUCCESS -> {
                    adapter.submitList(result.data)
                }
                ResultType.ERROR -> {
                    Toast.makeText(requireContext(), result.error?.message ?: "", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}