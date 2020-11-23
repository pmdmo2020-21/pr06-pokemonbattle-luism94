package es.iessaladillo.pedrojoya.intents.ui.battle

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import es.iessaladillo.pedrojoya.intents.data.local.Database
import es.iessaladillo.pedrojoya.intents.data.local.model.Pokemon
import es.iessaladillo.pedrojoya.intents.databinding.BattleActivityBinding
import es.iessaladillo.pedrojoya.intents.ui.selection.SelectionActivity
import es.iessaladillo.pedrojoya.intents.ui.winner.WinnerActivity

class BattleActivity : AppCompatActivity() {

    private lateinit var binding: BattleActivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = BattleActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupViews()
    }

    private fun setupViews() {
        var pokemon1: Pokemon = Database.getRandomPokemon()
        var pokemon2: Pokemon = Database.getRandomPokemon()

        showPokemon1(pokemon1)
        showPokemon2(pokemon2)


        binding.mainBtn.setOnClickListener {
            startBattle(pokemon1, pokemon2)
        }

        binding.mainPkmn1.setOnClickListener(View.OnClickListener {
            chooseOpponent(pokemon1)
        })
    }

    private fun chooseOpponent(pokemon: Pokemon) {
        startActivity(SelectionActivity.newIntent(this, pokemon.getName()))
    }

    private fun showPokemon2(pokemon2: Pokemon) {
        binding.mainPkmn1Icon.setImageResource(pokemon2.getImage())
        binding.lblPkmn1Name.text = pokemon2.getName()
    }

    private fun showPokemon1(pokemon1: Pokemon) {
        binding.mainPkmn1Icon.setImageResource(pokemon1.getImage())
        binding.lblPkmn1Name.text = pokemon1.getName()
    }

    private fun startBattle(pokemon1: Pokemon, pokemon2: Pokemon) {
        var winner: Pokemon
        var pkmn1Strenght = pokemon1.getStrength()
        var pkmn2Strenght = pokemon2.getStrength()

        if (pkmn1Strenght >= pkmn2Strenght) {
             winner = pokemon1
        } else {
             winner = pokemon2
        }

        startActivity(WinnerActivity.newIntent(this, winner.getName(), winner.getImage()))
    }


}