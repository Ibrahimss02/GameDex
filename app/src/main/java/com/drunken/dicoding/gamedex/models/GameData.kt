package com.drunken.dicoding.gamedex.models

import com.drunken.dicoding.gamedex.R

object GameData {
    private val gameName = arrayOf("It Takes Two",
            "Assassin's Creed Valhalla",
            "Hades",
            "Devil May Cry 5",
            "The Legend of Zelda : Breath of the Wild",
            "VALORANT",
            "The Sims 4",
            "God of War",
            "Uncharted 4 : A Thief's End",
            "Super Mario Odyssey",
            "L.A. Noire",
            "Grand Theft Auto V"
    )

    private val gameDescription = arrayOf("It Takes Two is an action-adventure platformer developed by Hazelight Studios and published by Electronic Arts under the EA Originals label",
            "Assassin's Creed Valhalla is an action role-playing video game developed by Ubisoft Montreal and published by Ubisoft",
            "Hades is a roguelike action dungeon crawler video game developed and published by Supergiant Games",
            "Devil May Cry 5 is a 2019 action-adventure game developed and published by Capcom",
            "The Legend of Zelda: Breath of the Wild is a 2017 action-adventure game developed and published by Nintendo for the Nintendo Switch and Wii U consoles.",
            "Valorant is a free-to-play hero shooter developed and published by Riot",
            "The Sims 4 is a 2014 life simulation video game developed by the Redwood Shores studio of Maxis and published by Electronic Arts",
            "God of War is an action-adventure game developed by Santa Monica Studio and published by Sony Interactive Entertainment",
            "Uncharted 4: A Thief's End is a 2016 action-adventure game developed by Naughty Dog and published by Sony Computer Entertainment",
            "Super Mario Odyssey is a 2017 platform game developed and published by Nintendo for the Nintendo Switch",
            "L.A. Noire is a neo-noir detective action-adventure video game developed by Team Bondi and published by Rockstar Games",
            "Grand Theft Auto V is a 2013 action-adventure game developed by Rockstar North and published by Rockstar Games"
            )

    private val gamePublisher = arrayOf("Electronic Arts",
            "Ubisoft",
            "Supergiant Games",
            "Capcom",
            "Nintendo",
            "Riot Games",
            "Electronic Arts",
            "Sony Interactive Entertainment",
            "Sony Interactive Entertainment",
            "Nintendo",
            "Rockstar Games",
            "Rockstar Games"
            )

    private val gameRating = floatArrayOf(9.0F,
            8.0F,
            9.0F,
            9.5F,
            10.0F,
            9.0F,
            7.5F,
            10.0F,
            9.0F,
            10.0F,
            8.5F,
            10.0F
            )

    private val gameImage = intArrayOf(R.drawable.it_takes_two,
            R.drawable.valhalla,
            R.drawable.hades,
            R.drawable.dmc_5,
            R.drawable.zelda_botw,
            R.drawable.valorant,
            R.drawable.the_sims_4,
            R.drawable.god_of_war,
            R.drawable.uncharted_4,
            R.drawable.mario_odyssey,
            R.drawable.la_noire,
            R.drawable.gta_v
    )

    val listData : ArrayList<Game>
        get() {
            val list = arrayListOf<Game>()
            for (index in gameName.indices){
                val game = Game(
                        gameName[index],
                        gameDescription[index],
                        gamePublisher[index],
                        gameRating[index],
                        gameImage[index]
                )
                list.add(game)
            }
            return list
        }
}