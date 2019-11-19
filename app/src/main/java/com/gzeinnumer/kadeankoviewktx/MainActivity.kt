package com.gzeinnumer.kadeankoviewktx

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import dmax.dialog.SpotsDialog
import org.jetbrains.anko.*
import org.jetbrains.anko.design.snackbar
import org.jetbrains.anko.sdk27.coroutines.onClick

class MainActivity : AppCompatActivity(), AnkoLogger {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        MainActivityUI().setContentView(this)

        //    implementation "org.jetbrains.anko:anko-commons:0.10.8"
        info("Hay Zein")
        debug(7)
        error(null)
    }

    class MainActivityUI : AnkoComponent<MainActivity> {

        private lateinit var alertDialog: android.app.AlertDialog

        override fun createView(ui: AnkoContext<MainActivity>) = with(ui) {
            verticalLayout {

                val tipeText = editText {
                    hint = "tipe somethink"
                }
                button("Toast") {
                    onClick {
                        toast("Hello!")
                        toast(R.string.demo)
                    }
                }
                button("Toast Long") {
                    onClick {
                        longToast("Selamat belajar!")
                    }
                }
                button("Alert") {
                    onClick {
                        alert("Happy Zein") {
                            yesButton { toast("Yes!!") }
                            noButton { toast("No!") }
                        }.show()
                    }
                }
                button("Selector") {
                    onClick {
                        val countries = listOf("M.", "Fadli", "Zein")
                        selector("Your nickname", countries, { dialogInterface, i ->
                            toast("So your nickname ${countries[i]} ya")
                        })
                    }
                }
                button("Snackbar") {
                    onClick {
                        //implementation "org.jetbrains.anko:anko-design:0.10.8"
                        //view.snackbar("Hi there!")
                        //view.snackbar(R.string.demo)
                        //view.longSnackbar("Wow, such duration")
                        view.snackbar("Action, reaction", "Click me!") { toast("Cliked") }
                    }
                }

                button("Loading...") {
                    onClick {
                        alertDialog = SpotsDialog.Builder()
                            .setContext(context)
                            .setMessage("Mohon Menunggu")
                            .setCancelable(false)
                            .build()

                        alertDialog.apply {
                            show()
                        }

//                        alertDialog.apply {
//                            dismiss()
//                        }
                    }
                }

                button("Intent"){
                    onClick {
                        //implementation "org.jetbrains.anko:anko-commons:0.10.8"
//                        startActivity(intentFor<MainActivity>("id" to 5).singleTop())
                        startActivity<MainActivity>("name" to "dicoding")
                    }
                }
            }
        }
    }
}
