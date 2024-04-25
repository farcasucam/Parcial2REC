
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

    public static void main(String[] args) {
        CarritoCompra carrito = new CarritoCompra();
        Producto leche = new Producto("Leche", 2.5, 1);
        Producto pan = new Producto("Pan", 1.0, 2);
        Producto huevos = new Producto("Huevos", 3.0, 1);
        carrito.agregarProducto(leche);
        carrito.agregarProducto(pan);
        carrito.agregarProducto(huevos);
        carrito.mostrarProductos();
        
        productos.clear();
        total = 0.0;
        System.out.println("Carrito vaciado.");
        carrito.mostrarProductos();
    }
}
