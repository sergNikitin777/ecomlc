package ru.markstudio.kafkaiot.view

import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import ru.markstudio.kafkaiot.R
import ru.markstudio.kafkaiot.view.fragments.StartFragment

class MainActivity : AppCompatActivity(), StartFragment.OnFragmentInteractionListener {

    override fun onFragmentInteraction(uri: Uri) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//        navigateToStart()
    }

    fun navigateToStart() {
        supportFragmentManager.beginTransaction().add(
                R.id.content,
                StartFragment()
        ).commitAllowingStateLoss()
    }

    override fun onSupportNavigateUp() = findNavController(R.id.nav_host_fragment).navigateUp()
}
