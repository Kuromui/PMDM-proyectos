// Generated by view binder compiler. Do not edit!
package com.example.ligasevaluable.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.ligasevaluable.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class EquiposItemBinding implements ViewBinding {
  @NonNull
  private final CardView rootView;

  @NonNull
  public final ImageButton btnFavorito;

  @NonNull
  public final ImageView imagenEquipo;

  @NonNull
  public final TextView nombreEquipo;

  private EquiposItemBinding(@NonNull CardView rootView, @NonNull ImageButton btnFavorito,
      @NonNull ImageView imagenEquipo, @NonNull TextView nombreEquipo) {
    this.rootView = rootView;
    this.btnFavorito = btnFavorito;
    this.imagenEquipo = imagenEquipo;
    this.nombreEquipo = nombreEquipo;
  }

  @Override
  @NonNull
  public CardView getRoot() {
    return rootView;
  }

  @NonNull
  public static EquiposItemBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static EquiposItemBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.equipos_item, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static EquiposItemBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.btnFavorito;
      ImageButton btnFavorito = ViewBindings.findChildViewById(rootView, id);
      if (btnFavorito == null) {
        break missingId;
      }

      id = R.id.imagenEquipo;
      ImageView imagenEquipo = ViewBindings.findChildViewById(rootView, id);
      if (imagenEquipo == null) {
        break missingId;
      }

      id = R.id.nombreEquipo;
      TextView nombreEquipo = ViewBindings.findChildViewById(rootView, id);
      if (nombreEquipo == null) {
        break missingId;
      }

      return new EquiposItemBinding((CardView) rootView, btnFavorito, imagenEquipo, nombreEquipo);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
