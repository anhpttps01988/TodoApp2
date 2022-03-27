package anh.ptt.todoapp.navigator

import androidx.fragment.app.FragmentActivity
import androidx.navigation.findNavController
import anh.ptt.presentation.interact.DashboardNavigator
import anh.ptt.presentation.view.dashboard.DashBoardFragmentDirections
import anh.ptt.todoapp.R
import javax.inject.Inject

class DashboardNavigatorImp @Inject constructor(private val activity: FragmentActivity) : DashboardNavigator {

    override fun gotoCallList() {
        val nav = DashBoardFragmentDirections.actionDashBoardFragmentToCallListFragment()
        activity.findNavController(R.id.nav_host_fragment).navigate(nav)
    }

    override fun gotoBuyList() {
        val nav = DashBoardFragmentDirections.actionDashBoardFragmentToBuyListFragment()
        activity.findNavController(R.id.nav_host_fragment).navigate(nav)
    }

    override fun goToSellList() {
        val nav = DashBoardFragmentDirections.actionDashBoardFragmentToSellListFragment()
        activity.findNavController(R.id.nav_host_fragment).navigate(nav)
    }
}