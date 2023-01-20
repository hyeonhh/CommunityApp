package com.example.mysoloapp.fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.FragmentTransaction
import androidx.navigation.findNavController
import com.example.mysoloapp.R
import com.example.mysoloapp.contentsList.ContentListActivity
import com.example.mysoloapp.databinding.FragmentTipBinding


class TipFragment : Fragment() {
   private  lateinit var binding:FragmentTipBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_tip, container, false)

        binding.category1.setOnClickListener {
            val intent = Intent(context,ContentListActivity::class.java)
            startActivity(intent)
        }

        binding.homeTap.setOnClickListener {
            it.findNavController().navigate(R.id.action_tipFragment_to_homeFragment)
        }

        binding.talkTap.setOnClickListener {
            it.findNavController().navigate(R.id.action_tipFragment_to_talkFragment)
        }
        binding.bookmarkTap.setOnClickListener {
            it.findNavController().navigate(R.id.action_tipFragment_to_bookmarkFragment)
        }
        binding.storeTap.setOnClickListener {
            it.findNavController().navigate(R.id.action_tipFragment_to_storeFragment)
        }

        return binding.root
    }

}