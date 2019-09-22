package com.example.moviesapp.activities

import android.app.AlertDialog
import android.os.Bundle
import android.view.*
import com.example.moviesapp.R
import com.example.moviesapp.adapters.MovieFragmentTVAdapter
import com.example.moviesapp.data.models.MovieModelImpl
import com.example.moviesapp.delegates.GetMovieInfoDelegate

import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.now_showing_tab_fragment_detail.*

class MainActivity : BaseActivity(), GetMovieInfoDelegate{

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        val adapter = MovieFragmentTVAdapter(supportFragmentManager, this)
        view_pager.adapter = adapter
        tab_layout.setupWithViewPager(view_pager)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun onTabMovieItem(id: Int) {
        //Toast.makeText(applicationContext, "Item clicked : $id", Toast.LENGTH_SHORT).show()

        val detailDialogView = LayoutInflater.from(applicationContext).inflate(R.layout.now_showing_tab_fragment_detail, null)

        val detailDialogBuilder = AlertDialog.Builder(this, android.R.style.Theme_Material_Light_NoActionBar_Fullscreen)
            .setView(detailDialogView)

        val detailDialog = detailDialogBuilder.show()

        detailDialog.ic_close.setOnClickListener{
            detailDialog.dismiss()
        }

        val movie = MovieModelImpl.getMovieById(id)

        detailDialog.lbl_movie_name.text = movie.movieName
        detailDialog.lbl_001.text = movie.imdb.toString()
        detailDialog.lbl_002.text = movie.rottenTomato.toString()
        detailDialog.lbl_003.text = movie.metaCentric.toString()
        detailDialog.lbl_review.text = movie.overview

    }
}
