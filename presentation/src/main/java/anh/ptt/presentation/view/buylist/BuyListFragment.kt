package anh.ptt.presentation.view.buylist

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
import androidx.recyclerview.widget.RecyclerView
import anh.ptt.core.ResultType
import anh.ptt.presentation.R
import anh.ptt.presentation.databinding.FragmentBuylistBinding
import anh.ptt.presentation.view.buylist.adapter.BuyListAdapter
import anh.ptt.presentation.viewmodel.DashboardViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class BuyListFragment : Fragment() {

    private var _binding: FragmentBuylistBinding? = null

    private val viewModel: DashboardViewModel by viewModels()

    private val binding get() = _binding!!

    private lateinit var adapter: BuyListAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = DataBindingUtil.inflate(inflater, R.layout.fragment_buylist, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupAdapter()
        getBuyList()
    }

    private fun getBuyList() {
        viewModel.getBuyList()
        viewModel.buyList.observe(viewLifecycleOwner) { result ->
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

    private fun setupAdapter() {
        adapter = BuyListAdapter()
        binding.rvBuyList.apply {
            layoutManager = LinearLayoutManager(requireContext())
            addItemDecoration(DividerItemDecoration(requireContext(), 1))
            adapter = this@BuyListFragment.adapter
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}