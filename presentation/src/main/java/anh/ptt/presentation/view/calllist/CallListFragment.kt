package anh.ptt.presentation.view.calllist

import android.os.Bundle
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
import anh.ptt.presentation.databinding.FragmentCalllistBinding
import anh.ptt.presentation.view.calllist.adapter.CallListAdapter
import anh.ptt.presentation.viewmodel.DashboardViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CallListFragment : Fragment() {

    private var _binding: FragmentCalllistBinding? = null

    private val viewModel: DashboardViewModel by viewModels()

    private val binding get() = _binding!!

    private lateinit var adapter: CallListAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = DataBindingUtil.inflate(inflater, R.layout.fragment_calllist, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupAdapter()
        getCallList()
    }

    private fun setupAdapter() {
        adapter = CallListAdapter()
        binding.rvCallList.apply {
            layoutManager = LinearLayoutManager(requireContext())
            addItemDecoration(DividerItemDecoration(requireContext(), 1))
            adapter = this@CallListFragment.adapter
        }
    }

    private fun getCallList() {
        viewModel.getCallList()
        viewModel.callList.observe(viewLifecycleOwner) { result ->
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