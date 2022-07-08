package com.noobdev.propermvvmarcitecture.ui

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.noobdev.propermvvmarcitecture.R
import com.noobdev.propermvvmarcitecture.databinding.FragmentXmlBinding
import com.noobdev.propermvvmarcitecture.presentation.ViewModelClass
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.ExperimentalCoroutinesApi

@ExperimentalCoroutinesApi
@AndroidEntryPoint
class XmlFragment : Fragment(R.layout.fragment_xml) {


    private val TAG = "XmlFragment "
    private val viewModel: ViewModelClass by activityViewModels()

    private var binding: FragmentXmlBinding? = null
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentXmlBinding.bind(view)

//        val response = viewModel.response.value
//        Log.d(TAG, response.toString())
//        Log.d(TAG, response?.data?.get(1)?.name.toString())

        Log.d(TAG, "days: "+startWar().toString())

    }

    class Army(var army: Int)

    class Nation(var armyList: List<Army>)

    var nationList: MutableList<Nation> = ArrayList()

    private fun startWar(): Int {
        val armyList: MutableList<Army> = ArrayList()
        armyList.add(Army(1))
        armyList.add(Army(2))
        armyList.add(Army(3))
        armyList.add(Army(4))
        nationList.add(Nation(armyList))
        nationList.add(Nation(armyList))
        nationList.add(Nation(armyList))
        return capture()
    }

    var day = 0
    var troop = 0
    var troopNeeded = 0
    var x = 1

    private fun capture(): Int {
        for (n in 1..nationList.size + 2) {
            for (i in 1..nationList[n].armyList.size + 2) {
                troopNeeded += nationList[n].armyList[i].army
                if (i == nationList[n].armyList.size + 1) { //at last
                    while (true) {
                        troop += x
                        day += 1
                        if (troop >= troopNeeded) { //war ended with one nation
                            troop = 0 // casualty all troop died
                            break
                        }
                    }
                }
            }
            x += 1
            if (n == nationList.size + 1) {
                Log.d("total number of days", day.toString())
                break
            }
        }
        return day
    }
}