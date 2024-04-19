package com.example.tv_application_practice

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.example.tv_application_practice.api.Response
import com.example.tv_application_practice.dataModel.DataModel
import com.example.tv_application_practice.viewmodel.DetailViewModel
import com.example.tv_application_practice.viewmodel.DetailViewModelFactory
import com.example.tv_application_practice.webView.WebViewActivity

class MainActivity : FragmentActivity() {

    private lateinit var viewModel : DetailViewModel
    private lateinit var listFragment: ListFragment

    private lateinit var titleText:TextView
    private lateinit var descriptionText:TextView
    private lateinit var authorText:TextView
    private lateinit var imageBanner:ImageView

    private lateinit var progressBar:ProgressBar


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        titleText= findViewById(R.id.title)
        descriptionText = findViewById(R.id.description)
        authorText = findViewById(R.id.authorName)
        imageBanner = findViewById(R.id.img_banner)

        listFragment = ListFragment()

        progressBar = findViewById(R.id.progressBar)

        val transaction = supportFragmentManager.beginTransaction()
        transaction.add(R.id.list_fragment, listFragment)
        transaction.commit()

        val repository =  (application as MyApplication).newsRepo

        viewModel = ViewModelProvider(this,
            DetailViewModelFactory(repository)
        )[DetailViewModel::class.java]


        listFragment.setOnContentSelectedListener{
            updateBanner(it)
        }

        listFragment.setOnItemClickListener{
            Log.d("checkingClick","clicked");
            val intent = Intent(applicationContext,WebViewActivity::class.java)
            intent.putExtra("newsUrl",it.url)
            startActivity(intent)
        }

        progressBar.visibility=View.VISIBLE

        callNewsApiForData()

    }

    private fun callNewsApiForData() {
        Log.d("When ","inside the function ")
        viewModel.generalDetails.observe(this){ it ->

            when (it){
                is Response.Error -> {
                    progressBar.visibility=View.GONE
                    Log.d("When error",it.toString())
                }
                is Response.Loading -> {
                    Log.d("When loading","Loading")
                }
                is Response.Success -> {
                    Log.d("When success",it.data.toString())
                    progressBar.visibility=View.GONE
                    it.data?.articles.let {
                        listFragment.bindData(it!!,"General News")
                    }
                }
            }
        }



        viewModel.businessNewsDetail.observe(this){ it ->
            when (it){
                is Response.Error -> {
                    progressBar.visibility=View.GONE
                    Log.d("When error",it.toString())
                }
                is Response.Loading -> {
                    Log.d("When loading","Loading")
                }
                is Response.Success -> {
                    Log.d("When success",it.data.toString())
                    progressBar.visibility=View.GONE
                    it.data?.articles.let {
                        listFragment.bindData(it!!,"Business News")
                    }
                }
            }
        }


        viewModel.techNewsDetail.observe(this){ it ->

            when (it){
                is Response.Error -> {
                    progressBar.visibility=View.GONE
                    Log.d("When error",it.toString())
                }
                is Response.Loading -> {
                    Log.d("When loading","Loading")
                }
                is Response.Success -> {
                    Log.d("When success",it.data.toString())
                    progressBar.visibility=View.GONE
                    it.data?.articles.let {
                        listFragment.bindData(it!!,"Technology News")
                    }
                }
            }
        }


        viewModel.entertainmentDetail.observe(this){ it ->

            when (it){
                is Response.Error -> {
                    progressBar.visibility=View.GONE
                    Log.d("When error",it.toString())
                }
                is Response.Loading -> {
                    Log.d("When loading","Loading")
                }
                is Response.Success -> {
                    Log.d("When success",it.data.toString())
                    progressBar.visibility=View.GONE
                    it.data?.articles.let {
                        listFragment.bindData(it!!,"Entertainment News")
                    }
                }
            }
        }


        viewModel.healthDetail.observe(this){ it ->

            when (it){
                is Response.Error -> {
                    progressBar.visibility=View.GONE
                    Log.d("When error",it.toString())
                }
                is Response.Loading -> {
                    Log.d("When loading","Loading")
                }
                is Response.Success -> {
                    Log.d("When success",it.data.toString())
                    progressBar.visibility=View.GONE
                    it.data?.articles.let {
                        listFragment.bindData(it!!,"Health News")
                    }
                }
            }
        }


        viewModel.scienceDetail.observe(this){ it ->

            when (it){
                is Response.Error -> {
                    progressBar.visibility=View.GONE
                    Log.d("When error",it.toString())
                }
                is Response.Loading -> {
                    Log.d("When loading","Loading")
                }
                is Response.Success -> {
                    Log.d("When success",it.data.toString())
                    progressBar.visibility=View.GONE
                    it.data?.articles.let {
                        listFragment.bindData(it!!,"Science News")
                    }
                }
            }
        }

        viewModel.sportsDetail.observe(this){ it ->

            when (it){
                is Response.Error -> {
                    progressBar.visibility=View.GONE
                    Log.d("When error",it.toString())
                }
                is Response.Loading -> {
                    Log.d("When loading","Loading")
                }
                is Response.Success -> {
                    Log.d("When success",it.data.toString())
                    progressBar.visibility=View.GONE
                    it.data?.articles.let {
                        listFragment.bindData(it!!,"Sports News")
                    }
                }
            }
        }


    }

    private fun updateBanner(newsDetails: DataModel.Article) {
        titleText.text= newsDetails.title
        descriptionText.text= newsDetails.description
        authorText.text= newsDetails.author
        val url = newsDetails.urlToImage
        Glide.with(application).load(url).into(imageBanner)
    }

}