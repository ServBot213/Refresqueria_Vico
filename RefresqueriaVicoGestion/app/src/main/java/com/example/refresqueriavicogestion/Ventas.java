package com.example.refresqueriavicogestion;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Ventas extends Fragment {

    private TextView tvTotal;
    private LinearLayout productTable;
    private double total = 0;
    private List<String> productos = new ArrayList<>();
    private List<Double> precios = new ArrayList<>();

    // Datos de ejemplo por categoría
    private final Map<String, Map<String, Double>> productosPorCategoria = new HashMap<String, Map<String, Double>>() {{
        put("Bebidas", new HashMap<String, Double>() {{
            put("Limonada", 20.0);
            put("Agua Mineral", 15.0);
            put("Refresco", 18.0);
        }});
        put("Helados", new HashMap<String, Double>() {{
            put("Chocolate", 25.0);
            put("Vainilla", 25.0);
            put("Fresa", 25.0);
        }});
        put("Sabritas", new HashMap<String, Double>() {{
            put("Clásicas", 15.0);
            put("Flaming Hot", 17.0);
            put("Adobadas", 16.0);
        }});
        put("Comida", new HashMap<String, Double>() {{
            put("Nachos", 30.0);
            put("Tostadas", 28.0);
            put("Tacos", 35.0);
        }});
    }};

    public Ventas() {}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_ventas, container, false);

        tvTotal = view.findViewById(R.id.tvTotal);
        productTable = view.findViewById(R.id.productTable);

        Button btnBebidas = view.findViewById(R.id.btnBebidas);
        Button btnHelados = view.findViewById(R.id.btnHelados);
        Button btnSabritas = view.findViewById(R.id.btnSabritas);
        Button btnComida = view.findViewById(R.id.btnComida);

        btnBebidas.setOnClickListener(v -> mostrarSelector("Bebidas"));
        btnHelados.setOnClickListener(v -> mostrarSelector("Helados"));
        btnSabritas.setOnClickListener(v -> mostrarSelector("Sabritas"));
        btnComida.setOnClickListener(v -> mostrarSelector("Comida"));

        view.findViewById(R.id.btnVenta).setOnClickListener(v -> realizarVenta());
        view.findViewById(R.id.btnCancelar).setOnClickListener(v -> cancelarVenta());
        view.findViewById(R.id.btnEliminar).setOnClickListener(v -> eliminarProducto());
        view.findViewById(R.id.btnDuplicar).setOnClickListener(v -> duplicarProducto());

        return view;
    }

    private void mostrarSelector(String categoria) {
        Map<String, Double> productosCat = productosPorCategoria.get(categoria);
        if (productosCat == null) return;

        String[] nombres = productosCat.keySet().toArray(new String[0]);
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("Selecciona un producto");

        final int[] selectedIndex = {0};

        builder.setSingleChoiceItems(nombres, 0, (dialog, which) -> selectedIndex[0] = which);

        // Inflar el layout con NumberPicker
        View dialogView = getLayoutInflater().inflate(R.layout.dialog_number_picker, null);
        NumberPicker numberPicker = dialogView.findViewById(R.id.numberPicker);
        numberPicker.setMinValue(1);
        numberPicker.setMaxValue(10);
        builder.setView(dialogView);

        builder.setPositiveButton("Agregar", (dialog, which) -> {
            String producto = nombres[selectedIndex[0]];
            double precio = productosCat.get(producto);
            int cantidad = numberPicker.getValue();
            for (int i = 0; i < cantidad; i++) {
                agregarProducto(producto, precio);
            }
        });

        builder.setNegativeButton("Cancelar", null);
        builder.show();
    }

    private void agregarProducto(String producto, double precio) {
        productos.add(producto);
        precios.add(precio);
        agregarProductoSinGuardar(producto, precio);
        total += precio;
        tvTotal.setText("$" + total);
    }

    private void agregarProductoSinGuardar(String producto, double precio) {
        TextView tvProducto = new TextView(getContext());
        tvProducto.setText(producto + " - $" + precio);
        tvProducto.setPadding(0, 8, 0, 8);
        productTable.addView(tvProducto);
    }

    private void realizarVenta() {
        Toast.makeText(getActivity(), "Venta realizada con éxito", Toast.LENGTH_SHORT).show();
        productTable.removeAllViews();
        total = 0;
        tvTotal.setText("$0");
        productos.clear();
        precios.clear();
    }

    private void cancelarVenta() {
        productTable.removeAllViews();
        total = 0;
        tvTotal.setText("$0");
        productos.clear();
        precios.clear();
        Toast.makeText(getActivity(), "Venta cancelada", Toast.LENGTH_SHORT).show();
    }

    private void eliminarProducto() {
        if (!productos.isEmpty()) {
            productos.remove(productos.size() - 1);
            double precioEliminado = precios.remove(precios.size() - 1);
            total -= precioEliminado;
            tvTotal.setText("$" + total);
            productTable.removeAllViews();
            for (int i = 0; i < productos.size(); i++) {
                agregarProductoSinGuardar(productos.get(i), precios.get(i));
            }
            Toast.makeText(getActivity(), "Último producto eliminado", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(getActivity(), "No hay productos para eliminar", Toast.LENGTH_SHORT).show();
        }
    }

    private void duplicarProducto() {
        if (!productos.isEmpty()) {
            String ultimoProducto = productos.get(productos.size() - 1);
            double ultimoPrecio = precios.get(precios.size() - 1);
            agregarProducto(ultimoProducto, ultimoPrecio);
            Toast.makeText(getActivity(), "Producto duplicado", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(getActivity(), "No hay productos para duplicar", Toast.LENGTH_SHORT).show();
        }
    }
}
