package dev.mko.dry

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

abstract class IconTextListViewAdapter<T>(
    context: Context, private val dataItems: List<T>,
    private val onAdapterItemClickListener: OnAdapterItemClickListener<T>
) : ArrayAdapter<T>(context, R.layout.icon_text_list_view_item, dataItems) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val viewHolder: ViewHolder<T>
        val view: View

        if (convertView == null) {
            val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            view = inflater.inflate(R.layout.icon_text_list_view_item, parent, false)
            viewHolder = getViewHolder(view)
            view.tag = viewHolder
            view.setOnClickListener {
                onAdapterItemClickListener.onAdapterItemClicked(dataItems[position])
            }
        } else {
            view = convertView
            viewHolder = view.tag as ViewHolder<T>
        }

        viewHolder.setData(dataItems[position])
        return view
    }

    protected abstract fun getViewHolder(view: View): ViewHolder<T>

    abstract class ViewHolder<T2>(view: View) : RecyclerView.ViewHolder(view) {

        protected var icon: ImageView = view.findViewById(R.id.icon)
        protected var label: TextView = view.findViewById(R.id.label)

        abstract fun setData(data: T2)

    }

    interface OnAdapterItemClickListener<T3> {
        fun onAdapterItemClicked(data: T3)
    }

}