package id.co.editya.simplewebview

import android.os.Bundle
import android.webkit.WebViewClient
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        wv_home.webViewClient = WebViewClient() // wv_home.setWbViewClinet(new WebViewClient())
        wv_home.loadUrl("https://www.google.com")
    }

    override fun onBackPressed() {

        if (wv_home.canGoBack()) {
            wv_home.goBack()
        } else
            super.onBackPressed()

    }
}
