package com.example.ui.activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.dao.ProdutosDao
import com.example.orgs.R
import com.example.ui.recyclerview.adpter.ListProductiveness
import com.google.android.material.floatingactionbutton.FloatingActionButton


class ListaProdutosActivity : AppCompatActivity(R.layout.activity_lista_produtos) {
    private val dao = ProdutosDao()
    private val adapter = ListProductiveness(context = this, produtos = dao.buscaTodos())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.ConfiguraRecyclerView()
        this.ConfiguraFab()
    }

    override fun onResume() {
        super.onResume()
        adapter.atualiza(dao.buscaTodos())
    }

    private fun ConfiguraRecyclerView()
    {
        // Usando o adapter
        val recyclerView = findViewById<RecyclerView>(R.id.recycleView)
        val dao = ProdutosDao()
        Log.i("ListaProdutosActivity", "onCreate: ${dao.buscaTodos()}")
        recyclerView.adapter = this.adapter
    }

    private fun ConfiguraFab(){
        val fab = findViewById<FloatingActionButton>(R.id.adicionarItem)
        fab.setOnClickListener {
            val intent = Intent(this, FormularioProdutoActivity::class.java)
            startActivity(intent)
        }
    }
}
