package id.co.editya.simplewebview

import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        wv_home.webViewClient = WebViewClient() //  webclient default
//        (java->) wv_home.setWebViewClient(new WebViewClient())

        wv_home.webViewClient = CustomWeViewClient()  //  custom webviewclient
        wv_home.loadUrl("https://www.google.com")   //  url request
    }

    override fun onBackPressed() {
        if (wv_home.canGoBack()) {
            wv_home.goBack() // ketika back button di klik, lakukan goback di webview, jika tidak berada pada page pertama
        } else
            super.onBackPressed()
    }

    inner class CustomWeViewClient : WebViewClient() {
        override fun shouldOverrideUrlLoading(view: WebView?, url: String?): Boolean {  // ketika hyperlink pada web di klik, tidak akan mengarah ke browser lain
            view!!.loadUrl(url)
            return true
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
