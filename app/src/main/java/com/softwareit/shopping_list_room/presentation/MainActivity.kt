package com.softwareit.shopping_list_room.presentation

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.softwareit.shopping_list_room.common.hide
import com.softwareit.shopping_list_room.common.show
import com.softwareit.shopping_list_room.databinding.ActivityMainBinding
import com.softwareit.shopping_list_room.databinding.DialogAddShoppingItemBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    private val viewModel: MainViewModel by viewModels()
    private lateinit var adapter: ShoppingListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        setupShoppingListRecyclerView()
        setupAddShoppingItemButtons()
    }

    private fun setupShoppingListRecyclerView() {
        binding.progressBar.show()
        binding.emptyShoppingListContainer.hide()
        binding.shoppingListContainer.hide()
        adapter = ShoppingListAdapter(
            onPurchaseClick = {
                viewModel.setIsPurchased(it)
            },
            onDeleteClick = {
                viewModel.deleteShoppingItem(it)
            }
        )
        binding.shoppingList.adapter = adapter

        viewModel.shoppingList.observe(this@MainActivity) { list ->
            binding.progressBar.hide()
            binding.counter.text = "${list.count { it.isPurchased }}/${list.size}"
            adapter.submitList(list)

            when (list.size) {
                0 -> {
                    binding.emptyShoppingListContainer.show()
                    binding.shoppingListContainer.hide()
                }

                else -> {
                    binding.emptyShoppingListContainer.hide()
                    binding.shoppingListContainer.show()
                }
            }
        }
    }

    private fun setupAddShoppingItemButtons() {
        binding.emptyShoppingListButton.setOnClickListener {
            showAddItemDialog()
        }
        binding.shoppingListButton.setOnClickListener {
            showAddItemDialog()
        }
    }

    private fun showAddItemDialog() {
        val alertBinding = DialogAddShoppingItemBinding.inflate(layoutInflater)
        val builder = AlertDialog.Builder(this).apply {
            setView(alertBinding.root)
        }

        val dialog = builder.create()

        alertBinding.cancel.setOnClickListener {
            dialog.dismiss()
        }

        alertBinding.save.setOnClickListener {
            val editText = alertBinding.addEditText
            val name = editText.text.toString()

            if (name.isBlank()) {
                editText.error = "Item name cannot be empty"
                return@setOnClickListener
            }

            viewModel.addShoppingItem(name)
            dialog.dismiss()
        }

        dialog.show()
    }
}