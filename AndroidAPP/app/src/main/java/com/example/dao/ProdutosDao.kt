package com.example.dao

import com.example.model.Produto

class ProdutosDao {
    fun adicionarProduto(produto: Produto)
    {
        produtos.add(produto)
    }

    fun buscaTodos() : List<Produto>
    {
        return  produtos.toList()
    }

    companion object {
        private  val produtos = mutableListOf<Produto>()
    }
}