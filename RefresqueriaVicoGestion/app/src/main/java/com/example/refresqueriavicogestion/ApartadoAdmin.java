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
        View view = inflater.inflate(R.layout.fragment_apartado_admin, container, false);

        // Botones del menú
        Button empleadosButton = view.findViewById(R.id.button);               // Empleados
        Button consultaProductosButton = view.findViewById(R.id.button2);      // Consulta Productos
        Button registrarProductosButton = view.findViewById(R.id.button3);     // Registrar Productos
        Button consultaMateriaPrimaButton = view.findViewById(R.id.button4);   // Consultar Materia Prima
        Button registrarMateriaPrimaButton = view.findViewById(R.id.button5);  // Registrar Materia Prima
        Button volverButton = view.findViewById(R.id.button6);                 // Volver

        empleadosButton.setOnClickListener(v ->
                Navigation.findNavController(view).navigate(R.id.action_apartadoAdmin_to_gestionEmpleados)
        );

        consultaProductosButton.setOnClickListener(v ->
                Navigation.findNavController(view).navigate(R.id.action_apartadoAdmin_to_consultaProductos)
        );

        registrarProductosButton.setOnClickListener(v ->
                Navigation.findNavController(view).navigate(R.id.action_apartadoAdmin_to_inventarioProductos2)
        );

        consultaMateriaPrimaButton.setOnClickListener(v ->
                Navigation.findNavController(view).navigate(R.id.action_apartadoAdmin_to_consultaMateriaPrima)
        );

        registrarMateriaPrimaButton.setOnClickListener(v ->
                Navigation.findNavController(view).navigate(R.id.action_apartadoAdmin_to_inventarioMatPrima)
        );

        volverButton.setOnClickListener(v ->
                requireActivity().onBackPressed()
        );

        return view;
    }
}
