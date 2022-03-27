package anh.ptt.presentation.view.dashboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import anh.ptt.presentation.R
import anh.ptt.presentation.databinding.FragmentDashboardBinding
import anh.ptt.presentation.interact.DashboardNavigator
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class DashBoardFragment : Fragment() {

    @Inject
    lateinit var navigator: DashboardNavigator

    private var _binding: FragmentDashboardBinding? = null

    val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = DataBindingUtil.inflate(inflater, R.layout.fragment_dashboard, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        bindEvents()
    }

    private fun bindEvents() {
        binding.btnCallList.setOnClickListener {
            navigator.gotoCallList()
        }
        binding.btnBuyList.setOnClickListener {
            navigator.gotoBuyList()
        }
        binding.btnSellList.setOnClickListener {
            navigator.goToSellList()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}