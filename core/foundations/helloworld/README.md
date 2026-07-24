# Hello World — Groovy

Implementación de la especificación [Hello, World!](https://github.com/yorche3/programming_languages) en **Groovy**, con un enfoque manual y minimalista.

---

## 📂 Archivos y estructura / Files & Structure

El proyecto consiste en un único script fuente, sin configuración de build ni dependencias externas.

| Archivo / Directorio | Propósito |
|----------------------|-----------|
| `helloworld.groovy`  | Código fuente principal que imprime el saludo. |

**Estructura de directorios esperada:**

```text
groovy/
└── core/
    └── foundations/
        └── helloworld/
            └── helloworld.groovy
```

No se requieren directorios adicionales de compilación, pruebas ni manifiestos.  
El script es autocontenido y puede ejecutarse directamente con el intérprete de Groovy.

---

## 🛠️ Enfoque y construcción / Approach & Build

**ES:** El proyecto se creó manualmente, sin herramientas de scaffolding (como `gradle init` o `mvn archetype:generate`), para controlar cada detalle y mantener la máxima sencillez.

**EN:** The project was created manually, without scaffolding tools (like `gradle init` or `mvn archetype:generate`), to control every detail and maintain maximum simplicity.

### Inicialización / Initialization

1. Crear la estructura de directorios:

   ```bash
   mkdir -p groovy/core/foundations/helloworld
   ```

2. Escribir el script `helloworld.groovy` con el código fuente.

3. No se necesita ningún paso adicional de construcción o vinculación de dependencias.

---

## 📄 Archivos de configuración clave / Key Configuration Files

No se requieren archivos de configuración de build (como `build.gradle` o `pom.xml`) ni archivos `.gitignore` específicos, dado que Groovy ejecuta scripts directamente sin generar artefactos intermedios.

Si se desea ignorar archivos compilados en caso de usar `groovyc`, se puede agregar un `.gitignore` con:

```gitignore
*.class
```

Sin embargo, en este módulo no se utiliza compilación previa.

---

## 🚀 Compilación y ejecución / Build & Run

### Ejecutar programa principal / Run main program

```bash
groovy helloworld.groovy
```

Si se prefiere compilar a bytecode y luego ejecutar:

```bash
groovyc helloworld.groovy
groovy -cp . helloworld
```

### Salida esperada / Expected output:

```text
Hello, World!, from Groovy!
```

---

## 📝 Notas de implementación / Implementation Notes

### Sencillez y ejecución directa / Simplicity and direct execution

**ES:** Groovy permite ejecutar código fuente directamente como un script, sin necesidad de definir una clase contenedora ni un método `main`, a diferencia de Java. Esto hace que un _"Hello, World!"_ en Groovy sea más conciso y legible, manteniendo total compatibilidad con la JVM.

**EN:** Groovy allows running source code directly as a script, without needing to define a containing class or a `main` method, unlike Java. This makes a _"Hello, World!"_ in Groovy more concise and readable while maintaining full JVM compatibility.

### Interoperabilidad con Java / Java interoperability

**ES:** Groovy se integra de forma transparente con cualquier biblioteca Java. El script que imprime el saludo utiliza internamente `System.out.println`, heredado del ecosistema Java, pero expuesto mediante la función `println` de Groovy.

**EN:** Groovy integrates transparently with any Java library. The script that prints the greeting internally uses `System.out.println`, inherited from the Java ecosystem, but exposed via Groovy’s `println` function.

---

Este proyecto también está implementado en otros lenguajes. Explora el repositorio principal para ver todas las versiones.

🌐 [github.com/yorche3/programming_languages](https://github.com/yorche3/programming_languages) · [GitHub Pages](https://yorche3.github.io/programming_languages/)