
import java.util.ArrayList;

public class CarritoCompra {
    private ArrayList<Producto> productos;
    private double total;

    public CarritoCompra() {
        productos = new ArrayList<>();
        total = 0.0;
    }

    public void agregarProducto(Producto producto) {
        productos.add(producto);
        total += producto.precio * producto.cantidad;
        System.out.println(producto.nombre + " añadido al carrito. Cantidad: " + producto.cantidad + ". Precio total: $" + producto.precio * producto.cantidad);
    }

    public void mostrarProductos() {
        if (productos.isEmpty()) {
            System.out.println("El carrito está vacío.");
        } else {
            System.out.println("Productos en el carrito:");
            for (Producto producto : productos) {
                System.out.println("- " + producto.nombre + " (Cantidad: " + producto.cantidad + ")");
            }
            System.out.println("Total: $" + total);
        }
    }

    public void vaciarCarrito() {
        productos.clear();
        total = 0.0;
        System.out.println("Carrito vaciado.");
    }
}
