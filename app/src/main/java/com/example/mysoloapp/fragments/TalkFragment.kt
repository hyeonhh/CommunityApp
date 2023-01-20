package com.example.mysoloapp.fragments

import android.os.Bundle
import android.provider.ContactsContract.Data
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.example.mysoloapp.R
import com.example.mysoloapp.databinding.FragmentTalkBinding


class TalkFragment : Fragment() {

    private lateinit var binding: FragmentTalkBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
        override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
        ): View? {
            // Inflate the layout for this fragment

            binding = DataBindingUtil.inflate(inflater,R.layout.fragment_talk, container, false)

            binding.bookmarkTap.setOnClickListener {
                it.findNavController().navigate(R.id.action_talkFragment_to_bookmarkFragment)
            }

            binding.homeTap.setOnClickListener {
                it.findNavController().navigate(R.id.action_talkFragment_to_homeFragment)
            }
            binding.storeTap.setOnClickListener {
                it.findNavController().navigate(R.id.action_talkFragment_to_storeFragment)

            }
            binding.tipTap.setOnClickListener {
                it.findNavController().navigate(R.id.action_talkFragment_to_tipFragment)

            }


            return binding.root
        }
    }
