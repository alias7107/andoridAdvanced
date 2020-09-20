package com.example.calculatormvp.presenter


import com.example.calculatormvp.contract.ContractInterface.*
import com.example.calculatormvp.model.Model

class Presenter(_view: ViewInterface): PresenterInterface {
    private var view: ViewInterface = _view
    private var model: ModelInterface = Model()




    override fun inputNumber(number: String) {
        model.numberInput(number)
    }

    override fun setAction(action: String) {
        model.setAction(action)
    }

    override fun updateText() = model.Answear()
    override fun equal() {
        model.equalquery()
    }

    override fun delete() {
        model.delete()
    }

    override fun clear() {
        model.clear()
    }

    override fun show(){
        view.Display()
    }


}