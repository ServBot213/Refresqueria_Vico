package com.example.refresqueriavicogestion;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import androidx.navigation.Navigation;

public class MenuPrincipal extends Fragment {

    public MenuPrincipal() {
        // Required empty public constructor
    }

    public static MenuPrincipal newInstance(String param1, String param2) {
        MenuPrincipal fragment = new MenuPrincipal();
        Bundle args = new Bundle();
        args.putString("param1", param1);
        args.putString("param2", param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_menu_principal, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // Botones
        Button btnEmpleado = view.findViewById(R.id.empleado);
        Button btnAdmin = view.findViewById(R.id.administrador);
        Button btnCerrarSesion = view.findViewById(R.id.Cerrarsesion);

        // Navegación
        btnEmpleado.setOnClickListener(v ->
                Navigation.findNavController(view).navigate(R.id.action_menuPrincipal_to_apartadoEmpleados)
        );

        btnAdmin.setOnClickListener(v ->
                Navigation.findNavController(view).navigate(R.id.action_menuPrincipal_to_apartadoAdmin)
        );

        // Volver al fragmento anterior (Login)
        btnCerrarSesion.setOnClickListener(v ->
                requireActivity().onBackPressed()
        );
    }
}
