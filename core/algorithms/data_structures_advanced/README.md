# Data Structures Advanced — Groovy

Implementación de la especificación [07 — Data Structures Advanced](../../../../../docs/core/algorithms/07_Data_Structures_Advanced.md) en **Groovy**, con un enfoque manual y minimalista.

**ES:** Implementación de `Node` (clase base abstracta portadora del valor), `TreeNode` (nodo de árbol con enlaces izquierdo y derecho), `BinaryTree` (árbol binario de búsqueda), `GraphNode` (nodo de grafo con lista de vecinos) y `Graph` (grafo dirigido con registro de vértices enlazado manualmente). Proyecto Gradle con Spock como framework de pruebas.

**EN:** Implementation of `Node` (abstract base class carrying the value), `TreeNode` (tree node with left and right links), `BinaryTree` (binary search tree), `GraphNode` (graph node with neighbour list) and `Graph` (directed graph with a manually linked vertex registry). Gradle project with Spock as the test framework.

---

## 📂 Archivos y estructura / Files & Structure

Proyecto Gradle que contiene una biblioteca de estructuras de datos avanzadas implementadas manualmente y su suite de pruebas unitarias con Spock.

| Archivo / Directory | Propósito / Purpose |
|---|---|
| `lib/src/main/groovy/data_structures_advanced/Node.groovy` | Clase base abstracta portadora del valor (`value`), sin enlaces ni validaciones. |
| `lib/src/main/groovy/data_structures_advanced/TreeNode.groovy` | Nodo de árbol que hereda de `Node` y añade enlaces mutables `left` y `right`. |
| `lib/src/main/groovy/data_structures_advanced/BinaryTree.groovy` | Árbol binario de búsqueda con inserción, consulta de pertenencia y tamaño. |
| `lib/src/main/groovy/data_structures_advanced/GraphNode.groovy` | Nodo de grafo que hereda de `Node`, almacena vecinos ordenados y enlace al siguiente vértice. |
| `lib/src/main/groovy/data_structures_advanced/Graph.groovy` | Grafo dirigido con registro enlazado canónico de vértices y operaciones sobre adyacencia. |
| `lib/src/test/groovy/data_structures_advanced/DataStructuresAdvancedTest.groovy` | Pruebas unitarias completas con Spock para `TreeNode`, `BinaryTree` y `Graph`. |
| `settings.gradle` | Configuración del proyecto raíz y submódulo `lib`. |
| `lib/build.gradle` | Plugins (`groovy`, `java-library`), dependencias y configuración de pruebas. |
| `gradle.properties` | Propiedades JVM para Gradle. |
| `gradle/libs.versions.toml` | Catálogo de versiones de dependencias (Groovy, Spock, JUnit). |
| `gradlew` / `gradlew.bat` | Gradle Wrapper (Unix / Windows). |
| `gradle/wrapper/` | Binarios y configuración del Wrapper. |
| `.gitignore` | Exclusión de `.gradle`, `build`, `.kotlin` y `lib/bin`. |
| `.gitattributes` | Normalización de fines de línea. |

**Desviación de la ubicación esperada:**

**ES:** La especificación propone `src/data_structures_advanced.ext` y `test/data_structures_advanced_test.ext` con `run_tests.ext`. Esta implementación sigue la convención estándar de Gradle para bibliotecas Groovy: código en `lib/src/main/groovy/data_structures_advanced/` y pruebas en `lib/src/test/groovy/data_structures_advanced/`. La ejecución y verificación se realizan directamente mediante Gradle (`./gradlew test`).

**EN:** The specification proposes `src/data_structures_advanced.ext` and `test/data_structures_advanced_test.ext` with `run_tests.ext`. This implementation follows Gradle's standard layout for Groovy libraries: source files under `lib/src/main/groovy/data_structures_advanced/` and tests under `lib/src/test/groovy/data_structures_advanced/`. Building and testing are handled directly via Gradle (`./gradlew test`).

---

## 🛠️ Enfoque y construcción / Approach & Build

