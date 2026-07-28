# Numbers — Groovy

Implementación de la especificación [Numbers](https://github.com/yorche3/programming_languages) en **Groovy**, con un enfoque manual y minimalista.

---

## 📂 Archivos y estructura / Files & Structure

Proyecto Gradle que contiene una biblioteca de operaciones numéricas implementadas con tres enfoques (recursivo directo, con acumulador e iterativo) y sus pruebas unitarias con Spock.

| Archivo / Directorio | Propósito |
|----------------------|-----------|
| `lib/src/main/groovy/org/example/Numbers.groovy` | Código fuente con todos los algoritmos. |
| `lib/src/test/groovy/org/example/NumbersRecTest.groovy` | Pruebas unitarias para los métodos recursivos directos. |
| `lib/src/test/groovy/org/example/NumbersIteTest.groovy` | Pruebas unitarias para los métodos iterativos. |
| `settings.gradle` | Configuración del proyecto raíz y submódulo `lib`. |
| `lib/build.gradle` | Plugins, dependencias y framework de pruebas. |
| `gradle.properties` | Propiedades JVM para Gradle. |
| `gradle/libs.versions.toml` | Catálogo de versiones. |
| `gradlew` / `gradlew.bat` | Gradle Wrapper (Unix / Windows). |
| `gradle/wrapper/` | Binarios y configuración del Wrapper. |
| `.gitignore` | Ignora `.gradle`, `build` y `.kotlin`. |
| `.gitattributes` | Normaliza fines de línea. |

**Estructura de directorios esperada:**

```text
groovy/
└── core/
    └── foundations/
        └── numbers/
            ├── lib/
            │   ├── build.gradle
            │   └── src/
            │       ├── main/
            │       │   └── groovy/
            │       │       └── org/
            │       │           └── example/
            │       │               └── Numbers.groovy
            │       └── test/
            │           └── groovy/
            │               └── org/
            │                   └── example/
            │                       ├── NumbersRecTest.groovy
            │                       └── NumbersIteTest.groovy
            ├── gradle/
            │   ├── libs.versions.toml
            │   └── wrapper/
            │       ├── gradle-wrapper.jar
            │       └── gradle-wrapper.properties
            ├── settings.gradle
            ├── gradle.properties
            ├── gradlew
            ├── gradlew.bat
            ├── .gitignore
            └── .gitattributes
```

---

## 🛠️ Enfoque y construcción / Approach & Build

**ES:** El proyecto se creó manualmente, sin herramientas de scaffolding automático, para controlar cada detalle. Se usa Gradle con DSL de Groovy para describir las dependencias y ejecutar las pruebas.

**EN:** The project was created manually, without automatic scaffolding tools, to control every detail. Gradle with Groovy DSL is used to describe dependencies and run tests.

### Inicialización / Initialization

1. Crear la estructura de directorios:

   ```bash
   mkdir -p groovy/core/foundations/numbers/lib/src/main/groovy/org/example
   mkdir -p groovy/core/foundations/numbers/lib/src/test/groovy/org/example
   ```

2. Escribir `Numbers.groovy`, `NumbersRecTest.groovy` y `NumbersIteTest.groovy`.

3. Crear los archivos de configuración `settings.gradle`, `lib/build.gradle`, `gradle.properties` y `.gitignore`.

4. (Opcional) Generar el Gradle Wrapper:

   ```bash
   gradle wrapper --gradle-version 8.12
   ```

---

## 📄 Archivos de configuración clave / Key Configuration Files

### `settings.gradle` – Configuración del proyecto

```groovy
rootProject.name = 'numbers'
include('lib')
```

### `lib/build.gradle` – Configuración de build

```groovy
plugins {
    id 'groovy'
    id 'java-library'
    id 'com.adarshr.test-logger' version '4.0.0'
}

repositories {
    mavenCentral()
}

dependencies {
    implementation libs.groovy.all
    implementation libs.guava
    api libs.commons.math3
}

testing {
    suites {
        test {
            useSpock('2.4-groovy-4.0')
        }
    }
}

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(21)
    }
}
```

### `gradle.properties` – Propiedades de Gradle

```properties
org.gradle.jvmargs=-Xmx1024m -Dfile.encoding=UTF-8
```

### `gradle/libs.versions.toml` – Catálogo de versiones

```toml
[versions]
groovy-all = "4.0.28"
guava = "33.4.6-jre"
testLogger = "4.0.0"
commons-math = "3.6.1"
spock = "2.4-groovy-4.0"

[libraries]
groovy-all = { module = "org.apache.groovy:groovy-all", version.ref = "groovy-all" }
guava = { module = "com.google.guava:guava", version.ref = "guava" }
commons-math3 = { module = "org.apache.commons:commons-math3", version.ref = "commons-math" }
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

### Salida esperada de las pruebas / Expected test output:

```text
NumbersRecTest > Sum First N Rec PASSED
NumbersRecTest > Factorial Rec PASSED
NumbersRecTest > Fibonacci Rec PASSED
NumbersRecTest > GCD Rec PASSED
NumbersRecTest > LCM Rec PASSED

NumbersIteTest > Sum First N Ite PASSED
NumbersIteTest > Factorial Ite PASSED
NumbersIteTest > Fibonacci Ite PASSED
NumbersIteTest > GCD Ite PASSED
NumbersIteTest > LCM Ite PASSED

BUILD SUCCESSFUL in 2s
```

---

## 🧠 Algoritmos / operaciones

| Función / Algoritmo | Enfoques | Descripción |
|---------------------|-----------|-------------|
| `sum_of_first_n`    | `_rec`, `_acc`, `_ite` | Suma de los primeros `n` números naturales. |
| `factorial`         | `_rec`, `_acc`, `_ite` | Factorial de `n`. |
| `fibonacci`         | `_rec`, `_acc`, `_ite` | Término `n`‑ésimo de la sucesión de Fibonacci. |
| `gcd`               | `_rec`, `_ite` | Máximo común divisor (algoritmo de Euclides). |
| `lcm`               | `_rec`, `_ite` | Mínimo común múltiplo (calculado a partir del GCD). |

> Los métodos con acumulador se conservan solo con fines educativos (ver Notas de implementación).

---

## 📝 Notas de implementación / Implementation Notes

### 🔁 Sobre recursión con acumulador y Tail Call Optimization (TCO) / On recursion with accumulator and Tail Call Optimization (TCO)

**ES:**  
Tail recursion ocurre cuando la llamada recursiva es la última acción que ejecuta una función/método; después de la llamada no hay más instrucciones, la función devuelve el resultado de la llamada recursiva. La recursión con acumulador consigue esto pasando el estado previo como parámetro a cada llamada, sin dejar trabajo pendiente en la pila.

En este lenguaje, **no** se garantiza TCO. Groovy se ejecuta sobre la JVM, la cual no ofrece soporte nativo para optimización de llamadas de cola. Las implementaciones con acumulador no reciben ningún beneficio de rendimiento frente a la recursión directa en este entorno.

La implementación con acumulador se conserva únicamente con fines educativos: sirve como puente conceptual entre la recursión directa (más cercana a la definición matemática) y la versión iterativa (más eficiente). Como en este contexto no hay un beneficio práctico de rendimiento, no se desarrollan pruebas unitarias específicas para los métodos con acumulador. La validación del comportamiento se cubre a través de las pruebas de los enfoques recursivo e iterativo, que juntos ejercitan los mismos resultados.

**EN:**  
Tail recursion occurs when the recursive call is the last action that runs a function/method; after the call there are no more instructions, the function returns the result of the recursive call. Recursion with accumulator gets this by passing the previous state as a parameter to each call, without leaving any pending work on the stack.

This language **does not** guarantee TCO. Groovy runs on the JVM, which does not provide native support for tail‑call optimization. The accumulator implementations receive no performance benefit over direct recursion in this environment.

The accumulator implementation is preserved only for educational purposes: it serves as a conceptual bridge between the direct recursive (closer to mathematical definition) and the iterative version (more efficient). Since there is no practical performance benefit, no specific unit tests are developed for the recursive methods with accumulator.

### Métodos estáticos y de instancia / Static vs. instance methods

**ES:** Algunos métodos (recursivos directos e iterativos) se declaran `static` para evitar la creación de instancias innecesarias. Los métodos con acumulador son de instancia porque se apoyan en helpers privados. Esta separación es puramente organizativa y no altera el comportamiento de los algoritmos.

**EN:** Some methods (direct recursive and iterative) are declared `static` to avoid unnecessary instantiation. The accumulator methods are instance methods because they rely on private helpers. This separation is purely organizational and does not affect algorithm behavior.

---

Este proyecto también está implementado en otros lenguajes. Explora el repositorio principal para ver todas las versiones.

🌐 [github.com/yorche3/programming_languages](https://github.com/yorche3/programming_languages) · [GitHub Pages](https://yorche3.github.io/programming_languages/)