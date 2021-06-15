package kr.co.hanbit.networkretrofit

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import org.sumin.githubapi.Repository
import org.sumin.githubapi.RepositoryItem
import org.sumin.githubapi.databinding.ItemRecyclerBinding

class CustomAdapter: RecyclerView.Adapter<Holder>() {
    var userList: Repository? = null
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val binding = ItemRecyclerBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return Holder(binding)
    }

    override fun getItemCount(): Int {      //총 아이템 개수 구하기
        return userList?.size?: 0
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        val user = userList?.get(position)
        holder.setUser(user)
    }
}
class Holder(val binding: ItemRecyclerBinding):RecyclerView.ViewHolder(binding.root){
    fun setUser(user: RepositoryItem?){
        user?.let{
            binding.textName.text = user.name
            binding.textId.text = user.node_id
            Glide.with(binding.imageAvatar).load(user.owner.avatar_url).into(binding.imageAvatar)
        }
    }
}