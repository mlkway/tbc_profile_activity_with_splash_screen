package com.raywenderlich.tbc_asignment_profile_screen

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.widget.RadioButton
import com.raywenderlich.tbc_asignment_profile_screen.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        init()


    }

    private fun init(){

        binding.maleRadioButton.apply {

        }
        binding.femaleRadioButton.apply {

        }

        binding.profileChangeButton.setOnClickListener {
            startActivityForResult(Intent(this, ChangeProfileActivity::class.java), REQUEST_CODE)
        }



    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == REQUEST_CODE && resultCode == RESULT_OK){


            binding.apply {

                    val profile = data?.getParcelableExtra<Profile>("profile")

                    emailTextView.text = profile?.email
                    firstNameTextView.text = profile?.name
                    lastNameTextView.text = profile?.lastName
                    dateTextView.text = profile?.date
                    radioGroup.check(profile?.gender!!)
                    if (femaleRadioButton.isChecked) {
                        imageView.setImageResource(R.mipmap.woman)
                    } else {
                        imageView.setImageResource(R.mipmap.profile)
                    }


                }




        }

    }



    companion object {
        const val REQUEST_CODE = 0
    }



}