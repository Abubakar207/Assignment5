// Generated by view binder compiler. Do not edit!
package com.example.assignment_4.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.assignment_4.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class FragmentCityBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final TextView cid;

  @NonNull
  public final TextView cityName;

  private FragmentCityBinding(@NonNull ConstraintLayout rootView, @NonNull TextView cid,
      @NonNull TextView cityName) {
    this.rootView = rootView;
    this.cid = cid;
    this.cityName = cityName;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static FragmentCityBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static FragmentCityBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.fragment_city, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static FragmentCityBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.cid;
      TextView cid = ViewBindings.findChildViewById(rootView, id);
      if (cid == null) {
        break missingId;
      }

      id = R.id.cityName;
      TextView cityName = ViewBindings.findChildViewById(rootView, id);
      if (cityName == null) {
        break missingId;
      }

      return new FragmentCityBinding((ConstraintLayout) rootView, cid, cityName);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}