**ES:** El proyecto se estructuró a partir de `gradle init` y se desarrollaron manualmente las clases `Node`, `TreeNode`, `BinaryTree`, `GraphNode` y `Graph`, junto con la suite de pruebas en Spock. El registro de vértices de `Graph` se implementa como una lista enlazada propia manual (`GraphNode.nextVertex`) sin recurrir a mapas, diccionarios ni tablas hash. La inserción ordenada de vecinos en `Graph` se realiza de manera manual sobre una lista lineal.

**EN:** The project was scaffolded with `gradle init`, and the classes `Node`, `TreeNode`, `BinaryTree`, `GraphNode`, and `Graph` were implemented manually alongside the Spock test suite. The vertex registry in `Graph` is maintained as a custom singly linked chain (`GraphNode.nextVertex`) without delegating to maps, dictionaries, or hash tables. Sorted neighbour insertion in `Graph` is performed manually over a linear list.

### Inicialización / Initialization

```bash
gradle init --type groovy-library --dsl groovy --test-framework spock --project-name data_structures_advanced
```

---

## 📄 Configuración clave / Key Configuration

### `settings.gradle`

```groovy
plugins {
    id 'org.gradle.toolchains.foojay-resolver-convention' version '1.0.0'
}

rootProject.name = 'data_structures_advanced'
include('lib')
```

### `lib/build.gradle`

```groovy
plugins {
    id 'groovy'
    id 'java-library'
}

repositories {
    mavenCentral()
}

dependencies {
    implementation libs.groovy.all
    implementation libs.guava
    testImplementation libs.spock.core
    testImplementation libs.junit
    testRuntimeOnly 'org.junit.platform:junit-platform-launcher'
    api libs.commons.math3
}

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(21)
    }
}

tasks.named('test') {
    useJUnitPlatform()
}
```

### `gradle/libs.versions.toml`

```toml
[versions]
commons-math3 = "3.6.1"
groovy-all = "4.0.29"
guava = "33.5.0-jre"
junit = "4.13.2"
spock-core = "2.4-groovy-4.0"

[libraries]
commons-math3 = { module = "org.apache.commons:commons-math3", version.ref = "commons-math3" }
groovy-all = { module = "org.apache.groovy:groovy-all", version.ref = "groovy-all" }
guava = { module = "com.google.guava:guava", version.ref = "guava" }
junit = { module = "junit:junit", version.ref = "junit" }
spock-core = { module = "org.spockframework:spock-core", version.ref = "spock-core" }
```

---

## 🚀 Compilación y ejecución / Build & Run

```bash
./gradlew build
./gradlew test
```

**Salida real / Actual output:**

```text
> Task :lib:clean
> Task :lib:compileJava NO-SOURCE
> Task :lib:processTestResources NO-SOURCE
> Task :lib:processResources NO-SOURCE
> Task :lib:compileGroovy
> Task :lib:classes
> Task :lib:compileTestJava NO-SOURCE
> Task :lib:compileTestGroovy
> Task :lib:testClasses
> Task :lib:test

BUILD SUCCESSFUL in 5s
4 actionable tasks: 4 executed
Configuration cache entry reused.
```

**ES:** La suite ejecutó 23 pruebas organizadas en bloques temáticos para `TreeNode` (5 pruebas), `BinaryTree` (7 pruebas) y `Graph` (11 pruebas), con 0 fallos y 0 omitidas.

**EN:** The suite executed 23 tests organized across thematic blocks for `TreeNode` (5 tests), `BinaryTree` (7 tests), and `Graph` (11 tests), with 0 failures and 0 skipped.

---

## 🧠 Algoritmos y operaciones / Algorithms & Operations

