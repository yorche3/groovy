# 🚀 Foundations — Groovy

Implementaciones de la [Fase 0 — Fundamentos](https://yorche3.github.io/programming_languages/ROADMAP/#fase-0--fundamentos--foundations--completada) en **Groovy**: `helloworld`, `hellouser`, `unit_test/calculator` y `numbers`.

---

## 📖 Módulos / Modules

| Módulo | Especificación | Enfoque | Tests | Estado |
|--------|---------------|---------|:-----:|:------:|
| [`helloworld/`](helloworld/) | [01_Hello_World](https://yorche3.github.io/programming_languages/core/foundations/01_Hello_World/) | Script directo (`groovy`) | — | ✅ |
| [`hellouser/`](hellouser/) | [02_Hello_User](https://yorche3.github.io/programming_languages/core/foundations/02_Hello_User/) | Script directo (`groovy`) | — | ✅ |
| [`unit_test/calculator/`](unit_test/calculator/) | [03_Unit_Test_Calculator](https://yorche3.github.io/programming_languages/core/foundations/03_Unit_Test_Calculator/) | Gradle + **Spock** | 5 | ✅ |
| [`numbers/`](numbers/) | [04_Numbers](https://yorche3.github.io/programming_languages/core/foundations/04_Numbers/) | Gradle + **Spock** | 10 | ✅ |

---

## 📁 Estructura / Structure

```text
foundations/
├── helloworld/                   # 01_Hello_World
│   ├── helloworld.groovy         # println 'Hello, World!, from Groovy!'
│   └── README.md
│
├── hellouser/                    # 02_Hello_User
│   ├── hellouser.groovy          # Lee nombre con System.console() y saluda
│   └── README.md
│
├── unit_test/
│   └── calculator/               # 03_Unit_Test_Calculator
│       ├── lib/
│       │   ├── src/main/groovy/org/example/
│       │   │   └── Calculator.groovy    # 5 operaciones (+, -, *, /, mod)
│       │   ├── src/test/groovy/org/example/
│       │   │   └── CalculatorTest.groovy # 5 tests con Spock
│       │   └── build.gradle
│       ├── settings.gradle
│       ├── gradle.properties
│       ├── gradle/libs.versions.toml
│       ├── gradlew / gradlew.bat
│       ├── .gitignore
│       ├── .gitattributes
│       └── README.md
│
└── numbers/                      # 04_Numbers
    ├── lib/
    │   ├── src/main/groovy/org/example/
    │   │   └── Numbers.groovy    # 15 funciones (3 enfoques × 5 algoritmos)
    │   ├── src/test/groovy/org/example/
    │   │   ├── NumbersRecTest.groovy  # 5 tests recursivos
    │   │   └── NumbersIteTest.groovy  # 5 tests iterativos
    │   └── build.gradle
    ├── settings.gradle
    ├── gradle.properties
    ├── gradle/libs.versions.toml
    ├── gradlew / gradlew.bat
    ├── .gitignore
    ├── .gitattributes
    └── README.md
```

---

## 🛠️ Patrón común / Common Pattern

| Característica | Descripción |
|---------------|-------------|
| **Lenguaje** | Groovy 4.x sobre JVM (JDK 21) |
| **Build system** | Scripts directos (`groovy`) o **Gradle** con DSL Groovy para proyectos con tests |
| **Test framework** | [Spock](https://spockframework.org/) 2.4 para pruebas unitarias |
| **Dependencias** | Gradle gestiona Guava, Commons Math, y otras dependencias automáticamente |
| **Ejecución directa** | `groovy <script>.groovy` para programas simples |
| **Ejecución con Gradle** | `./gradlew test` para proyectos con pruebas |

---

## 🚀 Compilación rápida / Quick Build

```bash
# Hello, World!
cd helloworld
groovy helloworld.groovy

# Hello, User!
cd hellouser
groovy hellouser.groovy

# Calculator Tests
cd unit_test/calculator
./gradlew test

# Numbers Tests
cd numbers
./gradlew test
```

---

### 🌐 Otras implementaciones / Other implementations

Este proyecto también está implementado en otros lenguajes. Explora el [repositorio principal](https://github.com/yorche3/programming_languages) para ver todas las versiones.

---

## ▶️ Siguiente / Next

👉 Después de fundamentos, continúa con [Fase 1 — Algoritmos Puros](https://yorche3.github.io/programming_languages/ROADMAP/#fase-1--algoritmos-puros--algorithms-pure-).  
👉 After foundations, continue with [Phase 1 — Algorithms Pure](https://yorche3.github.io/programming_languages/ROADMAP/#fase-1--algoritmos-puros--algorithms-pure-).

---

*[← Volver a Groovy](../README.md)*

*🌐 [github.com/yorche3/programming_languages](https://github.com/yorche3/programming_languages) · [GitHub Pages](https://yorche3.github.io/programming_languages/)*