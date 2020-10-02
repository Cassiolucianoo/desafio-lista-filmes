package com.cassiolucianodasilva.movielistchallenge.ui.popular_movie

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.cassiolucianodasilva.movielistchallenge.R
import com.cassiolucianodasilva.movielistchallenge.vo.Movie
import kotlinx.android.synthetic.main.movie_list_item.view.*

class MyAdapter (internal var context: Context,
                 internal var intemList: List<Movie>):RecyclerView.Adapter<MyAdapter.MyViewHolder>(),Filterable{


    internal var filterListResult: List<Movie>

    init {
        this.filterListResult = intemList
    }
    override fun getFilter(): Filter {
      return object :Filter(){
          override fun performFiltering(charString: CharSequence?): FilterResults {
              val charSearch:String = charString.toString()
              if (charSearch.isEmpty())
                  filterListResult = intemList
              else{

                  val  resultList = ArrayList<Movie>()
                  for (row in intemList)
                  {
                      if (row.title!!.toLowerCase().contains(charSearch.toLowerCase()))
                          resultList.add(row)
                  }
                  filterListResult = resultList
              }
              val filterResults = Filter.FilterResults()
              filterResults.values = filterListResult
              return filterResults
          }

          override fun publishResults(charSequence: CharSequence?, filterResults: FilterResults?) {
            filterListResult = filterResults!!.values as List<Movie>
              notifyDataSetChanged()
          }

      }


        }

    inner class MyViewHolder(itemView:View): RecyclerView.ViewHolder(itemView) {

        internal  var txt_title:TextView
        internal  var txt_url:TextView

        init {
            txt_title = itemView.findViewById<TextView>(R.id.cv_movie_title)
            txt_url = itemView.findViewById<TextView>(R.id.cv_iv_movie_poster)
        }

    }

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): MyViewHolder {
        val  itemView: View = LayoutInflater.from(context).inflate(R.layout.movie_list_item,p0,false)
        return MyViewHolder(itemView)
    }

    override fun getItemCount(): Int {
      return filterListResult.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.txt_title.text = filterListResult.get(position).title
       // holder.txt_url.text = filterListResult.get(position).url

    }




    }

