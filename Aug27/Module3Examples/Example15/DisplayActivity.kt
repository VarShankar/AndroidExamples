package com.varunshankar.example15

import androidx.appcompat.app.AppCompatActivity
import android.widget.TextView
import android.os.Bundle
import android.graphics.BitmapFactory
import android.view.View
import android.widget.ImageView

class DisplayActivity : AppCompatActivity() {
    var mTvFirstName: TextView? = null
    var mTvLastName: TextView? = null
    var mIvThumbnail: ImageView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_display)

        //Get the text views
        mTvFirstName = findViewById<View>(R.id.tv_fn_data) as TextView
        mTvLastName = findViewById<View>(R.id.tv_ln_data) as TextView

        //Get the image view
        mIvThumbnail = findViewById<View>(R.id.iv_pic) as ImageView

        //Get the starter intent
        val receivedIntent = intent

        //Set the text views
        mTvFirstName!!.text = receivedIntent.getStringExtra("FN_DATA")
        mTvLastName!!.text = receivedIntent.getStringExtra("LN_DATA")


        //Set the image view
        val imagePath = receivedIntent.getStringExtra("imagePath")
        val thumbnailImage = BitmapFactory.decodeFile(imagePath)
        if (thumbnailImage != null) {
            mIvThumbnail!!.setImageBitmap(thumbnailImage)
        }
    }
}