| Operación / Operation | Entrada → salida / Input → output | Complejidad / Complexity | Notas / Notes |
|---|---|---|---|
| `Node(value)` | `Integer → Node` | `O(1)` | Constructor protegido de clase base abstracta portadora de `value`. |
| `Node.getValue()` | `→ Integer` | `O(1)` | Retorna el valor encapsulado en el nodo. |
| `TreeNode(value)` | `Integer → TreeNode` | `O(1)` | Inicializa nodo de árbol con `left = null` y `right = null`. |
| `TreeNode.getLeft()` | `→ TreeNode` | `O(1)` | Retorna enlace izquierdo (o `null`). |
| `TreeNode.getRight()` | `→ TreeNode` | `O(1)` | Retorna enlace derecho (o `null`). |
| `TreeNode.setLeft(node)` | `TreeNode → void` | `O(1)` | Actualiza enlace izquierdo. |
| `TreeNode.setRight(node)` | `TreeNode → void` | `O(1)` | Actualiza enlace derecho. |
| `BinaryTree()` | `→ BinaryTree` | `O(1)` | Inicializa árbol vacío (`root = null`, `count = 0`). Equivale a `init()`. |
| `BinaryTree.insert(value)` | `Integer → boolean` | `O(h)` | Inserción iterativa en ABB; duplicados no incrementan tamaño. |
| `BinaryTree.contains(value)` | `Integer → boolean` | `O(h)` | Búsqueda iterativa siguiendo la propiedad de orden del ABB. |
| `BinaryTree.isEmpty()` | `→ boolean` | `O(1)` | `true` cuando `count == 0`. |
| `BinaryTree.getSize()` | `→ int` | `O(1)` | Retorna número de elementos distintos en el árbol. |
| `GraphNode(label)` | `Integer → GraphNode` | `O(1)` | Inicializa nodo con etiqueta, lista de vecinos y `nextVertex = null`. |
| `Graph()` | `→ Graph` | `O(1)` | Inicializa grafo vacío (`vertices = null`, contadores en 0). Equivale a `init()`. |
| `Graph.addVertex(label)` | `Integer → boolean` | `O(V)` | Registra vértice en la cabeza de la lista enlazada canónica; idempotente si existe. |
| `Graph.addEdge(u, v)` | `(Integer, Integer) → boolean` | `O(V + d(u))` | Requiere ambos extremos; inserta `v` ordenadamente en adyacencia de `u`; idempotente. |
| `Graph.hasEdge(u, v)` | `(Integer, Integer) → boolean` | `O(V + d(u))` | Verifica existencia de arista dirigida entre `u` y `v`. |
| `Graph.getNeighbors(u)` | `Integer → List<Integer>` | `O(V + d(u))` | Copia defensiva de la secuencia ordenada de vecinos; `null` si `u` no existe. |
| `Graph.isEmpty()` | `→ boolean` | `O(1)` | `true` cuando `vertexCount == 0`. |
| `Graph.getVertexCount()` | `→ int` | `O(1)` | Retorna total de vértices registrados. |
| `Graph.getEdgeCount()` | `→ int` | `O(1)` | Retorna total de aristas dirigidas registradas. |

---

## 🧩 Decisiones de diseño / Design decisions

| Decisión / Decision | Alternativa considerada / Alternative | Razón / Reason |
|---|---|---|
| Reutilización por herencia con clase base abstracta `Node` | Valor embebido (composición) en cada nodo | Groovy cuenta con soporte completo de orientación a objetos y herencia en la JVM. Declarar `abstract class Node` con constructor protegido encapsula `value` limpiamente y permite que `TreeNode` y `GraphNode` compartan la misma semántica de tipo base. |
| Registro de vértices enlazado manual (`GraphNode.nextVertex`) | Colección estándar como `Map<Integer, GraphNode>` o `List<GraphNode>` | Cumple estrictamente con la restricción de implementación manual y la cota `O(V)` sin delegar la indexación o búsqueda de vértices en tablas hash o colecciones de alto nivel. |
| Inserción manual ordenada de adyacencia (`O(d(u))`) | Ordenar la lista tras inserción (`sort()`) o usar `TreeSet` | Mantiene el invariante de adyacencia ordenada en todo momento en `O(d(u))` al insertar cada arista, evitando costes adicionales o delegación en colecciones de la biblioteca. |
| Devolver copia defensiva en `getNeighbors` | Exponer la lista interna directamente | Garantiza aislamiento del resultado: modificaciones externas sobre la lista retornada no mutan el estado interno del grafo ni sus contadores. |

---

## 🔀 Adaptaciones idiomáticas / Idiomatic adaptations

