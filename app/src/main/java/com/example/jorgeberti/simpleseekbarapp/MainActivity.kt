package com.example.jorgeberti.simpleseekbarapp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.SeekBar
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val initialTextViewTranslationY = textViewProgress.translationY

        seekBar.setOnSeekBarChangeListener(object: SeekBar.OnSeekBarChangeListener{
            override fun onStartTrackingTouch(seekBar: SeekBar?) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                textViewProgress.text = progress.toString()
                val transitionDistance = ( initialTextViewTranslationY + progress * resources.getDimension(R.dimen.text_anim_step) * -1)

                textViewProgress.animate().translationY(transitionDistance)

                if (!fromUser)
                    textViewProgress.animate().setDuration(500).rotationBy(360f).translationY(initialTextViewTranslationY)
            }

        } )

        btnReset.setOnClickListener{
            seekBar.progress = 0


        }
    }
}
