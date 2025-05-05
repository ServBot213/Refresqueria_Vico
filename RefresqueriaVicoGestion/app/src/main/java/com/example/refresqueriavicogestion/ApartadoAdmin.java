package com.example.refresqueriavicogestion;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import android.widget.Button;


public class ApartadoAdmin extends Fragment {

    public ApartadoAdmin() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_apartado_admin, container, false);

        // Obtener los botones del layout
        Button empleadosButton = view.findViewById(R.id.button);
        Button productosButton = view.findViewById(R.id.button2);
        Button materiaPrimaButton = view.findViewById(R.id.button3);
        Button cerrarSesionButton = view.findViewById(R.id.button4);

        // Definir las acciones de cada botón
        empleadosButton.setOnClickListener(v ->
                Navigation.findNavController(view).navigate(R.id.action_apartadoAdmin_to_gestionEmpleados)
        );

        productosButton.setOnClickListener(v ->
                Navigation.findNavController(view).navigate(R.id.action_apartadoAdmin_to_inventarioProductos2)
        );

        materiaPrimaButton.setOnClickListener(v ->
                Navigation.findNavController(view).navigate(R.id.action_apartadoAdmin_to_inventarioMatPrima)
        );

        cerrarSesionButton.setOnClickListener(v ->
                getActivity().onBackPressed()  // Regresar al fragmento anterior o salir de la aplicación
        );

        return view;
    }
}
