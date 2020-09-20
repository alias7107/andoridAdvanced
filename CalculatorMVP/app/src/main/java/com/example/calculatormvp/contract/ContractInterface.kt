package com.example.calculatormvp.contract

interface ContractInterface {
    interface ViewInterface{
        fun Display()


    }

    interface PresenterInterface{
        fun inputNumber(number:String)
        fun setAction(action: String)
        fun updateText():String
        fun equal()
        fun delete()
        fun clear()
        fun show()


    }

    interface ModelInterface{
        fun numberInput(number: String)
        fun setAction(action: String)
        fun Answear(): String
        fun equalquery()
        fun delete()
        fun clear()

    }
}