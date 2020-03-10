package id.co.editya.simplewebview

import android.os.Bundle
import android.os.Handler
import android.webkit.WebChromeClient
import android.webkit.WebSettings
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val webSettings: WebSettings = wv_home.settings
        webSettings.javaScriptEnabled = true
        webSettings.domStorageEnabled = true
        webSettings.loadWithOverviewMode = true
        webSettings.useWideViewPort = true
        webSettings.builtInZoomControls = true
        webSettings.displayZoomControls = false
        webSettings.setSupportZoom(true)
        webSettings.defaultTextEncodingName = "utf-8"
        webSettings.pluginState = WebSettings.PluginState.ON

        wv_home.webViewClient = CustomWeViewClient()  //  set custom webviewclient
        //        (java->) wv_home.setWebViewClient(new WebViewClient())

        wv_home.webChromeClient = WebChromeClient()  // set default WebChromeClient

        wv_home.loadUrl("http://156.67.220.101:8099/user-login")   //  url request
    }

    override fun onBackPressed() {
        if (wv_home.canGoBack()) {
            wv_home.goBack() // ketika back button di klik, lakukan goback di webview, jika tidak berada pada page pertama
        } else
            super.onBackPressed()
    }

    inner class CustomWeViewClient : WebViewClient() {
        override fun shouldOverrideUrlLoading(
            view: WebView?,
            url: String?
        ): Boolean {  // ketika hyperlink pada web di klik, tidak akan mengarah ke browser lain
            view!!.loadUrl(url)
            return true
        }

        override fun onPageFinished(view: WebView?, url: String?) {
            super.onPageFinished(view, url)
            Handler().postDelayed({
                //update your view with js here
                super.onPageFinished(view, url)
            }, 1000)
        }
    }

    /* (java->)
    class CustomWeViewClient extend WebViewClient {
      @Override
      public boolean shouldOverrideUrlLoading(WebView view, String : url){
          view.loadUrl(url)
          return true
      }
    */
}



