package com.example.calculatormvp.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import com.example.calculatormvp.R
import com.example.calculatormvp.contract.ContractInterface.*
import com.example.calculatormvp.presenter.Presenter
import java.lang.Exception


class MainActivity : AppCompatActivity(), View.OnClickListener, ViewInterface {
    private var presenter: Presenter?=null
    private lateinit var numberInput: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        numberInput = findViewById(R.id.inputoutputtext)
        presenter = Presenter(this)
    }




    override fun onClick(v: View) {
        try {

            when (v.id) {
                R.id.btn_one -> {
                    presenter?.inputNumber("1")
                    numberInput.append("1")
                }
                R.id.btn_two -> {
                    presenter?.inputNumber("2")
                    numberInput.append("2")
                }
                R.id.btn_three -> {
                    presenter?.inputNumber("3")
                    numberInput.append("3")
                }
                R.id.btn_four -> {
                    presenter?.inputNumber("4")
                    numberInput.append("4")
                }
                R.id.btn_five -> {
                    presenter?.inputNumber("5")
                    numberInput.append("5")
                }
                R.id.btn_six -> {
                    presenter?.inputNumber("6")
                    numberInput.append("6")
                }
                R.id.btn_seven -> {
                    presenter?.inputNumber("7")
                    numberInput.append("7")
                }
                R.id.btn_eight -> {
                    presenter?.inputNumber("8")
                    numberInput.append("8")
                }
                R.id.btn_nine -> {
                    presenter?.inputNumber("9")
                    numberInput.append("9")
                }
                R.id.btn_zero -> {
                    presenter?.inputNumber("0")
                    numberInput.append("0")
                }
                R.id.btn_plus -> {
                    presenter?.setAction("+")
                    numberInput.text = ""
                }
                R.id.btn_minus -> {
                    presenter?.setAction("-")
                    numberInput.text = ""
                }
                R.id.btn_mult -> {
                    presenter?.setAction("*")
                    numberInput.text = ""
                }
                R.id.btn_divide -> {
                    presenter?.setAction("/")
                    numberInput.text = ""
                }
                R.id.btn_equal -> {
                    presenter?.equal()
                    presenter?.show()

                }
                R.id.btn_del -> {
                    presenter?.delete()
                    presenter?.show()
                }
                R.id.btn_c -> {
                    presenter?.clear()
                    numberInput.text = ""
                }

            }
        } catch (e:Exception) {
            numberInput.text = "Wrong operation, Pleace press C"
        }






    }

    override fun Display() {
        numberInput.text = presenter?.updateText()
    }
}
