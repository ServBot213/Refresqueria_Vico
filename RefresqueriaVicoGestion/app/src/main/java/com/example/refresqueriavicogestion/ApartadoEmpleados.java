package com.example.refresqueriavicogestion;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import android.widget.Button;


public class ApartadoEmpleados extends Fragment {

    public ApartadoEmpleados() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_apartado_empleados, container, false);

        // Obtener los botones del layout
        Button venderButton = view.findViewById(R.id.Vender);
        Button consultaProductosButton = view.findViewById(R.id.ConsultaProduct);
        Button volverButton = view.findViewById(R.id.button8);

        // Definir las acciones de cada botón
        venderButton.setOnClickListener(v ->
                Navigation.findNavController(view).navigate(R.id.action_apartadoEmpleados_to_ventas)
        );

        consultaProductosButton.setOnClickListener(v ->
                Navigation.findNavController(view).navigate(R.id.action_apartadoEmpleados_to_consultaProductos)
        );

        volverButton.setOnClickListener(v ->
                getActivity().onBackPressed()  // Regresar al fragmento anterior
        );

        return view;
    }
}
