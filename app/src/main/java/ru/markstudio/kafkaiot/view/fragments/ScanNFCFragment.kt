package ru.markstudio.kafkaiot.view.fragments

import android.nfc.NfcAdapter
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.NavHostFragment
import ru.markstudio.kafkaiot.R
import java.util.concurrent.Executors
import java.util.concurrent.TimeUnit

class ScanNFCFragment : Fragment() {

    var nfcAdapter: NfcAdapter? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_scan_nfc, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initNFC()
    }

    private fun initNFC() {
        nfcAdapter = NfcAdapter.getDefaultAdapter(context)

        nfcAdapter?.let {

        } ?: run {
            Toast.makeText(context, "This device doesn't support NFC.", Toast.LENGTH_LONG).show()

            // Какой то баг в архитектурных компонентах - ниже воркараунд
//            NavHostFragment.findNavController(this).navigate(R.id.actionNoNfc)

            val executor = Executors.newSingleThreadScheduledExecutor()
            executor.schedule({
                activity?.runOnUiThread { NavHostFragment.findNavController(this)
                        .navigate(R.id.actionNoNfc) }
            }, 1, TimeUnit.MILLISECONDS)
        }
    }

}
