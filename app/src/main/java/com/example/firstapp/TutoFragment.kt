//package com.example.firstapp
//
//import android.R
//import android.animation.Animator
//import android.animation.AnimatorListenerAdapter
//import android.animation.AnimatorSet
//import android.animation.ObjectAnimator
//import android.app.Activity
//import android.support.v17.leanback.app.OnboardingSupportFragment
//import android.view.LayoutInflater
//import android.view.View
//import android.view.ViewGroup
//import android.view.ViewGroup.MarginLayoutParams
//import android.widget.ImageView
//import androidx.fragment.app.Fragment
//import androidx.leanback.app.OnboardingSupportFragment
//
//
//// TODO: Rename parameter arguments, choose names that match
//// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
//private const val ARG_PARAM1 = "param1"
//private const val ARG_PARAM2 = "param2"
//
///**
// * A simple [Fragment] subclass.
// * Use the [TutoFragment.newInstance] factory method to
// * create an instance of this fragment.
// */
//class TutoFragment : OnboardingSupportFragment() {
//    private lateinit var mTitles: Array<String>
//    private lateinit var mDescriptions: Array<String>
//    private var mBackgroundView: View? = null
//    private var mContentView: ImageView? = null
//    private val mImage1: ImageView? = null
//    private val mImage2: ImageView? = null
//    private var mContentAnimator: Animator? = null
//    fun onAttach(activity: Activity?) {
//        super.onAttach(activity!!)
//        mTitles = getResources().getStringArray(R.array.onboarding_page_titles)
//        mDescriptions = getResources().getStringArray(R.array.onboarding_page_descriptions)
//    }
//
//    protected fun getPageCount(): Int {
//        return mTitles.field
//    }
//
//    protected fun getPageTitle(i: Int): CharSequence {
//        return mTitles[i]
//    }
//
//    protected fun getPageDescription(i: Int): CharSequence {
//        return mDescriptions[i]
//    }
//
//    protected fun onCreateBackgroundView(
//        layoutInflater: LayoutInflater,
//        viewGroup: ViewGroup?
//    ): View? {
//        mBackgroundView = layoutInflater.inflate(R.layout.onboarding_image, viewGroup, false)
//        return mBackgroundView
//    }
//
//    protected fun onCreateContentView(
//        layoutInflater: LayoutInflater,
//        viewGroup: ViewGroup?
//    ): View? {
//        mContentView = layoutInflater.inflate(
//            R.layout.onboarding_image, viewGroup,
//            false
//        ) as ImageView?
//        val layoutParams = mContentView!!.layoutParams as MarginLayoutParams
//        layoutParams.topMargin = 30
//        layoutParams.bottomMargin = 60
//        return mContentView
//    }
//
//    protected fun onCreateForegroundView(
//        layoutInflater: LayoutInflater?,
//        viewGroup: ViewGroup?
//    ): View? {
//        return null
//    }
//
//    protected fun onCreateEnterAnimation(): Animator {
//        val animators = ArrayList<Animator?>()
//        animators.add(createFadeInAnimator(mBackgroundView))
//        mContentView!!.setImageResource(CONTENT_IMAGES[0])
//        mContentAnimator = createFadeInAnimator(mContentView)
//        animators.add(mContentAnimator)
//        val set = AnimatorSet()
//        set.playTogether(animators)
//        return set
//    }
//
//    protected fun onPageChanged(newPage: Int, previousPage: Int) {
//        if (mContentAnimator != null) {
//            mContentAnimator!!.end()
//        }
//        val animators = ArrayList<Animator>()
//        val fadeOut = createFadeOutAnimator(mContentView)
//        fadeOut.addListener(object : AnimatorListenerAdapter() {
//            override fun onAnimationEnd(animation: Animator) {
//                mContentView!!.setImageResource(CONTENT_IMAGES[newPage])
//            }
//        })
//        animators.add(fadeOut)
//        animators.add(createFadeInAnimator(mContentView))
//        val set = AnimatorSet()
//        set.playSequentially(animators)
//        set.start()
//        mContentAnimator = set
//    }
//
//    private fun createFadeInAnimator(view: View?): Animator {
//        return ObjectAnimator.ofFloat(view, View.ALPHA, 0.0f, 1.0f).setDuration(ANIMATION_DURATION)
//    }
//
//    private fun createFadeOutAnimator(view: View?): Animator {
//        return ObjectAnimator.ofFloat(view, View.ALPHA, 1.0f, 0.0f).setDuration(ANIMATION_DURATION)
//    }
//
//    protected fun onFinishFragment() {
//        getActivity().finish()
//    }
//
//    companion object {
//        private const val ANIMATION_DURATION: Long = 1000
//        private val CONTENT_IMAGES = intArrayOf(
//            R.drawable.gallery_photo_1,
//            R.drawable.gallery_photo_2,
//            R.drawable.gallery_photo_3
//        )
//    }
//}