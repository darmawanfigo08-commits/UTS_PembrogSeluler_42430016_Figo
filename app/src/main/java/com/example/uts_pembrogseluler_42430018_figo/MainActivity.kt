package com.example.uts_pembrogseluler_42430018_figo

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val etDosen = findViewById<EditText>(R.id.etDosen)
        val etMatkul = findViewById<EditText>(R.id.etMatkul)
        val etJumlah = findViewById<EditText>(R.id.etJumlah)
        val rgTipe = findViewById<RadioGroup>(R.id.rgTipe)
        val btnGenerate = findViewById<Button>(R.id.btnGenerate)

        btnGenerate.setOnClickListener {
            val dosen = etDosen.text.toString()
            val matkul = etMatkul.text.toString()
            val jumlahStr = etJumlah.text.toString()
            val selectedTypeId = rgTipe.checkedRadioButtonId

            // Validasi input tidak boleh kosong
            if (dosen.isEmpty() || matkul.isEmpty() || jumlahStr.isEmpty() || selectedTypeId == -1) {
                Toast.makeText(this, "Harap lengkapi semua data!", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val rbTipe = findViewById<RadioButton>(selectedTypeId)
            val tipeKelas = rbTipe.text.toString()

            // Modul 4: Data Passing menggunakan Intent
            val intent = Intent(this, MainActivity2::class.java).apply {
                putExtra("DOSEN", dosen)
                putExtra("MATKUL", matkul)
                putExtra("JUMLAH", jumlahStr.toInt())
                putExtra("TIPE", tipeKelas)
            }
            startActivity(intent)
        }
    }
}