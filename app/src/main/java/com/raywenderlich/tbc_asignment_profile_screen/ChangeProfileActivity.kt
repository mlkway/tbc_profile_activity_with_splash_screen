package com.raywenderlich.tbc_asignment_profile_screen


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.raywenderlich.tbc_asignment_profile_screen.databinding.ActivityChangeProfileBinding

class ChangeProfileActivity : AppCompatActivity() {


    private lateinit var binding: ActivityChangeProfileBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityChangeProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)
        init()

    }


    private fun makeToast(str: String){
        Toast.makeText(this, str,Toast.LENGTH_SHORT).show()
    }

    private fun init(){

        binding.saveDataButton.setOnClickListener{


            if (!binding.editTextTextPersonName.text.isNullOrBlank() &&
                !binding.editTextLastName.text.isNullOrBlank()
                && !binding.editTextDate.text.isNullOrBlank()
                && !binding.editTextTextEmailAddress.text.isNullOrBlank()){

                if (binding.femaleRadioButton.isChecked || binding.maleRadioButton.isChecked){

                    val profile = Profile(name = binding.editTextLastName.text.toString(),
                        lastName = binding.editTextLastName.text.toString(),
                        email = binding.editTextTextPersonName.text.toString(),
                        date = binding.editTextDate.text.toString(),
                        gender = binding.radioGroup2.checkedRadioButtonId)
                        returnResult(profile)

                }else{
                    makeToast("Check Your gender")
                }
            }else{
                makeToast("fill all inputs")
            }
        }


    }


    private fun returnResult(profile: Profile){
         val intent = Intent()
        intent.putExtra("profile", profile)
        setResult(RESULT_OK, intent)
        finish()

    }



}