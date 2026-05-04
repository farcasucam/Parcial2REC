# Parcial2REC - Documentacion Tecnica

## 1. Objetivo del proyecto
Aplicacion de consola en Java que modela un flujo simple de carrito de compra:

- Alta de productos en carrito.
- Calculo incremental del total.
- Visualizacion del estado del carrito.
- Vaciado del carrito.

## 2. Estructura de clases

### `Producto` ([Producto.java])
Representa un item de compra.

#### Responsabilidad
- Almacenar los datos base de un producto agregado al carrito.

#### Atributos
- `String nombre`: nombre del producto.
- `double precio`: precio unitario.
- `int cantidad`: cantidad de unidades.

#### Constructor
- `Producto(String nombre, double precio, int cantidad)`: inicializa los 3 atributos.

#### Notas tecnicas
- La clase tiene visibilidad de paquete (no `public`).
- Sus atributos son `public`, por lo que se accede directamente desde otras clases.

---

### `CarritoCompra` ([CarritoCompra.java])
Entidad de dominio principal para gestionar el estado del carrito.

#### Responsabilidad
- Mantener la coleccion de productos.
- Mantener el total acumulado.
- Exponer operaciones de negocio sobre el carrito.

#### Atributos
- `private ArrayList<Producto> productos`: lista interna de productos.
- `private double total`: importe total acumulado.

#### Metodos
- `CarritoCompra()`
	- Inicializa `productos` con `new ArrayList<>()`.
	- Inicializa `total` a `0.0`.

- `void agregarProducto(Producto producto)`
	- Agrega el producto a la lista.
	- Actualiza total con `producto.precio * producto.cantidad`.
	- Imprime por consola el detalle del alta.

- `void mostrarProductos()`
	- Si la lista esta vacia, imprime "El carrito esta vacio.".
	- Si hay elementos, imprime listado de productos y total.

- `void vaciarCarrito()`
	- Limpia la lista con `productos.clear()`.
	- Reinicia `total` a `0.0`.
	- Imprime "Carrito vaciado.".

#### Invariante funcional esperada
- El valor de `total` debe coincidir con la suma de `precio * cantidad` de todos los elementos de `productos`.

---

### `ProgramaPrincipal` ([ProgramaPrincipal.java])
Punto de entrada de la aplicacion.

#### Responsabilidad
- Orquestar una ejecucion de ejemplo del sistema.

#### Flujo de `main`
1. Crea una instancia de `CarritoCompra`.
2. Crea 3 productos (`Leche`, `Pan`, `Huevos`).
3. Agrega productos al carrito.
4. Muestra estado del carrito.
5. Vacia carrito.
6. Muestra estado final (vacio).

## 3. Relaciones entre clases

### Relacion principal
- `CarritoCompra` **contiene** una coleccion de `Producto` (`ArrayList<Producto>`).
- `ProgramaPrincipal` **usa** `CarritoCompra` y `Producto` para ejecutar el caso de uso.

### Diagrama simplificado (UML textual)
```text
ProgramaPrincipal
			|
			| crea/usa
			v
 CarritoCompra 1 -------- * Producto
			 (contiene lista)
```

## 4. Complejidad basica de operaciones
- `agregarProducto`: O(1) amortizado (append en `ArrayList`).
- `mostrarProductos`: O(n), siendo `n` la cantidad de productos.
- `vaciarCarrito`: O(n) por limpieza de lista (dependiente de implementacion interna).

## 5. Ejecucion del proyecto
Desde la carpeta raiz del proyecto:

```bash
javac *.java
java ProgramaPrincipal
```

## 6. Posibles mejoras tecnicas
- Encapsular `Producto` con atributos `private` + getters.
- Validar entrada (`precio >= 0`, `cantidad > 0`).
- Separar capa de dominio y capa de presentacion (evitar `System.out.println` dentro de `CarritoCompra`).
- Usar `BigDecimal` para importes monetarios y evitar errores de precision de `double`.
