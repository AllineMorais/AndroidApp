package com.example.ui.activity
import android.app.Activity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.model.Produto
import com.example.orgs.R
import com.example.ui.recyclerview.adpter.ListProductiveness
import java.math.BigDecimal

class MainActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //Toast.makeText(this, "Bem-vindo!", Toast.LENGTH_SHORT).show()R
       // val view = View(this)
        //val textView = TextView(this)
        //textView.setText("Hello Word!")
        setContentView(R.layout.activity_main)
        //val nome = findViewById<TextView>(R.id.nome)
        //nome.text = "Descricao"
       // val descricao = findViewById<TextView>(R.id.descricao)
        val recycleView = findViewById<RecyclerView>(R.id.recycleView)
       recycleView.adapter = ListProductiveness(context = this, produtos = listOf(
           Produto(nome = "Morango", descricao = "Desc 1", valor = BigDecimal("12.90")),
           Produto(nome = "Laranjas", descricao = "Desc 2", valor = BigDecimal("16.90"))
       ))
      // recycleView.layoutManager = LinearLayoutManager(this)
    }
}


