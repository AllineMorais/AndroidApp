package com.example.ui.recyclerview.adpter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.model.Produto
import com.example.orgs.R

class ListProductiveness(
    private val context: Context,
    produtos: List<Produto>
) : RecyclerView.Adapter<ListProductiveness.ViewHolder>() {

    private val produtos = produtos.toMutableList()

   class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
       fun Vincula(produto: Produto) {
           val nome = itemView.findViewById<TextView>(R.id.nome)
           nome.text = produto.nome
           val descricao = itemView.findViewById<TextView>(R.id.descricao)
           descricao.text = produto.descricao
           val valor = itemView.findViewById<TextView>(R.id.preco)
           valor.text = produto.valor.toEngineeringString()
       }
   }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
       val inflater = LayoutInflater.from(context)
       val view = inflater.inflate(R.layout.produto_item, parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val produto = produtos[position]
        holder.Vincula(produto)
    }


    override fun getItemCount(): Int = produtos.size
    fun atualiza(produtos: List<Produto>) {
        this.produtos.clear()
        this.produtos.addAll(produtos)
        notifyDataSetChanged()
    }
}
