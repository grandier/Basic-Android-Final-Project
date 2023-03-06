package com.bangkit.androidproject.artist

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bangkit.androidproject.R
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class ArtistAdapter(val listArtist: ArrayList<Artist>) : RecyclerView.Adapter<ArtistAdapter.ListViewHolder>() {
    inner class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var Name: TextView = itemView.findViewById(R.id.artist_name)
        var Listener: TextView = itemView.findViewById(R.id.artist_listener)
        var Photo: ImageView = itemView.findViewById(R.id.img_logo)
    }

    override fun getItemCount(): Int {
        return listArtist.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.activity_layout_artist, parent, false)
        return ListViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val (name, listener, photo, overview, detail) = listArtist[position]
        Glide.with(holder.itemView.context)
            .load(photo)
            .apply(RequestOptions())
            .into(holder.Photo)
        holder.Name.text = name
        holder.Listener.text = listener

        val mContext = holder.itemView.context

        holder.itemView.setOnClickListener{
            val moveDetail = Intent(mContext, ArtistDetail::class.java)
            moveDetail.putExtra(ArtistDetail.EXTRA_NAME, name)
            moveDetail.putExtra(ArtistDetail.EXTRA_LISTENER, listener)
            moveDetail.putExtra(ArtistDetail.EXTRA_PHOTO, photo)
            moveDetail.putExtra(ArtistDetail.EXTRA_DETAIL, detail)
            moveDetail.putExtra(ArtistDetail.EXTRA_OVERVIEW, overview)
            mContext.startActivity(moveDetail)
        }
    }

}
