package com.example.uts_pembrogseluler_42430018_figo

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        val tvInfo = findViewById<TextView>(R.id.tvInfo)
        val tvStatus = findViewById<TextView>(R.id.tvStatus)
        val tvList = findViewById<TextView>(R.id.tvList)
        val btnBack = findViewById<Button>(R.id.btnBack)

        // Menerima data dari Intent
        val dosen = intent.getStringExtra("DOSEN") ?: "-"
        val matkul = intent.getStringExtra("MATKUL") ?: "-"
        val jumlah = intent.getIntExtra("JUMLAH", 0)
        val tipe = intent.getStringExtra("TIPE") ?: "-"

        tvInfo.text = "Dosen: $dosen\nMata Kuliah: $matkul\nTotal Mahasiswa: $jumlah"

        // Modul 5: Percabangan If-Else
        val statusKelas: String
        if (jumlah == 0) {
            statusKelas = "Status: Kelas Dibatalkan (Mahasiswa Kosong)"
        } else if (jumlah > 40) {
            statusKelas = "Status: Kelas Overload ($tipe) - Butuh Ruang Ekstra"
        } else {
            statusKelas = "Status: Kelas Berjalan Normal ($tipe)"
        }
        tvStatus.text = statusKelas

        // Modul 5: Perulangan For Loop
        val listBuilder = StringBuilder()
        for (i in 1..jumlah) {
            listBuilder.append("$i. Nama: ________________________ | Nilai: ______\n\n")
        }
        tvList.text = listBuilder.toString()

        btnBack.setOnClickListener {
            finish() // Kembali ke halaman sebelumnya
        }
    }
}