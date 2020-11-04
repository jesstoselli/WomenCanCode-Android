package com.androidwcc.whatdidilearn.data

import com.androidwcc.whatdidilearn.entities.ItemLearned
import com.androidwcc.whatdidilearn.entities.UnderstandingLevel

class DatabaseItems {

    fun getAll(): List<ItemLearned> {
        val itemOne = ItemLearned(
            "Kotlin - Null safety",
            "O sistema de tipos de Kotlin visa eliminar o perigo de referências nulas do código.",
            UnderstandingLevel.HIGH)

        val itemTwo = ItemLearned(
            "Layout editor",
            "O Design Editor exibe o layout em vários dispositivos e versões do Android.É possível criar e editar um layout usando apenas componentes visuais.",
            UnderstandingLevel.MEDIUM
        )

        val itemThree = ItemLearned(
            "Git",
            "É um sistema de controle de versão distribuído. Com ele é possível rastrear mudanças no código-fonte durante o desenvolvimento de software.",
            UnderstandingLevel.MEDIUM
        )

        val itemFour = ItemLearned(
            "GroupView",
            "É uma view especial que pode conter outras views (chamadas de filhos).É a classe base para layouts e contêineres de views.",
            UnderstandingLevel.HIGH
        )

        val itemFive = ItemLearned(
            "View Binding",
            "View Binding é um recurso que facilita a programação de códigos que interagem com views.\n",
            UnderstandingLevel.LOW


        )

        return listOf<ItemLearned>(itemOne, itemTwo, itemThree, itemFour, itemFive)
    }
}