package com.akshay.dragonballteam

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.akshay.dragonballteam.DataBinding.DragonTeamDataBingingAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val dragonTeamList = listOf(
            DragonTeamData(
                "Goku",
                "https://vignette.wikia.nocookie.net/dragonball/images/5/5b/Gokusteppingoutofaspaceship.jpg/revision/latest?cb=20150325220848"
            ),
            DragonTeamData(
                "Bulma",
                "https://vignette.wikia.nocookie.net/dragonball/images/e/eb/Bulma_-_Blood_Rubies_-_000.png/revision/latest/scale-to-width-down/628?cb=20191109020452"
            ),
            DragonTeamData(
                "Oolong",
                "https://vignette.wikia.nocookie.net/dragonball/images/7/79/OolongWMATEp17.png/revision/latest?cb=20101005205111"
            ),
            DragonTeamData(
                "Yamcha",
                "https://vignette.wikia.nocookie.net/dragonball/images/f/fd/Yamcha_DB_Ep_138_001.png/revision/latest/scale-to-width-down/472?cb=20171021170338"
            ),
            DragonTeamData("Puar"),
            DragonTeamData("Master Roshi"),
            DragonTeamData("Krillin"),
            DragonTeamData("Tien Shinhan"),
            DragonTeamData("Chiaotzu"),
            DragonTeamData("Yajirobe"),
            DragonTeamData("Piccolo")
        )

        setUpRecyclerView(dragonTeamList)
    }

    private fun setUpRecyclerView(list: List<DragonTeamData>) {
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = DragonTeamDataBingingAdapter(list)
    }
}
