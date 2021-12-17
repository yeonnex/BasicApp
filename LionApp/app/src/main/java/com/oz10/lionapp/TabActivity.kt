package com.oz10.lionapp

import android.os.Bundle
import android.widget.TableLayout
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import com.google.android.material.tabs.TabLayoutMediator
import com.oz10.lionapp.databinding.ActivityTabBinding
// 탭 인터페이스
// TabLayout 은 ViewPager2 클래스와 함께 사용되며 탭 기반 UI를 제공

class TabActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityTabBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityTabBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)


        binding.fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }
        configureTabLayout()
    }

    private fun configureTabLayout() {
        // 4개의 탭 생성
        repeat(4) {
            binding.tabLayout.addTab(binding.tabLayout.newTab())
        }
        // TabPagerAdapter 생성
        val adapter = TabPagerAdapter(this, binding.tabLayout.tabCount)
        binding.viewPager.adapter = adapter

        // Tablayout 을 ViewPager2 인스턴스와 연결
        TabLayoutMediator(binding.tabLayout, binding.viewPager) { tab, position ->
            tab.text = "Tab $position Item"
        }.attach()
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment_content_tab)
        return navController.navigateUp(appBarConfiguration)
                || super.onSupportNavigateUp()
    }
}