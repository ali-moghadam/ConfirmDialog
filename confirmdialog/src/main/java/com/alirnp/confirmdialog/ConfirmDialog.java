package com.alirnp.confirmdialog;

import android.app.Dialog;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.core.content.ContextCompat;
import androidx.core.widget.ImageViewCompat;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentManager;

public class ConfirmDialog extends DialogFragment {

   private View mView;
   private String mMessage;
   private String mMessageBody;
   private String mTextPositiveButton;
   private String mTextNegativeButton;
   private Button mButtonPositive, mButtonNegative;
   private TextView mTextViewTitle, mTextViewMessageBody;
   private ImageView mImageView;
   private View mViewLine;
   private OnClickListener mPositiveButtonListener;
   private OnClickListener mNegativeButtonListener;
   private Typeface mTypeface;
   private int mColorPositiveButton;
   private int mColorNegativeButton;
   private int mColorTextPositiveButton;
   private int mColorTextNegativeButton;
   private int mColorRipplePositiveButton;
   private int mColorRippleNegativeButton;
   private int mIcon;
   private int mIconColor;

   private ConfirmDialog() {

   }

   @Override
   public void onCreate(@Nullable Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);

      setStyle(DialogFragment.STYLE_NORMAL, R.style.dialog);
   }


   /**
    * commented super method
    * for fix bug -> IllegalStateException: Can not perform this action after onSaveInstanceState
    */
   @Override
   public void onSaveInstanceState(@NonNull Bundle outState) {
      //super.onSaveInstanceState(outState);
   }


   @Override
   public void show(@NonNull FragmentManager manager, @Nullable String tag) {
      try {
         super.show(manager, tag);

      } catch (IllegalStateException e) {
         e.printStackTrace();
      }

   }

   @Nullable
   @Override
   public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
      setBackgroundForDialog();
      return inflater.inflate(R.layout.confirm_dialog, container, false);
   }

   @Override
   public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
      super.onViewCreated(view, savedInstanceState);
      mView = view;
      initViews();
      initData();
      initListeners();

   }

   private void initListeners() {
      mButtonPositive.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {
            if (mPositiveButtonListener != null)
               mPositiveButtonListener.onClick(ConfirmDialog.this, v);


         }
      });
      mButtonNegative.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {
            if (mNegativeButtonListener != null)
               mNegativeButtonListener.onClick(ConfirmDialog.this, v);

         }
      });
   }

   private void initData() {
      //set title text
      mTextViewTitle.setText(mMessage);

      // set body text
      if (mMessageBody != null) {
         mTextViewMessageBody.setText(mMessageBody);
         if (mMessageBody.equals(""))
            mTextViewMessageBody.setVisibility(View.GONE);

      } else {
         mTextViewMessageBody.setVisibility(View.GONE);
      }


      //When positive color was equal to negative color
      mViewLine.setVisibility(mColorNegativeButton == mColorPositiveButton ? View.VISIBLE : View.GONE);

      // when just need positive button
      mButtonNegative.setVisibility(mNegativeButtonListener == null ? View.GONE : View.VISIBLE);

      //button text,s
      if (mTextPositiveButton != null) {
         mButtonPositive.setText(mTextPositiveButton);
      }

      if (mTextNegativeButton != null) {
         mButtonNegative.setText(mTextNegativeButton);
      }

      // icon
      if (mIcon > 0) {
         mImageView.setVisibility(View.VISIBLE);
         mImageView.setImageResource(mIcon);
      } else {
         mImageView.setVisibility(View.GONE);
      }

      if (mIconColor < 0) {
         ImageViewCompat.setImageTintList(mImageView, ColorStateList.valueOf(mIconColor));
      }

      // background color
      if (mColorPositiveButton < 0) {
         mButtonPositive.setBackgroundColor(mColorPositiveButton);
      }

      if (mColorNegativeButton < 0) {
         mButtonNegative.setBackgroundColor(mColorNegativeButton);
      }

      // text color
      if (mColorTextPositiveButton < 0) {
         mButtonPositive.setTextColor(mColorTextPositiveButton);
      }

      if (mColorTextNegativeButton < 0) {
         mButtonNegative.setTextColor(mColorTextNegativeButton);
      }

      // ripple color
      if (mColorRipplePositiveButton < 0) {
         Helper.setRippleColor(mButtonPositive, mColorRipplePositiveButton);
      }

      // ripple color
      if (mColorRippleNegativeButton < 0) {
         Helper.setRippleColor(mButtonNegative, mColorRippleNegativeButton);
      }

      //typeface
      if (mTypeface != null)
         setTypeFace(mButtonPositive, mButtonNegative, mTextViewTitle, mTextViewMessageBody);

   }

   private void setTypeFace(View... views) {
      for (View v : views) {
         if (v instanceof Button) {
            ((Button) v).setTypeface(mTypeface);
         } else if (v instanceof TextView) {
            ((TextView) v).setTypeface(mTypeface);
         }
      }

   }

   private void initViews() {
      mTextViewTitle = mView.findViewById(R.id.confirm_dialog_title);
      mTextViewMessageBody = mView.findViewById(R.id.confirm_dialog_subTitle);
      mImageView = mView.findViewById(R.id.confirm_dialog_imageView);
      mViewLine = mView.findViewById(R.id.confirm_dialog_line);
      mButtonPositive = mView.findViewById(R.id.confirm_dialog_button_positive);
      mButtonNegative = mView.findViewById(R.id.confirm_dialog_button_negative);
   }

   private void setBackgroundForDialog() {
      Dialog dialog = getDialog();
      if (dialog != null)
         if (dialog.getWindow() != null) {
            dialog.getWindow().setBackgroundDrawable(ContextCompat.getDrawable(dialog.getContext(), R.drawable.background_dialog));
            dialog.getWindow().requestFeature(Window.FEATURE_NO_TITLE);
         }
   }

   public void setmMessage(String mMessage) {
      this.mMessage = mMessage;
   }

   public void setmPositiveButtonListener(OnClickListener mPositiveButtonListener) {
      this.mPositiveButtonListener = mPositiveButtonListener;
   }

   public void setmNegativeButtonListener(OnClickListener mNegativeButtonListener) {
      this.mNegativeButtonListener = mNegativeButtonListener;
   }


   public static class Builder {
      private Context mContext;
      private String mMessage;
      private String mMessageBody;
      private String mTextPositiveButton;
      private String mTextNegativeButton;
      private int mIcon;
      private int mIconColor;
      private OnClickListener mPositiveButtonListener;
      private OnClickListener mNegativeButtonListener;
      private Typeface mTypeface;
      private int mColorPositiveButton;
      private int mColorNegativeButton;
      private int mColorTextPositiveButton;
      private int mColorTextNegativeButton;
      private int mColorRipplePositiveButton;
      private int mColorRippleNegativeButton;


      public Builder(Context context, String message) {
         this.mContext = context;
         this.mMessage = message;
      }

      public Builder(Context context, @StringRes int message) {
         this.mContext = context;
         this.mMessage = mContext.getString(message);
      }

      public Builder setMessageBody(String messageBody) {
         this.mMessageBody = messageBody;
         return this;
      }

      public Builder setIcon(@DrawableRes int icon) {
         this.mIcon = icon;
         return this;
      }

      public Builder setIconColor(int iconColor) {
         this.mIconColor = iconColor;
         return this;
      }

      public Builder setPositiveButtonListener(String textPositiveButton, OnClickListener positiveButtonListener) {
         this.mTextPositiveButton = textPositiveButton;
         this.mPositiveButtonListener = positiveButtonListener;
         return this;
      }

      public Builder setPositiveButtonListener(@StringRes int textPositiveButton, OnClickListener positiveButtonListener) {
         this.mTextPositiveButton = mContext.getResources().getString(textPositiveButton);
         this.mPositiveButtonListener = positiveButtonListener;
         return this;
      }

      public Builder setNegativeButtonListener(String textNegativeButton, OnClickListener negativeButtonListener) {
         this.mTextNegativeButton = textNegativeButton;
         this.mNegativeButtonListener = negativeButtonListener;
         return this;
      }

      public Builder setNegativeButtonListener(@StringRes int textNegativeButton, OnClickListener negativeButtonListener) {
         this.mTextNegativeButton = mContext.getResources().getString(textNegativeButton);
         this.mNegativeButtonListener = negativeButtonListener;
         return this;
      }

      public Builder setTypeface(Typeface typeface) {
         this.mTypeface = typeface;
         return this;
      }

      public Builder setColorPositiveButton(int color) {
         this.mColorPositiveButton = color;
         return this;
      }

      public Builder setColorNegativeButton(int color) {
         this.mColorNegativeButton = color;
         return this;
      }

      public Builder setColorTextPositiveButton(int color) {
         this.mColorTextPositiveButton = color;
         return this;
      }

      public Builder setColorTextNegativeButton(int color) {
         this.mColorTextNegativeButton = color;
         return this;
      }

      public Builder setColorRipplePositiveButton(int color) {
         this.mColorRipplePositiveButton = color;
         return this;
      }

      public Builder setColorRippleNegativeButton(int color) {
         this.mColorRippleNegativeButton = color;
         return this;
      }

      public ConfirmDialog build() {

         ConfirmDialog dialog = new ConfirmDialog();
         dialog.mMessage = this.mMessage;
         dialog.mMessageBody = this.mMessageBody;
         dialog.mIcon = this.mIcon;
         dialog.mIconColor = this.mIconColor;
         dialog.mPositiveButtonListener = this.mPositiveButtonListener;
         dialog.mNegativeButtonListener = this.mNegativeButtonListener;
         dialog.mColorPositiveButton = this.mColorPositiveButton;
         dialog.mColorNegativeButton = this.mColorNegativeButton;
         dialog.mTypeface = this.mTypeface;
         dialog.mColorTextPositiveButton = this.mColorTextPositiveButton;
         dialog.mColorTextNegativeButton = this.mColorTextNegativeButton;
         dialog.mColorRipplePositiveButton = this.mColorRipplePositiveButton;
         dialog.mColorRippleNegativeButton = this.mColorRippleNegativeButton;
         dialog.mTextPositiveButton = this.mTextPositiveButton;
         dialog.mTextNegativeButton = this.mTextNegativeButton;

         return dialog;
      }
   }


}
