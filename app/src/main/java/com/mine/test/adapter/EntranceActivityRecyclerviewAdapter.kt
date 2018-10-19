package com.mine.test.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.mine.test.R
import com.mine.test.bean.EntrancePageBean
import kotlinx.android.synthetic.main.entrance_rv_adapter.view.*

/**
 * Created by Administrator on 2018-10-15.
 */
class EntranceActivityRecyclerviewAdapter(val context: Context, val data: ArrayList<EntrancePageBean>, var earecAdapterInterface: EARecAdapterInterface) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    var mContext: Context = context
    val NORMAL = 0
    val TITLE = 1
    override fun onCreateViewHolder(p0: ViewGroup, viewType: Int): RecyclerView.ViewHolder = when (viewType) {
        NORMAL -> {
            //var view: View = LayoutInflater.from(mContext).inflate(R.layout.entrance_rv_adapter, p0, false)
            //var viewHolder: ViewHolder = ViewHolder(view)
            ViewHolder(LayoutInflater.from(mContext).inflate(R.layout.entrance_rv_adapter, p0, false))
        }
        else -> {
            TitleViewHolder(LayoutInflater.from(mContext).inflate(R.layout.entrance_rv_adapter_title, p0, false))
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

        when (getItemViewType(position)) {
            TITLE -> {
                if (holder is TitleViewHolder) {
                    holder.textContent.setText(data?.get(position).content)
                    holder.textContent.setOnClickListener(object : View.OnClickListener {
                        override fun onClick(v: View?) {
                            earecAdapterInterface?.viewClick(v, position)
                        }
                    })
                }
            }
            NORMAL -> {
                if (holder is ViewHolder) {
                    holder.textContent.setText(data?.get(position).content)
                    holder.textContent.setOnClickListener { view ->
                        Log.i("zyp", " earecAdapterInterface" + earecAdapterInterface)
                        earecAdapterInterface?.viewClick(view, position)
                    }
                }
            }


        }


    }

    //when else == java`s if else
    override fun getItemViewType(position: Int): Int = when (position) {
        0 -> {
            TITLE
        }
        else -> {
            NORMAL
        }

    }

    override fun getItemCount(): Int = data.size


    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var textContent: TextView = itemView.findViewById(R.id.tv_content)
    }

    class TitleViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var textContent: TextView = itemView.findViewById(R.id.tv_content)
    }
}