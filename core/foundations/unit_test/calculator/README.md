# Calculator — Groovy

Implementación de la especificación [03_Unit_Test_Calculator](https://yorche3.github.io/programming_languages/core/foundations/03_Unit_Test_Calculator/) en **Groovy**, usando **Gradle** (`gradle init --type groovy-library`) con **Spock** como framework de pruebas unitarias.

---

## 📂 Archivos y estructura / Files & Structure

| Archivo / Directorio | Propósito |
|----------------------|-----------|
| [`lib/src/main/groovy/org/example/Calculator.groovy`](lib/src/main/groovy/org/example/Calculator.groovy) | Clase `Calculator` — implementa las 5 operaciones aritméticas. |
| [`lib/src/test/groovy/org/example/CalculatorTest.groovy`](lib/src/test/groovy/org/example/CalculatorTest.groovy) | Suite de pruebas con Spock — 5 tests (`Specification`). |
| `lib/build.gradle` | Plugins (`groovy`, `java-library`), dependencias y configuración de Spock. |
| `settings.gradle` | Configuración del proyecto raíz y submódulo `lib`. |
| `gradle.properties` | Propiedades JVM para Gradle. |
| `gradle/libs.versions.toml` | Catálogo de versiones. |
| `gradlew` / `gradlew.bat` | Gradle Wrapper (Unix / Windows). |
| `.gitignore` | Ignora `.gradle`, `build` y `.kotlin`. |
| `.gitattributes` | Normaliza fines de línea (`gradlew` en `lf`, `.bat` en `crlf`). |

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
                ├── settings.gradle
                ├── gradle.properties
                ├── gradlew
                ├── gradlew.bat
                ├── .gitignore
                └── .gitattributes
```

---

## 🛠️ Enfoque y construcción / Approach & Build

**ES:** El proyecto fue creado con `gradle init` (tipo `groovy-library`), generando el subproyecto `lib/` con la estructura estándar de Gradle (`src/main`, `src/test`). Sobre esa base se reemplazó el código de ejemplo por la implementación de `Calculator` y sus pruebas con Spock.

**EN:** The project was created with `gradle init` (`groovy-library` type), generating the `lib/` subproject with Gradle's standard structure (`src/main`, `src/test`). On top of that scaffold, the sample code was replaced with the `Calculator` implementation and its Spock tests.

### Inicialización / Initialization

```bash
# Generar el scaffold (ejecutado una sola vez)
gradle init --type groovy-library --dsl groovy --test-framework spock

# Ejecutar las pruebas
./gradlew test
```

---

## 📄 Archivos de configuración clave / Key Configuration Files

### `lib/build.gradle` — Configuración de build

**ES:** Define los plugins `groovy` y `java-library`, y configura el conjunto de pruebas integrado (`testing.suites.test`) para usar **Spock** (`useSpock('2.4-groovy-4.0')`) en lugar de JUnit por defecto.

**EN:** Defines the `groovy` and `java-library` plugins, and configures the built-in test suite (`testing.suites.test`) to use **Spock** (`useSpock('2.4-groovy-4.0')`) instead of the default JUnit.

```groovy
plugins {
    id 'groovy'
    id 'java-library'
}

testing {
    suites {
        test {
            useSpock('2.4-groovy-4.0')
        }
    }
}
```

### `.gitignore` — Archivos ignorados

**ES:** Ignora `.gradle` (caché local de Gradle) y `build` (artefactos compilados y reportes de pruebas), ambos regenerables con `./gradlew`.

**EN:** Ignores `.gradle` (local Gradle cache) and `build` (compiled artifacts and test reports), both regenerable with `./gradlew`.

```gitignore
.gradle
build
.kotlin
```

---

## 🚀 Compilación y ejecución / Build & Run

### Ejecutar pruebas unitarias

```bash
# Desde groovy/core/foundations/unit_test/calculator/
./gradlew test
```

**Salida esperada / Expected output:**

```text
CalculatorTest

  Test Addition Test          PASSED
  Test Subtraction Test       PASSED
  Test Multiplication Test    PASSED
  Test Division Test          PASSED
  Test Modulus Test           PASSED

Tests: 5, Passed: 5, Failed: 0
BUILD SUCCESSFUL
```

> **ES:** El reporte HTML de resultados se genera en `lib/build/reports/tests/test/index.html`.
> **EN:** The HTML results report is generated at `lib/build/reports/tests/test/index.html`.

---

## 🧠 Algoritmos / operaciones (según el módulo)

| Función | Implementación | Cumple |
|---------|---------------|--------|
| `addition(a, b)` | `a + b` (suma directa) | ✅ |
| `subtraction(a, b)` | `a - b` (resta directa) | ✅ |
| `multiplication(a, b)` | Suma repetitiva de `a`, `b` veces con `for` | ✅ No usa `*` |
| `division(a, b)` | Resta repetitiva con `while` | ✅ No usa `/` |
| `modulus(a, b)` | `a - multiplication(b, division(a, b))` | ✅ No usa `%` |

---

## 📝 Notas de implementación / Implementation Notes

- **ES:** Spock descubre automáticamente los métodos declarados con `def "descripción"()` dentro de una clase que extiende `Specification`. No es necesario registrar los tests manualmente.
- **EN:** Spock automatically discovers methods declared with `def "description"()` inside a class extending `Specification`. No manual test registration is needed.
- **ES:** Cada test sigue el formato Given-When-Then de Spock: `setup:` (given), `when:` (acción) y `then:` (aserción).
- **EN:** Each test follows Spock's Given-When-Then format: `setup:` (given), `when:` (action), and `then:` (assertion).
- **ES:** `multiplication` y `division` están implementadas con sumas/restas repetitivas para cumplir la especificación educativa (sin operadores `*` ni `/` directos).
- **EN:** `multiplication` and `division` are implemented with repeated addition/subtraction to comply with the educational specification (no direct `*` or `/` operators).

---

### 🌐 Otras implementaciones / Other implementations

Este proyecto también está implementado en otros lenguajes. Explora el [repositorio principal](https://github.com/yorche3/programming_languages) para ver todas las versiones.

---

*🌐 [github.com/yorche3/programming_languages](https://github.com/yorche3/programming_languages) · [GitHub Pages](https://yorche3.github.io/programming_languages/)*
