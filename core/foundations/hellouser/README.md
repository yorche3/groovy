# Hello User — Groovy

Implementación de la especificación [Hello, User!](https://github.com/yorche3/programming_languages) en **Groovy**, con un enfoque manual y minimalista.

---

## 📂 Archivos y estructura / Files & Structure

Un único script que solicita el nombre de usuario y devuelve un saludo personalizado.

| Archivo / Directorio | Propósito |
|----------------------|-----------|
| `hellouser.groovy` | Código fuente que lee la entrada del usuario y la saluda. |

**Estructura de directorios esperada:**

```text
groovy/
└── core/
    └── foundations/
        └── hellouser/
            └── hellouser.groovy
```

No se necesitan subproyectos de pruebas ni manifiestos. El script es autocontenido y se ejecuta directamente con el intérprete de Groovy.

---

## 🛠️ Enfoque y construcción / Approach & Build

**ES:** El proyecto se creó manualmente, sin herramientas de scaffolding (como `gradle init` o `mvn archetype:generate`), para controlar cada detalle y mantener la máxima sencillez.

**EN:** The project was created manually, without scaffolding tools (like `gradle init` or `mvn archetype:generate`), to control every detail and maintain maximum simplicity.

### Inicialización / Initialization

1. Crear la estructura de directorios:

   ```bash
   mkdir -p groovy/core/foundations/hellouser
   ```

2. Escribir el script `hellouser.groovy` con el código fuente.

No se requieren pasos adicionales de construcción o gestión de dependencias.

---

## 📄 Archivos de configuración clave / Key Configuration Files

No se emplean archivos de configuración de build (como `build.gradle` o `pom.xml`). Si se compila a bytecode con `groovyc`, se pueden ignorar los `.class` añadiendo un `.gitignore`:

```gitignore
*.class
```

Para este módulo no es necesario porque la ejecución se realiza directamente sobre el script fuente.

---

## 🚀 Compilación y ejecución / Build & Run

### Ejecutar programa principal / Run main program

```bash
groovy hellouser.groovy
```

Si se prefiere compilar a bytecode y luego ejecutar:

```bash
groovyc hellouser.groovy
groovy -cp . hellouser
```

### Interacción esperada / Expected interaction:

```text
Enter your name: Yorche
Hello, Yorche!
```

---

## 📝 Notas de implementación / Implementation Notes

### Entrada de usuario y seguridad / User input and safety

**ES:**  
Se utiliza `System.console().readLine()` para leer la entrada del usuario de forma segura (sin eco de caracteres, si se usara para contraseñas). Esta función devuelve una línea de texto sin el salto de línea final. Es importante ejecutar el script en una terminal real; algunos IDE o entornos virtualizados podrían devolver `null` en `System.console()`, lo que provocaría un error. En ese caso, se puede sustituir por `new BufferedReader(new InputStreamReader(System.in)).readLine()`.

**EN:**  
`System.console().readLine()` is used to read user input safely (without echoing characters, if used for passwords). This method returns a line of text without the trailing newline. It's important to run the script in a real terminal; some IDEs or virtualized environments may return `null` for `System.console()`, causing an error. In that case, you can replace it with `new BufferedReader(new InputStreamReader(System.in)).readLine()`.

### Interpolación de cadenas / String interpolation

**ES:**  
Groovy permite interpolar variables dentro de cadenas con dobles comillas usando `$variable` o `${expresión}`. En este script, `"Hello, $name!"` concatena el saludo con el nombre ingresado de manera idiomática, sin necesidad de concatenación explícita como en Java (`"Hello, " + name + "!"`).

**EN:**  
Groovy allows variable interpolation inside double-quoted strings using `$variable` or `${expression}`. In this script, `"Hello, $name!"` concatenates the greeting with the input name idiomatically, without requiring explicit concatenation like Java’s `"Hello, " + name + "!"`.

---

Este proyecto también está implementado en otros lenguajes. Explora el repositorio principal para ver todas las versiones.

🌐 [github.com/yorche3/programming_languages](https://github.com/yorche3/programming_languages) · [GitHub Pages](https://yorche3.github.io/programming_languages/)
Un único script que solicita el nombre de usuario y devuelve un saludo personalizado.

| Archivo / Directorio | Propósito |
|----------------------|-----------|
| `hellouser.groovy` | Código fuente que lee la entrada del usuario y la saluda. |

**Estructura de directorios esperada:**

