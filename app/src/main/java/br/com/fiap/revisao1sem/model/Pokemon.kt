package br.com.fiap.revisao1sem.model

import android.graphics.drawable.Drawable
import com.google.gson.annotations.SerializedName

data class Pokemon(@SerializedName("number") val numero: String,
                   @SerializedName("name") val name: String,
                   @SerializedName("attack") val ataque: Int,
                   @SerializedName("defense") val defesa: Int,
                   @SerializedName("geration") val geração: Int,
                   @SerializedName("id") val id : Int,
                   @SerializedName("ps") val ps: Int,
                   @SerializedName("velocity") val velocidade: Int,
                   @SerializedName("imageURL") val urlImagem: String)