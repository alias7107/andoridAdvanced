package com.example.calculatormvp.model

import com.example.calculatormvp.contract.ContractInterface.*
import kotlin.properties.Delegates

class Model: ModelInterface {
    private var number:Double = 0.0
    private var number1: Double = 0.0

    private lateinit var delText: String
    private var action : String=""
    private var check: Boolean = true
    private var checkNumber: Boolean = true
    private var checkAction: Boolean = true
    private var delete: Boolean = true
    private var checkZero: Boolean = true
    private var first:String=""
    private var second:String=""
    private var answear:String=""


    private var thisNumber:Int=0




    override fun numberInput(number: String) {
        thisNumber = number.toInt()
        if(checkNumber&&checkZero) {
            if (action == "") {
                if(first=="0")
                    first=number
                else
                    first += number
            } else {
                second += number
            }
        }
    }

    override fun setAction(action: String) {
        check = true
        checkNumber = true
        checkAction = true
        this.action = action
    }

    override fun Answear(): String {
        return answear
    }

    override fun equalquery() {
        checkNumber = false
        check = false
        if(second.toInt()==0 && action == "/"){
            answear = ("Can not divide by 0").toString()
            first="0"
            delete = false
        }

        else {
            answear = (operation(first.toInt(), second.toInt())).toString()
            first = answear
            second = ""

            checkAction = false
        }
    }

    override fun delete() {
        if(delete) {

            if (action == "") {
                delText = first
                delText = delText.substring(0, delText.length - 1)
                answear = delText
                first = delText
            } else if (action.isNotEmpty() && checkAction) {
                delText = second
                delText = delText.substring(0, delText.length - 1)
                answear = delText
                second = delText
            } else {
                delText = answear
                delText = delText.substring(0, delText.length - 1)
                answear = delText
                first = delText
            }
        }

    }

    override fun clear() {
        checkNumber = true
        checkAction =true
        check = true
        delete = true
        first = "0"
        second = ""
        action = ""
    }


    fun operation(number: Int, number1: Int): Int {
        when(action){
            "+" ->
                return number+number1
            "-" ->
                return number-number1
            "*" ->
                return number*number1
            "/" ->
                return number/number1
        }

        return 0


    }

}