package com.yhao.module

import android.annotation.SuppressLint
import android.content.pm.PackageManager
import android.graphics.Color
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_about_app.*

class AboutAppActivity : AppCompatActivity() {

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about_app)
        mCollapsingToolbarLayout.setExpandedTitleColor(Color.WHITE)
        mCollapsingToolbarLayout.setCollapsedTitleTextColor(Color.WHITE)
        mVersionTv.text = "v${getVersion()}"
        toolbar.setNavigationOnClickListener { finish() }
    }


    private fun getVersion(): String {
        try {
            val pi = packageManager.getPackageInfo(packageName, 0)
            return pi.versionName
        } catch (e: PackageManager.NameNotFoundException) {
            e.printStackTrace()
            return "1.0"
        }
    }

    override fun finish() {
        super.finish()
        overridePendingTransition(0, R.anim.out_to_right)
    }
}
