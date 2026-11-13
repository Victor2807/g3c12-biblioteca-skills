# 📱 Mobile

Módulo **mobile** de la [Biblioteca de Skills](../README.md).

Esta carpeta está pensada para alojar el proyecto móvil asociado a la biblioteca. Por ahora contiene solo la configuración del IDE (IntelliJ IDEA / Android Studio) y está lista para empezar a desarrollar.

---

## 🗂️ Estructura actual

```text
mobile/
├── .idea/        # Configuración del proyecto para IntelliJ IDEA / Android Studio
└── readme.md     # Este archivo
```

> A medida que el proyecto crezca, se recomienda añadir carpetas como `src/`, `assets/` y `tests/`, y actualizar este diagrama.

---

## ⚙️ Requisitos

- **IntelliJ IDEA** o **Android Studio** (versión reciente).
- **JDK** configurado en el IDE (el módulo hereda el JDK del proyecto).
- **Git** para el control de versiones.

---

## 🚀 Primeros pasos

1. Clona el repositorio:
   ```bash
   git clone <url-del-repositorio>
   cd g3c12-biblioteca-skills/mobile
   ```
2. Abre la carpeta `mobile/` desde IntelliJ IDEA o Android Studio (**File → Open**).
3. Verifica que haya un JDK seleccionado en **File → Project Structure → Project SDK**.
4. Empieza a crear el código fuente dentro del módulo.

---

## 🤝 Cómo contribuir

1. Crea una rama a partir de la rama principal: `git checkout -b feature/mi-cambio`.
2. Haz commits pequeños y con mensajes descriptivos.
3. Abre un *pull request* describiendo qué cambia y por qué.

Consulta el [README principal](../README.md) para conocer las convenciones generales del repositorio.

---

## 📝 Notas

- La carpeta `.idea/` incluye su propio `.gitignore` para excluir archivos locales del IDE (como `workspace.xml`).
- Mantén este archivo actualizado cuando cambie la estructura o los requisitos del módulo.
