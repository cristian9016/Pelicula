package com.example.cristiandev.utils

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.content.SharedPreferences
import android.support.v7.app.AppCompatActivity
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.EditText
import io.reactivex.Observable
import org.jetbrains.anko.toast
import kotlin.reflect.KClass

/**
 * Created by jlbel on 11/10/2017.
 */
fun EditText.text(): String = text.toString()

fun ViewGroup.inflate(layout: Int) = LayoutInflater.from(context).inflate(layout, this, false)

fun <T: ViewModel> AppCompatActivity.buildViewModel(factory: ViewModelProvider.Factory, kClass: KClass<T>):T
        = ViewModelProviders.of(this, factory).get(kClass.java)

fun SharedPreferences.save(vararg data:Pair<String, Any>){
    val editor =  edit()
    data.forEach { (key, value)->
        when(value){
            is String -> editor.putString(key, value)
            is Int -> editor.putInt(key, value)
            is Boolean -> editor.putBoolean(key, value)
            is Long -> editor.putLong(key, value)
        }

    }
    editor.apply()
}

fun AppCompatActivity.validateForm(message: Int,
                                   vararg fields: String) : Observable<List<String>>
        = Observable.create<List<String>>{
    if(fields.contains("")) toast(message)
    else it.onNext(fields.toList())
    it.onComplete()
}

fun isOnlineNet():Boolean{
    try {
        val process:Process = Runtime.getRuntime().exec("ping -c 1 www.google.es")
        return (process.waitFor() == 0)
    }catch (e:Exception){
        e.printStackTrace()
    }
    return false
}