package com.excercise.androidnavigationcomponent.swipviewpager2


import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2

import com.excercise.androidnavigationcomponent.R
import kotlinx.android.synthetic.main.category_item.view.*
import kotlinx.android.synthetic.main.fragment_main5.*
import kotlin.math.abs
import kotlin.math.max

/**
 * A simple [Fragment] subclass.
 */
class Main5Fragment : Fragment() {

    private val categories = listOf(
        Category(1, "Your Recording"),
        Category(2, "Film"),
        Category(3, "Series"),
        Category(4, "Kids"),
        Category(5, "Sport")
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main5, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val viewPager2Adapter = CategoryAdapter()
        main5_viewpager2.adapter = viewPager2Adapter
        viewPager2Adapter.setItem(categories)
        main5_viewpager2.orientation = ViewPager2.ORIENTATION_VERTICAL
        main5_viewpager2.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback(){
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                //Log.d("onPageSelected", "page selected $position")
            }

            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {
                super.onPageScrolled(position, positionOffset, positionOffsetPixels)
                //Log.d("onPageScrolled", "position: $position, positionOffset: $positionOffset, positionOffsetPixels: $positionOffsetPixels")
            }
        })
        main5_viewpager2.setPageTransformer(ViewPager2TranslationPageTransformation())
    }

    inner class Category(var index: Int, var name: String)

    inner class CategoryAdapter : RecyclerView.Adapter<CategoryViewHolder>() {

        var list: List<Category> = listOf()

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
            return CategoryViewHolder(parent)
        }

        override fun getItemCount(): Int {
            return list.size
        }

        override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
            holder.bind(list[position])
        }

        fun setItem(list: List<Category>) {
            this.list = list
            notifyDataSetChanged()
        }
    }

    inner class CategoryViewHolder constructor(itemView: View) : RecyclerView.ViewHolder(itemView) {
        constructor(parent: ViewGroup) : this(LayoutInflater.from(parent.context).inflate(R.layout.category_item, parent, false))

        fun bind(category: Category) {
            itemView.tv_category.text = category.name
        }
    }

    inner class ViewPager2PageTransformation : ViewPager2.PageTransformer {
        override fun transformPage(page: View, position: Float) {
            Log.d("transformPage", "position: $position")
            when {
                position < -1 -> page.alpha = 0.1f
                position <= 1 -> page.alpha = max(0.2f, 1 - abs(position))
                else -> page.alpha = 0.1f
            }
        }
    }

    inner class ViewPager2TranslationPageTransformation : ViewPager2.PageTransformer {
        override fun transformPage(page: View, position: Float) {
            Log.d("transformPage", "position: $position")
            val absPos = abs(position)
            page.apply {
                translationY = absPos * 500f
                translationX = absPos * 500f
                scaleX = 1f
                scaleY = 1f
            }

            when {
                position < -1 -> page.alpha = 0.1f
                position <= 1 -> page.alpha = max(0.2f, 1 - abs(position))
                else -> page.alpha = 0.1f
            }
        }
    }
}
