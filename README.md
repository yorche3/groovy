# Groovy

Proyectos en **Groovy**, ejecutados sobre la JVM (JDK 21) con **Gradle** como sistema de construcción para proyectos con pruebas unitarias usando **Spock**.

---

## 📦 Requisitos / Requirements

| Herramienta | Instalación |
|-------------|-------------|
| [JDK 21+](https://adoptium.net/) | `sudo apt install openjdk-21-jdk` (Linux) / `winget install EclipseAdoptium.Temurin.21.JDK` (Windows) |
| [Groovy 4.x](https://groovy.apache.org/download.html) | `sdk install groovy` (SDKMAN) o descargar binario |
| [Gradle 8.x](https://gradle.org/install/) | Incluido vía Gradle Wrapper (`./gradlew`) — no requiere instalación global |

```bash
# Verificar instalación
java --version && groovy --version
```

---

## 🏗️ Tipos de proyecto / Project Types

### 1. Script simple (archivo único)

**ES:** Un único archivo fuente `.groovy`, sin dependencias externas, ejecutado directamente con el intérprete `groovy`. Ideal para `helloworld` y `hellouser`.

**EN:** A single `.groovy` source file, no external dependencies, executed directly with the `groovy` interpreter. Ideal for `helloworld` and `hellouser`.

```bash
groovy <script>.groovy
```

### 2. Proyecto con pruebas unitarias (Gradle + Spock)

**ES:** Para proyectos que requieren pruebas unitarias, se utiliza **Gradle** como sistema de construcción, con **Spock** como framework de testing. Las dependencias se gestionan mediante el catálogo de versiones (`libs.versions.toml`). El Gradle Wrapper (`gradlew`) permite ejecutar el proyecto sin necesidad de instalar Gradle globalmente.

**EN:** For projects that require unit tests, **Gradle** is used as the build system with **Spock** as the testing framework. Dependencies are managed via the version catalog (`libs.versions.toml`). The Gradle Wrapper (`gradlew`) allows running the project without a global Gradle installation.

```bash
./gradlew test
```

---

## 📂 Módulos / Modules

| Módulo | Descripción |
|--------|-------------|
| [`core/foundations/`](core/foundations/) | **Fase 0 — Fundamentos**: `helloworld`, `hellouser`, `calculator`, `numbers` |

---

### ▶️ Comenzar / Getting Started

```bash
# Hello, World!
cd core/foundations/helloworld
groovy helloworld.groovy

# Hello, User!
cd core/foundations/hellouser
groovy hellouser.groovy

# Calculator Tests
cd core/foundations/unit_test/calculator
./gradlew test

# Numbers Tests
cd core/foundations/numbers
./gradlew test
```

---

## 🌐 Otras implementaciones / Other implementations

Este proyecto también está implementado en otros lenguajes. Explora el [repositorio principal](https://github.com/yorche3/programming_languages) para ver todas las versiones.

---

*🌐 [github.com/yorche3/programming_languages](https://github.com/yorche3/programming_languages) · [GitHub Pages](https://yorche3.github.io/programming_languages/)*