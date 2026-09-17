# Algorithms Pure — Groovy

Implementaciones de la [Fase 1 — Algoritmos Puros](https://yorche3.github.io/programming_languages/ROADMAP/#fase-1--algoritmos-puros--algorithms-pure-) en **Groovy** sobre la JVM: ordenamientos elementales, estructuras de datos propias, ordenamientos óptimos y distribuidos, y búsqueda.

Los módulos de esta fase trabajan sobre `List<Integer>`, el tipo de colección idiomático de Groovy, y ordenan una **copia** (`clone()`) para no mutar la entrada del llamador.

---

## 📂 Módulos / Modules

| Módulo | Especificación | Enfoque | Tests | Estado |
|--------|---------------|---------|:-----:|:------:|
| [`naive_sort/`](naive_sort/) | [05_Naive_Sort](https://yorche3.github.io/programming_languages/core/algorithms/05_Naive_Sort/) | `./gradlew test` + Spock | 3 | ✅ |

---

## 📁 Estructura / Structure

```text
algorithms/
└── naive_sort/                          # 05_Naive_Sort
    ├── settings.gradle
    ├── gradle.properties
    ├── .gitignore / .gitattributes
    ├── gradlew / gradlew.bat
    ├── gradle/
    │   ├── libs.versions.toml
    │   └── wrapper/
    └── lib/
        ├── build.gradle
        └── src/
            ├── main/groovy/org/example/
            │   └── NaiveSort.groovy     # selectionSort, bubbleSort, insertionSort
            └── test/groovy/org/example/
                └── NaiveSortTest.groovy # 3 tests × (7 casos + caso nulo)
```

---

## 🛠️ Patrón común / Common Pattern

| Característica | Descripción |
|---------------|-------------|
| **Runtime** | JVM (JDK 21) |
| **CLI** | `./gradlew build`, `./gradlew test` |
| **Build** | Gradle 9.x con DSL de Groovy, proyecto multiproyecto con submódulo `lib` |
| **Manifiesto** | `settings.gradle` (raíz + `include('lib')`) y `lib/build.gradle` |
| **Catálogo** | `gradle/libs.versions.toml` — versiones centralizadas |
| **Framework de tests** | Spock `2.4-groovy-4.0` sobre JUnit Platform |
| **Descubrimiento** | Toda clase `extends Specification` en `src/test` |
| **Entry point** | No aplica: `./gradlew test` descubre las specs |
| **Separación** | `lib/src/main` (código) ↔ `lib/src/test` (specs) |
| **Iteración** | Bucles `for`/`while` explícitos sobre `List<Integer>` |
| **Visibilidad** | `static` en la clase `NaiveSort`, como `Numbers` en `numbers/` |
| **Naming** | `camelCase` (`selectionSort`), archivos en `PascalCase` |
| **Indicador de fallo** | `null` — se devuelve tal cual, sin lanzar excepciones |
| **Artefactos** | `.gradle`, `build`, `.kotlin`, `bin` — ignorados en `.gitignore` |

---

## 🚀 Compilación rápida / Quick Build

```bash
# Naive Sort Tests
cd naive_sort
./gradlew test
```

---

### 🌐 Otras implementaciones / Other implementations

Este proyecto también está implementado en otros lenguajes. Explora el [repositorio principal](https://github.com/yorche3/programming_languages) para ver todas las versiones.

---

## ▶️ Siguiente / Next

👉 Continúa con los módulos pendientes de esta fase en el [Roadmap](https://yorche3.github.io/programming_languages/ROADMAP/).
👉 Continue with the pending modules of this phase in the [Roadmap](https://yorche3.github.io/programming_languages/ROADMAP/).

---

*[← Volver a Core](../README.md)*

*🌐 [github.com/yorche3/programming_languages](https://github.com/yorche3/programming_languages) · [GitHub Pages](https://yorche3.github.io/programming_languages/)*
