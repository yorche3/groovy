# Calculator — Groovy

Implementación de la especificación [Calculator](https://github.com/yorche3/programming_languages) en **Groovy**, con un enfoque manual y minimalista.

---

## 📂 Archivos y estructura / Files & Structure

Proyecto Gradle con estructura de submódulo `lib` que contiene una biblioteca de calculadora aritmética y sus pruebas unitarias con Spock.

| Archivo / Directorio | Propósito |
|----------------------|-----------|
| `lib/src/main/groovy/org/example/Calculator.groovy` | Código fuente de la calculadora (5 operaciones). |
| `lib/src/test/groovy/org/example/CalculatorTest.groovy` | Pruebas unitarias con Spock. |
| `settings.gradle` | Define el proyecto raíz e incluye el submódulo `lib`. |
| `lib/build.gradle` | Plugins, dependencias y configuración de pruebas. |
| `gradle.properties` | Propiedades JVM para Gradle. |
| `gradle/libs.versions.toml` | Catálogo centralizado de versiones de dependencias. |
| `gradlew` / `gradlew.bat` | Gradle Wrapper (Unix / Windows). |
| `gradle/wrapper/` | Binarios y propiedades del Wrapper. |
| `.gitignore` | Ignora `.gradle`, `build` y `.kotlin`. |
| `.gitattributes` | Normaliza fines de línea para `gradlew` y `*.bat`. |

**Estructura de directorios esperada:**

```text
groovy/
└── core/
    └── foundations/
        └── unit_test/
            └── calculator/
                ├── lib/
                │   ├── build.gradle
                │   └── src/
                │       ├── main/
                │       │   └── groovy/
                │       │       └── org/
                │       │           └── example/
                │       │               └── Calculator.groovy
                │       └── test/
                │           └── groovy/
                │               └── org/
                │                   └── example/
                │                       └── CalculatorTest.groovy
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

**ES:** El proyecto se creó manualmente, sin herramientas de scaffolding automático, para controlar cada detalle. Se usa Gradle con DSL de Groovy para describir las dependencias y la ejecución de pruebas.

**EN:** The project was created manually, without automatic scaffolding tools, to control every detail. Gradle with Groovy DSL is used to describe dependencies and test execution.

### Inicialización / Initialization

1. Crear la estructura de directorios:

   ```bash
   mkdir -p groovy/core/foundations/unit_test/calculator/lib/src/main/groovy/org/example
   mkdir -p groovy/core/foundations/unit_test/calculator/lib/src/test/groovy/org/example
   ```

2. Escribir `Calculator.groovy` y `CalculatorTest.groovy` en las rutas correspondientes.

3. Crear los archivos de configuración `settings.gradle`, `lib/build.gradle`, `gradle.properties` y `.gitignore`.

4. (Opcional) Generar el Gradle Wrapper si no está incluido:

   ```bash
   gradle wrapper --gradle-version 8.12
   ```

---

## 📄 Archivos de configuración clave / Key Configuration Files

### `settings.gradle` – Configuración del proyecto

```groovy
rootProject.name = 'calculator'
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

Compila el código fuente, ejecuta las pruebas y empaqueta la biblioteca en `lib/build/libs/`.

### Ejecutar pruebas unitarias / Run tests

```bash
./gradlew test
```

O apuntando directamente al submódulo:

```bash
./gradlew :lib:test
```

### Salida esperada de las pruebas / Expected test output:

```text
CalculatorTest > Addition Test PASSED
CalculatorTest > Subtraction Test PASSED
CalculatorTest > Multiplication Test PASSED
CalculatorTest > Division Test PASSED
CalculatorTest > Modulus Test PASSED

BUILD SUCCESSFUL in 2s
```

---

## 📝 Notas de implementación / Implementation Notes

### Operaciones aritméticas desde cero / Arithmetic operations from scratch

**ES:** La clase `Calculator` implementa suma, resta, multiplicación, división entera y módulo usando únicamente suma y resta como primitivas. La multiplicación se logra con sumas repetidas, la división con restas repetidas y el módulo mediante la relación `mod = a - (b × (a ÷ b))`. Este enfoque didáctico muestra cómo construir operaciones compuestas a partir de las elementales, sin usar los operadores `*`, `/` y `%` nativos.

**EN:** The `Calculator` class implements addition, subtraction, multiplication, integer division and modulus using only addition and subtraction as primitives. Multiplication is achieved by repeated addition, division by repeated subtraction, and modulus via the relation `mod = a - (b × (a ÷ b))`. This educational approach shows how to build compound operations from elementary ones, without using native `*`, `/` and `%` operators.

### Pruebas con Spock / Testing with Spock

**ES:** Se utiliza **Spock**, un framework para Groovy/Java que permite escribir especificaciones expresivas. Cada prueba tiene un nombre descriptivo en lenguaje natural y sigue la estructura `setup / when / then`, separando claramente preparación, acción y verificación. El plugin `com.adarshr.test-logger` mejora la salida mostrando cada prueba individualmente.

**EN:** **Spock** is used, a Groovy/Java framework for expressive specifications. Each test has a descriptive natural-language name and follows the `setup / when / then` structure, clearly separating preparation, action and verification. The `com.adarshr.test-logger` plugin enhances output by showing each test individually.

### Reproducibilidad con Gradle Wrapper / Reproducibility via Gradle Wrapper

**ES:** El **Gradle Wrapper** (`gradlew` / `gradlew.bat`) permite compilar y probar sin instalar Gradle globalmente. La versión exacta de Gradle está fijada en `gradle-wrapper.properties`. Se define un toolchain de JDK 21 para consistencia entre entornos.

**EN:** The **Gradle Wrapper** (`gradlew` / `gradlew.bat`) allows building and testing without a global Gradle installation. The exact Gradle version is locked in `gradle-wrapper.properties`. A JDK 21 toolchain ensures consistency across environments.

---

Este proyecto también está implementado en otros lenguajes. Explora el repositorio principal para ver todas las versiones.

🌐 [github.com/yorche3/programming_languages](https://github.com/yorche3/programming_languages) · [GitHub Pages](https://yorche3.github.io/programming_languages/)