# Foundations — Groovy

Implementación de los módulos fundamentales en **Groovy**, con un enfoque manual y minimalista.  
Este nivel agrupa las implementaciones de «Hello World», «Hello User», «Numbers» y «Unit Test (Calculator)».

---

## 📂 Submódulos y estructura / Submodules & Structure

El proyecto `foundations` es un contenedor lógico; cada submódulo es independiente y puede ejecutarse o compilarse por separado.

| Submódulo | Propósito |
|-----------|----------|
| `helloworld/` | Script mínimo que imprime un saludo. |
| `hellouser/` | Script que saluda al usuario usando su nombre. |
| `numbers/` | Biblioteca con operaciones numéricas (recursivas, acumulador, iterativas) y pruebas Spock. |
| `unit_test/calculator/` | Biblioteca de calculadora aritmética básica con pruebas unitarias Spock. |

**Estructura de directorios esperada:**

```text
groovy/
└── core/
    └── foundations/
        ├── helloworld/
        │   ├── helloworld.groovy
        │   └── README.md
        ├── hellouser/
        │   ├── hellouser.groovy
        │   └── README.md
        ├── numbers/
        │   ├── lib/
        │   ├── settings.gradle
        │   └── README.md
        └── unit_test/
            └── calculator/
                ├── lib/
                ├── settings.gradle
                └── README.md
```

Los submódulos de scripts (`helloworld`, `hellouser`) se ejecutan directamente con el intérprete de Groovy.  
Los submódulos con pruebas (`numbers`, `unit_test/calculator`) usan Gradle como sistema de construcción.

---

## 🛠️ Enfoque y construcción / Approach & Build

**ES:** Todos los proyectos bajo `foundations` se crearon manualmente, sin herramientas de scaffolding, para controlar cada detalle y mantener la máxima transparencia. Los scripts no requieren compilación; las bibliotecas se gestionan con Gradle.

**EN:** All projects under `foundations` were created manually, without scaffolding tools, to control every detail and maintain maximum transparency. The scripts require no compilation; the libraries are managed with Gradle.

### Ejecución de los submódulos

- **Scripts** (`helloworld`, `hellouser`):
  ```bash
  groovy helloworld.groovy
  groovy hellouser.groovy
  ```

- **Bibliotecas con pruebas** (`numbers`, `unit_test/calculator`):
  ```bash
  cd numbers
  ./gradlew test

  cd ../unit_test/calculator
  ./gradlew test
  ```

---

## 📝 Notas de implementación / Implementation Notes

### Groovy sobre la JVM

Todos los submódulos se ejecutan sobre la **Java Virtual Machine (JVM)**.  
Groovy permite tanto la ejecución directa de scripts (sin clases ni método `main`) como la definición de clases completas que siguen el modelo de Java.  
Esto facilita una progresión natural dentro de `foundations`:

1. **`helloworld`** – script directo.  
2. **`hellouser`** – script con entrada de usuario e interpolación de cadenas.  
3. **`numbers`** – biblioteca con métodos estáticos y de instancia, y pruebas unitarias.  
4. **`unit_test/calculator`** – biblioteca con operaciones construidas desde cero y pruebas Spock.  

### Tail Call Optimization (TCO)

Groovy **no** garantiza TCO porque la JVM subyacente no ofrece soporte nativo para la optimización de llamadas de cola. Los métodos con acumulador presentes en el submódulo `numbers` se conservan únicamente con fines educativos.

---

Este proyecto también está implementado en otros lenguajes. Explora el repositorio principal para ver todas las versiones.

🌐 [github.com/yorche3/programming_languages](https://github.com/yorche3/programming_languages) · [GitHub Pages](https://yorche3.github.io/programming_languages/)