| Especificación / Specification | Adaptación / Adaptation | Justificación / Justification |
|---|---|---|
| Métodos de inicialización `init(...)` | Constructores de clase (`new TreeNode(val)`, `new BinaryTree()`, `new Graph()`) | Convención idiomática en Groovy/JVM: los constructores inicializan campos y referencias nativamente. |
| Ausencia de enlace o vértice (`absent`) | `null` | Representación nativa de referencia ausente en Groovy/JVM para tipos de objeto. |
| Fallo en consulta de vecinos (`get_neighbors`) | Retorno de `null` | Permite distinguir de forma no ambigua el fallo por vértice inexistente (`null`) de un vértice existente sin vecinos (`[]`). |
| Fallo en arista o inserción (`add_edge`, `has_edge`) | Valor booleano `false` | Indicador unívoco de fallo frente a `true` (éxito), evitando excepciones o tipos `Option`/`Result` no previstos en la fase. |
| Layout de archivos `src/` y `test/` | Estructura modular Gradle (`lib/src/main/groovy`, `lib/src/test/groovy`) | Estándar de Gradle para proyectos Groovy/Java; el runner de pruebas es `./gradlew test`. |

---

## 🚨 Indicadores de fallo / Failure indicators

| Operación / Operation | Situación de fallo / Failure situation | Indicador / Indicator | Ejemplo / Example |
|---|---|---|---|
| `BinaryTree.contains(value)` | Árbol vacío o valor no encontrado | `false` | `new BinaryTree().contains(50) == false` |
| `Graph.addEdge(u, v)` | Vértice origen `u` o destino `v` inexistente | `false` | `new Graph().addEdge(10, 99) == false` |
| `Graph.hasEdge(u, v)` | Extremo origen o destino no registrado, o arista inexistente | `false` | `new Graph().hasEdge(10, 30) == false` |
| `Graph.getNeighbors(u)` | Vértice `u` inexistente en el registro | `null` | `new Graph().getNeighbors(99) == null` |

---

## ✅ Cobertura de pruebas / Test coverage

