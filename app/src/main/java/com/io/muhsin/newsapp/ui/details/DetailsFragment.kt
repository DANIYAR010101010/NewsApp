package com.io.muhsin.newsapp.ui.details

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.URLUtil
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.io.muhsin.newsapp.R
import com.io.muhsin.newsapp.databinding.FragmentDetailsBinding
import com.io.muhsin.newsapp.models.Article
import dagger.hilt.android.AndroidEntryPoint
import java.lang.Exception

@AndroidEntryPoint
class DetailsFragment : Fragment() {

    private lateinit var binding: FragmentDetailsBinding
    private val bundleArgs: DetailsFragmentArgs by navArgs()
    private val viewModel by viewModels<DetailsViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentDetailsBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val articleArg = bundleArgs.article

        articleArg.let { article ->
            article.urlToImage.let {
                Glide.with(this).load(article.urlToImage).into(binding.headImage1)
            }
            binding.headImage1.clipToOutline = true
            binding.tvArticleTitle.text = article.title
            binding.tvArticleTitleDescription.text = article.description

            binding.btnDt.setOnClickListener {
                try {
                    Intent()
                        .setAction(Intent.ACTION_VIEW)
                        .addCategory(Intent.CATEGORY_BROWSABLE)
                        .setData(Uri.parse(takeIf { URLUtil.isValidUrl(article.url) }
                            ?.let {
                                article.url
                            } ?: "http//google.com"))
                        .let {
                            ContextCompat.startActivity(requireActivity(), it, null)
                        }
                } catch (e: Exception) {
                    Toast.makeText(context,
                        "The device doesn't have any browser to view the document",
                        Toast.LENGTH_SHORT).show()
                }
            }
            binding.ivHeart2.setOnClickListener{
                viewModel.saveFavouriteArticle(article)
            }
        }
    }


}