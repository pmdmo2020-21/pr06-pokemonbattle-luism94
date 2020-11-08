package es.iessaladillo.pedrojoya.intents.ui.selection

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import es.iessaladillo.pedrojoya.intents.databinding.SelectionActivityBinding

class SelectionActivity : AppCompatActivity() {

    private lateinit var binding: SelectionActivityBinding
    private var name: String = ""


    companion object {
        const val NAME = "NAME"
        fun newIntent(context: Context, name: String): Intent {
            return Intent(context, SelectionActivity::class.java)
                .putExtra(NAME, name)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = SelectionActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)
        receiveData()
        setupViews()
    }

    private fun receiveData() {
        name = intent.getStringExtra(NAME).toString()
    }

    private fun setupViews() {
        if (name == "Bulbasaur") {
            choosePokemon(1)
        } else if (name == "Cubone") {
            choosePokemon(2)
        } else if (name == "Feebas") {
            choosePokemon(3)
        } else if (name == "Giratina") {
            choosePokemon(4)
        } else if (name == "Gyarados") {
            choosePokemon(5)
        } else if (name == "Pikachu") {
            choosePokemon(6)
        }

        binding.iconPkmn1.setOnClickListener(View.OnClickListener { v -> choosePokemon(1) })
        binding.iconPkmn2.setOnClickListener(View.OnClickListener { v -> choosePokemon(2) })
        binding.iconPkmn3.setOnClickListener(View.OnClickListener { v -> choosePokemon(3) })
        binding.iconPkmn4.setOnClickListener(View.OnClickListener { v -> choosePokemon(4) })
        binding.iconPkmn5.setOnClickListener(View.OnClickListener { v -> choosePokemon(5) })
        binding.iconPkmn6.setOnClickListener(View.OnClickListener { v -> choosePokemon(6) })
    }

    private fun choosePokemon(option: Int) {
        when (option) {
            1 -> {
                binding.optionPkmn1.isChecked = true
                binding.optionPkmn2.isChecked = false
                binding.optionPkmn3.isChecked = false
                binding.optionPkmn4.isChecked = false
                binding.optionPkmn5.isChecked = false
                binding.optionPkmn6.isChecked = false
            }

            2 -> {
                binding.optionPkmn1.isChecked = false
                binding.optionPkmn2.isChecked = true
                binding.optionPkmn3.isChecked = false
                binding.optionPkmn4.isChecked = false
                binding.optionPkmn5.isChecked = false
                binding.optionPkmn6.isChecked = false
            }

            3 -> {
                binding.optionPkmn1.isChecked = false
                binding.optionPkmn2.isChecked = false
                binding.optionPkmn3.isChecked = true
                binding.optionPkmn4.isChecked = false
                binding.optionPkmn5.isChecked = false
                binding.optionPkmn6.isChecked = false
            }

            4 -> {
                binding.optionPkmn1.isChecked = false
                binding.optionPkmn2.isChecked = false
                binding.optionPkmn3.isChecked = false
                binding.optionPkmn4.isChecked = true
                binding.optionPkmn5.isChecked = false
                binding.optionPkmn6.isChecked = false
            }

            5 -> {
                binding.optionPkmn1.isChecked = false
                binding.optionPkmn2.isChecked = false
                binding.optionPkmn3.isChecked = false
                binding.optionPkmn4.isChecked = false
                binding.optionPkmn5.isChecked = true
                binding.optionPkmn6.isChecked = false
            }

            6 -> {
                binding.optionPkmn1.isChecked = false
                binding.optionPkmn2.isChecked = false
                binding.optionPkmn3.isChecked = false
                binding.optionPkmn4.isChecked = false
                binding.optionPkmn5.isChecked = false
                binding.optionPkmn6.isChecked = true
            }
        }
    }

    override fun onBackPressed() {
        // TODO: AQUÍ ES DONDE DEBES ESTABLECER EL RESULTADO CON setResult()
        // ...
        super.onBackPressed()
    }

}