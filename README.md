# 📚 Biblioteca de Skills

Repositorio central para crear, documentar, compartir y mantener **Skills** reutilizables para Claude (Claude Code, Claude.ai y Claude Agent SDK).

Una *Skill* es un paquete de instrucciones, scripts y recursos que Claude carga cuando una tarea lo requiere. Le enseña a hacer algo de forma repetible y consistente: generar un tipo de documento, seguir un flujo de trabajo del equipo, extraer información de una web, etc.

---

## 🎯 Objetivos del proyecto

- **Centralizar** las Skills del equipo en un único lugar versionado.
- **Estandarizar** su estructura para que cualquiera pueda entenderlas y modificarlas.
- **Reutilizar** el trabajo: una Skill bien hecha se usa en muchos proyectos.
- **Documentar** cada Skill con su propósito, entradas, salidas y ejemplos.
- **Mejorar continuamente** las Skills mediante pruebas y revisiones.

---

## 🗂️ Estructura del repositorio

```text
g3c12-biblioteca-skills/
├── README.md                  # Este archivo
├── CONTRIBUTING.md            # Guía para contribuir (opcional)
├── plantilla/                 # Plantilla base para crear nuevas Skills
│   └── SKILL.md
└── skills/
    ├── resumen-libros-word/
    │   ├── SKILL.md           # Instrucciones y metadatos (obligatorio)
    │   ├── scripts/           # Código auxiliar (Python, Bash, JS…)
    │   ├── references/        # Documentación de apoyo que Claude lee bajo demanda
    │   └── assets/            # Plantillas, imágenes, fuentes, etc.
    ├── web-presentacion/
    │   └── SKILL.md
    └── scrapping/
        └── SKILL.md
```

Cada Skill vive en su propia carpeta dentro de `skills/` y **debe** contener un archivo `SKILL.md`.

---

## 🧩 Anatomía de una Skill

El archivo `SKILL.md` comienza con un bloque de metadatos (*frontmatter*) en YAML, seguido de las instrucciones en Markdown:

```markdown
---
name: resumen-libros-word
description: Genera un resumen ejecutivo de un libro en español como documento Word (.docx) de 3 a 6 páginas. Úsala cuando el usuario pida resumir un libro, novela o ensayo.
---

# Resumen de libros en Word

## Cuándo usar esta Skill
- El usuario comparte un libro (PDF, enlace o archivo) y pide un resumen.

## Pasos
1. Leer el contenido del libro.
2. Identificar tesis, capítulos clave y conclusiones.
3. Generar el documento con `scripts/generar_docx.py`.

## Formato de salida
- Portada, índice, resumen por capítulos y conclusiones.
```

| Campo         | Obligatorio | Descripción |
|---------------|:-----------:|-------------|
| `name`        | ✅ | Identificador único, en minúsculas y con guiones (`mi-skill`). |
| `description` | ✅ | Qué hace y **cuándo** debe activarse. Es lo que Claude lee para decidir si la usa, así que debe ser clara y específica. |

### Buenas prácticas

- **Descripción precisa:** incluye palabras clave y situaciones concretas en las que debe activarse.
- **Instrucciones breves:** mantén `SKILL.md` conciso; mueve el detalle extenso a `references/`.
- **Scripts deterministas:** lo que pueda hacerse con código, hazlo con un script en `scripts/`.
- **Ejemplos reales:** muestra entradas y salidas esperadas.
- **Sin secretos:** nunca incluyas contraseñas, tokens ni claves API.

---

## 📦 Catálogo de Skills

| Skill | Descripción | Estado |
|-------|-------------|--------|
| `resumen-libros-word` | Resume un libro y entrega un documento Word (.docx) de 3–6 páginas. | 🟡 En desarrollo |
| `web-presentacion` | Construye una web de presentación personal en HTML. | 🟡 En desarrollo |
| `scrapping` | Extrae información estructurada de una página web. | 🟡 En desarrollo |

> Leyenda: 🟢 Estable · 🟡 En desarrollo · 🔴 Obsoleta

Actualiza esta tabla cada vez que añadas o cambies el estado de una Skill.

---

## 🚀 Cómo usar las Skills

### En Claude Code

Copia la carpeta de la Skill en el directorio de Skills de tu proyecto o de tu usuario:

```bash
git clone https://github.com/victor2807/g3c12-biblioteca-skills.git
```

```bash
mkdir -p .claude/skills && cp -r g3c12-biblioteca-skills/skills/resumen-libros-word .claude/skills/
```

Para tenerla disponible en todos tus proyectos, cópiala en `~/.claude/skills/`.

### En Claude.ai

1. Comprime la carpeta de la Skill en un archivo `.zip`.
2. Ve a **Configuración → Capacidades → Skills** y súbela.
3. Actívala y pídele a Claude una tarea relacionada.

Claude decidirá automáticamente cuándo cargar la Skill según su `description`. También puedes invocarla directamente por su nombre (por ejemplo, `/resumen-libros-word` en Claude Code).

---

## ✍️ Cómo crear una nueva Skill

1. Crea una rama nueva:
   ```bash
   git checkout -b skill/nombre-de-la-skill
   ```
2. Copia la plantilla:
   ```bash
   cp -r plantilla skills/nombre-de-la-skill
   ```
3. Edita `SKILL.md` con el nombre, la descripción y las instrucciones.
4. Añade los scripts, referencias o recursos necesarios.
5. **Pruébala** con al menos 3 peticiones reales y comprueba que:
   - se activa cuando debe (y no cuando no debe);
   - el resultado cumple el formato esperado.
6. Añádela al **Catálogo de Skills** de este README.
7. Abre un *Pull Request* describiendo qué hace la Skill y cómo la probaste.

---

## ✅ Lista de verificación antes de publicar

- [ ] La carpeta tiene un `SKILL.md` con `name` y `description`.
- [ ] El `name` coincide con el nombre de la carpeta.
- [ ] La descripción indica claramente **qué hace** y **cuándo usarla**.
- [ ] Incluye al menos un ejemplo de uso.
- [ ] No contiene datos sensibles ni credenciales.
- [ ] Ha sido probada con casos reales.
- [ ] Está registrada en el catálogo.

---

## 🤝 Contribuir

Las contribuciones son bienvenidas. Para mantener la calidad de la biblioteca:

- Usa nombres de rama descriptivos: `skill/<nombre>`, `fix/<nombre>`, `docs/<tema>`.
- Escribe mensajes de *commit* claros y en presente: `Añade skill de resumen de libros`.
- Toda Skill nueva o modificada pasa por revisión mediante *Pull Request*.
- Si encuentras un error o tienes una idea, abre un *Issue*.

---

## 🛣️ Hoja de ruta

- [ ] Publicar la plantilla base (`plantilla/SKILL.md`).
- [ ] Migrar las primeras Skills del equipo al repositorio.
- [ ] Añadir pruebas/evaluaciones automáticas para cada Skill.
- [ ] Crear una guía de estilo para redactar descripciones.
- [ ] Empaquetar las Skills como *plugin* para instalarlas de una sola vez.

---

## 📖 Recursos

- [Documentación de Claude Code](https://code.claude.com/docs)
- [Agent Skills – Anthropic](https://docs.claude.com/en/docs/agents-and-tools/agent-skills/overview)

---

## 📄 Licencia

Este proyecto se distribuye bajo la licencia **MIT**, salvo que una Skill indique lo contrario en su propia carpeta.