| Caso de la especificación / Specification case | Cubierto / Covered | Prueba / Test | Notas / Notes |
|---|---|:--:|---|
| **TreeNode**: Crear un nodo de árbol | Sí | `TreeNode should create a tree node` | Verifica asignación y obtención de `value == 10`. |
| **TreeNode**: Enlaces iniciales ausentes | Sí | `TreeNode should expose absent initial links` | Verifica `left == null` y `right == null`. |
| **TreeNode**: Enlazar dos hijos | Sí | `TreeNode should link two children` | Enlaza hijos 20 y 30 y verifica valores vía `getLeft()` y `getRight()`. |
| **TreeNode**: Recorrer cada enlace | Sí | `TreeNode should traverse each link` | Recorre enlaces izquierdo y derecho confirmando ausencia de hijos en las hojas. |
| **TreeNode**: Desenlazar hijos | Sí | `TreeNode should unlink children` | Desvincula secuencialmente `setLeft(null)` y `setRight(null)` preservando invariantes. |
| **TreeNode**: Adaptación inmutable | Omitido | — | No aplica: Groovy implementa nodos mutables con referencias anulables directas. |
| **BinaryTree**: Crear vacío | Sí | `BinaryTree should be empty on creation` | Verifica `isEmpty() == true`, `size == 0` y `contains(50) == false`. |
| **BinaryTree**: Insertar la raíz | Sí | `BinaryTree should insert the root` | Inserta 50; verifica éxito, tamaño 1, no vacío y `contains(50) == true`. |
| **BinaryTree**: Insertar menor y mayor | Sí | `BinaryTree should insert lower and higher values` | Inserta 50, 30, 70; verifica éxitos, tamaño 3 y pertenencia de los tres. |
| **BinaryTree**: Ramas de varios niveles | Sí | `BinaryTree should keep multilevel branches` | Inserta 50, 30, 70, 20, 40; verifica tamaño 5 y pertenencia de todos los valores. |
| **BinaryTree**: Valor ausente en árbol no vacío | Sí | `BinaryTree should fail on a missing value in a nonempty tree` | Árbol con 50; `contains(99)` falla (`false`), tamaño 1 y `50` presente. |
| **BinaryTree**: Duplicado idempotente | Sí | `BinaryTree should treat a duplicate as idempotent` | Inserta 50, 30, 70, 30; éxito, tamaño se mantiene en 3 y conserva valores. |
| **BinaryTree**: Inserciones ordenadas | Sí | `BinaryTree should accept ordered insertions` | Inserta 20, 30, 40, 50, 70; tamaño 5, pertenencia y `contains(99) == false`. |
| **Graph**: Crear vacío | Sí | `Graph should be empty on creation` | Verifica `isEmpty() == true`, contadores en 0, `hasEdge` y `getNeighbors` fallan. |
| **Graph**: Vértice aislado | Sí | `Graph should hold an isolated vertex` | Registra 10; 1 vértice, 0 aristas y vecinos `[]` (vacío, no `null`). |
| **Graph**: Etiquetas no consecutivas y arista dirigida | Sí | `Graph should keep a directed edge between nonconsecutive labels` | Registra 10 y 70, arista (10,70); éxito en sentido directo, fallo en inverso; 2 vértices, 1 arista. |
| **Graph**: Vértice duplicado conserva adyacencia | Sí | `Graph should preserve adjacency on a duplicate vertex` | Registra 10, 30, arista (10,30), re-registra 10; 2 vértices, 1 arista, vecinos `[30]`. |
| **Graph**: Arista duplicada | Sí | `Graph should treat a duplicate edge as idempotent` | Añade arista (10,30) dos veces; éxitos, 2 vértices, 1 arista, vecinos `[30]`. |
| **Graph**: Extremo inexistente sin mutación | Sí | `Graph should reject a missing endpoint without mutation` | Intenta aristas con extremos 98/99; 4 fallos, estado intacto y consultas fallan. |
| **Graph**: Vecinos ordenados y contadores | Sí | `Graph should list sorted neighbours and counts` | Añade múltiples aristas desordenadas; verifica vecinos ordenados `[30, 50, 70]` y contadores. |
| **Graph**: Consulta de arista ausente | Sí | `Graph should fail a missing-edge query` | Vértices registrados 10 y 30 sin arista; `hasEdge(10,30)` devuelve `false`. |
| **Graph**: Vecinos de vértice inexistente | Sí | `Graph should distinguish failure from empty neighbours of a missing vertex` | Distingue `getNeighbors(99) == null` de `getNeighbors(10) == []`. |
| **Graph**: Bucle y duplicado | Sí | `Graph should accept a self-loop and its duplicate` | Arista (10,10) duplicada; `hasEdge(10,10) == true`, vecinos `[10]`, 1 arista. |
| **Graph**: Aislamiento del resultado de vecinos | Sí | `Graph should isolate the neighbour result from the graph` | Modificar lista devuelta o añadir nuevas aristas no altera copias previas. |

---

## ⚠️ Limitaciones conocidas / Known limitations

| Limitación / Limitation | Impacto / Impact | Alternativa o plan / Workaround or plan |
|---|---|---|
| Ninguna / None | El módulo cumple con todos los criterios de aceptación y las cotas de complejidad de la especificación. | — |

---

## 📝 Notas de implementación / Implementation Notes

### Mutabilidad y representación de ausencia / Mutability and absence representation

**ES:** En Groovy sobre JVM, las referencias a objetos son anulables de forma natural. Los punteros de enlace (`TreeNode.left`, `TreeNode.right`, `GraphNode.nextVertex`) utilizan `null` como representación canónica de ausencia. Las mutaciones de estado en las estructuras (`insert`, `addVertex`, `addEdge`) modifican las referencias en memoria de forma destructiva local sin clonar innecesariamente el árbol o el grafo.

**EN:** In Groovy on the JVM, object references are naturally nullable. Link pointers (`TreeNode.left`, `TreeNode.right`, `GraphNode.nextVertex`) use `null` as the canonical absence representation. State mutations in the structures (`insert`, `addVertex`, `addEdge`) alter memory references directly without unnecessarily cloning the tree or graph.

### Anotación `@CompileStatic` / `@CompileStatic` annotation

