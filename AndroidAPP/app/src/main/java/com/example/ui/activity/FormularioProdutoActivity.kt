package com.example.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import com.example.dao.ProdutosDao
import com.example.model.Produto
import com.example.orgs.R
import java.math.BigDecimal

class FormularioProdutoActivity : AppCompatActivity(R.layout.activity_formulario_produtos) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.configuraBotaoSalvar()
    }

    private fun configuraBotaoSalvar() {
        val botaoSalvar = findViewById<Button>(R.id.salvar)
        botaoSalvar.setOnClickListener{
            val campoNome = findViewById<EditText>(R.id.nome)
            val nome = campoNome.text.toString()
            val CampoDescricao = findViewById<EditText>(R.id.descricao)
            val descricao = CampoDescricao.text.toString()
            val CampoValor = findViewById<EditText>(R.id.valor)
            val ValorEmTexto = CampoValor.text.toString()

            val valor = if(ValorEmTexto.isBlank())
            {
                BigDecimal.ZERO
            }
            else
            {
                BigDecimal(ValorEmTexto)
            }

            val ProdutoNovo = Produto(
                nome = nome,
                descricao = descricao,
                valor = valor
            )

            this.adicionaProdutolista(ProdutoNovo)
        }
    }

    private fun adicionaProdutolista(produtoNovo: Produto) {
        val dao = ProdutosDao()
        dao.adicionarProduto(produtoNovo)
        Log.i("FormularioProduto","OnCreate ${dao.buscaTodos()}")
        finish()
    }


}


