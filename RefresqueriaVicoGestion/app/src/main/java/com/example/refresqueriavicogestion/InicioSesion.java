package com.example.refresqueriavicogestion;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

public class InicioSesion extends Fragment {

    private static final String USUARIO_VALIDO = "admin";
    private static final String CONTRASENA_VALIDA = "1234";

    private EditText usernameEditText;
    private EditText passwordEditText;
    private Button loginButton;

    public InicioSesion() {
        // Required empty public constructor
    }

    public static InicioSesion newInstance(String param1, String param2) {
        InicioSesion fragment = new InicioSesion();
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
        return inflater.inflate(R.layout.fragment_inicio_sesion, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        usernameEditText = view.findViewById(R.id.username);
        passwordEditText = view.findViewById(R.id.password);
        loginButton = view.findViewById(R.id.login);

        loginButton.setOnClickListener(v -> verificarCredenciales());
    }

    private void verificarCredenciales() {
        String usuario = usernameEditText.getText().toString().trim();
        String contrasena = passwordEditText.getText().toString().trim();

        if (usuario.equals(USUARIO_VALIDO) && contrasena.equals(CONTRASENA_VALIDA)) {
            // Autenticación exitosa
            cambiarAFragmentoMenu();
        } else {
            // Error de autenticación
            Toast.makeText(getContext(), "Usuario o contraseña incorrectos", Toast.LENGTH_SHORT).show();
        }
    }

    private void cambiarAFragmentoMenu() {
        NavController navController = Navigation.findNavController(requireView());
        navController.navigate(R.id.action_inicioSesion_to_menuPrincipal);
    }

}