**ES:** Todos los archivos fuente (`Node.groovy`, `TreeNode.groovy`, `BinaryTree.groovy`, `GraphNode.groovy`, `Graph.groovy`) aplican `@CompileStatic`. Esto fuerza la resolución estática de tipos en tiempo de compilación y optimiza el bytecode generado, garantizando rendimiento equivalente a Java y verificación estática estricta.

**EN:** All source files (`Node.groovy`, `TreeNode.groovy`, `BinaryTree.groovy`, `GraphNode.groovy`, `Graph.groovy`) apply `@CompileStatic`. This enforces static type checking at compile time and optimizes the generated bytecode, ensuring Java-grade execution performance and strict static validation.

### Implementación manual del registro y adyacencia / Manual registry and adjacency implementation

**ES:** Siguiendo el contrato de la especificación, `Graph` no utiliza ninguna estructura asociativa estándar de Java/Groovy (como `HashMap` o `TreeMap`). El registro canónico de vértices es una lista enlazada simple construida con el campo `GraphNode.nextVertex`. Las búsquedas de vértices se realizan por recorrido lineal `O(V)`. Para cada vértice, los vecinos se mantienen en orden ascendente realizando inserción ordenada en `O(d(u))`.

**EN:** In accordance with the specification contract, `Graph` does not use standard Java/Groovy associative collections (such as `HashMap` or `TreeMap`). The canonical vertex registry is a singly linked chain built via `GraphNode.nextVertex`. Vertex lookups are performed via linear traversal in `O(V)`. For each vertex, neighbours are kept in ascending order via manual ordered insertion in `O(d(u))`.

### Organización de pruebas con Spock / Test organization with Spock

**ES:** La suite de pruebas `DataStructuresAdvancedTest.groovy` utiliza Spock Framework. Se agrupan los escenarios de prueba en métodos específicos con bloques semánticos `when:`, `then:` y `given:`, garantizando asilamiento de estado en cada prueba unitaria y trazabilidad completa de cada caso contractual.

**EN:** The `DataStructuresAdvancedTest.groovy` test suite uses Spock Framework. Test scenarios are grouped into distinct feature methods with semantic `when:`, `then:`, and `given:` blocks, ensuring isolated state per unit test and complete traceability back to the specification.

---

Este proyecto también está implementado en otros lenguajes. Explora el repositorio principal para consultar las demás versiones.

🌐 [github.com/yorche3/programming_languages](https://github.com/yorche3/programming_languages) · [GitHub Pages](https://yorche3.github.io/programming_languages/)

---

## 🔍 Checklist de validación / Validation checklist

- [x] La suite nativa se ejecutó y su salida real está copiada en este README.
- [x] Cada caso de la especificación tiene su fila en _Cobertura de pruebas_ (o `Omitido` con razón).
- [x] Cada desviación del pseudocódigo o de la ubicación esperada está en _Adaptaciones idiomáticas_.
- [x] Cada operación con fallo posible está en _Indicadores de fallo_.
- [x] No hay rutas absolutas del autor, credenciales ni salidas inventadas.
- [x] Los enlaces relativos resuelven dentro del repositorio y el documento es bilingüe.
- [x] Ninguna sección repite lo que ya dice la especificación.

---

## 📚 Referencias / References

| Tipo / Kind | Referencia / Reference |
|---|---|
| Especificación / Specification | [`07_Data_Structures_Advanced.md`](../../../../../docs/core/algorithms/07_Data_Structures_Advanced.md) |
| Primera base del lenguaje / First language reference | `data_structures_basics` — [`data_structures_basics/README.md`](../data_structures_basics/README.md) |
| Segunda base del lenguaje / Second language reference | `numbers` — [`numbers/README.md`](../../foundations/numbers/README.md) |
| Guía de inicialización / Initialisation guide | [`core/00_Project_Initialization_Guide.md`](../../../../../docs/core/00_Project_Initialization_Guide.md) |
| Adaptaciones idiomáticas / Idiomatic adaptations | [`AGENT_Template.md`](../../../../../docs/AGENT_Template.md) |
| Validación de la documentación / Documentation validation | [`WORKFLOW.md`](../../../../../docs/WORKFLOW.md) |
| Documentación oficial del lenguaje / Language official docs | [Groovy Documentation](https://groovy-lang.org/documentation.html) |
