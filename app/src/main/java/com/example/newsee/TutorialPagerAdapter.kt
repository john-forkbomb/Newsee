package com.example.newsee

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter


class TutorialPagerAdapter(fa: FragmentActivity) : FragmentStateAdapter(fa) {

    override fun getItemCount(): Int = ScreenSlidePagerFragment.itemsCount

    override fun createFragment(position: Int) = ScreenSlidePagerFragment(position)

    class ScreenSlidePagerFragment(private val position: Int) : Fragment() {
        companion object {
            private data class SlideItem(val title: String, val description: String, val image: Int)

            private val slideItems = listOf(
                SlideItem("STEP1", "hoge", R.drawable.shoebill),
                SlideItem("STEP2", "fuga", R.drawable.shoebill),
                SlideItem("STEP3", "piyo", R.drawable.shoebill)
            )

            val itemsCount = slideItems.size
        }

        override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
        ): View = inflater.inflate(R.layout.tutorial_slide_item, container, false).apply {
            slideItems[position].let {
                findViewById<TextView>(R.id.tutorial_title).text = it.title
                findViewById<TextView>(R.id.tutorial_description).text = it.description
                findViewById<ImageView>(R.id.tutorial_image).setImageResource(it.image)
            }
        }
    }
}
