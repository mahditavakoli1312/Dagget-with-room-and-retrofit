package com.example.dagger_with_room_retrofit_base_on_reqres

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

private const val TAG = "MainActivity"

class MainActivity : AppCompatActivity() {
    /*
        @Inject @Named("base_url") lateinit var baseUrl : String
    */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /*  DaggerNetworkComponent.factory().create().inject(
              this
          )

          Log.d(TAG, "onCreate: ${baseUrl}")*/
    }
}