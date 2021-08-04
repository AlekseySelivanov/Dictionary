package com.example.myapplication.view.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View.GONE
import android.view.View.VISIBLE
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.R
import com.example.myapplication.databinding.ActivityMainBinding
import com.example.myapplication.model.data.AppState
import com.example.myapplication.view.base.View
import com.example.myapplication.view.main.adapter.MainAdapter
import com.example.myapplication.application.DictionaryApp
import javax.inject.Inject

class MainActivity : AppCompatActivity(), View {
    @Inject
    internal lateinit var viewmodelFactory: ViewModelProvider.Factory

    private var adapter: MainAdapter? = null
    val model: MainViewModel by lazy {
        viewmodelFactory.create(MainViewModel::class.java)
    }
    private val observer = Observer<AppState> { renderData(it) }
    private var _binding: ActivityMainBinding? = null
    private val binding get() = _binding!!
    override fun onCreate(savedInstanceState: Bundle?) {
        DictionaryApp.component.inject(this)
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.searchButton.setOnClickListener {
            model.getData(binding.searchEditText.text.toString(), true)
        }
        model.viewState.observe(this, observer)
    }

    override fun renderData(appState: AppState) {
        when (appState) {
            is AppState.Success -> {
                val dataModel = appState.data
                if (dataModel == null || dataModel.isEmpty()) {
                    showErrorScreen(getString(R.string.error_empty_response))
                } else {
                    showViewSuccess()
                    if (adapter == null) {
                        binding.mainActivityRv.layoutManager =
                            LinearLayoutManager(applicationContext)
                        binding.mainActivityRv.adapter = MainAdapter(dataModel)
                    } else {
                        adapter!!.setData(dataModel)
                    }
                }
            }
            is AppState.Loading -> {
                showViewLoading()
            }
            is AppState.Error -> {
                showErrorScreen(appState.error.message)
            }
        }
    }

    private fun showErrorScreen(error: String?) {
        showViewError()
        binding.errorTextView.text = error ?: getString(R.string.error_undefined)
        binding.reloadButton.setOnClickListener { model.getData("Hi", true) }
    }

    private fun showViewSuccess() {
        binding.successLinearLayout.visibility = VISIBLE
        binding.loadingFrameLayout.visibility = GONE
        binding.errorLinearLayout.visibility = GONE
    }

    private fun showViewLoading() {
        binding.successLinearLayout.visibility = GONE
        binding.loadingFrameLayout.visibility = VISIBLE
        binding.errorLinearLayout.visibility = GONE
    }

    private fun showViewError() {
        binding.successLinearLayout.visibility = GONE
        binding.loadingFrameLayout.visibility = GONE
        binding.errorLinearLayout.visibility = VISIBLE
    }
}