package com.jorgesanaguaray.prepopulatedatabase.home.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import coil.transform.CircleCropTransformation
import com.jorgesanaguaray.prepopulatedatabase.R
import com.jorgesanaguaray.prepopulatedatabase.core.item.User
import com.jorgesanaguaray.prepopulatedatabase.databinding.ItemHomeBinding

/**
 * Created by Jorge Sanaguaray
 */

class HomeAdapter : RecyclerView.Adapter<HomeAdapter.MyHomeViewHolder>() {

    private var users: List<User> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHomeViewHolder {
        return MyHomeViewHolder(ItemHomeBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: MyHomeViewHolder, position: Int) {

        val user = users[position]

        holder.binding.apply {

            mUsername.text = user.username
            mName.text = user.name
            mProfilePicture.load(user.profilePicture) {
                transformations(CircleCropTransformation())
                placeholder(R.drawable.ic_profile)
                error(R.drawable.ic_profile)
                crossfade(true)
                crossfade(400)
            }

        }

    }

    override fun getItemCount(): Int {
        return users.size
    }

    class MyHomeViewHolder(val binding: ItemHomeBinding) : RecyclerView.ViewHolder(binding.root)

    fun setUsers(users: List<User>) {
        this.users = users
    }

}