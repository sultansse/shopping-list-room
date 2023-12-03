package com.softwareit.shopping_list_room.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.softwareit.shopping_list_room.R
import com.softwareit.shopping_list_room.databinding.ItemShoppingItemBinding
import com.softwareit.shopping_list_room.domain.model.ShoppingItem

class ShoppingListAdapter(
    private val onPurchaseClick: (ShoppingItem) -> Unit,
    private val onDeleteClick: (ShoppingItem) -> Unit,
) : ListAdapter<ShoppingItem, ShoppingListAdapter.ViewHolder>(DiffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemShoppingItemBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class ViewHolder(
        private val binding: ItemShoppingItemBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(shoppingItem: ShoppingItem) {
            with(binding) {
                name.text = shoppingItem.name
                if (shoppingItem.isPurchased) {
                    purchase.setImageResource(R.drawable.ic_purchased)
                } else {
                    purchase.setImageResource(R.drawable.ic_not_purchased)
                }

                purchase.setOnClickListener {
                    shoppingItem.isPurchased = !shoppingItem.isPurchased
                    if (shoppingItem.isPurchased) {
                        purchase.setImageResource(R.drawable.ic_purchased)
                    } else {
                        purchase.setImageResource(R.drawable.ic_not_purchased)
                    }
                    onPurchaseClick(shoppingItem)
                }

                link.setOnClickListener {
                    onDeleteClick(shoppingItem)
                }
            }
        }
    }


    companion object {
        private val DiffCallback =  object : DiffUtil.ItemCallback<ShoppingItem>() {
            override fun areItemsTheSame(oldItem: ShoppingItem, newItem: ShoppingItem): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: ShoppingItem, newItem: ShoppingItem): Boolean {
                return oldItem == newItem
            }
        }
    }
}