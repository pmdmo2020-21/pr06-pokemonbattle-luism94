package es.iessaladillo.pedrojoya.intents.ui.winner

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import es.iessaladillo.pedrojoya.intents.databinding.WinnerActivityBinding

class WinnerActivity : AppCompatActivity() {

    private lateinit var binding: WinnerActivityBinding
    private var winnerName: String = ""
    private var winnerImage: Int = 0

    companion object {
        const val NAME = "NAME"
        const val IMAGE = "IMAGE"
        fun newIntent(context: Context, name: String, image: Int): Intent {
            return Intent(context, WinnerActivity::class.java)
                .putExtra(NAME, name)
                .putExtra(IMAGE, image)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = WinnerActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)
        receiveData()
        setupViews()
    }

    private fun receiveData() {
        winnerName = intent.getStringExtra(NAME).toString()
        winnerImage = intent.getIntExtra(IMAGE,0)
    }

    private fun setupViews() {
        binding.textView2.text = winnerName
        binding.imageView3.setImageResource(winnerImage)
    }

}