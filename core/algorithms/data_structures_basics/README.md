# Data Structures Basics — Groovy

Implementación de la especificación [Data Structures Basics](https://github.com/yorche3/programming_languages/docs/core/algorithms/06_Data_Structures_Basics.md) en **Groovy**, con un enfoque manual y minimalista.

**ES:** Implementación de `Node`, `LinkedList`, `Stack` y `Queue` sobre nodos enlazados manualmente, sin delegar en colecciones de la biblioteca estándar. Proyecto Gradle con Spock como framework de pruebas.

**EN:** Implementation of `Node`, `LinkedList`, `Stack` and `Queue` over manually linked nodes, without delegating to standard-library collections. Gradle project with Spock as the test framework.

---

## 📂 Archivos y estructura / Files & Structure

Proyecto Gradle que contiene una biblioteca de estructuras de datos enlazadas implementadas desde cero y sus pruebas unitarias con Spock.

| Archivo / Directorio | Propósito |
|----------------------|-----------|
| `lib/src/main/groovy/data_structures_basics/Node.groovy` | Tipo de nodo enlazado compartido por las tres estructuras. |
| `lib/src/main/groovy/data_structures_basics/LinkedList.groovy` | Lista enlazada simple con inserción por ambos extremos y eliminación. |
| `lib/src/main/groovy/data_structures_basics/Stack.groovy` | Pila LIFO sobre `Node`. |
| `lib/src/main/groovy/data_structures_basics/Queue.groovy` | Cola FIFO sobre `Node`. |
| `lib/src/test/groovy/data_structures_basics/DataStructuresBasicsTest.groovy` | Pruebas unitarias con Spock para las cuatro estructuras. |
| `settings.gradle` | Configuración del proyecto raíz y submódulo `lib`. |
| `lib/build.gradle` | Plugins, dependencias y framework de pruebas. |
| `gradle.properties` | Propiedades JVM para Gradle. |
| `gradle/libs.versions.toml` | Catálogo de versiones. |
| `gradlew` / `gradlew.bat` | Gradle Wrapper (Unix / Windows). |
| `gradle/wrapper/` | Binarios y configuración del Wrapper. |
| `.gitignore` | Ignora `.gradle`, `build` y `.kotlin`. |
| `.gitattributes` | Normaliza fines de línea. |

**Desviación de la ubicación esperada:**

La especificación propone `src/data_structures_basics.ext` y `test/run_tests.ext`. Esta implementación usa el layout estándar de Gradle: `lib/src/main/groovy/` para el código fuente y `lib/src/test/groovy/` para las pruebas. La razón es que Gradle espera esa estructura para proyectos con el plugin `groovy` y `java-library`, y el runner de pruebas es el propio Gradle (`./gradlew test`) en lugar de un script `run_tests.ext` manual.

**EN:** The specification proposes `src/data_structures_basics.ext` and `test/run_tests.ext`. This implementation uses Gradle's standard layout: `lib/src/main/groovy/` for source code and `lib/src/test/groovy/` for tests. The reason is that Gradle expects this structure for projects with the `groovy` and `java-library` plugins, and the test runner is Gradle itself (`./gradlew test`) instead of a manual `run_tests.ext` script.

---

## 🛠️ Enfoque y construcción / Approach & Build

**ES:** El proyecto se creó con `gradle init` para generar el andamiaje básico de un proyecto Groovy con Gradle, y luego se escribieron manualmente las cuatro estructuras y sus pruebas. Se usa Gradle con DSL de Groovy para describir las dependencias y ejecutar las pruebas.

**EN:** The project was created with `gradle init` to generate the basic scaffolding of a Groovy project with Gradle, and then the four structures and their tests were written manually. Gradle with Groovy DSL is used to describe dependencies and run tests.

### Inicialización / Initialization

1. Generar el proyecto base con Gradle:

   ```bash
   gradle init --type groovy-library --dsl groovy --test-framework spock --project-name data_structures_basics
   ```

2. Escribir `Node.groovy`, `LinkedList.groovy`, `Stack.groovy`, `Queue.groovy` y `DataStructuresBasicsTest.groovy`.

3. Ajustar `settings.gradle`, `lib/build.gradle` y `gradle/libs.versions.toml` para las dependencias necesarias.

4. (Opcional) Generar el Gradle Wrapper:

   ```bash
   gradle wrapper --gradle-version 9.6.1
   ```

---

## 📄 Configuración clave / Key Configuration

### `settings.gradle` – Configuración del proyecto

```groovy
plugins {
    id 'org.gradle.toolchains.foojay-resolver-convention' version '1.0.0'
}

rootProject.name = 'data_structures_basics'
include('lib')
```

### `lib/build.gradle` – Configuración de build

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
    api libs.commons.math3
    testImplementation libs.spock.core
    testImplementation libs.junit
    testRuntimeOnly 'org.junit.platform:junit-platform-launcher'
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

### `gradle/libs.versions.toml` – Catálogo de versiones

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

### `.gitignore` – Archivos ignorados

```gitignore
.gradle
build
.kotlin
```

### `.gitattributes` – Normalización de fin de línea

```gitattributes
/gradlew        text eol=lf
*.bat           text eol=crlf
*.jar           binary
```

---

## 🚀 Compilación y ejecución / Build & Run

### Compilar / Build

```bash
./gradlew build
```

Compila el código fuente, ejecuta todas las pruebas y empaqueta la biblioteca en `lib/build/libs/`.

### Ejecutar pruebas unitarias / Run tests

```bash
./gradlew test
```

O directamente sobre el submódulo:

```bash
./gradlew :lib:test
```

### Salida real de las pruebas / Actual test output:

```text
> Task :lib:compileJava NO-SOURCE
> Task :lib:processResources NO-SOURCE
> Task :lib:processTestResources NO-SOURCE
> Task :lib:compileGroovy
> Task :lib:classes
> Task :lib:compileTestJava NO-SOURCE
> Task :lib:compileTestGroovy
> Task :lib:testClasses
> Task :lib:test

BUILD SUCCESSFUL in 2s
3 actionable tasks: 3 executed
```

**ES:** La suite ejecutó 4 pruebas (una por estructura: `Node`, `LinkedList`, `Stack`, `Queue`) con 0 fallos y 0 omitidas. Duración: 0.739s.

**EN:** The suite ran 4 tests (one per structure: `Node`, `LinkedList`, `Stack`, `Queue`) with 0 failures and 0 skipped. Duration: 0.739s.

---

## 🧠 Algoritmos y operaciones / Algorithms & Operations

| Operación / Operation | Entrada → salida / Input → output | Complejidad / Complexity | Notas / Notes |
|---|---|---|---|
| `Node(value)` | `Integer → Node` | `O(1)` | Constructor que asigna `value` y deja `next` en `null`. |
| `Node.getValue()` | `→ Integer` | `O(1)` | Devuelve el valor del nodo. |
| `Node.getNext()` | `→ Node` | `O(1)` | Devuelve el enlace al siguiente nodo, o `null`. |
| `Node.setNext(next)` | `Node → void` | `O(1)` | Enlaza con el siguiente nodo. |
| `LinkedList()` | `→ LinkedList` | `O(1)` | Constructor que inicializa lista vacía (`head`, `tail` en `null`, `count = 0`). Equivale a `init()`. |
| `LinkedList.getHeadValue()` | `→ int` | `O(1)` | Valor de la cabeza, o `-1` si está vacía. |
| `LinkedList.insertHead(value)` | `Integer → void` | `O(1)` | Inserta al inicio. |
| `LinkedList.insertTail(value)` | `Integer → void` | `O(1)` | Inserta al final. |
| `LinkedList.delete(value)` | `Integer → boolean` | `O(n)` | Elimina la primera aparición; devuelve `true` en éxito, `false` si no existe. |
| `LinkedList.isEmpty()` | `→ boolean` | `O(1)` | `true` cuando `count == 0`. |
| `LinkedList.getSize()` | `→ int` | `O(1)` | Número de nodos almacenados. |
| `Stack()` | `→ Stack` | `O(1)` | Constructor que inicializa pila vacía (`top` en `null`, `count = 0`). Equivale a `init()`. |
| `Stack.push(value)` | `Integer → void` | `O(1)` | Coloca valor sobre `top`. |
| `Stack.pop()` | `→ int` | `O(1)` | Extrae y devuelve el tope, o `-1` si está vacía. |
| `Stack.peek()` | `→ int` | `O(1)` | Observa el tope sin extraer, o `-1` si está vacía. |
| `Stack.isEmpty()` | `→ boolean` | `O(1)` | `true` cuando `count == 0`. |
| `Stack.getSize()` | `→ int` | `O(1)` | Número de elementos almacenados. |
| `Queue()` | `→ Queue` | `O(1)` | Constructor que inicializa cola vacía (`front`, `rear` en `null`, `count = 0`). Equivale a `init()`. |
| `Queue.enqueue(value)` | `Integer → void` | `O(1)` | Añade valor tras `rear`. |
| `Queue.dequeue()` | `→ int` | `O(1)` | Extrae y devuelve el frente, o `-1` si está vacía. |
| `Queue.peek()` | `→ int` | `O(1)` | Observa el frente sin extraer, o `-1` si está vacía. |
| `Queue.isEmpty()` | `→ boolean` | `O(1)` | `true` cuando `count == 0`. |
| `Queue.getSize()` | `→ int` | `O(1)` | Número de elementos almacenados. |

---

## 🧩 Decisiones de diseño / Design decisions

| Decisión / Decision | Alternativa considerada / Alternative | Razón / Reason |
|---|---|---|
| Usar el constructor por defecto como `init` | Método `init()` explícito separado del constructor | Groovy permite constructores con parámetros y el constructor sin argumentos inicializa los campos a sus valores por defecto (`null` para objetos, `0` para enteros). `new Node(value)`, `new LinkedList()`, `new Stack()` y `new Queue()` cumplen el contrato de `init` sin requerir un método adicional. |
| `Node` con `value` final y `next` mutable | Ambos campos mutables, o ambos inmutables | El valor de un nodo no cambia tras su creación (inmutabilidad parcial), pero el enlace `next` debe poder actualizarse para construir la estructura. Esta separación refleja el contrato: el valor se asigna en `init`, el enlace se modifica con `set_next`. |
| Una clase por estructura en archivos separados | Todas las estructuras en un solo archivo | Groovy permite múltiples clases por archivo, pero separarlas mejora la legibilidad y sigue la convención de un tipo público por archivo. |
| `int` como tipo de retorno para `getHeadValue`, `pop`, `peek`, `dequeue` | `Integer` (nullable) | El contrato exige un indicador de fallo natural. Groovy sobre JVM no tiene tipos de valor anulables sin envoltorios, y la fase prohíbe `Option`/`Maybe`. Usar `int` con `-1` como centinela es el indicador más simple y directo. |

---

## 🔀 Adaptaciones idiomáticas / Idiomatic adaptations

| Especificación / Specification | Adaptación / Adaptation | Justificación / Justification |
|---|---|---|
| `init()` como método separado para inicializar la estructura | Constructor por defecto `new LinkedList()`, `new Stack()`, `new Queue()` | Groovy es un lenguaje orientado a objetos con constructores. El constructor sin argumentos inicializa los campos a sus valores por defecto (`null` para referencias, `0` para enteros), cumpliendo el contrato de `init` sin requerir un método adicional. |
| `Node.init(value)` como método de instancia | Constructor `new Node(value)` | El constructor asigna `value` y deja `next` en `null`, que es la representación nativa de ausencia en Groovy para tipos de referencia. |
| `get_value()`, `get_next()`, `set_next(next)` como métodos explícitos | Propiedades de Groovy: `node.value`, `node.next`, `node.next = other` | Groovy genera automáticamente getters y setters para campos públicos o anotados con `@CompileStatic`. El acceso por propiedades es idiomático y equivalente a los métodos explícitos. |
| `get_head()` como método | Propiedad `list.headValue` (getter `getHeadValue()`) | Groovy expone propiedades mediante getters. `list.headValue` invoca `getHeadValue()` de forma idiomática. |
| `is_empty()` como método | Método `isEmpty()` | Convención de Java/Groovy para predicados booleanos. `list.isEmpty()` es idiomático. |
| `size()` como método | Propiedad `list.size` (getter `getSize()`) | Groovy expone `size` como propiedad mediante el getter `getSize()`. |
| Ubicación esperada: `src/data_structures_basics.ext` y `test/run_tests.ext` | Layout de Gradle: `lib/src/main/groovy/` y `lib/src/test/groovy/` | Gradle espera esta estructura para proyectos con el plugin `groovy`. El runner es `./gradlew test` en lugar de un script manual. |
| Ausencia de enlace representada con `null` | `null` como indicador nativo de ausencia | Groovy es un lenguaje de JVM con tipos de referencia anulables. `null` es la representación natural de "sin enlace" para `Node.next`, `head`, `tail`, `top`, `front` y `rear`. |
| Indicador de fallo: `-1` para valores, `false` para operaciones booleanas | `null` o excepciones | La fase prohíbe `Option`/`Maybe`/`Result` y excepciones para indicar fallo. `-1` es un centinela válido porque los casos de prueba usan solo enteros positivos. `false` indica que `delete` no encontró el valor. |

---

## 🚨 Indicadores de fallo / Failure indicators

| Operación / Operation | Situación de fallo / Failure situation | Indicador / Indicator | Ejemplo / Example |
|---|---|---|---|
| `LinkedList.getHeadValue()` | Lista vacía | `-1` | `new LinkedList().headValue == -1` |
| `LinkedList.delete(value)` | Valor no existe en la lista | `false` | `list.delete(99) == false` |
| `Stack.pop()` | Pila vacía | `-1` | `new Stack().pop() == -1` |
| `Stack.peek()` | Pila vacía | `-1` | `new Stack().peek() == -1` |
| `Queue.dequeue()` | Cola vacía | `-1` | `new Queue().dequeue() == -1` |
| `Queue.peek()` | Cola vacía | `-1` | `new Queue().peek() == -1` |

---

## ✅ Cobertura de pruebas / Test coverage

| Caso de la especificación / Specification case | Cubierto / Covered | Prueba / Test | Notas / Notes |
|---|---|:--:|---|
| **Node**: Inicializar y observar valor/enlace | Sí | `DataStructuresBasicsTest.groovy:assertNodeCases()` | Verifica `value` y `next == null` tras `new Node(10)`. |
| **Node**: Inicializar otro nodo, enlazar y recorrer | Sí | `DataStructuresBasicsTest.groovy:assertNodeCases()` | Verifica `firstNode.next.value == 20` y `secondNode.next == null`. |
| **LinkedList**: Estado vacío | Sí | `DataStructuresBasicsTest.groovy:assertLinkedListCases()` | Verifica `isEmpty() == true`, `size == 0`, `headValue == -1`. |
| **LinkedList**: Insertar por ambos extremos | Sí | `DataStructuresBasicsTest.groovy:assertLinkedListCases()` | Inserta `10`, `20`, `5`, `10`; verifica `size == 4` y recorrido desde `headValue`. |
| **LinkedList**: Eliminar primera aparición | Sí | `DataStructuresBasicsTest.groovy:assertLinkedListCases()` | Elimina `10`; verifica `size == 3` y `headValue` conservado. |
| **LinkedList**: Valor ausente | Sí | `DataStructuresBasicsTest.groovy:assertLinkedListCases()` | `delete(99)` devuelve `false`; tamaño y recorrido no cambian. |
| **LinkedList**: Vaciar | Sí | `DataStructuresBasicsTest.groovy:assertLinkedListCases()` | Elimina `5`, `20`, `10`; verifica `isEmpty() == true`, `size == 0`, `headValue == -1`. |
| **Stack**: Estado vacío y extracción fallida | Sí | `DataStructuresBasicsTest.groovy:assertStackCases()` | Verifica `isEmpty() == true`, `size == 0`, `peek() == -1`, `pop() == -1`. |
| **Stack**: LIFO y `peek` no mutante | Sí | `DataStructuresBasicsTest.groovy:assertStackCases()` | `push(10)`, `push(20)`, `push(30)`; `peek() == 30`, `size == 3`. |
| **Stack**: Extracción y reutilización | Sí | `DataStructuresBasicsTest.groovy:assertStackCases()` | `pop()` devuelve `30`, `push(40)`, tres `pop()` devuelven `40`, `20`, `10`; `isEmpty() == true`. |
| **Stack**: Vacío tras extracción | Sí | `DataStructuresBasicsTest.groovy:assertStackCases()` | `pop()` sobre pila vacía devuelve `-1`; `isEmpty()` sigue `true`. |
| **Queue**: Estado vacío y extracción fallida | Sí | `DataStructuresBasicsTest.groovy:assertQueueCases()` | Verifica `isEmpty() == true`, `size == 0`, `peek() == -1`, `dequeue() == -1`. |
| **Queue**: FIFO y `peek` no mutante | Sí | `DataStructuresBasicsTest.groovy:assertQueueCases()` | `enqueue(10)`, `enqueue(20)`, `enqueue(30)`; `peek() == 10`, `size == 3`. |
| **Queue**: Extracción y reutilización | Sí | `DataStructuresBasicsTest.groovy:assertQueueCases()` | `dequeue()` devuelve `10`, `enqueue(40)`, tres `dequeue()` devuelven `20`, `30`, `40`; `isEmpty() == true`. |
| **Queue**: Vacío tras extracción | Sí | `DataStructuresBasicsTest.groovy:assertQueueCases()` | `dequeue()` sobre cola vacía devuelve `-1`; `isEmpty()` sigue `true`. |

**Total de pruebas:** 4 (una por estructura), todas con múltiples aserciones que cubren los casos de la especificación.

---

## ⚠️ Limitaciones conocidas / Known limitations

| Limitación / Limitation | Impacto / Impact | Alternativa o plan / Workaround or plan |
|---|---|---|
| Ninguna / None | El módulo cumple todos los criterios de aceptación de la especificación. | — |

---

## 📝 Notas de implementación / Implementation Notes

### Mutabilidad y representación de ausencia / Mutability and absence representation

**ES:** Groovy es un lenguaje de JVM que permite mutación y tipos de referencia anulables. `Node.next`, `head`, `tail`, `top`, `front` y `rear` son campos mutables que se inicializan en `null` (la representación nativa de ausencia). Las estructuras son mutables: `insertHead`, `insertTail`, `delete`, `push`, `pop`, `enqueue` y `dequeue` modifican el estado interno.

**EN:** Groovy is a JVM language that allows mutation and nullable reference types. `Node.next`, `head`, `tail`, `top`, `front` and `rear` are mutable fields initialized to `null` (the native representation of absence). Structures are mutable: `insertHead`, `insertTail`, `delete`, `push`, `pop`, `enqueue` and `dequeue` modify internal state.

### Anotación `@CompileStatic` / `@CompileStatic` annotation

**ES:** Todas las clases están anotadas con `@CompileStatic` para habilitar la compilación estática de Groovy, que mejora el rendimiento y detecta errores de tipo en tiempo de compilación. Esta anotación no altera la semántica de los algoritmos.

**EN:** All classes are annotated with `@CompileStatic` to enable Groovy's static compilation, which improves performance and detects type errors at compile time. This annotation does not alter the algorithms' semantics.

### Estructura de pruebas con Spock / Test structure with Spock

**ES:** Las pruebas usan Spock, un framework de especificaciones basado en Groovy. Cada estructura tiene un método estático privado (`assertNodeCases`, `assertLinkedListCases`, `assertStackCases`, `assertQueueCases`) que ejecuta todos los casos de la especificación sobre una misma instancia, siguiendo la secuencia de pasos sucesivos que exige el contrato. Los métodos de prueba (`def "..."()`) invocan estos helpers.

**EN:** Tests use Spock, a Groovy-based specification framework. Each structure has a private static method (`assertNodeCases`, `assertLinkedListCases`, `assertStackCases`, `assertQueueCases`) that runs all specification cases on the same instance, following the successive-steps sequence the contract requires. Test methods (`def "..."()`) invoke these helpers.

### Independencia de estructuras / Structure independence

**ES:** `LinkedList`, `Stack` y `Queue` reutilizan el mismo tipo `Node`, pero cada una gestiona sus propios punteros y contador. `Stack` no envuelve a `LinkedList`; `Queue` no delega en `LinkedList`. Cada ADT es independiente y se implementa manualmente sobre `Node`, como exige la especificación.

**EN:** `LinkedList`, `Stack` and `Queue` reuse the same `Node` type, but each manages its own pointers and count. `Stack` does not wrap `LinkedList`; `Queue` does not delegate to `LinkedList`. Each ADT is independent and implemented manually over `Node`, as the specification requires.

---

Este proyecto también está implementado en otros lenguajes. Explora el repositorio principal para consultar las demás versiones.

🌐 [github.com/yorche3/programming_languages](https://github.com/yorche3/programming_languages) · [GitHub Pages](https://yorche3.github.io/programming_languages/)

---

## 🔍 Checklist de validación / Validation checklist

- [x] La suite nativa se ejecutó y su salida real está copiada en este README.
- [x] Cada caso de la especificación tiene su fila en _Cobertura de pruebas_.
- [x] Cada desviación del pseudocódigo o de la ubicación esperada está en _Adaptaciones idiomáticas_.
- [x] Cada operación con fallo posible está en _Indicadores de fallo_.
- [x] No hay rutas absolutas del autor, credenciales ni salidas inventadas.
- [x] Los enlaces relativos resuelven dentro del repositorio y el documento es bilingüe.
- [x] Ninguna sección repite lo que ya dice la especificación.

---

## 📚 Referencias / References

| Tipo / Kind | Referencia / Reference |
|---|---|
| Especificación / Specification | [`06_Data_Structures_Basics.md`](https://github.com/yorche3/programming_languages/docs/core/algorithms/06_Data_Structures_Basics.md) |
| Módulo homologado del lenguaje / Homologated module | [`groovy/core/foundations/numbers/`](../../foundations/numbers/README.md) |
| Guía de inicialización / Initialisation guide | [`core/00_Project_Initialization_Guide.md`](https://github.com/yorche3/programming_languages/docs/core/00_Project_Initialization_Guide.md) |
| Adaptaciones idiomáticas / Idiomatic adaptations | [`AGENT_Template.md`](https://github.com/yorche3/programming_languages/docs/AGENT_Template.md) |
| Validación de la documentación / Documentation validation | [`WORKFLOW.md`](https://github.com/yorche3/programming_languages/docs/WORKFLOW.md) |
| Documentación oficial del lenguaje / Language official docs | [Groovy Documentation](https://groovy-lang.org/documentation.html) |
