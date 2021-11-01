package com.example.registrationcardproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract
import android.text.TextUtils
import android.view.View
import android.widget.Button
import android.widget.Toast
import com.example.registrationcardproject.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar
import java.util.jar.Attributes

class MainActivity : AppCompatActivity() {
    lateinit var Binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

       Binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(Binding.root)


        Binding.Registration.setOnClickListener { ShowInformations() } // call fun on button
    }

    private fun ShowInformations() {



        val inputName = Binding.inputName.text.toString()
        val inputPass1 = Binding.inputPassword.text.toString()
        val inputPass2 = Binding.inputRepassword.text.toString()
        val inputBdate = Binding.inputBarthday.text.toString()
        var Email = Binding.inputEmail.text.toString()
        var emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+"

        val Gender = when (Binding.radioGroup.checkedRadioButtonId) {
            Binding.male.id -> Binding.male.text.toString()
            Binding.Female.id -> Binding.Female.text.toString()
            else -> "None"
        } // end when to get the Percentage Of Tip


        TextUtils.isEmpty(inputPass1) &&
                TextUtils.isEmpty(inputPass2) &&
                TextUtils.isEmpty(inputBdate)
//
        if (TextUtils.isEmpty(inputName) == false &&
            TextUtils.isEmpty(inputPass1) == false &&
            TextUtils.isEmpty(inputPass2) == false &&
            TextUtils.isEmpty(inputBdate) == false) {

            if(Email.trim { it <= ' ' }.matches(emailPattern.toRegex()) == false){
                Toast.makeText(applicationContext, "Invalid email address", Toast.LENGTH_SHORT).show()
            }
            else if (inputPass1 == inputPass2) {

                Binding.viewInfo.setText(
                    "Your Informations is \n" +
                            "Name: $inputName \n" +
                            "Email: $Email \n" +
                            "Date: $inputBdate \n" +
                            "Gender: $Gender \n"


                )
            } // end if pass
            else
                IsSamePassword()
        } // end if are not null
        else
            IsNullInfo()

    } // end fun of Show Informations


    private fun IsNullInfo() {
        Snackbar.make( findViewById(R.id.App), "Sorry some info is empty", Snackbar.LENGTH_SHORT).show()
    }  // end Is Null Info

    private fun IsEmail() {
        var Email = Binding.inputEmail.text.toString()
        var emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+"

        if (Email.trim { it <= ' ' }.matches(emailPattern.toRegex()) == false) {
            Toast.makeText(applicationContext, "Invalid email address", Toast.LENGTH_SHORT).show()
        }
    }// end isEmail (Never Use)

    private fun IsSamePassword() {
        Snackbar.make(
            findViewById(R.id.App),
            "Sorry the password is not the same",
            Snackbar.LENGTH_SHORT
        ).show()
    }  // end Is Same Password

} // end class